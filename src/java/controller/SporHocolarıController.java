/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.SporHocolarıDAO;
import entity.SporHocoları;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author ABDULLAH
 */
@Named
@SessionScoped
public class SporHocolarıController implements Serializable{
 
 private List<SporHocoları> shlist;
 private SporHocolarıDAO shdao;
 private SporHocoları sporHocoları;
 
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
    
    public SporHocolarıController() {
    }

    public SporHocolarıController(List<SporHocoları> shlist, SporHocolarıDAO shdao) {
        this.shlist = shlist;
        this.shdao = shdao;        
    }
    public void guncelleForm(SporHocoları sporhocoları) {
        this.sporHocoları=sporhocoları;
    }
    public void silBilgi(SporHocoları sporhocoları){
       this.sporHocoları=sporhocoları;
    }

    public void clearForm() {
        this.sporHocoları = new SporHocoları();

    }

    public void guncelle() {
        this.getShdao().guncelle(this.sporHocoları);
         this.sporHocoları = new SporHocoları();
    }

    public void sil() {
        this.getShdao().sil(this.sporHocoları);
        this.sporHocoları=new SporHocoları();

    }

    public void create() {
        this.getShdao().ekle(this.sporHocoları);
         this.sporHocoları = new SporHocoları();
    }

    public List<SporHocoları> getYlist() {
        this.shlist = getShdao().findall(page,pageSize);
        return shlist;
    }

    public void setYlist(List<SporHocoları> shlist) {
        this.shlist = shlist;
    }

    public SporHocolarıDAO getShdao() {
        if (this.shdao == null){ 
            this.shdao = new SporHocolarıDAO();
    }
        return shdao;}

    public void setShdao(SporHocolarıDAO shdao) {
        this.shdao = shdao;
    }

    public SporHocoları getSporHocoları() {
        if (this.sporHocoları == null) {
            this.sporHocoları = new SporHocoları();
        }
        return sporHocoları;
    }

    public void setSporHocoları(SporHocoları sporHocoları) {
        this.sporHocoları = sporHocoları;
    }
    
}
