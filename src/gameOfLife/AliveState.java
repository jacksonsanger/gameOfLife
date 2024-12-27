package gameOfLife;

public class AliveState implements CellState{
	
	private static AliveState instance;
	
	//make constructor private to prevent instantiation
	private AliveState() {
	
	}
	
	public static AliveState create() {
		if(instance == null) {
			instance = new AliveState();
		}
		return instance;
	}

	@Override
	public CellState live() {
		return this;
	}

	@Override
	public CellState die() {
		return DeadState.create();
	}

	@Override
	public boolean isAlive() {
		return true;
	}

}
