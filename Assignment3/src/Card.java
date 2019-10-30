public class Card {
    public String title;

    public Card(String theTitle) {
        this.title = theTitle;
    }

    public String getTitle() {
        return title;
    }

    public static int assignValue(String cardTitle) {
        int pointValue;

        char firstCharacter = cardTitle.charAt(0);

        boolean isAce = firstCharacter == 'A';
        boolean isFaceCard = cardHasFace(firstCharacter);

        if (isAce) {
            pointValue = 11;
        } else if (isFaceCard) {
            pointValue = 10;
        } else {
            pointValue = Character.getNumericValue(firstCharacter);
        }
        return pointValue;
    }

    public static boolean cardHasFace(char firstCharacter) {
        boolean value = (firstCharacter == 'J' || firstCharacter == 'Q' || firstCharacter == 'K');
        return value;
    }
}
