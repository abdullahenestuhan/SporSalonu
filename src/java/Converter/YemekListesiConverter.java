    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.YemekListesiDAO;
import entity.YemekListesi;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("yemeklistesiConverter")
public class YemekListesiConverter implements Converter{

    private YemekListesiDAO yemekListesiDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getYemekListesiDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        YemekListesi y=(YemekListesi) arg2;
        return y.getYemeklistesi_id().toString();
    }

    public YemekListesiDAO getYemekListesiDAO() {
         if (this.yemekListesiDAO==null) 
            this.yemekListesiDAO=new YemekListesiDAO();
        return yemekListesiDAO;
    }
    
}
