package gameOfLife;

public class DeadState implements CellState{
	
	private static DeadState instance;
	
	//make constructor private to prevent instantiation
	private DeadState() {
	}
	
	public static DeadState create() {
		if(instance == null) {
			instance = new DeadState();
		}
		return instance;
	}
	

	@Override
	public CellState live() {
		return AliveState.create();
	}

	@Override
	public CellState die() {
		return this;
	}

	@Override
	public boolean isAlive() {
		return false;
	}

}
