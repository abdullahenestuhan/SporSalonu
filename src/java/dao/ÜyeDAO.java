/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SporAlanları;
import entity.Üye;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.List;


public class ÜyeDAO extends DAO {

    private YemekListesiDAO yemekListesiDAO;
    private SporAlanlarıDAO sporAlanlarıDAO;

    public List<Üye> findall(int page, int pageSize) {
        List<Üye> yList = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from üye order by üye_id asc OFFSET " + start + " LIMIT " + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Üye tmp = new Üye();
                tmp.setÜye_id(rs.getLong("üye_id"));
                tmp.setAd(rs.getString("ad"));
                tmp.setSoyad(rs.getString("soyad"));
                tmp.setÜyelik_başlangıç_tarihi(rs.getString("üyelik_başlangıç_tarihi"));
                tmp.setÜyelik_bitiş_tarihi(rs.getString("üyelik_bitiş_tarihi"));
                tmp.setYas(rs.getInt("yas"));
                tmp.setYemekListesi(this.getYemekListesiDAO().find(rs.getLong("yemeklistesi_id")));
                tmp.setSporyapar(this.getSporAlanlarıDAO().getSporYapar(tmp.getÜye_id()));
                yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = getConn().prepareStatement("select count(üye_id) as üye_count from üye");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("üye_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

    }

    public Üye find(Long id) {
        Üye y = null;
        String query = ("select * from üye where üye_id=" + id);
        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();

            y = new Üye();
            y.setÜye_id(rs.getLong("üye_id"));
            y.setAd(rs.getString("ad"));
            y.setSoyad(rs.getString("soyad"));
            y.setÜyelik_başlangıç_tarihi(rs.getString("üyelik_başlangıç_tarihi"));
            y.setÜyelik_bitiş_tarihi(rs.getString("üyelik_bitiş_tarihi"));
            y.setYas(rs.getInt("yas"));
            y.setYemeklistesi_id(rs.getLong("yemeklistesi_id"));
            y.setSporalanları_id(rs.getLong("sporalanı_id"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return y;

    }

    public void ekle(Üye üye) {

        try {
            PreparedStatement pst = getConn().prepareStatement("insert into üye values(default,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, üye.getAd());
            pst.setString(2, üye.getSoyad());
            pst.setString(3, üye.getÜyelik_başlangıç_tarihi());
            pst.setString(4, üye.getÜyelik_bitiş_tarihi());
            pst.setInt(5, üye.getYas());
            pst.setLong(6, üye.getYemekListesi().getYemeklistesi_id());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();

            Long üye_id = null;
            if (gk.next()) {
                üye_id = gk.getLong(1);
            }

            for (SporAlanları t : üye.getSporyapar()) {
                pst = this.getConn().prepareStatement("insert into sporyapar(sporyapar_id,üye_id,sporsalonu_id) values(default,?,?)");
                pst.setLong(1, üye_id);
                pst.setLong(2, t.getSporalanları_id());
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Üye üye) {

        try {
            PreparedStatement pst = getConn().prepareStatement("delete from sporyapar where üye_id=?");
            pst.setLong(1, üye.getÜye_id());
            pst.executeUpdate();
            pst = this.getConn().prepareStatement("delete from üye where üye_id=?");
            pst.setLong(1, üye.getÜye_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Üye üye) {

        try {
            PreparedStatement pst = getConn().prepareStatement("update üye set ad=?,soyad=?,üyelik_başlangıç_tarihi=?,üyelik_bitiş_tarihi=?,yas=?,yemeklistesi_id=? where üye_id=?");
            pst.setString(1, üye.getAd());
            pst.setString(2, üye.getSoyad());
            pst.setString(3, üye.getÜyelik_başlangıç_tarihi());
            pst.setString(4, üye.getÜyelik_bitiş_tarihi());
            pst.setInt(5, üye.getYas());
            pst.setLong(6, üye.getYemekListesi().getYemeklistesi_id());
            pst.setLong(7, üye.getÜye_id());
            pst.executeUpdate();

            pst = this.getConn().prepareStatement("delete from sporyapar where üye_id=?");
            pst.setLong(1, üye.getÜye_id());
            pst.executeUpdate();
            for (SporAlanları t : üye.getSporyapar()) {
                pst = this.getConn().prepareStatement("insert into sporyapar(üye_id,sporsalonu_id) values(?,?)");
                pst.setLong(1, üye.getÜye_id());
                pst.setLong(2, t.getSporalanları_id());
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Üye> findall() {
        List<Üye> yList = new ArrayList<>();
        try {

            PreparedStatement pst = getConn().prepareStatement("select * from üye order by üye_id asc ");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Üye tmp = new Üye();
                tmp.setÜye_id(rs.getLong("üye_id"));
                tmp.setAd(rs.getString("ad"));
                tmp.setSoyad(rs.getString("soyad"));
                tmp.setÜyelik_başlangıç_tarihi(rs.getString("üyelik_başlangıç_tarihi"));
                tmp.setÜyelik_bitiş_tarihi(rs.getString("üyelik_bitiş_tarihi"));
                tmp.setYas(rs.getInt("yas"));
                tmp.setYemeklistesi_id(rs.getLong("yemeklistesi_id"));
                tmp.setSporalanları_id(rs.getLong("sporalanı_id"));
                yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }

    public YemekListesiDAO getYemekListesiDAO() {
        if (this.yemekListesiDAO == null) {
            this.yemekListesiDAO = new YemekListesiDAO();
        }
        return yemekListesiDAO;
    }

    public void setYemekListesiDAO(YemekListesiDAO yemekListesiDAO) {
        this.yemekListesiDAO = yemekListesiDAO;
    }

    public SporAlanlarıDAO getSporAlanlarıDAO() {
        if (this.sporAlanlarıDAO == null) {
            this.sporAlanlarıDAO = new SporAlanlarıDAO();
        }
        return sporAlanlarıDAO;
    }

    public void setSporAlanlarıDAO(SporAlanlarıDAO sporAlanlarıDAO) {
        this.sporAlanlarıDAO = sporAlanlarıDAO;
    }

}
