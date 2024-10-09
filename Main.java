import java.util.*;
import java.io.File;
public class Main {
    public static void main(String[] args) {
        File textfile = new File("input.txt");
        Scanner myScanner = new Scanner(textfile);
        System.out.println(myScanner.next());
        myScanner.close();
    }
}