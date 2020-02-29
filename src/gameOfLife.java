/*
 * @author Marcelo Sanchez
 * @Version 12/5/2017
 */
public class gameOfLife {
	
	/*
	 * the int grid that is used to store all the values
	 * of the game. 1 is a live cell, 0 is a dead cell. 
	 */
	private static int [][] grid;
	
	private void update(){
		/*
		 * the two for loops are used throughout this program
		 * to traverse through the grid. This method called
		 * after x amount of cycles. Currently set at 200.
		 */
		for(int row = 1; row < grid.length -1; row++){
			for(int col =1; col < grid[row].length -1; col++){
				
				/*
				 * if conditions are set to check the given index's 
				 * number of neighbors, then decides if the cell lives
				 * or dies according to the game rules.
				 */
				if(getNeighbors(row, col) < 2 && grid[row][col] == 1){
					grid[row][col] = 0;
				}
				if(grid[row][col] == 1 && getNeighbors(row, col) > 3){
					grid[row][col] = 0;
				}
				
				if(grid[row][col] == 0 && getNeighbors(row, col) == 3){
					grid[row][col] = 1;
				}
				
				/*
				 * commented out this code // used for testing purposes
				 */
			//	System.out.print(grid[row][col] + " ");
				
			}//System.out.println();
		}
	}

	private int getNeighbors(int x, int y){
		/*
		 * this method returns the amount of neighbors
		 * given an index.
		 */
		int count = 0;
		
		/*
		 * these two for loops iterate through a 3 x 3 grid
		 * and increment the count variable for every live
		 * cell found. The if statements determine when 
		 * the count is incremented.
		 */
		for(int a = x-1; a <= x+1; a++){
			for(int b = y-1; b <= y+1; b++){
				if(!(a == x && b == y))
					if(grid[a][b] == 1)
						count++;
			}
		}

		return count;
	}

	public void run(int cycles){
		/*
		 * user enter x amount of cycles and then this
		 * method calls on the update method for that 
		 * amount of cycles with a simple for loop. An
		 * object of type LifeWindow is created to display
		 * the animation of the grid.
		 */
		
		LifeWindow win = new LifeWindow(grid, 20);
		for(int i = 0; i < cycles; i++){
			update();
			win.displayLife();
		}
	}

	private void initializeGrid(){
		/*
		 * this method randomly chooses a 1 or 0
		 * to be placed within each cell. The method
		 * also prints out the initial values of the 
		 * grid.
		 */
		System.out.println("The initial grid: ");
		for(int row = 1; row < grid[row].length -1; row++){
			for(int col =1; col < grid[row].length -1; col++){
				int random = (int)(Math.random() * 2);
				grid[row][col] = random;
				System.out.print(grid[row][col] + " ");
			}System.out.println();
		}
	}

	gameOfLife(){
		/*
		 * the constructor for the gameOfLife
		 * initializes the grid and calls the
		 * initializeGrid() method to randomly
		 * place a 1 or 0 in each cell. 
		 */
		grid = new int[27][27];
		initializeGrid();
		System.out.println();
	}
}



