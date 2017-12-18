//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	
	
	boolean[][] grid;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		//corner case
		if(grid==null || grid.length==0 || grid[0].length==0){
			return;
		}
		
		//main
		for(int row = 0; row < grid[0].length; row++){
			if(isFilledRow(row)){
				dropRow(row);
			}
		}
		
	}
	
	private boolean isFilledRow(int row){
        for (int col = 0; col < grid.length; col++)
            if (!grid[col][row])
                return false;		
		return true;
	}
	
	private void dropRow(int row){
        for (int currRow = row; currRow < grid[0].length; currRow++){
            pushNextRowDown(currRow);
    	}
	}
	
	private void pushNextRowDown(int currRow){
        for (int col = 0; col < grid.length; col++)
            if (currRow < grid[0].length - 1)          //all except last rows
                grid[col][currRow] = grid[col][currRow + 1];
            else if (currRow == grid[0].length - 1)  // last row
                grid[col][currRow] = false;
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; // YOUR CODE HERE
	}
}
