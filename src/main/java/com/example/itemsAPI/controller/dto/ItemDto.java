package com.example.itemsAPI.controller.dto;

public class ItemDto {


    private String name;

    private String description;

    private String imageURL;

    private double price;

    private Integer quantity;

    public ItemDto( String name, String description, String imageURL, double price,Integer quantity )
    {   this.price=price;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.quantity=quantity;
    }


    public ItemDto(){

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public void setImageURL( String imageURL )
    {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageURL + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
