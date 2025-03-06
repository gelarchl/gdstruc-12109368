import java.util.Random;
import java.util.Scanner;

public class CardGame {
    private static final int TOTAL_CARDS = 30;
    private static final String[] CARD_TYPES = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        CardStack deck = new CardStack();
        for (int i = 0; i < TOTAL_CARDS; i++) {
            String cardType = CARD_TYPES[rand.nextInt(CARD_TYPES.length)];
            deck.push(new Card(cardType));
        }

        CardStack hand = new CardStack();
        CardStack discard = new CardStack();

        while (!deck.isEmpty()) {
            System.out.println("\n--- New Turn ---");

            int action = rand.nextInt(3);
            int numCards = rand.nextInt(5) + 1;

            switch (action) {
                case 0 -> {
                    System.out.println("Action: Draw " + numCards + " cards");
                    drawFromDeck(deck, hand, numCards);
                }
                case 1 -> {
                    System.out.println("Action: Discard " + numCards + " cards");
                    discardFromHand(hand, discard, numCards);
                }
                case 2 -> {
                    System.out.println("Action: Retrieve " + numCards + " cards from discard pile");
                    retrieveFromDiscard(discard, hand, numCards);
                }
            }

            System.out.println("\nPlayer Hand: " + hand);
            System.out.println("Cards Remaining in Deck: " + deck.size());
            System.out.println("Cards in Discard Pile: " + discard.size());

            System.out.println("\nPress Enter to continue to the next turn...");
            input.nextLine();
        }

        System.out.println("\nGame Over! The deck is empty.");
    }

    private static void drawFromDeck(CardStack deck, CardStack hand, int numCards) {
        for (int i = 0; i < numCards; i++) {
            if (!deck.isEmpty()) {
                hand.push(deck.pop());
            } else {
                System.out.println("The deck is empty! No more cards to draw.");
                break;
            }
        }
    }

    private static void discardFromHand(CardStack hand, CardStack discard, int numCards) {
        for (int i = 0; i < numCards; i++) {
            if (!hand.isEmpty()) {
                discard.push(hand.pop());
            } else {
                System.out.println("Your hand is empty! No more cards to discard.");
                break;
            }
        }
    }

    private static void retrieveFromDiscard(CardStack discard, CardStack hand, int numCards) {
        for (int i = 0; i < numCards; i++) {
            if (!discard.isEmpty()) {
                hand.push(discard.pop());
            } else {
                System.out.println("The discard pile is empty! No more cards to retrieve.");
                break;
            }
        }
    }
}
