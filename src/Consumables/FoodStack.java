package Consumables;

import java.util.HashMap;

/**
 * Created by jb039k on 6/30/2017.
 */
public class FoodStack {

    private HashMap<String, double[]> food = new HashMap<>();

    public void addFood(String foodName, double stats, double fill, double duration){
        double[] foodStats = {stats, fill, duration};
        food.put(foodName, foodStats);
    }

    public HashMap<String, double[]> getFood() {
        return food;
    }
}
