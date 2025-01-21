import java.util.Scanner;
import java.util.ArrayList;import

public class Blackjack {
    public static void printCards(ArrayList<Card> cards) {

    }

    public static void drawBoard(ArrayList<Card> playerCards, ArrayList<Card> dealerCards) {
        clearScreen();

        System.out.print("Dealer: ");
        printCards(dealerCards);
        System.out.print("Player: ");
        printCards(playerCards);
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

        }
    }

    public static void playGame() {
        ArrayList<Card> playerCards = new ArrayList<>();
        ArrayList<Card> dealerCards = new ArrayList<>();
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
            tie("WHAAAAAT");
            return;
        } else if (player == 21) {
            revealCards(dealerCards);
            drawBoard(playerCards, dealerCards);
            victory("WHAAAAAT");
            return;
        } else if (dealer == 21) {
            revealCards(dealerCards);
            drawBoard(playerCards, dealerCards);
            loss("WHAAAAAT");
            return;
        }

        boolean doLoop = true;
        String reply;
        while (doLoop) {
            drawBoard(playerCards, dealerCards);
            reply = promptUser("EnterH to siedk");
            if (reply.equals("h")) {
                playerCards.add(new Card());
                drawboard(playerCards, dealerCards);
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
        }

        revealCards(dealerCards);
        dealer = calcScore(dealerCards);
        while (dealer < 17) {
            dealerCards.add(new Card());
            dealer = calcScore(dealerCards);
            drawBoard(playerCards, dealerCards);

        }

        drawBoard(playerCards, dealerCards);
        if (dealer > 21) {
            victory("dealer bust");
        } else if (player > dealer) {
            victory("score bigger");
        } else if (player > dealer) {
            loss("they bigger");
        } else {
            tie("ya tied");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        displayTitle();
        boolean playAgain = true;
        while (playAgain) {
            playGame();
            String willYouPlayAgain = in.
        }
        
    }
}
