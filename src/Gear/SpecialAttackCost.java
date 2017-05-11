package Gear;

/**
 * Created by jb039k on 4/6/2017.
 */
public class SpecialAttackCost {
    public double getTotalSAC(int SAC, double attackModifier, int efficiencyStat, int armorEncumbrance){
        double baseCost = (double)SAC*attackModifier;
        //SAC is calculated after encumbrance
        double totalSac = ((efficiencyStat -(double)armorEncumbrance) - 300) / 1200;


        return baseCost - (totalSac * baseCost);
    }
}
