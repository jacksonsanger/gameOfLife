package gameOfLife;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

// Game of life main app using DuDraw
// Use mouse clicks to toggle cells
// Use spacebar to advance game

public class GameOfLife {
 
    // rows and cols for the game
    private int rows;
    private int cols;
    private Cell grid[][];
    private List<LifeObserver> lifeObservers;
   
    
    public GameOfLife(int rows, int cols) {
        
    	// Save the instance variables
    	this.rows = rows;
		this.cols = cols;
		this.lifeObservers = new ArrayList<LifeObserver>();
		

		// Setup the grid MOVE: to setupGrid method CHANGE: initialization
		this.grid = new Cell[rows][cols];
		setupGrid(this.grid);
    }
    
    private void setupGrid(Cell[][] g) {
    	for(int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    			g[i][j] = new Cell();
    		}
    	}
    	
    	//Tell each of the cells about their neighbors
    	//Remember that the neighbors wrap around the edges
    	for(int r = 0; r < rows; r++) {
    		for(int c = 0; c < cols; c++) {
    			int x = 0;
    			int y = r-1;
    			if(y < 0) {
    				y = rows - 1;
    			}
    			for(int rCt = 1; rCt <= 3; rCt++) {
    				x = c - 1;
    				if(x<0) {
    					x = cols - 1;
    				}
    				for (int cCt = 1; cCt <= 3; cCt++) {
    					if(x != c || y != r) {
    						g[r][c].addNeighbor(g[y][x]);
    					}
    					x = (x+1) % cols;
    				}
    				y = (y+1) % rows;
    			}
    		}
    	}	
    }
   

    // This method implements the rules of the Game of Life. For each cell,
    //   we simple find the number of neighbors and then bring the cell to life
    //   if appropriate.
    public void advance() {
        int n = 0;
        ArrayList<LifeCommand> commands = new ArrayList<LifeCommand>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                n = grid[i][j].nbrAliveNeigbors();
                if (grid[i][j].isAlive()) {
                	//if the cell is alive and doesn't have the correct amount of neighbors, it dies
                    if (n != 2 && n != 3) {
                        commands.add(new DieCommand(grid[i][j]));
                    }
                } 
                else {
                	//cell comes to life if it is dead and has 3 living neighbors
                    if (n == 3) {
                        commands.add(new LiveCommand(grid[i][j]));
                    }
                }
            }
        }
        //iterate through the commands and execute them
        for(LifeCommand command : commands) {
        	command.execute();
        }
        //notify the observers of the game state changes
        notifyObservers();
    }

    
	//here iterate through observers list and call their update method
	public void notifyObservers() {
		for(LifeObserver observer : lifeObservers) {
			observer.update();
		}

	}
	
	public void attatch(LifeObserver lo) {
		lifeObservers.add(lo);
	}
	
	public void detatch(LifeObserver lo) {
		lifeObservers.remove(lo);
	}
	
	public int getRows() {
		return rows;
	}
    
	public int getCols() {
		return cols;
	}
	public Cell getCell(int row, int col) {
		return grid[row][col];
	}
}