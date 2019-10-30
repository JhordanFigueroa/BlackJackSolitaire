public class Player {

    public void displayIntroduction() {
        print("\n\n");
        println("==================================================================");
        println("Thanks for playing Blackjack Solitaire!");
        println("Instructions: ");
        println("- Enter the number of the slot where you want to place your card.");
        println("- Enter \"exit\" at anytime to end the game.");
        println("==================================================================");
    }

    public void displayBoard(Board board) {
        println("\nGAME BOARD:");

        for (int i = 0; i < board.slots.length; i++) {
            if (i == 5) {
                print("\n");
            }
            if (i == 10 || i == 13) {
                print("\n \t");
            }
            if (i == 16) {
                print("\n \n");
                println("DISCARDING PILE:");
            }
            print(board.slots[i] + "\t");
        }
    }

    public void displayCard(Card card) {
        println("\n\nYOUR CARD:");
        println(card.getTitle());
    }

    public void askForInput() {
        println("\nIn which slot do you want to place your card?");
    }

    public void displayExitMessage() {
        println("========================================");
        println("THANK YOU FOR PLAYING, GOOD BYE! :) ");
        println("========================================");
    }

    public void displayScore(Board board) {
        String results = Score.analyzeResults(board);
        println(results);
    }

    public void print(String s) {
        System.out.print(s);
    }

    public void println(String s) {
        System.out.println(s);
    }
}

