/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.SporAlanlarıDAO;
import entity.SporAlanları;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;




@Named
@SessionScoped
public class SporAlanlarıController implements Serializable{
 
 private List<SporAlanları> salist;
 private SporAlanlarıDAO sadao;
 private SporAlanları sporAlanları;
 
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
        this.pageCount=(int)Math.ceil(this.getShdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public SporAlanlarıController() {
    }

    public SporAlanlarıController(List<SporAlanları> salist, SporAlanlarıDAO sadao) {
        this.salist = salist;
        this.sadao = sadao;        
    }
    public void guncelleForm(SporAlanları sporalanları) {
        this.sporAlanları=sporalanları;
    }
    public void silBilgi(SporAlanları sporalanları){
       this.sporAlanları=sporalanları;
    }

    public void clearForm() {
        this.sporAlanları = new SporAlanları();

    }

    public void guncelle() {
        this.getShdao().guncelle(this.sporAlanları);
         this.sporAlanları = new SporAlanları();
    }

    public void sil() {
        this.getShdao().sil(this.sporAlanları);
        this.sporAlanları=new SporAlanları();

    }

    public void create() {
        this.getShdao().ekle(this.sporAlanları);
         this.sporAlanları = new SporAlanları();
    }

    public List<SporAlanları> getSalist() {
        this.salist = getShdao().findall(page,pageSize);
        return salist;
    }

    public void setSalist(List<SporAlanları> salist) {
        this.salist = salist;
    }

    public SporAlanlarıDAO getShdao() {
        if (this.sadao == null){ 
            this.sadao = new SporAlanlarıDAO();
    }
        return sadao;}

    public void setSadao(SporAlanlarıDAO sadao) {
        this.sadao = sadao;
    }

    public SporAlanları getSporAlanları() {
        if (this.sporAlanları == null) {
            this.sporAlanları = new SporAlanları();
        }
        return sporAlanları;
    }

    public void setSporAlanları(SporAlanları sporAlanları) {
        this.sporAlanları = sporAlanları;
    }
    
}
