/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.SporAlanlarıDAO;
import dao.YemekListesiDAO;
import dao.ÜyeDAO;
import entity.SporAlanları;
import entity.YemekListesi;
import entity.Üye;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;




@Named
@SessionScoped
public class ÜyeController implements Serializable{
    @Inject
    private SporAlanlarıController sporAlanlarıController;
    
    private List<SporAlanları> slist;
    private List<YemekListesi> ylist;
    private SporAlanlarıDAO sporAlanlarıDAO;
    private YemekListesiDAO yemekListesiDAO;
    
 private List<Üye> ülist;
 private ÜyeDAO üdao;
 private Üye üye;
 
 
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
        this.pageCount=(int)Math.ceil(this.getÜdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public ÜyeController() {
    }

    public ÜyeController(SporAlanlarıController sporAlanlarıController, List<SporAlanları> slist, List<YemekListesi> ylist, SporAlanlarıDAO sporAlanlarıDAO, YemekListesiDAO yemekListesiDAO, List<Üye> ülist, ÜyeDAO üdao, Üye üye, int pageCount) {
        this.sporAlanlarıController = sporAlanlarıController;
        this.slist = slist;
        this.ylist = ylist;
        this.sporAlanlarıDAO = sporAlanlarıDAO;
        this.yemekListesiDAO = yemekListesiDAO;
        this.ülist = ülist;
        this.üdao = üdao;
        this.üye = üye;
        this.pageCount = pageCount;
    }
    public ÜyeController(List<Üye> ülist, ÜyeDAO üdao) {
        this.ülist = ülist;
        this.üdao = üdao;        
    }
    public void guncelleForm(Üye üye) {
        this.üye=üye;
    }
    public void silBilgi(Üye üye){
       this.üye=üye;
    }

    public void clearForm() {
        this.üye = new Üye();

    }

    public void guncelle() {
        this.getÜdao().guncelle(this.üye);
         this.üye = new Üye();
    }

    public void sil() {
        this.getÜdao().sil(this.üye);
        this.üye=new Üye();

    }

    public void create() {
        this.getÜdao().ekle(this.üye);
         this.üye = new Üye();
    }

    public List<Üye> getÜlist() {
        this.ülist = getÜdao().findall(page,pageSize);
        return ülist;
    }

    public void setÜlist(List<Üye> ülist) {
        this.ülist = ülist;
    }

    public ÜyeDAO getÜdao() {
        if (this.üdao == null){ 
            this.üdao = new ÜyeDAO();
    }
        return üdao;}

    public void setÜdao(ÜyeDAO üdao) {
        this.üdao = üdao;
    }

    public Üye getÜye() {
        if (this.üye == null) {
            this.üye = new Üye();
        }
        return üye;
    }

    public void setÜye(Üye üye) {
        this.üye = üye;
    }

    public SporAlanlarıController getSporAlanlarıController() {
        return sporAlanlarıController;
    }

    public void setSporAlanlarıController(SporAlanlarıController sporAlanlarıController) {
        this.sporAlanlarıController = sporAlanlarıController;
    }

    public List<SporAlanları> getSlist() {
         this.slist=this.getSporAlanlarıDAO().findall();
        return slist;
    }

    public void setSlist(List<SporAlanları> slist) {
        this.slist = slist;
    }

    public List<YemekListesi> getYlist() {
        this.ylist=this.getYemekListesiDAO().findall();
        return ylist;
    }

    public void setYlist(List<YemekListesi> ylist) {
        this.ylist = ylist;
    }

    public SporAlanlarıDAO getSporAlanlarıDAO() {
        if (this.sporAlanlarıDAO == null) {
            this.sporAlanlarıDAO = new SporAlanlarıDAO();
        }
        return sporAlanlarıDAO;
    }



    public YemekListesiDAO getYemekListesiDAO() {
        if (this.yemekListesiDAO == null) {
            this.yemekListesiDAO = new YemekListesiDAO();
        }
        return yemekListesiDAO;
    }

    
}
