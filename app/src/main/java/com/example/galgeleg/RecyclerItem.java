package com.example.galgeleg;

public class RecyclerItem {
    private int image;
    private String name;
    private int point;
    private String text;

    public String getText(){
        return text;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    //constructor
    public RecyclerItem(int image, String name, int point, String text){
        this.image = image;
        this.name = name;
        this.point = point;
        this.text = text;
    }



}
