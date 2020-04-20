/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SporAlanları;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


    
public class SporAlanlarıDAO extends DAO {

    public List<SporAlanları> findall(int page, int pageSize) {
        List<SporAlanları> yList = new ArrayList<>();
        int start=(page-1)*pageSize;
        
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from sporalanları order by sporsalonu_id asc OFFSET "+start+" LIMIT "+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                SporAlanları tmp = new SporAlanları();
                tmp.setSporalanları_id(rs.getLong("sporsalonu_id"));
                tmp.setSporsalonu_ad(rs.getString("sporsalonu_ad"));
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
            PreparedStatement pst = getConn().prepareStatement("select count(sporsalonu_id) as sporalanı_count from sporalanları");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("sporalanı_count");  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

     }
     public List<SporAlanları> getSporYapar(Long üye_id) {
         List<SporAlanları> sporyapar = new ArrayList<>();
      
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from sporyapar where üye_id=?");
            pst.setLong(1, üye_id);
             ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                sporyapar.add(this.find(rs.getLong("sporsalonu_id")));
            }         
         } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
         return sporyapar;
    }

    public SporAlanları find(Long id) {
        SporAlanları y = null;
        String query = ("select * from sporalanları where sporsalonu_id=" + id);
        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();

            y = new SporAlanları();
            y.setSporalanları_id(rs.getLong("sporsalonu_id"));
                y.setSporsalonu_ad(rs.getString("sporsalonu_ad"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return y;

    }

 

    public void ekle(SporAlanları sporalanı) {
        String query = "insert into sporalanları values(default,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, sporalanı.getSporsalonu_ad());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(SporAlanları sporalanı) {
        String query = "delete from sporalanları where sporsalonu_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setLong(1, sporalanı.getSporalanları_id());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(SporAlanları sporalanı) {
        String query = "update sporalanları set sporsalonu_ad=? where sporsalonu_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, sporalanı.getSporsalonu_ad());
            pst.setLong(2,sporalanı.getSporalanları_id());
            ResultSet rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<SporAlanları> findall() {
         List<SporAlanları> yList = new ArrayList<>();
       try {
           
            PreparedStatement pst = getConn().prepareStatement("select * from sporalanları order by sporsalonu_id asc ");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                SporAlanları tmp = new SporAlanları();
                tmp.setSporalanları_id(rs.getLong("sporsalonu_id"));
                tmp.setSporsalonu_ad(rs.getString("sporsalonu_ad"));
                 yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }
}
