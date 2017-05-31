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
//
//        System.out.println();
//        System.out.print("What is your total armor encumbrance per pool?  (Enter one number and return for each)\n");
//        System.out.print("Health Encumbrance: "); int healthEncumbrance = sc.nextInt();
//        System.out.print("Action Encumbrance: ");int actionEncumbrance = sc.nextInt();
//        System.out.print("Mind Encumbrance: ");int mindEncumbrance = sc.nextInt();
//
//        System.out.println();
//        System.out.print("Enter your migrated health states starting with Strength and Constitution and then action/mind  (Enter one number and return for each)\n");
//        System.out.print("Strength: "); int strength = sc.nextInt();
//        System.out.print("Constitution: ");int constitution = sc.nextInt();
//        System.out.print("Quickness: ");int quickness = sc.nextInt();
//        System.out.print("Stamina: ");int stamina = sc.nextInt();
//        System.out.print("Focus: ");int focus = sc.nextInt();
//        System.out.print("Willpower: ");int willpower = sc.nextInt();

        // Weapon Special Action Costs (SAC)
        String weaponType = "baton";
        int healthCost = 81;
        int actionCost = 11;
        int mindCost = 5;

        // Armor Encumbrance
        int healthEncumbrance = 220;
        int actionEncumbrance = 0;
        int mindEncumbrance = 210;

        // Food buff stat bonuses
        int gruuvanShall = 430*3;
        int accarragm = 410*2;
        int brandy = 406*2;

        /***************************************************************************
         * The total of base stats (not including food buffs) should not exceed 5400
         ***************************************************************************/

        /**
         * HEALTH
         */
        int health = 1100;
        int strength = 400;
        int constitution = 500;
        /**
         * ACTION
         */
        int action = 400;
        int quickness = 800;
        int stamina = 400;
        /**
         * MIND
         */
        int mind = 400;
        int focus = 900;
        int willpower = 400;

        int totalHAM = health + strength + constitution +
                action + quickness + stamina +
                mind + focus + willpower;

        boolean validHam = (5400 == totalHAM);

        System.out.printf("Total HAM is: %d \n", totalHAM);


        Weapon weapon = new Weapon();
        ArmorSet miniSuit = new ArmorSet();
        StatMigration stats = new StatMigration();
        SpecialAttackCost specialAttackCost = new SpecialAttackCost();

        weapon.newWeapon(weaponType, healthCost, actionCost, mindCost);
        miniSuit.newArmorSuit(healthEncumbrance, actionEncumbrance, mindEncumbrance);
        stats.newStatMigration(strength + gruuvanShall, constitution, quickness + accarragm, stamina + accarragm, focus + brandy, willpower + brandy);

        double healthSAC = specialAttackCost.getTotalSAC(weapon.getHealthSAC(), weapon.getHealthCostMultiplier(), stats.getStrength(), miniSuit.getHealthEncumbrance());
        double actionSAC = specialAttackCost.getTotalSAC(weapon.getActionSAC(), weapon.getActionCostMultiplier(), stats.getQuickness(), miniSuit.getActionEncumbrance());
        double mindSAC = specialAttackCost.getTotalSAC(weapon.getMindSAC(), weapon.getMindCostMultiplier(), stats.getFocus(), miniSuit.getMindEncumbrance());

        RegenerationTime regenSpeed = new RegenerationTime();
        double healthRegen = regenSpeed.timeToRegen(stats.getConstitution());
        double actionRegen = regenSpeed.timeToRegen(stats.getStamina());
        double mindRegen = regenSpeed.timeToRegen(stats.getWillpower());

        System.out.println();
        System.out.print("The total SAC per attack is:\n");
        System.out.printf("%.2f | %.2f | %.2f", healthSAC, actionSAC, mindSAC);

        System.out.println();
        System.out.print("Regeneration rate per HAM pool:\n");
        System.out.printf("%.2f/sec | %.2f/sec | %.2f/sec", healthRegen, actionRegen, mindRegen);
    }

}
