// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		// rectangle coordinate
		//	(x1,y1)
		//		(x2,y2)
		int x1=Integer.MAX_VALUE, y1=Integer.MAX_VALUE;
		int x2=Integer.MIN_VALUE, y2=Integer.MIN_VALUE;
		
		int m = grid.length;
		int n = grid[0].length;
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(grid[i][j]==ch){
					x1 = Math.min(x1,i);
					y1 = Math.min(y1,j);					
					x2 = Math.max(x2,i);
					y2 = Math.max(y2,j);					
				}
			}
		}
		
		int area = (x2-x1+1)*(y2-y1+1);
		return area; 
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	//copy from https://github.com/varren/cs108/blob/master/hw1/CharGrid.java
    public int countPlus() {
        int numOfPlus = 0;

        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[0].length; col++)
                if (isValidPlus(row, col))
                    numOfPlus++;

        return numOfPlus;
    }

    private boolean isValidPlus(int row, int col) {
        int left = nCharsInDirection(row, col, 0, -1);
        int right = nCharsInDirection(row, col, 0, 1);
        int down = nCharsInDirection(row, col, -1, 0);
        int up = nCharsInDirection(row, col, 1, 0);

        return left != 0 && left == right && left == up && left == down;
    }

    private int nCharsInDirection(int row, int col, int shiftRow, int shiftCol) {
        int nextRow = row + shiftRow;
        int nextCol = col + shiftCol;

        if (isValidCell(nextRow, nextCol) && grid[row][col] == grid[nextRow][nextCol])
            return 1 + nCharsInDirection(nextRow, nextCol, shiftRow, shiftCol);
        else return 0;
    }

    private boolean isValidCell(int row, int col) {
        return row < grid.length && grid.length > 0 && col < grid[0].length && col >= 0 && row >= 0;
    }
    
	
}
