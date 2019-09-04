package com.example.instagramgetallimage;

import java.util.ArrayList;

public class InstagramClass {
    private boolean has_next_page;
    private String end_cursor;
    private String data;


    public String getEnd_cursor() {
        return end_cursor;
    }

    public void setEnd_cursor(String end_cursor) {
        this.end_cursor = end_cursor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isHas_next_page() {
        return has_next_page;
    }

    public void setHas_next_page(boolean has_next_page) {
        this.has_next_page = has_next_page;
    }

    private ArrayList<String> getDataList() {
        ArrayList<String> arrList = new ArrayList<>();


        return arrList;
    }

}
