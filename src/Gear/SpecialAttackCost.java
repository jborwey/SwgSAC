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
    public double getTotalSAC(double SAC, double attackModifier, double efficiencyStat, double armorEncumbrance){
        double baseCost = SAC*attackModifier;
        //SAC is calculated after encumbrance
        double totalSac = (((efficiencyStat - armorEncumbrance) - 300) / 1200) * baseCost;

        return (totalSac > baseCost) ? 0: baseCost - totalSac;
    }
}
