import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Random;
public class Robot {
    private String Name;
    private int numOfBatteries;
    private boolean continuity;
    private int health = 200;
    public Robot(String Name, int numOfBatteries, boolean continuity, int health) {
        this.Name = Name;
        this.numOfBatteries = numOfBatteries;
        this.continuity = continuity;
        this.health = health;
    }
    public boolean isLegal(){
        if (this.numOfBatteries == 1 && continuity == false) {
            return true;
        } else {
            return false;
        }
    }
    public String returnLegal(){
        if (this.isLegal() == true) {
            return "The robot " + this.Name + " is legal!";
         } else {
            return "The robot " + this.Name + " is not legal. :(";
         }
    }
    public void enableTurnBasedCombat() throws InterruptedException{
        Dictionary<String, Integer> moveset = new Hashtable<>();
        moveset.put("Baby Oil", 50);
        moveset.put("Storm of A 1000 Bottles", 100);
        moveset.put("Slippery Stairs", 20);

        int opponenthealth = this.health - 10;

        Dictionary<String, Integer> oppMoveset = new Hashtable<>();
        oppMoveset.put("Unlimited Void", 100);
        oppMoveset.put("Remove Wheels", 50);
        oppMoveset.put("Shadow Clone Jutsu", 30);

        Random random = new Random();
        Scanner sysin = new Scanner(System.in);
        String oppMove;
        int moveNum;
        String myMove;
        while ((opponenthealth > 0) && (this.health > 0)) {
            System.out.println("Enter your move! [Unlimited Void, Remove Wheels, Shadow Clone Jutsu]");
            System.out.println("Your health: " + opponenthealth + ", Opponent's Health: " + this.health);

            oppMove = sysin.nextLine();
            System.out.println("You used " + oppMove + "!");
            if (!oppMove.equals("Unlimited Void") && !oppMove.equals("Remove Wheels") && !oppMove.equals("Shadow Clone Jutsu")) {
                // Invalid move case: you might want to add a warning or ignore this turn
                System.out.println("Invalid move! " + this.Name + " will now use its turn!");
            } else {
                // Valid move case: apply damage
                this.health -= oppMoveset.get(oppMove);
                if (this.health <= 0) break;
            }           

            
            moveNum = random.nextInt(3);
            myMove = "nothing";
            if (moveNum == 0) {
                myMove = "Baby Oil";
            } else if (moveNum == 1) {
                myMove = "Storm of A 1000 Bottles";
            } else if (moveNum == 2) {
                myMove = "Slippery Stairs";
            }

            Thread.sleep(2000);
            System.out.println(this.Name + " used " + myMove + "!");
            opponenthealth -= moveset.get(myMove);
            System.out.println("Your health is now " + opponenthealth);
            if (opponenthealth <= 0) break;
        }

        sysin.close();
        if (opponenthealth <= 0) {
            System.out.println("You Lose!");
        }

        if (this.health <= 0) {
            System.out.println("YOU WON!!!");
        }

    }
}