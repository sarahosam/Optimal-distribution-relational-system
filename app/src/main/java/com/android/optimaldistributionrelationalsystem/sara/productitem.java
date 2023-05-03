package com.android.optimaldistributionrelationalsystem.sara;

public class productitem {
    int image,id;
    String name,title,price;


    public productitem(int image, int id, String name, String title, String price) {
        this.image = image;
        this.id = id;
        this.name = name;
        this.title = title;
        this.price = price;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }
}

