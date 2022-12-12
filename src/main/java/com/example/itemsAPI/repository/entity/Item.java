package com.example.itemsAPI.repository.entity;

import com.example.itemsAPI.controller.dto.ItemDto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1)

    private Integer id;

    private String name;

    private String description;

    private String imageURL;

    private Integer quantity;

    private double price;


    public Item() {
    }

    public Item(ItemDto itemDto){
        this.name=itemDto.getName();
        this.quantity= itemDto.getQuantity();
        this.price= itemDto.getPrice();
        this.imageURL=itemDto.getImageURL();
        this.description= itemDto.getDescription();
    }

    public Item(Integer id, String name, String description, String imageUrl, double price, Integer quantity) {
        this.id = id;
        this.description=description;
        this.imageURL=imageUrl;
        this.price=price;
        this.name=name;
        this.quantity=quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(description, item.description) && Objects.equals(imageURL, item.imageURL) && Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imageURL, quantity, price);
    }
}
