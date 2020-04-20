/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;


public class YemekListesi {
    private Long yemeklistesi_id;
    private String adı;
    private String program;
    

    public YemekListesi() {
    }

    public YemekListesi(Long yemeklistesi_id, String adı, String program) {
        this.yemeklistesi_id = yemeklistesi_id;
        this.adı = adı;
        this.program = program;
    }

    public Long getYemeklistesi_id() {
        return yemeklistesi_id;
    }

    public void setYemeklistesi_id(Long yemeklistesi_id) {
        this.yemeklistesi_id = yemeklistesi_id;
    }

    public String getAdı() {
        return adı;
    }

    public void setAdı(String adı) {
        this.adı = adı;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "YemekListesi{" + "yemeklistesi_id=" + yemeklistesi_id + ", ad\u0131=" + adı + ", program=" + program + '}';
    }

 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.yemeklistesi_id);
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
        final YemekListesi other = (YemekListesi) obj;
        if (!Objects.equals(this.yemeklistesi_id, other.yemeklistesi_id)) {
            return false;
        }
        return true;
    }
    
}
