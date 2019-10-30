import java.util.Scanner;

public class BlackjackSolitaire {
    public boolean playingGame = true;

    public Scanner scanner;
    public Player userInterface;
    public Board board;
    public Deck deck;

    public BlackjackSolitaire() {
        this.scanner = new Scanner(System.in);
        this.userInterface = new Player();
        this.board = new Board();
        this.deck = new Deck();
    }

    public void play() {
        userInterface.displayIntroduction();

        while (playingGame) {
            userInterface.displayBoard(board);

            Card cardOnHand = deck.getRandomCard();
            userInterface.displayCard(cardOnHand);
            userInterface.askForInput();

            String input = scanner.nextLine();
            if (input.equals("exit")) {
                endGame();
                return;
            }
            board.updateBoard(input, cardOnHand);

            if (board.slotsAreFilled()) {
                userInterface.displayBoard(board);
                userInterface.displayScore(board);
                endGame();
                return;
            }
        }
    }

    public void endGame() {
        userInterface.displayExitMessage();
        playingGame = false;
    }
}
