import java.util.ArrayList;
import java.util.List;

class CardStack {
    private final List<Card> cards;

    public CardStack() {
        this.cards = new ArrayList<>();
    }

    // Push a card onto the stack
    public void push(Card card) {
        cards.add(card);
    }

    // Pop a card from the stack
    public Card pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return cards.removeLast();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}