package Gear;

/**
 * Created by jb039k on 4/6/2017.
 */
public class Weapon {

    private int healthSAC;
    private int actionSAC;
    private int mindSAC;
    private double hAttackMod;
    private double aAttackMod;
    private double mAttackMod;


    public void newWeapon(String weaponType, int healthCost, int actionCost, int mindCost){
        if(weaponType.equalsIgnoreCase("vk") || weaponType.equalsIgnoreCase("vibro knuckler")){
            this.hAttackMod = 1.5;
            this.aAttackMod = 1.5;
            this.mAttackMod = 1.5;
        }
        else if(weaponType.equalsIgnoreCase("baton") || weaponType.equalsIgnoreCase("vibro knuckler")){
            this.hAttackMod = 1.25;
            this.aAttackMod = 1.25;
            this.mAttackMod = 2.0;
        }
        else if(weaponType.equalsIgnoreCase("pike") || weaponType.equalsIgnoreCase("polearm")){
            this.hAttackMod = 2.0;
            this.aAttackMod = 1.5;
            this.mAttackMod = 1.5;
        }

        this.healthSAC = healthCost;
        this.actionSAC = actionCost;
        this.mindSAC = mindCost;
    }

    public void sethAttackMod(double hAttackMod) {
        this.hAttackMod = hAttackMod;
    }

    public void setaAttackMod(double aAttackMod) {
        this.aAttackMod = aAttackMod;
    }

    public void setmAttackMod(double mAttackMod) {
        this.mAttackMod = mAttackMod;
    }

    public double gethAttackMod() {

        return hAttackMod;
    }

    public double getaAttackMod() {
        return aAttackMod;
    }

    public double getmAttackMod() {
        return mAttackMod;
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
