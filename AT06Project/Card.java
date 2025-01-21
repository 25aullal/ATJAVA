
import java.util.Scanner;
import java.util.ArrayList;

public class Card {
    public enum Suit {
        SPADE, HEART, CLUB, DIAMOND
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private Suit suit;
    private Rank rank;
    private boolean viewable;

    public Card(boolean viewable) {
        if (viewable) {
            viewable = true;
        } else {
            viewable = false;
        }
        int valSuit = (int) (5 * Math.random());
        if (valSuit == 0) {
            suit = Suit.SPADE;
        } else if (valSuit == 1) {
            suit = Suit.HEART;
        } else if (valSuit == 2) {
            suit = Suit.CLUB;
        } else {
            suit = Suit.DIAMOND;
        }

        int valRank = (int) (14 * Math.random());
        if (valRank == 0) {
            rank = Rank.TWO;
        } else if (valRank == 1) {
            rank = Rank.THREE;
        } else if (valRank == 2) {
            rank = Rank.FOUR;
        } else if (valRank == 3) {
            rank = Rank.FIVE;
        } else if (valRank == 4) {
            rank = Rank.SIX;
        } else if (valRank == 5) {
            rank = Rank.SEVEN;
        } else if (valRank == 6) {
            rank = Rank.EIGHT;
        } else if (valRank == 7) {
            rank = Rank.NINE;
        } else if (valRank == 8) {
            rank = Rank.TEN;
        } else if (valRank == 9) {
            rank = Rank.JACK;
        } else if (valRank == 10) {
            rank = Rank.QUEEN;
        } else if (valRank == 11) {
            rank = Rank.KING;
        } else {
            rank = Rank.ACE;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void getFace() {
        if (viewable) {
            char spade = '\u2660'; // ♠
            char heart = '\u2661'; // ♡
            char club = '\u2663'; // ♣
            char diamond = '\u2662'; // ♢
            char two = '2';
            char three = '3';
            char four = '4';
            char five = '5';
            char six = '6';
            char seven = '7';
            char eight = '8';
            char nine = '9';
            char ten = 'T';
            char jack = 'J';
            char queen = 'Q';
            char king = 'K';
            char ace = 'A';

            if (suit == Suit.SPADE) {
                System.out.print(spade);
            } else if (suit == Suit.HEART) {
                System.out.print(heart);
            } else if (suit == Suit.CLUB) {
                System.out.print(club);
            } else {
                System.out.print(diamond);
            }

            if (rank == Rank.TWO) {
                System.out.println(two);
            } else if (rank == Rank.THREE) {
                System.out.println(three);
            } else if (rank == Rank.FOUR) {
                System.out.println(four);
            } else if (rank == Rank.FIVE) {
                System.out.println(five);
            } else if (rank == Rank.SIX) {
                System.out.println(six);
            } else if (rank == Rank.SEVEN) {
                System.out.println(seven);
            } else if (rank == Rank.EIGHT) {
                System.out.println(eight);
            } else if (rank == Rank.NINE) {
                System.out.println(nine);
            } else if (rank == Rank.TEN) {
                System.out.println(ten);
            } else if (rank == Rank.JACK) {
                System.out.println(jack);
            } else if (rank == Rank.QUEEN) {
                System.out.println(queen);
            } else if (rank == Rank.KING) {
                System.out.println(king);
            } else {
                System.out.println(ace);
            }
        } else {
            System.out.println("##");
        }
    }

    public int getValue(Card.Rank rank) {
        if (rank == Rank.TWO) {
            return 2;
        } else if (rank == Rank.THREE) {
            return 3;
        } else if (rank == Rank.FOUR) {
            return 4;
        } else if (rank == Rank.FIVE) {
            return 5;
        } else if (rank == Rank.SIX) {
            return 6;
        } else if (rank == Rank.SEVEN) {
            return 7;
        } else if (rank == Rank.EIGHT) {
            return 8;
        } else if (rank == Rank.NINE) {
            return 9;
        } else if (rank == Rank.TEN) {
            return 10;
        } else if (rank == Rank.JACK) {
            return 10;
        } else if (rank == Rank.QUEEN) {
            return 10;
        } else if (rank == Rank.KING) {
            return 10;
        } else {
            return 11;
        }
    }

    public static void main(String[] args) {
    }
}
