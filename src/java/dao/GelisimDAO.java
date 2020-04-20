/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Gelisim;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GelisimDAO extends DAO {
    private ÜyeDAO üyeDAO;
    public List<Gelisim> findall(int page, int pageSize) {
        List<Gelisim> yList = new ArrayList<>();
        int start=(page-1)*pageSize;
        
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from gelisim order by gelisim_id asc OFFSET "+start+" LIMIT "+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Gelisim tmp = new Gelisim();
                tmp.setGelisim_id(rs.getLong("gelisim_id"));
                tmp.setEski_kg(rs.getInt("eski_kg"));
                tmp.setYenikg(rs.getInt("yenikg"));
                tmp.setYenivücutkütleindeksi(rs.getInt("yenivücutkütleindeksi"));
                tmp.setEskivücutkütleindeksi(rs.getInt("eskivücutkütleindeksi"));
                tmp.setBoy(rs.getInt("boy"));
                tmp.setÜye(this.getÜyeDAO().find(rs.getLong("üye_id")));
                 yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }
     public int  count() {
        int count=0;
         
        try {
            PreparedStatement pst = getConn().prepareStatement("select count(gelisim_id) as gelisim_count from gelisim");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("gelisim_count");  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

     }

    public Gelisim find(Long id) {
        Gelisim y = null;
        String query = ("select * from gelisim where gelisim_id=" + id);
        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();

            y = new Gelisim();
                y.setGelisim_id(rs.getLong("gelisim_id"));              
                y.setEski_kg(rs.getInt("eski_kg"));
                y.setYenikg(rs.getInt("yenikg"));
                y.setYenivücutkütleindeksi(rs.getInt("yenivücutkütleindeksi"));
                y.setEskivücutkütleindeksi(rs.getInt("eskivücutkütleindeksi"));
                y.setBoy(rs.getInt("boy"));
                y.setÜye_id(rs.getLong("üye_id"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return y;

    }

 

    public void ekle(Gelisim gelisim) {
        String query = "insert into gelisim values(default,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);           
            pst.setInt(1, gelisim.getEski_kg());
            pst.setInt(2, gelisim.getYenikg());
            pst.setInt(3, gelisim.getYenivücutkütleindeksi());
            pst.setInt(4, gelisim.getEskivücutkütleindeksi());
            pst.setInt(5, gelisim.getBoy());
            pst.setLong(6,gelisim.getÜye().getÜye_id());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Gelisim gelisim) {
        String query = "delete from gelisim where gelisim_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setLong(1, gelisim.getGelisim_id());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Gelisim gelisim) {
        String query = "update gelisim set eski_kg=?,yenikg=?,yenivücutkütleindeksi=?,eskivücutkütleindeksi=?,boy=?,üye_id=? where gelisim_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            
            pst.setInt(1, gelisim.getEski_kg());
            pst.setInt(2, gelisim.getYenikg());
            pst.setInt(3, gelisim.getYenivücutkütleindeksi());
            pst.setInt(4, gelisim.getEskivücutkütleindeksi());
            pst.setInt(5, gelisim.getBoy());
            pst.setLong(6,gelisim.getÜye().getÜye_id());
            pst.setLong(7,gelisim.getGelisim_id());
            ResultSet rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Gelisim> findall() {
         List<Gelisim> yList = new ArrayList<>();
       try {
           
            PreparedStatement pst = getConn().prepareStatement("select * from gelisim order by gelisim_id asc ");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Gelisim tmp = new Gelisim();
                 tmp.setGelisim_id(rs.getLong("gelisim_id"));
                tmp.setEski_kg(rs.getInt("eski_kg"));
                tmp.setYenikg(rs.getInt("yenikg"));
                tmp.setYenivücutkütleindeksi(rs.getInt("yenivücutkütleindeksi"));
                tmp.setEskivücutkütleindeksi(rs.getInt("eskivücutkütleindeksi"));
                tmp.setBoy(rs.getInt("boy"));
                tmp.setÜye_id(rs.getLong("üye_id"));
                 yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }

    public ÜyeDAO getÜyeDAO() {
        if (this.üyeDAO == null) {
            this.üyeDAO = new ÜyeDAO();
        }
        return üyeDAO;
    }
 
    public void setÜyeDAO(ÜyeDAO üyeDAO) {
        this.üyeDAO = üyeDAO;
    }
    
}
