import java.util.Random;
import java.util.Scanner;

class Main {
    private static final int DECK_SIZE = 30;
    private static final String[] CARD_NAMES = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Initialize player deck with 30 cards
        CardStack playerDeck = new CardStack();
        for (int i = 0; i < DECK_SIZE; i++) {
            String cardName = CARD_NAMES[random.nextInt(CARD_NAMES.length)];
            playerDeck.push(new Card(cardName));
        }

        // Initialize empty hand and discard pile
        CardStack playerHand = new CardStack();
        CardStack discardPile = new CardStack();

        // Game loop
        while (!playerDeck.isEmpty()) {
            System.out.println("\n--- New Turn ---");

            // Randomly select a command
            int command = random.nextInt(3);
            int x = random.nextInt(5) + 1; // Random number of cards (1 to 5)

            switch (command) {
                case 0 -> {
                    System.out.println("Command: Draw " + x + " cards");
                    drawCards(playerDeck, playerHand, x);
                }
                case 1 -> {
                    System.out.println("Command: Discard " + x + " cards");
                    discardCards(playerHand, discardPile, x);
                }
                case 2 -> {
                    System.out.println("Command: Get " + x + " cards from the discard pile");
                    getCardsFromDiscard(discardPile, playerHand, x);
                }
            }

            // Display game state
            System.out.println("\nPlayer Hand: " + playerHand);
            System.out.println("Remaining Cards in Deck: " + playerDeck.size());
            System.out.println("Cards in Discard Pile: " + discardPile.size());

            // Wait for player to press Enter
            System.out.println("\nPress Enter to proceed to the next turn...");
            scanner.nextLine();
        }

        System.out.println("\nGame Over! The player deck is empty.");
    }

    // Draw x cards from the deck to the hand
    private static void drawCards(CardStack deck, CardStack hand, int x) {
        for (int i = 0; i < x; i++) {
            if (!deck.isEmpty()) {
                hand.push(deck.pop());
            } else {
                System.out.println("No more cards in the deck to draw!");
                break;
            }
        }
    }

    // Discard x cards from the hand to the discard pile
    private static void discardCards(CardStack hand, CardStack discardPile, int x) {
        for (int i = 0; i < x; i++) {
            if (!hand.isEmpty()) {
                discardPile.push(hand.pop());
            } else {
                System.out.println("No more cards in the hand to discard!");
                break;
            }
        }
    }

    // Get x cards from the discard pile to the hand
    private static void getCardsFromDiscard(CardStack discardPile, CardStack hand, int x) {
        for (int i = 0; i < x; i++) {
            if (!discardPile.isEmpty()) {
                hand.push(discardPile.pop());
            } else {
                System.out.println("No more cards in the discard pile to get!");
                break;
            }
        }
    }
}