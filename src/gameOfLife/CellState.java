package gameOfLife;

public interface CellState {
	public CellState live();
	public CellState die();
	public boolean isAlive();
}
