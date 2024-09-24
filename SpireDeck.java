import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpireDeck
{

    public static Scanner scan;
    public static int deckId;
    public static int totalCost = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please type in the correctly formated file name with your deck");
        String filename = input.next();
        fileReader(filename);

    }

    public static void fileReader(String filename) throws FileNotFoundException {
        scan = new Scanner(new File(filename));
        Random random = new Random();
        if (scan.hasNext() == true){
            deckId = random.nextInt(111111111,999999999);
            System.out.println(deckId);
        } else {
            System.out.println("This file is empty");
            return;
        }
        while (scan.hasNext()) {
            costTally(scan.next());
        }



    }

    public static void costTally(String cardInfo){
        String [] temp = cardInfo.split(":");
        if (temp.length == 1) {
            return;
        }
        int cost = Integer.parseInt(temp[1]);
        if ((cost >= 0) && (cost <= 6)) {
            totalCost += cost;
        } else {
            System.out.println(cardInfo + " has an invalid engery cost amount");
        }
        System.out.println(totalCost);

    }
}
