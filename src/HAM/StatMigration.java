package HAM;

/**
 * Created by jb039k on 4/6/2017.
 */
public class StatMigration {

    /**
     *
     * SAC formula for special attacks is:
     * BaseCost = (SAC * Attack SAC modifier)
     *  BaseCost - ((((Efficiency stat - armor encumbrance)- 300) / 1200) * BaseCost)
     */


    private int strength;
    private int constitution;
    private int quickness;
    private int stamina;
    private int focus;
    private int willpower;

    public void newStatMigration(int strength, int constitution, int quickness, int stamina, int focus, int willpower){
        this.strength = strength;
        this.constitution = constitution;
        this.quickness = quickness;
        this.stamina = stamina;
        this.focus = focus;
        this.willpower = willpower;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setQuickness(int quickness) {
        this.quickness = quickness;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public void setWillpower(int willpower) {
        this.willpower = willpower;
    }

    public int getStrength() {
        return strength;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getQuickness() {
        return quickness;
    }

    public int getStamina() {
        return stamina;
    }

    public int getFocus() {
        return focus;
    }

    public int getWillpower() {
        return willpower;
    }
}
