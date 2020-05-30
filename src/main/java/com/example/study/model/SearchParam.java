package com.example.study.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

//200529 Lombok 추가
//맥북에서 세팅
@Data
@AllArgsConstructor
public class SearchParam {
    private String account;
    private String email;
    private int page;

    
    
    
    //Lombok 세팅 전
   /* public SearchParam(){

    }

    public SearchParam(String account, String email, int page){
        this.account = account;
        this.email = email;
        this.page = page;
    }

    // { "account" : "", "email" : "", "page" : 0} <-- json 형태

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }*/
}
