

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Console user interface.
 */
public class ConsoleUI implements UserInterface {
    /** Playing field. */
    private Field field;
    
    /** Input reader. */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Reads line of text from the reader.
     * @return line as a string
     */
    private String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    /* (non-Javadoc)
	 * @see minesweeper.consoleui.UserInterface#newGameStarted(minesweeper.core.Field)
	 */
    public void newGameStarted(Field field) {
        this.field = field;
        do {
            update();
            processInput();
            switch (field.getState()) {
			case SOLVED:
				System.out.println("Game solved");
				update();
				System.exit(0);
				break;
//			case FAILED:
//				System.out.println("Game OVER");
//				update();
//				System.exit(0);
//				break;
			default:
				break;

			}
        } while(true);
    }
    
    /* (non-Javadoc)
	 * @see minesweeper.consoleui.UserInterface#update()
	 */
    @Override
    public void update() {
    	NumberTile nt = new NumberTile(1);
        for(int i = 0; i < field.getColumnCount();i++){
        	for(int j =-0; j < field.getRowCount(); j++){
        		if(Tile.State.VISIBLE != null){
        			Tile tempTile = field.getTile(i, j);
        			if(tempTile instanceof EmptyTile){
						System.out.print("*  ");
					}
					if(tempTile instanceof NumberTile){
						if(((NumberTile) tempTile).getValue()<10){
							System.out.print(((NumberTile) tempTile).getValue() + "  ");
						}else if(((NumberTile) tempTile).getValue()>=10){
							System.out.print(((NumberTile) tempTile).getValue() + " ");
						}
						}
        		}
//        		if(nt.getValue()<10){
//    				System.out.print(nt.getValue() + "  ");
//    				
//    			}else if (nt.getValue()>=10){
//    				System.out.print(nt.getValue() + " ");
//   				a++;
//    				if(nt.getValue()==(field.getColumnCount()*field.getRowCount())){
//    					System.out.print("*");
//    					break; 
//    				}
//    			}
        			
        		}
        	System.out.println();
        	}
    }
    		
        	
    
    /**
     * Processes user input.
     * Reads line from console and does the action on a playing field according to input string.
     */
	private void processInput() {

		try {
	        System.out.println();
	        System.out.println("                          w");
	        System.out.println("Hru ovladas pismenami   a,s,d");
	        System.out.println("pre spustenie novej hry napis: new");
	        System.out.println("pre ukoncenie hry napis: exit");
	        System.out.println("Zadaj vstup: ");
			handleInput(readLine());
		}
		catch(WrongFormatException ex){
			ex.printStackTrace();
		}

	}
    
    
	private void handleInput(String input) throws WrongFormatException{
		
        Pattern pattern = Pattern
				.compile("([w]{1}|[a]{1}|[s]{1}|[d]{1}|[new]{1}|[exit]{1})?");

		Matcher matcher = pattern.matcher(input);
		
		if (matcher.matches()) {

			String command = matcher.group(1);

			int row, col;

			switch (command) {
			case "a":
				field.moveLeft();
				break;
			case "w": 
				field.moveUp();
				break;
			case "s":
				field.moveDown();
				break;
			case "d":
				field.moveRight();
				break;
			case "exit": 
				System.exit(0);
				break;
			case "new": 
				System.exit(0);
				break;
			}
			
			
    }
    }}
