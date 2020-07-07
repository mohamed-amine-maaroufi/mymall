package com.example.mymall;

public class CartItemModel {

    public static final int CART_ITEM = 0;
    public static final int TOTAL_AMOUNT = 1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    ////cart item
    private String productID;
    private String productImage;
    private String productTitle;
    private Long freeCoupens;
    private String productPrice;
    private String cuttedPrice;
    private Long productQuantite;
    private Long offerApplied;
    private Long coupensApplied;
    private boolean inStock;


    public CartItemModel(int type, String productID, String productImage, String productTitle, Long freeCoupens, String productPrice, String cuttedPrice, Long productQuantite, Long offerApplied, Long coupensApplied,boolean inStock) {
        this.type = type;
        this.productID=productID;
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freeCoupens = freeCoupens;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.productQuantite = productQuantite;
        this.offerApplied = offerApplied;
        this.coupensApplied = coupensApplied;
        this.inStock=inStock;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Long getFreeCoupens() {
        return freeCoupens;
    }

    public void setFreeCoupens(Long freeCoupens) {
        this.freeCoupens = freeCoupens;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public Long getProductQuantite() {
        return productQuantite;
    }

    public void setProductQuantite(Long productQuantite) {
        this.productQuantite = productQuantite;
    }

    public Long getOfferApplied() {
        return offerApplied;
    }

    public void setOfferApplied(Long offerApplied) {
        this.offerApplied = offerApplied;
    }

    public Long getCoupensApplied() {
        return coupensApplied;
    }

    public void setCoupensApplied(Long coupensApplied) {
        this.coupensApplied = coupensApplied;
    }

    ////cart item

    ////cart total

    public CartItemModel(int type) {
        this.type = type;
    }
    ////cart total

}
