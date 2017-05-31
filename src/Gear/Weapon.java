package Gear;

/**
 * Created by jb039k on 4/6/2017.
 */
public class Weapon {

    private int healthSAC;
    private int actionSAC;
    private int mindSAC;
    private double healthCostMultiplier;
    private double actionCostMultiplier;
    private double mindCostMultiplier;


    public void newWeapon(String weaponType, int healthCost, int actionCost, int mindCost){
        if(weaponType.equalsIgnoreCase("vk") || weaponType.equalsIgnoreCase("vibro knuckler")){
            this.healthCostMultiplier = 1.5;
            this.actionCostMultiplier = 1.5;
            this.mindCostMultiplier = 1.5;
        }
        else if(weaponType.equalsIgnoreCase("baton") || weaponType.equalsIgnoreCase("vibro knuckler")){
            this.healthCostMultiplier = 1.25;
            this.actionCostMultiplier = 1.25;
            this.mindCostMultiplier = 2.0;
        }
        else if(weaponType.equalsIgnoreCase("hammer") || weaponType.equalsIgnoreCase("polearm")){
            this.healthCostMultiplier = 1.5;
            this.actionCostMultiplier = 2.0;
            this.mindCostMultiplier = 1.5;
        }
        else if(weaponType.equalsIgnoreCase("pike") || weaponType.equalsIgnoreCase("polearm")){
            this.healthCostMultiplier = 2.0;
            this.actionCostMultiplier = 1.5;
            this.mindCostMultiplier = 1.5;
        }

        this.healthSAC = healthCost;
        this.actionSAC = actionCost;
        this.mindSAC = mindCost;
    }

    public void setHealthCostMultiplier(double healthCostMultiplier) {
        this.healthCostMultiplier = healthCostMultiplier;
    }

    public void setActionCostMultiplier(double actionCostMultiplier) {
        this.actionCostMultiplier = actionCostMultiplier;
    }

    public void setMindCostMultiplier(double mindCostMultiplier) {
        this.mindCostMultiplier = mindCostMultiplier;
    }

    public double getHealthCostMultiplier() {return healthCostMultiplier;}

    public double getActionCostMultiplier() {
        return actionCostMultiplier;
    }

    public double getMindCostMultiplier() {
        return mindCostMultiplier;
    }

    public void setHealthSAC(int healthSAC) {
        this.healthSAC = healthSAC;
    }

    public void setActionSAC(int actionSAC) {
        this.actionSAC = actionSAC;
    }

    public void setMindSAC(int mindSAC) {
        this.mindSAC = mindSAC;
    }

    public int getHealthSAC() {
        return healthSAC;
    }

    public int getMindSAC() {
        return mindSAC;
    }

    public int getActionSAC() {
        return actionSAC;
    }
}
