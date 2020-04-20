    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.ÜyeDAO;
import entity.Üye;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("üyeConverter")
public class ÜyeConverter implements Converter{

    private ÜyeDAO üyeDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getÜyeDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Üye y=(Üye) arg2;
        return y.getÜye_id().toString();
    }

    public ÜyeDAO getÜyeDAO() {
         if (this.üyeDAO==null) 
            this.üyeDAO=new ÜyeDAO();
        return üyeDAO;
    }
    
}
