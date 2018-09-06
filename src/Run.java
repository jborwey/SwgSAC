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
        // High-End Acklay Hammer SAC 103-25-13
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
        double health = 400;
        double strength = 400;
        double constitution = 400;

        /**
         * ACTION
         */
        double action = 400;
        double quickness = 400;
        double stamina = 400;
        /**
         * MIND
         */
        double mind = 1100;
        double focus = 800;
        double willpower = 1100;

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
        double actionEncumbrance = 40;
        double mindEncumbrance = 235;

        ArmorSet armorSet = new ArmorSet(healthEncumbrance, actionEncumbrance, mindEncumbrance);

        /***************************************************************************
         * stomach empty rate == 3.33/minute; Full to empty in 30 minutes
         ***************************************************************************/
        /***************************************************************************
         * High-end mobs (NS Elders, Protectors, DJM, DJK and Krayts never miss)
         * Use all stat enhancing food + citrus snow cake/protein wafer
         ***************************************************************************/

        // Food buff stat bonuses
        double garmorrl = 0;
        double gruuvanShall = 418*2;
        double wonWon = 0;
        double accarragm = 368*2;
        double ahrisa = 0;
        double brandy = 329*2;

        double medicalEnhance = 586;

        double healthWounds = 200;
        double actionWounds = 140;
        double mindWounds = 60;

        stats.setHealth(health + garmorrl + medicalEnhance);
        stats.setStrength(strength + gruuvanShall + wonWon + garmorrl + medicalEnhance - healthWounds - armorSet.getHealthEncumbrance());
        stats.setConstitution(constitution + wonWon + garmorrl + medicalEnhance - healthWounds - armorSet.getHealthEncumbrance());
        stats.setAction(action + accarragm + medicalEnhance);
        stats.setQuickness(quickness + accarragm + medicalEnhance - actionWounds - armorSet.getActionEncumbrance());
        stats.setStamina(stamina + accarragm + medicalEnhance - actionWounds - armorSet.getActionEncumbrance());
        stats.setMind(mind + brandy);
        stats.setFocus(focus + brandy + ahrisa - mindWounds - armorSet.getMindEncumbrance());
        stats.setWillpower(willpower + brandy - mindWounds - armorSet.getMindEncumbrance());



        Weapon weapon = new Weapon();

        SpecialAttackCost specialAttackCost = new SpecialAttackCost();
        weapon.newWeapon(weaponType, healthCost, actionCost, mindCost);

        double healthSAC = specialAttackCost.getTotalSAC(weapon.getHealthSAC(), weapon.getHealthCostMultiplier(), stats.getStrength());
        double actionSAC = specialAttackCost.getTotalSAC(weapon.getActionSAC(), weapon.getActionCostMultiplier(), stats.getQuickness());
        double mindSAC = specialAttackCost.getTotalSAC(weapon.getMindSAC(), weapon.getMindCostMultiplier(), stats.getFocus());

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
