import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpireDeck
{

    public static Scanner scan;
    public static int deckId;
    public static int cardCount;
    public static int totalCost = 0;
    public static String[] invalidCards = new String[10];
    public static int invalidCount = 0;
    public static int[] histogram = new int[6];


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
            if (invalidCards[9] != null) {
                System.out.println("SpireDeck_" + deckId + "(VOID).pdf");
                System.out.println("This deck has 10 invalid cards");
                for (int i = 0; i < invalidCards.length; i++) {
                    System.out.println(invalidCards[i]);
                }
                return;
            }
            if (cardCount > 1000) {
                return;
            }
            costTally(scan.next());
        }

        System.out.println("SpireDeck_" + deckId + ".pdf");
        System.out.println("Total energy cost of the deck: " + totalCost + " energies");
        System.out.println("Histogram array starting from 1-6 left to right: " + Arrays.toString(histogram));
        System.out.println("This deck had " + invalidCount + " cards with invalid energy values");
        if (invalidCount == 0) {
            return;
        }
        for (int i = 0; i < invalidCards.length; i++) {
            if (invalidCards[i] == null) {
                return;
            }
            System.out.println(invalidCards[i]);
        }


    }

    public static void costTally(String cardInfo){
        String [] temp = cardInfo.split(":");
        if (temp.length == 1) {
            return;
        }
        int cost = Integer.parseInt(temp[1]);
        if ((cost >= 0) && (cost <= 6)) {
            histogram[cost-1] = histogram[cost-1] + 1;
            totalCost += cost;
            cardCount++;
        } else {
            invalidCards[invalidCount] = cardInfo;
        }

    }
}
