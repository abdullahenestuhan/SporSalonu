/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;


public class SporHocoları {
    private Long sporhocoları_id;
    private String ad;
    private String soyad;
    private int deneyim;
    private int yas;
    private String uzamanlıkalanı; 

    public SporHocoları() {
    }

    public SporHocoları(Long sporhocoları_id, String ad, String soyad, int deneyim, int yas, String uzamanlıkalanı) {
        this.sporhocoları_id = sporhocoları_id;
        this.ad = ad;
        this.soyad = soyad;
        this.deneyim = deneyim;
        this.yas = yas;
        this.uzamanlıkalanı = uzamanlıkalanı;
    }

    

    public Long getSporhocoları_id() {
        return sporhocoları_id;
    }

    public void setSporhocoları_id(Long sporhocoları_id) {
        this.sporhocoları_id = sporhocoları_id;
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

    public int getDeneyim() {
        return deneyim;
    }

    public void setDeneyim(int deneyim) {
        this.deneyim = deneyim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

   

    public String getUzamanlıkalanı() {
        return uzamanlıkalanı;
    }

    public void setUzamanlıkalanı(String uzamanlıkalanı) {
        this.uzamanlıkalanı = uzamanlıkalanı;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.sporhocoları_id);
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
        final SporHocoları other = (SporHocoları) obj;
        if (!Objects.equals(this.sporhocoları_id, other.sporhocoları_id)) {
            return false;
        }
        return true;
    }

   
    
    
    
}
