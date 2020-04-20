/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import java.util.Objects;


public class Üye {
    private Long üye_id;
    private String ad;
    private String soyad;
    private String üyelik_başlangıç_tarihi;
    private String üyelik_bitiş_tarihi;
    private int yas;
    private Long sporalanları_id;
    private Long yemeklistesi_id;
    
    private YemekListesi yemekListesi;
    private List<SporAlanları> sporyapar;

    public Üye(Long üye_id, String ad, String soyad, String üyelik_başlangıç_tarihi, String üyelik_bitiş_tarihi, int yas, Long sporalanları_id, Long yemeklistesi_id, YemekListesi yemekListesi, List<SporAlanları> sporyapar) {
        this.üye_id = üye_id;
        this.ad = ad;
        this.soyad = soyad;
        this.üyelik_başlangıç_tarihi = üyelik_başlangıç_tarihi;
        this.üyelik_bitiş_tarihi = üyelik_bitiş_tarihi;
        this.yas = yas;
        this.sporalanları_id = sporalanları_id;
        this.yemeklistesi_id = yemeklistesi_id;
        this.yemekListesi = yemekListesi;
        this.sporyapar = sporyapar;
    }

    

    public Üye() {
    }

    public YemekListesi getYemekListesi() {
        return yemekListesi;
    }

    public void setYemekListesi(YemekListesi yemekListesi) {
        this.yemekListesi = yemekListesi;
    }

    public List<SporAlanları> getSporyapar() {
        return sporyapar;
    }

    public void setSporyapar(List<SporAlanları> sporyapar) {
        this.sporyapar = sporyapar;
    }

    public Long getÜye_id() {
        return üye_id;
    }

    public void setÜye_id(Long üye_id) {
        this.üye_id = üye_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getÜyelik_başlangıç_tarihi() {
        return üyelik_başlangıç_tarihi;
    }

    public void setÜyelik_başlangıç_tarihi(String üyelik_başlangıç_tarihi) {
        this.üyelik_başlangıç_tarihi = üyelik_başlangıç_tarihi;
    }

    public String getÜyelik_bitiş_tarihi() {
        return üyelik_bitiş_tarihi;
    }

    public void setÜyelik_bitiş_tarihi(String üyelik_bitiş_tarihi) {
        this.üyelik_bitiş_tarihi = üyelik_bitiş_tarihi;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public Long getSporalanları_id() {
        return sporalanları_id;
    }

    public void setSporalanları_id(Long sporalanları_id) {
        this.sporalanları_id = sporalanları_id;
    }

    public Long getYemeklistesi_id() {
        return yemeklistesi_id;
    }

    public void setYemeklistesi_id(Long yemeklistesi_id) {
        this.yemeklistesi_id = yemeklistesi_id;
    }

    @Override
    public String toString() {
        return "\u00dcye{" + "\u00fcye_id=" + üye_id + ", ad=" + ad + ", soyad=" + soyad + ", \u00fcyelik_ba\u015flang\u0131\u00e7_tarihi=" + üyelik_başlangıç_tarihi + ", \u00fcyelik_biti\u015f_tarihi=" + üyelik_bitiş_tarihi + ", yas=" + yas + ", sporalanlar\u0131_id=" + sporalanları_id + ", yemeklistesi_id=" + yemeklistesi_id + ", yemekListesi=" + yemekListesi + ", sporyapar=" + sporyapar + '}';
    }

 





    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.üye_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Üye other = (Üye) obj;
        if (!Objects.equals(this.üye_id, other.üye_id)) {
            return false;
        }
        return true;
    }
    
}
