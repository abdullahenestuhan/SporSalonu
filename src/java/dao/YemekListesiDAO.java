/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.YemekListesi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


    
public class YemekListesiDAO extends DAO {

    public List<YemekListesi> findall(int page, int pageSize) {
        List<YemekListesi> yList = new ArrayList<>();
        int start=(page-1)*pageSize;
        
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from yemeklistesi order by yemeklistesi_id asc OFFSET "+start+" LIMIT "+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                YemekListesi tmp = new YemekListesi();
                tmp.setYemeklistesi_id(rs.getLong("yemeklistesi_id"));
                tmp.setAdı(rs.getString("adı"));
                tmp.setProgram(rs.getString("program"));            
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
            PreparedStatement pst = getConn().prepareStatement("select count(yemeklistesi_id) as yemeklistesi_count from yemeklistesi");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("yemeklistesi_count");  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

     }

    public YemekListesi find(Long id) {
        YemekListesi y = null;
        String query = ("select * from yemeklistesi where yemeklistesi_id=" + id);
        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();

            y = new YemekListesi();
                y.setYemeklistesi_id(rs.getLong("yemeklistesi_id"));
                y.setAdı(rs.getString("adı"));
                y.setProgram(rs.getString("program"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return y;

    }

 

    public void ekle(YemekListesi yemeklistesi) {
        String query = "insert into yemeklistesi values(default,?,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, yemeklistesi.getAdı());
            pst.setString(2, yemeklistesi.getProgram());         
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(YemekListesi yemeklistesi) {
        String query = "delete from yemeklistesi where yemeklistesi_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setLong(1, yemeklistesi.getYemeklistesi_id());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(YemekListesi yemeklistesi) {
        String query = "update yemeklistesi set adı=?,program=? where yemeklistesi_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, yemeklistesi.getAdı());
            pst.setString(2, yemeklistesi.getProgram());
            pst.setLong(3, yemeklistesi.getYemeklistesi_id());
            ResultSet rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<YemekListesi> findall() {
         List<YemekListesi> yList = new ArrayList<>();
       try {
           
            PreparedStatement pst = getConn().prepareStatement("select * from yemeklistesi order by yemeklistesi_id asc ");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                YemekListesi tmp = new YemekListesi();
                tmp.setYemeklistesi_id(rs.getLong("yemeklistesi_id"));
                tmp.setAdı(rs.getString("adı"));
                tmp.setProgram(rs.getString("program"));
                 yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }
}
