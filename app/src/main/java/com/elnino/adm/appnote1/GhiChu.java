package com.elnino.adm.appnote1;

public class GhiChu {
    String title;
    String content;
    static public int i;

    public GhiChu(){
        title ="";
        content="";

    }

    public GhiChu(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.title ;
    }
}
