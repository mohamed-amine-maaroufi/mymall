package com.example.mymall.manageproducts;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String star_1;
    private String star_2;
    private String star_3;
    private String star_4;
    private String star_5;
    private String cod;
    private String in_stock;
    private String average_rating;
    private String cutted_price;
    private String free_coupen_body;
    private String free_coupen_title;
    private String free_coupens;
    private String product_description;
    private String no_of_product_images;
    private String product_image_1;
    private String product_image_2;
    private String product_image_3;
    private String product_other_details;
    private String product_price;
    private String product_title;
    private String spec_title_1;
    private String spec_title_1_field_1_name;
    private String spec_title_1_field_1_value;
    private String spec_title_1_field_2_name;
    private String spec_title_1_field_2_value;
    private String spec_title_1_totals_fields;
    private String spec_title_2;
    private String spec_title_2_field_1_name;
    private String spec_title_2_field_1_value;
    private String spec_title_2_field_2_name;
    private String spec_title_2_field_2_value;
    private String spec_title_2_totals_fields;
    private String spec_title_3;
    private String spec_title_3_field_1_name;
    private String spec_title_3_field_1_value;
    private String spec_title_3_field_2_name;
    private String spec_title_3_field_2_value;
    private String spec_title_3_totals_fields;
    private String spec_title_4;
    private String spec_title_4_field_1_name;
    private String spec_title_4_field_1_value;
    private String spec_title_4_field_2_name;
    private String spec_title_4_field_2_value;
    private String spec_title_4_field_3_name;
    private String spec_title_4_field_3_value;
    private String spec_title_4_totals_fields;
    private String total_rating;
    private String total_spec_titles;

    //constructor with parameters
    public Product(
            String star_1,
            String star_2,
            String star_3,
            String star_4,
            String star_5,
            String cod,
            String in_stock,
            String average_rating,
            String cutted_price,
            String free_coupen_body,
            String free_coupen_title,
            String free_coupens,
            String product_description,
            String product_image_1,
            String no_of_product_images,
            String product_image_2,
            String product_image_3,
            String product_other_details,
            String product_price,
            String product_title,
            String spec_title_1,
            String spec_title_1_field_1_name,
            String spec_title_1_field_1_value,
            String spec_title_1_field_2_value,
            String spec_title_1_totals_fields,
            String spec_title_2,
            String spec_title_2_field_1_name,
            String spec_title_2_field_1_value,
            String spec_title_2_field_2_name,
            String spec_title_2_field_2_value,
            String spec_title_2_totals_fields,
            String spec_title_3,
            String spec_title_3_field_1_name,
            String spec_title_3_field_1_value,
            String spec_title_3_field_2_name,
            String spec_title_3_field_2_value,
            String spec_title_3_totals_fields,
            String spec_title_4,
            String spec_title_4_field_1_name,
            String spec_title_4_field_1_value,
            String spec_title_4_field_2_name,
            String spec_title_4_field_2_value,
            String spec_title_4_field_3_name,
            String spec_title_4_field_3_value,
            String spec_title_4_totals_fields,
            String total_rating,
            String total_spec_titles
    )
    {
		this.star_1 = star_1;
		this.star_2 = star_2;
		this.star_3 = star_3;
		this.star_4 = star_4;
		this.star_5 = star_5;
		this.in_stock = in_stock;
		this.cod = cod;
		this.average_rating = average_rating;
		this.cutted_price = cutted_price;
		this.free_coupen_body = free_coupen_body;
		this.free_coupen_title = free_coupen_title;
		this.free_coupens = free_coupens;
		this.product_description = product_description;
		this.no_of_product_images = no_of_product_images;
		this.product_image_1 = product_image_1;
		this.product_image_2 = product_image_2;
		this.product_image_3 = product_image_3;
		this.product_other_details = product_other_details;
		this.product_price = product_price;
		this.product_title = product_title;
		this.spec_title_1 = spec_title_1;
		this.spec_title_1_field_1_name = spec_title_1_field_1_name;
		this.spec_title_1_field_1_value = spec_title_1_field_1_value;
		this.spec_title_1_field_2_name = spec_title_1_field_2_name;
		this.spec_title_1_field_2_value = spec_title_1_field_2_value;
		this.spec_title_1_totals_fields = spec_title_1_totals_fields;
		this.spec_title_2 = spec_title_2;
		this.spec_title_2_field_1_name = spec_title_2_field_1_name;
		this.spec_title_2_field_1_value = spec_title_2_field_1_value;
		this.spec_title_2_field_2_name = spec_title_2_field_2_name;
		this.spec_title_2_field_2_value = spec_title_2_field_2_value;
		this.spec_title_2_totals_fields = spec_title_2_totals_fields;
		this.spec_title_3 = spec_title_3;
		this.spec_title_3_field_1_name = spec_title_3_field_1_name;
		this.spec_title_3_field_1_value = spec_title_3_field_1_value;
		this.spec_title_3_field_2_name = spec_title_3_field_2_name;
		this.spec_title_3_field_2_value = spec_title_3_field_2_value;
		this.spec_title_3_totals_fields = spec_title_3_totals_fields;
		this.spec_title_4 = spec_title_4;
		this.spec_title_4_field_1_name = spec_title_4_field_1_name;
		this.spec_title_4_field_1_value = spec_title_4_field_1_value;
		this.spec_title_4_field_2_name = spec_title_4_field_2_name;
		this.spec_title_4_field_2_value = spec_title_4_field_2_value;
		this.spec_title_4_field_3_name = spec_title_4_field_3_name;
		this.spec_title_4_field_3_value = spec_title_4_field_3_value;
		this.spec_title_4_totals_fields = spec_title_4_totals_fields;
		this.total_rating = total_rating;
		this.total_spec_titles = total_spec_titles;

    }

    //default constructor
    public Product(){

    }

    public String getNo_of_product_images() {
        return no_of_product_images;
    }

    public void setNo_of_product_images(String no_of_product_images) {
        this.no_of_product_images = no_of_product_images;
    }

    public String getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(String in_stock) {
        this.in_stock = in_stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStar_1() {
        return star_1;
    }

    public void setStar_1(String star_1) {
        this.star_1 = star_1;
    }

    public String getStar_2() {
        return star_2;
    }

    public void setStar_2(String star_2) {
        this.star_2 = star_2;
    }

    public String getStar_3() {
        return star_3;
    }

    public void setStar_3(String star_3) {
        this.star_3 = star_3;
    }

    public String getStar_4() {
        return star_4;
    }

    public void setStar_4(String star_4) {
        this.star_4 = star_4;
    }

    public String getStar_5() {
        return star_5;
    }

    public void setStar_5(String star_5) {
        this.star_5 = star_5;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public String getCutted_price() {
        return cutted_price;
    }

    public void setCutted_price(String cutted_price) {
        this.cutted_price = cutted_price;
    }

    public String getFree_coupen_body() {
        return free_coupen_body;
    }

    public void setFree_coupen_body(String free_coupen_body) {
        this.free_coupen_body = free_coupen_body;
    }

    public String getFree_coupen_title() {
        return free_coupen_title;
    }

    public void setFree_coupen_title(String free_coupen_title) {
        this.free_coupen_title = free_coupen_title;
    }

    public String getFree_coupens() {
        return free_coupens;
    }

    public void setFree_coupens(String free_coupens) {
        this.free_coupens = free_coupens;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_image_1() {
        return product_image_1;
    }

    public void setProduct_image_1(String product_image_1) {
        this.product_image_1 = product_image_1;
    }

    public String getProduct_image_2() {
        return product_image_2;
    }

    public void setProduct_image_2(String product_image_2) {
        this.product_image_2 = product_image_2;
    }

    public String getProduct_image_3() {
        return product_image_3;
    }

    public void setProduct_image_3(String product_image_3) {
        this.product_image_3 = product_image_3;
    }

    public String getProduct_other_details() {
        return product_other_details;
    }

    public void setProduct_other_details(String product_other_details) {
        this.product_other_details = product_other_details;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getSpec_title_1() {
        return spec_title_1;
    }

    public void setSpec_title_1(String spec_title_1) {
        this.spec_title_1 = spec_title_1;
    }

    public String getSpec_title_1_field_1_name() {
        return spec_title_1_field_1_name;
    }

    public void setSpec_title_1_field_1_name(String spec_title_1_field_1_name) {
        this.spec_title_1_field_1_name = spec_title_1_field_1_name;
    }

    public String getSpec_title_1_field_1_value() {
        return spec_title_1_field_1_value;
    }

    public void setSpec_title_1_field_1_value(String spec_title_1_field_1_value) {
        this.spec_title_1_field_1_value = spec_title_1_field_1_value;
    }

    public String getSpec_title_1_field_2_name() {
        return spec_title_1_field_2_name;
    }

    public void setSpec_title_1_field_2_name(String spec_title_1_field_2_name) {
        this.spec_title_1_field_2_name = spec_title_1_field_2_name;
    }

    public String getSpec_title_1_field_2_value() {
        return spec_title_1_field_2_value;
    }

    public void setSpec_title_1_field_2_value(String spec_title_1_field_2_value) {
        this.spec_title_1_field_2_value = spec_title_1_field_2_value;
    }

    public String getSpec_title_1_totals_fields() {
        return spec_title_1_totals_fields;
    }

    public void setSpec_title_1_totals_fields(String spec_title_1_totals_fields) {
        this.spec_title_1_totals_fields = spec_title_1_totals_fields;
    }

    public String getSpec_title_2() {
        return spec_title_2;
    }

    public void setSpec_title_2(String spec_title_2) {
        this.spec_title_2 = spec_title_2;
    }

    public String getSpec_title_2_field_1_name() {
        return spec_title_2_field_1_name;
    }

    public void setSpec_title_2_field_1_name(String spec_title_2_field_1_name) {
        this.spec_title_2_field_1_name = spec_title_2_field_1_name;
    }

    public String getSpec_title_2_field_1_value() {
        return spec_title_2_field_1_value;
    }

    public void setSpec_title_2_field_1_value(String spec_title_2_field_1_value) {
        this.spec_title_2_field_1_value = spec_title_2_field_1_value;
    }

    public String getSpec_title_2_field_2_name() {
        return spec_title_2_field_2_name;
    }

    public void setSpec_title_2_field_2_name(String spec_title_2_field_2_name) {
        this.spec_title_2_field_2_name = spec_title_2_field_2_name;
    }

    public String getSpec_title_2_field_2_value() {
        return spec_title_2_field_2_value;
    }

    public void setSpec_title_2_field_2_value(String spec_title_2_field_2_value) {
        this.spec_title_2_field_2_value = spec_title_2_field_2_value;
    }

    public String getSpec_title_2_totals_fields() {
        return spec_title_2_totals_fields;
    }

    public void setSpec_title_2_totals_fields(String spec_title_2_totals_fields) {
        this.spec_title_2_totals_fields = spec_title_2_totals_fields;
    }

    public String getSpec_title_3() {
        return spec_title_3;
    }

    public void setSpec_title_3(String spec_title_3) {
        this.spec_title_3 = spec_title_3;
    }

    public String getSpec_title_3_field_1_name() {
        return spec_title_3_field_1_name;
    }

    public void setSpec_title_3_field_1_name(String spec_title_3_field_1_name) {
        this.spec_title_3_field_1_name = spec_title_3_field_1_name;
    }

    public String getSpec_title_3_field_1_value() {
        return spec_title_3_field_1_value;
    }

    public void setSpec_title_3_field_1_value(String spec_title_3_field_1_value) {
        this.spec_title_3_field_1_value = spec_title_3_field_1_value;
    }

    public String getSpec_title_3_field_2_name() {
        return spec_title_3_field_2_name;
    }

    public void setSpec_title_3_field_2_name(String spec_title_3_field_2_name) {
        this.spec_title_3_field_2_name = spec_title_3_field_2_name;
    }

    public String getSpec_title_3_field_2_value() {
        return spec_title_3_field_2_value;
    }

    public void setSpec_title_3_field_2_value(String spec_title_3_field_2_value) {
        this.spec_title_3_field_2_value = spec_title_3_field_2_value;
    }

    public String getSpec_title_3_totals_fields() {
        return spec_title_3_totals_fields;
    }

    public void setSpec_title_3_totals_fields(String spec_title_3_totals_fields) {
        this.spec_title_3_totals_fields = spec_title_3_totals_fields;
    }

    public String getSpec_title_4() {
        return spec_title_4;
    }

    public void setSpec_title_4(String spec_title_4) {
        this.spec_title_4 = spec_title_4;
    }

    public String getSpec_title_4_field_1_name() {
        return spec_title_4_field_1_name;
    }

    public void setSpec_title_4_field_1_name(String spec_title_4_field_1_name) {
        this.spec_title_4_field_1_name = spec_title_4_field_1_name;
    }

    public String getSpec_title_4_field_1_value() {
        return spec_title_4_field_1_value;
    }

    public void setSpec_title_4_field_1_value(String spec_title_4_field_1_value) {
        this.spec_title_4_field_1_value = spec_title_4_field_1_value;
    }

    public String getSpec_title_4_field_2_name() {
        return spec_title_4_field_2_name;
    }

    public void setSpec_title_4_field_2_name(String spec_title_4_field_2_name) {
        this.spec_title_4_field_2_name = spec_title_4_field_2_name;
    }

    public String getSpec_title_4_field_2_value() {
        return spec_title_4_field_2_value;
    }

    public void setSpec_title_4_field_2_value(String spec_title_4_field_2_value) {
        this.spec_title_4_field_2_value = spec_title_4_field_2_value;
    }

    public String getSpec_title_4_field_3_name() {
        return spec_title_4_field_3_name;
    }

    public void setSpec_title_4_field_3_name(String spec_title_4_field_3_name) {
        this.spec_title_4_field_3_name = spec_title_4_field_3_name;
    }

    public String getSpec_title_4_field_3_value() {
        return spec_title_4_field_3_value;
    }

    public void setSpec_title_4_field_3_value(String spec_title_4_field_3_value) {
        this.spec_title_4_field_3_value = spec_title_4_field_3_value;
    }

    public String getSpec_title_4_totals_fields() {
        return spec_title_4_totals_fields;
    }

    public void setSpec_title_4_totals_fields(String spec_title_4_totals_fields) {
        this.spec_title_4_totals_fields = spec_title_4_totals_fields;
    }

    public String getTotal_rating() {
        return total_rating;
    }

    public void setTotal_rating(String total_rating) {
        this.total_rating = total_rating;
    }

    public String getTotal_spec_titles() {
        return total_spec_titles;
    }

    public void setTotal_spec_titles(String total_spec_titles) {
        this.total_spec_titles = total_spec_titles;
    }
}