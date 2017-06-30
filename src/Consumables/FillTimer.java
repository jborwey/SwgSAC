package Consumables;

import com.google.common.base.Stopwatch;

import java.util.HashMap;

/**
 * Created by jb039k on 6/30/2017.
 */
public class FillTimer {

    private Stopwatch stopwatch;
    private HashMap<String, double[]> consumableStack = new HashMap<>();
    private double totalFill = 0;
    private double emptyRate = 3.33;

    public void getStack(HashMap<String, double[]> consumableStack){
        this.consumableStack = consumableStack;
    }
}
