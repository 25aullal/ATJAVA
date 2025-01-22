import java.util.Scanner;
import java.util.ArrayList;

public class Blackjack {
    static Scanner in = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printCards(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i));
        }
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

    public static String promptUser(String sending) {
        System.out.println();
        System.out.print(sending);
        String reply = in.nextLine().toLowerCase();
        return reply;
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
                    acesCount++;
                }
            }
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
            drawBoard(playerCards, dealerCards);
            reply = promptUser("Enter H to hit or S to stand");
            if (reply.equals("h")) {
                playerCards.add(new Card(true));
                drawBoard(playerCards, dealerCards);
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
            System.out.print("you lose");
        }

        revealCards(dealerCards);
        dealer = calcScore(dealerCards);
        while (dealer < 17) {
            dealerCards.add(new Card(true));
            dealer = calcScore(dealerCards);
            drawBoard(playerCards, dealerCards);

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

    public static void main(String[] args) {
        in = new Scanner(System.in);
        displayTitle();
        boolean playAgain = true;
        while (playAgain) {
            playGame();
            System.out.print("Type P to play again, or Q to quit: ");
            String willYouPlayAgain = in.next().toUpperCase();

            if (willYouPlayAgain.equals("P")) {
                clearScreen();
            } else if (willYouPlayAgain.equals("Q")) {
                System.out.println("Sad to see you go! Thanks for playing.");
                playAgain = false;
            }
        }

    }
}
