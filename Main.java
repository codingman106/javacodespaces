import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException{
        Scanner sysout = new Scanner(System.in);
        Robot robot = new Robot("Diddy", 1, false, 210);
        System.out.println(robot.returnLegal());
        System.out.println("Would you like to enter combat? [Y/N]");
        String ans = sysout.nextLine();
        if (ans.contains("Y") || ans.contains("y")) {
            robot.enableTurnBasedCombat();
        } else {
            System.out.println("Okay. Your loss.");
        }
        sysout.close();
    }
}