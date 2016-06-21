
public class NumberTile extends Tile{
    /** Value of the tile. */
    private final int value;
    
    /**
     * Constructor.
     * @param value  value of the tile
     */
    public NumberTile(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}
}

