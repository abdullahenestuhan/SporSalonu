/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ABDULLAH
 */
@Named
@RequestScoped
public class NavigationBean implements Serializable{
    public String page(String p){
        return "/module/"+p+"/"+p+"?faces-redirct=true";       
    }
    public String pages(String s){
        return "/module/"+s+"/"+s+"?faces-redirct=true";       
    }
    public String pagess(String t){
        return "/module/"+t+"/"+t+"?faces-redirct=true";       
    }
    public String pagesss(String r){
        return "/module/"+r+"/"+r+"?faces-redirct=true";       
    }
    public String pagessss(String a){
        return "/module/"+a+"/"+a+"?faces-redirct=true";       
    }


}
