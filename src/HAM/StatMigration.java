package HAM;

/**
 * Created by jb039k on 4/6/2017.
 */
public class StatMigration {


    //Health
    private double health;
    private double strength;
    private double constitution;
    //Action
    private double action;
    private double quickness;
    private double stamina;
    //Mind
    private double mind;
    private double focus;
    private double willpower;


        public StatMigration(double health, double strength, double constitution,
                         double action, double quickness, double stamina,
                         double mind, double focus, double willpower){
        this.health = health;
        this.strength = strength;
        this.constitution = constitution;
        this.action = action;
        this.quickness = quickness;
        this.stamina = stamina;
        this.mind = mind;
        this.focus = focus;
        this.willpower = willpower;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setConstitution(double constitution) {
        this.constitution = constitution;
    }

    public void setAction(double action) {
        this.action = action;
    }

    public void setQuickness(double quickness) {
        this.quickness = quickness;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public void setMind(double mind) {
        this.mind = mind;
    }

    public void setFocus(double focus) {
        this.focus = focus;
    }

    public void setWillpower(double willpower) {
        this.willpower = willpower;
    }






    public double getHealth() {
        return health;
    }

    public double getStrength() {
        return strength;
    }

    public double getConstitution() {
        return constitution;
    }

    public double getAction() {
        return action;
    }

    public double getQuickness() {
        return quickness;
    }

    public double getStamina() {
        return stamina;
    }

    public double getMind() {
        return mind;
    }

    public double getFocus() {
        return focus;
    }

    public double getWillpower() {
        return willpower;
    }
}
