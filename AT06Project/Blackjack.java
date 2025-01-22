import java.util.Scanner;
import java.util.ArrayList;

public class Blackjack {
    static Scanner in = new Scanner(System.in);

    public static void delay(long msec) {
        try {
            Thread.sleep(msec);
        } catch (Exception e) {

        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printCards(ArrayList<Card> cards) {
        Card c;
        for (int i = 0; i < cards.size(); i++) {
            c = cards.get(i);
            c.getFace();
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void drawBoard(ArrayList<Card> playerCards, ArrayList<Card> dealerCards) {
        clearScreen();

        System.out.print("Dealer: ");
        printCards(dealerCards);
        System.out.print("Player: ");
        printCards(playerCards);
    }

    public static void revealCards(ArrayList<Card> cards) {
        Card c;
        int i = 0;
        while (i < cards.size()) {
            c = cards.get(i);
            c.reveal();
            i++;
        }
    }

    public static int calcScore(ArrayList<Card> cards) {
        int score = 0;
        int acesCount = 0;
        Card c;
        int i = 0;
        while (i < cards.size()) {
            c = cards.get(i);
            if (c.getRank() == Card.Rank.ACE) {
                acesCount++;
            }
            score += c.getValue();

            if (score > 21) {
                while (acesCount > 0) {
                    score -= 10;
                    acesCount--;
                }
            }
            i++;
        }
        return score;
    }

    public static void displayTitle() {
        System.out.println(" ___  __   _  _   ___   __   ____     ___   __   ____  __  __ _   __  ");
        System.out.println("/ __)/  \\ / )( \\ / __) / _\\ (  _ \\   / __) / _\\ / ___)(  )(  ( \\ /  \\ ");
        System.out.println("( (__(  O )) \\/ (( (_ \\/    \\ )   /  ( (__ /    \\\\___ \\ )( /    /(  O )");
        System.out.println(" \\___)\\__/ \\____/ \\___/\\_/\\_/(__\\_)   \\___)\\_/\\_/(____/(__)\\_)__) \\__/ ");
    }

    public static void playGame() {
        ArrayList<Card> playerCards = new ArrayList<>();
        ArrayList<Card> dealerCards = new ArrayList<>();

        int player = 0;
        int dealer = 0;

        playerCards.add(new Card(true));
        dealerCards.add(new Card(true));
        playerCards.add(new Card(true));
        dealerCards.add(new Card(false));

        drawBoard(playerCards, dealerCards);
        player = calcScore(playerCards);
        dealer = calcScore(dealerCards);
        if (player == 21 && dealer == 21) {
            revealCards(dealerCards);
            drawBoard(playerCards, dealerCards);
            System.out.println("Tie game! Push!");
            return;
        } else if (player == 21) {
            revealCards(dealerCards);
            drawBoard(playerCards, dealerCards);
            System.out.println("Blackjack! You win");
            return;
        } else if (dealer == 21) {
            revealCards(dealerCards);
            drawBoard(playerCards, dealerCards);
            System.out.println("Womp womp! Dealer has blackjack!");
            return;
        }

        boolean doLoop = true;
        String reply;
        while (doLoop) {

            System.out.println("Enter H to hit or S to stand");
            reply = in.nextLine();
            if (reply.equals("h")) {
                playerCards.add(new Card(true));
                delay(500);
                drawBoard(playerCards, dealerCards);
                delay(500);
            } else if (reply.equals("s")) {
                doLoop = false;
            }

            player = calcScore(playerCards);
            if (player > 21) {
                doLoop = false;
            }
        }

        if (player > 21) {
            revealCards(dealerCards);
            drawBoard(playerCards, dealerCards);
            System.out.println("Bust! You lose.");
        } else {
            revealCards(dealerCards);
            dealer = calcScore(dealerCards);
            while (dealer < 17) {
                dealerCards.add(new Card(true));
                dealer = calcScore(dealerCards);
                delay(500);
                drawBoard(playerCards, dealerCards);
                delay(500);

            }

            drawBoard(playerCards, dealerCards);
            if (dealer > 21) {
                System.out.println("Dealer busts! You win.");
            } else if (player > dealer) {
                System.out.println("You have a higher score. You win!");
            } else if (dealer > player) {
                System.out.println("Dealer has a higher score. You lose!");
            } else {
                System.out.println("You tied!");
            }
        }

    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        boolean playAgain = true;
        displayTitle();
        System.out.println("Welcome to the Cougar Casino! Type P to play, or Q to quit.");
        String response = in.nextLine().toUpperCase();
        if (response.equals("P")) {
            clearScreen();
        } else if (response.equals("Q")) {
            System.out.println("Sad to see you go! Thanks for coming.");
            playAgain = false;
        }

        while (playAgain) {
            playGame();
            System.out.print("Type P to play again, or Q to quit: ");
            response = in.nextLine().toUpperCase();

            if (response.equals("P")) {
                clearScreen();
            } else if (response.equals("Q")) {
                System.out.println("Sad to see you go! Thanks for coming.");
                playAgain = false;
            }
        }

    }
}
