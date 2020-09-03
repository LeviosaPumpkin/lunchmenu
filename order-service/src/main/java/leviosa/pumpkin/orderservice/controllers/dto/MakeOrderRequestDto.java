package leviosa.pumpkin.orderservice.controllers.dto;

import java.util.Date;
import java.util.Map;

public class MakeOrderRequestDto {
    private int empolyeeId;
    private int restaurantId;
    private Date date;
    Map<Integer, Integer> mealIdAmountMap;

    public int getEmpolyeeId() {
        return empolyeeId;
    }

    public void setEmpolyeeId(int empolyeeId) {
        this.empolyeeId = empolyeeId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<Integer, Integer> getMealIdAmountMap() {
        return mealIdAmountMap;
    }

    public void setMealIdAmountMap(Map<Integer, Integer> mealIdAmountMap) {
        this.mealIdAmountMap = mealIdAmountMap;
    }


}