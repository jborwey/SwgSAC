package Gear;

/**
 * Created by jb039k on 4/6/2017.
 */
public class ArmorSet {


    private int healthEncumbrance;
    private int actionEncumbrance;
    private int mindEncumbrance;

    public void newArmorSuit(int healthEncumbrance, int actionEncumbrance, int mindEncumbrance){
        this.healthEncumbrance = healthEncumbrance;
        this.actionEncumbrance = actionEncumbrance;
        this.mindEncumbrance = mindEncumbrance;
    }

    public int getHealthEncumbrance() {
        return healthEncumbrance;
    }

    public int getActionEncumbrance() {
        return actionEncumbrance;
    }

    public int getMindEncumbrance() {
        return mindEncumbrance;
    }

    public void setHealthEncumbrance(int healthEncumbrance) {
        this.healthEncumbrance = healthEncumbrance;
    }

    public void setActionEncumbrance(int actionEncumbrance) {
        this.actionEncumbrance = actionEncumbrance;
    }

    public void setMindEncumbrance(int mindEncumbrance) {
        this.mindEncumbrance = mindEncumbrance;
    }
}
