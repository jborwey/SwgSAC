package Consumables;

import java.util.HashMap;

/**
 * Created by jb039k on 6/30/2017.
 */
public class DrinkStack {

    private HashMap<String, double[]> drink = new HashMap<>();

    public void addDrink(String drinkName, double stats, double fill, double duration){
        double[] drinkStats = {stats, fill, duration};
        drink.put(drinkName, drinkStats);
    }

    public HashMap<String, double[]> getDrink() {
        return drink;
    }
}
