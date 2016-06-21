
import java.lang.Thread.State;
import java.util.Random;

import javax.swing.SwingWorker.StateValue;

/**
 * Field represents playing field and game logic.
 */
public class Field {
	
	
	
    /**
     * Playing field tiles.
     */
    private final Tile[][] tiles;

    /**
     * Field row count. Rows are indexed from 0 to (rowCount - 1).
     */
    private final int rowCount;
    
    

    /**
     * Column count. Columns are indexed from 0 to (columnCount - 1).
     */
    private final int columnCount;

    public GameState getState() {
		return state;
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public int getColumnCount() {
		return columnCount;
	}

	
	public Tile[][] getTile() {
		return tiles;
	}

	public int getRowCount() {
		return rowCount;
	}
	
	public Tile getTile(int row, int column){
		return tiles[row][column];
	}
	
	

    /**
     * Game state.
     */
    private GameState state = GameState.PLAYING;

	

    /**
     * Constructor.
     *
     * @param rowCount    row count
     * @param columnCount column count
     * @param mineCount   mine count
     */
    public Field(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        tiles = new Tile[rowCount][columnCount];

        //generate the field content
        generate();
    }



    /**
     * Generates playing field.
     */
    private void generate() {
    	Random rnd = new Random();
    	int randomColl = rnd.nextInt(getColumnCount());
    	int randomRow = rnd.nextInt(getRowCount());
    	
    	if(getTile(randomRow, randomColl)==null){
    		tiles[randomRow][randomColl] = new EmptyTile();
    	}
    int valueOdRock=1;
    for(int row=0;row<getRowCount();row++ ){
    	for(int coll = 0; coll<getColumnCount();coll++){
    		if(getTile(row, coll)==null){
    			tiles[row][coll] = new NumberTile(valueOdRock++);
    		}
    	}
    } 
    }
    /**
     * Returns true if game is solved, false otherwise.
     * @return 
     * @return true if game is solved, false otherwise
     */
    private boolean isSolved() {
		boolean result = false;
		int valueOdRock=1;
		 for(int row=0;row<getRowCount();row++ ){
			 for(int coll = 0; coll<getColumnCount();coll++){
    		if(tiles[row][coll] == new NumberTile(valueOdRock++)){
    			result = true;
    		}else {
    			result = false; 
    		    }
			 }
		 }
		 return result;
	}
    
    public Tile findEmpty(){
    	Tile helpTile = null;
    	for(int row=0;row<getRowCount();row++ ){
        	for(int col= 0; col<getColumnCount();col++){
        		if(tiles[row][col] instanceof EmptyTile){
        			helpTile =  tiles[row][col];
        		
        		}
        	}
        }
		return helpTile;
		
		 
    }

	public void moveLeft(){
		findEmpty();
	}
	
	public void moveUp(){
		findEmpty();
	}
	
	public void moveDown(){
		findEmpty();
	}
	
	public void moveRight(){
    	findEmpty();
	}

    /**
     * Returns number of adjacent mines for a tile at specified position in the field.
     *
     * @param row    row number.
     * @param column column number.
     * @return number of adjacent mines.
     */
    
	
}
