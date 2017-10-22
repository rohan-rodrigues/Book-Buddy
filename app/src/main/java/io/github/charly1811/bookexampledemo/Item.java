package io.github.charly1811.bookexampledemo;

import android.widget.ImageView;

/**
 * Created by rohanrodrigues on 4/10/17.
 */

public class Item {
    private String name;
    private boolean isFavorite;
    private ImageView mImageView;
    private String description;
    private double price;
    private int review;

    private String sellerName;
    private String sellerEmail;
    private String sellerAddress;

    public Item(String name, ImageView mImageView, String description, double price) {
        this.name = name;
        this.mImageView = mImageView;
        this.description = description;
        this.price = price;
        review = -1;
        isFavorite = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setImageView(ImageView imageView) {
        mImageView = imageView;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }


    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }
}
