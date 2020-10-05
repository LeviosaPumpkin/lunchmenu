package leviosa.pumpkin.orderservice.controllers.dto;

import java.util.Date;

public class GetOrdersResponseDto {
    private Date date;
    private int mealOrderId; 
    private String mealName;
    private String restaurant;
    private int amount;
    private float price;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMealOrderId() {
        return mealOrderId;
    }

    public void setMealOrderId(int mealOrderId) {
        this.mealOrderId = mealOrderId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}