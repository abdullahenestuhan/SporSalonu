/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;


public class Gelisim {
    private Long gelisim_id;
    private Long üye_id;
    private int eski_kg;
    private int yenikg;

    public Gelisim(Long gelisim_id, Long üye_id, int eski_kg, int yenikg, int yenivücutkütleindeksi, int eskivücutkütleindeksi, int boy, Üye üye) {
        this.gelisim_id = gelisim_id;
        this.üye_id = üye_id;
        this.eski_kg = eski_kg;
        this.yenikg = yenikg;
        this.yenivücutkütleindeksi = yenivücutkütleindeksi;
        this.eskivücutkütleindeksi = eskivücutkütleindeksi;
        this.boy = boy;
        this.üye = üye;
    }
    private int yenivücutkütleindeksi;
    private int eskivücutkütleindeksi;
    private int boy;
    private Üye üye;

   

    public Gelisim() {
    }

    public Long getGelisim_id() {
        return gelisim_id;
    }

    public void setGelisim_id(Long gelisim_id) {
        this.gelisim_id = gelisim_id;
    }

    public int getEski_kg() {
        return eski_kg;
    }

    public void setEski_kg(int eski_kg) {
        this.eski_kg = eski_kg;
    }

    public int getYenikg() {
        return yenikg;
    }

    public void setYenikg(int yenikg) {
        this.yenikg = yenikg;
    }

    public int getYenivücutkütleindeksi() {
        return yenivücutkütleindeksi;
    }

    public void setYenivücutkütleindeksi(int yenivücutkütleindeksi) {
        this.yenivücutkütleindeksi = yenivücutkütleindeksi;
    }

    public int getEskivücutkütleindeksi() {
        return eskivücutkütleindeksi;
    }

    public void setEskivücutkütleindeksi(int eskivücutkütleindeksi) {
        this.eskivücutkütleindeksi = eskivücutkütleindeksi;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public Long getÜye_id() {
        return üye_id;
    }

    public void setÜye_id(Long üye_id) {
        this.üye_id = üye_id;
    }

    

    public Üye getÜye() {
        return üye;
    }

    public void setÜye(Üye üye) {
        this.üye = üye;
    }

    @Override
    public String toString() {
        return "Gelisim{" + "gelisim_id=" + gelisim_id + ", \u00fcye_id=" + üye_id + ", eski_kg=" + eski_kg + ", yenikg=" + yenikg + ", yeniv\u00fccutk\u00fctleindeksi=" + yenivücutkütleindeksi + ", eskiv\u00fccutk\u00fctleindeksi=" + eskivücutkütleindeksi + ", boy=" + boy + ", \u00fcye=" + üye + '}';
    }
    

    

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.gelisim_id);
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
        final Gelisim other = (Gelisim) obj;
        if (!Objects.equals(this.gelisim_id, other.gelisim_id)) {
            return false;
        }
        return true;
    }
    
}
