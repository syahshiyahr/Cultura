package com.example.cultura.model;

public class home {
    private int image;
    private String name;
    private String desc;
    private String jarak;
    private String objek;

    public home(int image, String name, String desc, String jarak, String objek){
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.jarak = jarak;
        this.objek = objek;

    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getJarak() {
        return jarak;
    }

    public String getObjek() {
        return objek;
    }


}
