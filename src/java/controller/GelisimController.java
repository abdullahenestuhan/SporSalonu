/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.GelisimDAO;
import dao.ÜyeDAO;
import entity.Gelisim;
import entity.Üye;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;




@Named
@SessionScoped
public class GelisimController implements Serializable{
 private List<Üye> ülist;
 private ÜyeDAO üyeDAO;
 private List<Gelisim> glist;
 private GelisimDAO gdao;
 private Gelisim gelisim;

    public GelisimController(List<Üye> ülist, ÜyeDAO üyeDAO, List<Gelisim> glist, GelisimDAO gdao, Gelisim gelisim, int pageCount) {
        this.ülist = ülist;
        this.üyeDAO = üyeDAO;
        this.glist = glist;
        this.gdao = gdao;
        this.gelisim = gelisim;
        this.pageCount = pageCount;
    }
 
private int page=1;
    private int pageSize=5;
    private int pageCount;

    public void ileri(){
        if (this.page ==this.getPageCount()) 
            this.page=1;
        else
        this.page++;
        this.clearForm();
    }
    public void geri(){
        if (this.page==1) 
            this.page=this.getPageCount();
        else
        this.page--;
        this.clearForm();
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount=(int)Math.ceil(this.getGdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public GelisimController() {
    }

    public GelisimController(List<Gelisim> glist, GelisimDAO gdao) {
        this.glist = glist;
        this.gdao = gdao;        
    }
    public void guncelleForm(Gelisim sporalanları) {
        this.gelisim=sporalanları;
    }
    public void silBilgi(Gelisim sporalanları){
       this.gelisim=sporalanları;
    }

    public void clearForm() {
        this.gelisim = new Gelisim();

    }

    public void guncelle() {
        this.getGdao().guncelle(this.gelisim);
         this.gelisim = new Gelisim();
    }

    public void sil() {
        this.getGdao().sil(this.gelisim);
        this.gelisim=new Gelisim();

    }

    public void create() {
        this.getGdao().ekle(this.gelisim);
         this.gelisim = new Gelisim();
    }

    public List<Gelisim> getGlist() {
        this.glist = getGdao().findall(page,pageSize);
        return glist;
    }

    public void setGlist(List<Gelisim> glist) {
        this.glist = glist;
    }

    public GelisimDAO getGdao() {
        if (this.gdao == null){ 
            this.gdao = new GelisimDAO();
    }
        return gdao;}

    public void setSadao(GelisimDAO gdao) {
        this.gdao = gdao;
    }

    public Gelisim getGelisim() {
        if (this.gelisim == null) {
            this.gelisim = new Gelisim();
        }
        return gelisim;
    }

    public void setGelisim(Gelisim gelisim) {
        this.gelisim = gelisim;
    }

    public List<Üye> getÜlist() {
        this.ülist=this.getÜyeDAO().findall();
        return ülist;
    }

    public void setÜlist(List<Üye> ülist) {
        this.ülist = ülist;
    }

    public ÜyeDAO getÜyeDAO() {
        if (this.üyeDAO == null) {
            this.üyeDAO = new ÜyeDAO();
        }
        return üyeDAO;
    }

    public void setÜyeDAO(ÜyeDAO üyeDAO) {
        this.üyeDAO = üyeDAO;
    }
    
}
