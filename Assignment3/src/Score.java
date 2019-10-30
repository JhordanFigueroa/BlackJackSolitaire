import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Score {

    public static String analyzeResults(Board board) {
        ArrayList<String> slots = new ArrayList<>(Arrays.asList(board.slots));

        int rowOneSum = sumForRow(slots.subList(0, 4));
        int handOneScore = scoreForHand(rowOneSum, 5);

        int rowTwoSum = sumForRow(slots.subList(5, 9));
        int handTwoScore = scoreForHand(rowTwoSum, 5);

        int rowThreeSum = sumForRow(slots.subList(10, 12));
        int handThreeScore = scoreForHand(rowThreeSum, 3);

        int rowFourSum = sumForRow(slots.subList(13, 15));
        int handFourScore = scoreForHand(rowFourSum, 3);

        int columnOneSum = sumForColumn(new int[] { 0, 5 }, board);
        int handFiveScore = scoreForHand(columnOneSum, 2);

        int columnTwoSum = sumForColumn(new int[] { 1, 6, 10, 13 }, board);
        int handSixScore = scoreForHand(columnTwoSum, 4);

        int columnThreeSum = sumForColumn(new int[] { 2, 7, 11, 14 }, board);
        int handSevenScore = scoreForHand(columnThreeSum, 4);

        int columnFourSum = sumForColumn(new int[] { 3, 8, 12, 15 }, board);
        int handEightScore = scoreForHand(columnFourSum, 4);

        int columnFiveSum = sumForColumn(new int[] { 4, 9 }, board);
        int handNineScore = scoreForHand(columnFiveSum, 2);

        int totalScore = handOneScore + handTwoScore + handThreeScore + handFourScore + handFiveScore + handSixScore
                + handSevenScore + handEightScore + handNineScore;

        String displayString = "Total Score: " + Integer.toString(totalScore);

        return displayString;
    }

    public static int sumForRow(List<String> hand) {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            String titleOfCard = hand.get(i);
            int cardValue = Card.assignValue(titleOfCard);
            sum += cardValue;
        }
        return sum;
    }

    public static int sumForColumn(int[] listOfIndices, Board board) {
        int sum = 0;
        for (int i = 0; i < listOfIndices.length; i++) {
            String titleOfCard = board.slots[listOfIndices[i]];
            sum += Card.assignValue(titleOfCard);
        }
        return sum;
    }

    public static int scoreForHand(int sum, int numberOfCards) {
        if (sum > 21) {
            return 0;
        }
        if (sum <= 16) {
            return 1;
        }
        if (sum == 17) {
            return 2;
        }
        if (sum == 18) {
            return 3;
        }
        if (sum == 19) {
            return 4;
        }
        if (sum == 20) {
            return 5;
        }
        if ((numberOfCards == 3 || numberOfCards == 4 || numberOfCards == 5) && sum == 21) {
            return 7;
        }
        if (numberOfCards == 2 && sum == 21) {
            return 10;
        }
        return 0;
    }
}