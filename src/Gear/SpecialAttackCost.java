package Gear;

/**
 * Created by jb039k on 4/6/2017.
 */
public class SpecialAttackCost {
    /**
     *
     * SAC formula for special attacks is:
     * BaseCost = (SAC * Attack SAC modifier)
     *  BaseCost - ((((Efficiency stat - armor encumbrance)- 300) / 1200) * BaseCost)
     */
    public double getTotalSAC(double SAC, double attackModifier, double efficiencyStat){
        double baseCost = SAC*attackModifier;
        //SAC is calculated after encumbrance
//        double totalSac = ((efficiencyStat - 300) / 1200) * baseCost;
        double totalSac = baseCost * (1 - (efficiencyStat / 1500));

//        return (totalSac > baseCost) ? 0: baseCost - totalSac;
        return (totalSac < 0) ? 0: totalSac;
    }
}
