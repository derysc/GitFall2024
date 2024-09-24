import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpireDeck
{

    public static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please type in the correctly formated file name with your deck");
        String filename = input.next();
        costTally(filename);

    }

    public static void costTally(String filename) throws FileNotFoundException {
        scan = new Scanner(new File(filename));
        System.out.println(scan.next());


    }
}
