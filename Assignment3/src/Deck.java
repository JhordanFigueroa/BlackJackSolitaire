import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public ArrayList<Card> cards;

    public Deck() {
        this.cards = generateDeckOfCards();
    }

    public Card getRandomCard() {
        int randomIndex = new Random().nextInt(cards.size());
        Card card = cards.remove(randomIndex);
        return card;
    }

    public ArrayList<Card> generateDeckOfCards() {
        String[] suits = new String[] { "C", "D", "H", "S" };
        String[] values = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

        ArrayList<Card> deckOfCards = new ArrayList<>();
        for (int suitsIndex = 0; suitsIndex < suits.length; suitsIndex++) {
            for (int valuesIndex = 0; valuesIndex < values.length; valuesIndex++) {
                String title = values[valuesIndex] + suits[suitsIndex];
                Card card = new Card(title);
                deckOfCards.add(card);
            }
        }
        return deckOfCards;
    }
}