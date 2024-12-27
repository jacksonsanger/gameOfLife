package gameOfLife;

import java.awt.Color;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class GameOfLifeUI extends LifeObserver implements DrawListener{
	
	// width and height in pixels
	private int width;
	private int height;
	//the game window
	private Draw window;
	
	//we will store the rows and cols values using the getter methods
	private int rows;
	private int cols;

	public GameOfLifeUI(GameOfLife game, String title, int width, int height) {
		//call superclass constructor
		super(game);
		//assign width and height variables
		this.width = width;
		this.height = height;
		
        //get row and col info for future use
        rows = game.getRows();
        cols = game.getCols();
        
        //set up DUdraw window
		window = new Draw(title);
        window.setCanvasSize(width, height);
        window.setXscale(0, width);
		window.setYscale(0, height);
       
		// Add the mouse/key listeners
        window.addListener(this);
        
        //add itself to the GameOfLife's observers
        game.attatch(this);
        
        //draw initial window
        update();
	}

	@Override
	public void update() {
		// Redraw the entire board
		window.clear(Color.white);  // Clear in white
	 	drawGrid();
	 	drawLives();
		
	}
	
    private void drawGrid() {
        
    	window.setPenColor(Color.black);
    
        int cellWidth = width / cols;
        int cellHeight = height / rows;
     
        for (int i = 0; i <= rows; i++) {
        	window.line(0, i * cellHeight, this.width, i * cellHeight);
        }
        
        for (int i = 0; i <= cols; i++) {
        	window.line(i * cellWidth, 0, i * cellWidth, this.height);
        }
    }
    
    private void drawLives() {
    	
    	int cellWidth = width / cols;
        int cellHeight = height / rows;
        
    	window.setPenColor(Color.red);
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (game.getCell(i, j).isAlive()) {
        			// This is the center and half width/height
        			window.filledRectangle((j * cellWidth)+(cellWidth/2), (i * cellHeight)+(cellHeight/2), cellWidth/2, cellHeight/2);
                }
            }
        }
    }
    
    
    
    //All the mouse/keyboard listeners
	@Override
	public void keyPressed(int key) {
		// This is the advance button
		// Only advance for spacebar (ascii 32)
		if (key==32) {
			game.advance();
		}
	}

	@Override
	public void keyReleased(int key) {
		// Do nothing
	}

	@Override
	public void keyTyped(char key) {
		// Do nothing
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		// Do nothing
	}

	@Override
	public void mouseDragged(double x, double y) {
		// Do nothing
	}

	@Override
	public void mousePressed(double x, double y) {
		// This is the toggle of grid locations
		int cellWidth = width / cols;
        int cellHeight = height / rows;
        
        int cellLocRow = (int)(y / cellHeight);
        int cellLocCol = (int)(x / cellWidth);
       
		if (game.getCell(cellLocRow,cellLocCol).isAlive()) {
			game.getCell(cellLocRow,cellLocCol).die();
        } 
		else {
			game.getCell(cellLocRow,cellLocCol).live();
        }
		update();        
	}

	@Override
	public void mouseReleased(double x, double y) {
		// Do nothing
	}
	

}
