package Gear;

/**
 * Created by jb039k on 4/6/2017.
 */
public class ArmorSet {


    private double healthEncumbrance;
    private double actionEncumbrance;
    private double mindEncumbrance;

    public ArmorSet(double healthEncumbrance, double actionEncumbrance, double mindEncumbrance){
        this.healthEncumbrance = healthEncumbrance;
        this.actionEncumbrance = actionEncumbrance;
        this.mindEncumbrance = mindEncumbrance;
    }

    public double getHealthEncumbrance() {
        return healthEncumbrance;
    }

    public double getActionEncumbrance() {
        return actionEncumbrance;
    }

    public double getMindEncumbrance() {
        return mindEncumbrance;
    }

    public void setHealthEncumbrance(double healthEncumbrance) {
        this.healthEncumbrance = healthEncumbrance;
    }

    public void setActionEncumbrance(double actionEncumbrance) {
        this.actionEncumbrance = actionEncumbrance;
    }

    public void setMindEncumbrance(double mindEncumbrance) {
        this.mindEncumbrance = mindEncumbrance;
    }
}
