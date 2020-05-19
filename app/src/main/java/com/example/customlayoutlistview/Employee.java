package com.example.customlayoutlistview;

public class Employee {
    private String id;
    private String foodName;
    private boolean isChecked;
    private String price;
    private String foodLink;
    private String foodLocaltion;
    private int imgFood;

    public Employee(String id, String foodName, boolean isChecked, String price, String foodLink, String foodLocaltion, int imgFood) {
        this.id = id;
        this.foodName = foodName;
        this.isChecked = isChecked;
        this.price = price;
        this.foodLink = foodLink;
        this.foodLocaltion = foodLocaltion;
        this.imgFood = imgFood;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id+"_"+foodName+"_"+price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFoodLink() {
        return foodLink;
    }

    public void setFoodLink(String foodLink) {
        this.foodLink = foodLink;
    }

    public String getFoodLocaltion() {
        return foodLocaltion;
    }

    public void setFoodLocaltion(String foodLocaltion) {
        this.foodLocaltion = foodLocaltion;
    }

    public int getImgFood() {
        return imgFood;
    }

    public void setImgFood(int imgFood) {
        this.imgFood = imgFood;
    }
}