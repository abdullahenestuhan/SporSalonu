/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.YemekListesiDAO;
import entity.YemekListesi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;




@Named
@SessionScoped
public class YemekListesiController implements Serializable{
 
 private List<YemekListesi> ylist;
 private YemekListesiDAO ydao;
 private YemekListesi yemeklistesi;
 
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
        this.pageCount=(int)Math.ceil(this.getYdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public YemekListesiController() {
    }

    public YemekListesiController(List<YemekListesi> ylist, YemekListesiDAO ydao) {
        this.ylist = ylist;
        this.ydao = ydao;        
    }
    public void guncelleForm(YemekListesi sporalanları) {
        this.yemeklistesi=sporalanları;
    }
    public void silBilgi(YemekListesi sporalanları){
       this.yemeklistesi=sporalanları;
    }

    public void clearForm() {
        this.yemeklistesi = new YemekListesi();

    }

    public void guncelle() {
        this.getYdao().guncelle(this.yemeklistesi);
         this.yemeklistesi = new YemekListesi();
    }

    public void sil() {
        this.getYdao().sil(this.yemeklistesi);
        this.yemeklistesi=new YemekListesi();

    }

    public void create() {
        this.getYdao().ekle(this.yemeklistesi);
         this.yemeklistesi = new YemekListesi();
    }

    public List<YemekListesi> getYlist() {
        this.ylist = getYdao().findall(page,pageSize);
        return ylist;
    }

    public void setYlist(List<YemekListesi> ylist) {
        this.ylist = ylist;
    }

    public YemekListesiDAO getYdao() {
        if (this.ydao == null){ 
            this.ydao = new YemekListesiDAO();
    }
        return ydao;}

    public void setYdao(YemekListesiDAO ydao) {
        this.ydao = ydao;
    }

    public YemekListesi getYemekListesi() {
        if (this.yemeklistesi == null) {
            this.yemeklistesi = new YemekListesi();
        }
        return yemeklistesi;
    }

    public void setYemekListesi(YemekListesi yemeklistesi) {
        this.yemeklistesi = yemeklistesi;
    }
    
}
