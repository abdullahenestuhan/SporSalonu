    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.SporAlanlarıDAO;
import entity.SporAlanları;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("sporalanlarıConverter")
public class SporAlanlarıConverter implements Converter{

    private SporAlanlarıDAO sporAlanıDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getSporAlanlarıDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        SporAlanları y=(SporAlanları) arg2;
         return y.getSporalanları_id().toString();
    }

    public SporAlanlarıDAO getSporAlanlarıDAO() {
         if (this.sporAlanıDAO==null) 
            this.sporAlanıDAO=new SporAlanlarıDAO();
        return sporAlanıDAO;
    }
    
}
