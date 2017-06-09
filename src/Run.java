import Gear.ArmorSet;
import Gear.SpecialAttackCost;
import Gear.Weapon;
import HAM.RegenerationTime;
import HAM.StatMigration;

import java.util.Scanner;

/**
 * Created by jb039k on 4/6/2017.
 */
public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("What kind of weapon is this? (Please enter vk, 1h, 2h or pike)\n");
//        System.out.print("Weapon type: "); String weaponType = sc.next();
//        System.out.print("What is the SAC of the Weapon?  (Enter one number and return for each)\n");
//        System.out.print("Health SAC: "); int healthCost = sc.nextInt();
//        System.out.print("Action SAC: ");int actionCost = sc.nextInt();
//        System.out.print("Mind SAC: ");int mindCost = sc.nextInt();
//        System.out.println();
//        System.out.print("Enter your migrated health states starting with Strength and Constitution and then action/mind  (Enter one number and return for each)\n");
//        System.out.print("Strength: "); int strength = sc.nextInt();
//        System.out.print("Constitution: ");int constitution = sc.nextInt();
//        System.out.print("Quickness: ");int quickness = sc.nextInt();
//        System.out.print("Stamina: ");int stamina = sc.nextInt();
//        System.out.print("Focus: ");int focus = sc.nextInt();
//        System.out.print("Willpower: ");int willpower = sc.nextInt();
//
//        System.out.println();
//        System.out.print("What is your total armor encumbrance per pool?  (Enter one number and return for each)\n");
//        System.out.print("Health Encumbrance: "); int healthEncumbrance = sc.nextInt();
//        System.out.print("Action Encumbrance: ");int actionEncumbrance = sc.nextInt();
//        System.out.print("Mind Encumbrance: ");int mindEncumbrance = sc.nextInt();
//

        // Weapon Special Action Costs (SAC)
        // AFK Hammer SAC (unpup) 44-22-4
        String weaponType = "hammer";

        double healthCost = 44;
        double actionCost = 22;
        double mindCost = 4;

        /***************************************************************************
         * The total of base stats (not including food buffs) should not exceed 5400
         ***************************************************************************/

        /**
         * HEALTH
         */
        double health = 800;
        double strength = 850;
        double constitution = 750;

        /**
         * ACTION
         */
        double action = 400;
        double quickness = 1000;
        double stamina = 400;
        /**
         * MIND
         */
        double mind = 400;
        double focus = 400;
        double willpower = 400;

        StatMigration stats = new StatMigration(health, strength, constitution,
                action, quickness, stamina,
                mind, focus, willpower);

        double totalHAM = health + strength + constitution +
                action + quickness + stamina +
                mind + focus + willpower;

        boolean validHam = (5400 == totalHAM);

        System.out.printf("Total HAM is: %.0f \n", totalHAM);

        // Armor Encumbrance
        double healthEncumbrance = 207;
        double actionEncumbrance = 48;
        double mindEncumbrance = 232;

        ArmorSet armorSet = new ArmorSet(healthEncumbrance, actionEncumbrance, mindEncumbrance);

        // Food buff stat bonuses
        double gruuvanShall = 430*2;
        double wonWon = 0;
        double accarragm = 350;
        double brandy = 329;

        stats.setStrength(strength + gruuvanShall + wonWon);
        stats.setConstitution(constitution + wonWon);
        stats.setAction(action + accarragm);
        stats.setQuickness(quickness + accarragm);
        stats.setStamina(stamina + accarragm);
        stats.setMind(mind + brandy);
        stats.setFocus(focus + brandy);
        stats.setWillpower(willpower + brandy);



        Weapon weapon = new Weapon();

        SpecialAttackCost specialAttackCost = new SpecialAttackCost();
        weapon.newWeapon(weaponType, healthCost, actionCost, mindCost);

        double healthSAC = specialAttackCost.getTotalSAC(weapon.getHealthSAC(), weapon.getHealthCostMultiplier(), stats.getStrength(), armorSet.getHealthEncumbrance());
        double actionSAC = specialAttackCost.getTotalSAC(weapon.getActionSAC(), weapon.getActionCostMultiplier(), stats.getQuickness(), armorSet.getActionEncumbrance());
        double mindSAC = specialAttackCost.getTotalSAC(weapon.getMindSAC(), weapon.getMindCostMultiplier(), stats.getFocus(), armorSet.getMindEncumbrance());

        RegenerationTime regenSpeed = new RegenerationTime();
        double healthRegen = regenSpeed.timeToRegen(stats.getConstitution(), armorSet.getHealthEncumbrance());
        double actionRegen = regenSpeed.timeToRegen(stats.getStamina(), armorSet.getActionEncumbrance());
        double mindRegen = regenSpeed.timeToRegen(stats.getWillpower(), armorSet.getMindEncumbrance());

        System.out.println();
        System.out.print("The total SAC per attack is:\n");
        System.out.printf("%.2f | %.2f | %.2f", healthSAC, actionSAC, mindSAC);

        System.out.println();
        System.out.print("Regeneration rate per HAM pool:\n");
        System.out.printf("%.2f/sec | %.2f/sec | %.2f/sec", healthRegen, actionRegen, mindRegen);
    }

}
