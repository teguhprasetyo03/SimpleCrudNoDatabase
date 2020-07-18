package com.studiomasteguh.simplecrudnodatabase;

public class MusicItem {

    private int imgItem;
    private String tvTitle;
    private String tvDesc;

    public void changeText1(String text){
        tvTitle = text;
    }

    public int getImgItem() {
        return imgItem;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public String getTvDesc() {
        return tvDesc;
    }

    public MusicItem(int imgItem, String tvTitle,  String tvDesc) {
        this.imgItem = imgItem;
        this.tvTitle = tvTitle;
        this.tvDesc = tvDesc;
    }


}
