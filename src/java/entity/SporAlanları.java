/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;


public class SporAlanları {
    private Long sporalanları_id;
    private String sporsalonu_ad;

    public SporAlanları(Long sporalanları_id, String sporsalonu_ad) {
        this.sporalanları_id = sporalanları_id;
        this.sporsalonu_ad = sporsalonu_ad;
    }

    public SporAlanları() {
    }

    public Long getSporalanları_id() {
        return sporalanları_id;
    }

    public void setSporalanları_id(Long sporalanları_id) {
        this.sporalanları_id = sporalanları_id;
    }

    public String getSporsalonu_ad() {
        return sporsalonu_ad;
    }

    public void setSporsalonu_ad(String sporsalonu_ad) {
        this.sporsalonu_ad = sporsalonu_ad;
    }

    @Override
    public String toString() {
        return "SporAlanlar\u0131{" + "sporalanlar\u0131_id=" + sporalanları_id + ", sporsalonu_ad=" + sporsalonu_ad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.sporalanları_id);
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
        final SporAlanları other = (SporAlanları) obj;
        if (!Objects.equals(this.sporalanları_id, other.sporalanları_id)) {
            return false;
        }
        return true;
    }
    
}
