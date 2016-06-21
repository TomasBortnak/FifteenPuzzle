
public class FifteenPuzzle {
    /** User interface. */
    private UserInterface userInterface;
 
    /**
     * Constructor.
     */
    private FifteenPuzzle() {
        userInterface = new ConsoleUI();
        
        Field field = new Field(4, 4);
        userInterface.newGameStarted(field);
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        new FifteenPuzzle();
    }
}