import java.util.Scanner;
import java.util.Random;

/*
       * I denna uppgift ska ni skapa spelet sten sax påse, för två spelare. Ni bör
       * använda Scanner, och ert program ska kunna utse om det är en vinnare eller
       * oavgjort.
       * 
       * Utnyttja er av flera metoder och satser. Bonus uppgifter: - ni ska få ert
       * spel att både ta emot text och nummer. - skapa en AI spelar version, där man
       * kör mot en dator Kommentera i er kod väl och tänk på att namnge era variabler
       * och metoder väl.
       * 
       * För att lämna in, skapa ett Github konto och lägg upp er inlämning där, sedan
       * skicka in länken till ert projekt på Github här på Classrom
       */

class Main {

    // Choooses the type of game, pvp or pvE and returns

    // Reads in the inputs rock, paper, scissors from user
    // or the correspoding 0,1 and 2
    public static String choseValue() {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine().toUpperCase();
        return inputString;
    }

    public static String choseType() {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        return inputString;
    }

    // Generate a random integer between 0 and 2

    public static String randomString(int upperBound) {
        Random rand = new Random();
        String randString = String.valueOf(rand.nextInt(upperBound));
        return randString;
    }

    // second player input
    public static String player2(String type) {
        String input2 = "";
        if (type.equals("pvp")) {
            System.out.println("Second player: ");
            input2 = choseValue();

        } else if (type.equals("pvE")) {
            input2 = randomString(3);
            System.out.println(input2);
            // input2 = "computer input";
        } else {
            System.out.println("Invalid choice, type either pvp or pvE");
        }
        return input2;
    }

    // Transfroms the inputs rock, paper, scissors from user
    // or the correspoding 0,1 and 2 to int 0, 1 or 2
    public static int transform(String readIn) {
        switch (readIn) {
            case "ROCK":
            case "0":
                return 0;
            case "PAPER":
            case "1":
                return 1;
            case "SCISSORS":
            case "2":
                return 2;
            case "quit":
            case "-1":
                return -1;
            default:
                return -999999;

        }
    }

    public static String winner(int player1, int player2) {
        switch (player1 | (player2 << 4)) {
            case 0:
            case 0x11:
            case 0x22:
                return "Tie";
            case 0x02: // computer:scissors, player:paper
            case 0x10:
            case 0x21:
                return "Second player wins\n";
            case 0x01:
            case 0x12:
            case 0x20:
                return "First player wins\n";
            default:
                return "Invalid choice, try again\n";
        }
    }

    // Checks if any of the players types -1 and return a boolean true if so

    // while bool is not true keep playing
    public static void keepPlaying() {
        System.out.println(
                "Lets play rock paper scissors, to exit the program type quit.\n choose by typing either pvp or pvE to continue");
        System.out.println(" 0: ROCK\n 1: PAPER\n 2: SCISSORS");
        while (true) {

            // choose the type of game
            //String type = "pvE";
            String type = choseType();
            System.out.println("Test 1: "+type);
            
            // read in from user(users)
            System.out.println("First player: ");
            String input1 = choseValue();
            String input2 = player2(type);

            // transform String into int
            int player1 = transform(input1);
            int player2 = transform(input2);
            // check who wins or if quit game

            if (player1 == -1 || player2 == -1) {
                System.out.println("Thanks for playing, hope to see you again!");
                break;
            } else {
                String win = winner(player1, player2);
                System.out.println(win);
                System.out.println("lets play again \n");
            }
        }
    }

    public static void main(String[] args) {
        keepPlaying();
        //System.out.println(choseType());
    }
}
