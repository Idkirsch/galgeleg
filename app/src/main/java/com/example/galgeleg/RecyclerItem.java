package com.example.galgeleg;

public class RecyclerItem {
    private int image;
    private String name;
    private int point;

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
    public RecyclerItem(int image, String name, int point){
        this.image = image;
        this.name = name;
        this.point = point;
    }



}
