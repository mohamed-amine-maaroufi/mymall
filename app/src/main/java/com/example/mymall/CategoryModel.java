package com.example.mymall;

public class CategoryModel {
    private  String CategoryIconLink;
    private  String categoryName;
    private String categoryindex;

    /*public CategoryModel(String categoryIconLink, String categoryName, int categoryindex) {
        CategoryIconLink = categoryIconLink;
        this.categoryName = categoryName;
        this.categoryindex = categoryindex;
    }*/

    public CategoryModel(String categoryIconLink, String categoryName, String categoryindex) {
        CategoryIconLink = categoryIconLink;
        this.categoryName = categoryName;
        this.categoryindex = categoryindex;
    }

    public CategoryModel(String categoryIconLink, String categoryName) {
        CategoryIconLink = categoryIconLink;
        this.categoryName = categoryName;
    }


    public String getCategoryIconLink() {
        return CategoryIconLink;
    }

    public void setCategoryIconLink(String categoryIconLink) {
        CategoryIconLink = categoryIconLink;
    }

    public String getCategoryindex() {
        return categoryindex;
    }

    public void setCategoryindex(String categoryindex) {
        this.categoryindex = categoryindex;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
