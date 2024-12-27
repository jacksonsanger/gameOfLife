package gameOfLife;

import java.util.ArrayList;
import java.util.List;

public class Cell{
	private CellState state;
	private List<Cell> neighbors;
	
	//Every cell starts off as dead
	public Cell() {
		this.state = DeadState.create();
		this.neighbors = new ArrayList<Cell>();
	}

	//Delegate the behavior to the state objects
	public void live() {
		state = state.live();
	}

	public void die() {
		state = state.die();
	}

	public boolean isAlive() {
		return state.isAlive();
	}
	
	public void addNeighbor(Cell neighborCell) {
		neighbors.add(neighborCell);
	}
	
	public int nbrAliveNeigbors() {
		int n = 0;
		for(Cell neighbor : neighbors) {
			if (neighbor.isAlive()){
				n++;
			}
		}
		return n;
	}
	
	

}
