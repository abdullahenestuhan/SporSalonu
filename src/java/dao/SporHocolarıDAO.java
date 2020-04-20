/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SporHocoları;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SporHocolarıDAO extends DAO {

    public List<SporHocoları> findall(int page, int pageSize) {
        List<SporHocoları> yList = new ArrayList<>();
        int start=(page-1)*pageSize;
        
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from sporhocoları order by sporhocoları_id asc OFFSET "+start+" LIMIT "+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                SporHocoları tmp = new SporHocoları();
                tmp.setSporhocoları_id(rs.getLong("sporhocoları_id"));
                tmp.setAd(rs.getString("ad"));
                tmp.setSoyad(rs.getString("soyad"));
                tmp.setDeneyim(rs.getInt("deneyim"));
                tmp.setYas(rs.getInt("yas"));
                tmp.setUzamanlıkalanı(rs.getString("uzmanlıkalanı"));
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
            PreparedStatement pst = getConn().prepareStatement("select count(sporhocoları_id) as sporhocoları_count from sporhocoları");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("sporhocoları_count");  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

     }

    public SporHocoları find(Long id) {
        SporHocoları y = null;
        String query = ("select * from sporhocoları where sporhocoları_id=" + id);
        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();

            y = new SporHocoları();
            y.setSporhocoları_id(rs.getLong("sporhocoları_id"));
                y.setAd(rs.getString("ad"));
                y.setSoyad(rs.getString("soyad"));
                y.setDeneyim(rs.getInt("deneyim"));
                y.setYas(rs.getInt("yas"));
                y.setUzamanlıkalanı(rs.getString("uzmanlıkalanı"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return y;

    }

 

    public void ekle(SporHocoları sporhocoları) {
        String query = "insert into sporhocoları values(default,?,?,?,?,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, sporhocoları.getAd());
            pst.setString(2, sporhocoları.getSoyad());
            pst.setInt(3, sporhocoları.getDeneyim());
            pst.setInt(4, sporhocoları.getYas());
            pst.setString(5, sporhocoları.getUzamanlıkalanı());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(SporHocoları sporhocoları) {
        String query = "delete from sporhocoları where sporhocoları_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setLong(1, sporhocoları.getSporhocoları_id());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(SporHocoları sporhocoları) {
        String query = "update sporhocoları set ad=?,soyad=?,deneyim=?,yas=?,uzmanlıkalanı=? where sporhocoları_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, sporhocoları.getAd());
            pst.setString(2, sporhocoları.getSoyad());
            pst.setInt(3, sporhocoları.getDeneyim());
            pst.setInt(4, sporhocoları.getYas());
            pst.setString(5, sporhocoları.getUzamanlıkalanı());
            pst.setLong(6,sporhocoları.getSporhocoları_id());
            ResultSet rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<SporHocoları> findall() {
         List<SporHocoları> yList = new ArrayList<>();
       try {
           
            PreparedStatement pst = getConn().prepareStatement("select * from sporhocoları order by sporhocoları_id asc ");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                SporHocoları tmp = new SporHocoları();
                tmp.setSporhocoları_id(rs.getLong("sporhocoları_id"));
                tmp.setAd(rs.getString("ad"));
                tmp.setSoyad(rs.getString("soyad"));
                tmp.setDeneyim(rs.getInt("deneyim"));
                tmp.setYas(rs.getInt("yas"));
                tmp.setUzamanlıkalanı(rs.getString("uzmanlıkalanı"));
                 yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }
}
