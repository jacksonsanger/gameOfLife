package gameOfLife;


public abstract class LifeObserver{
	protected GameOfLife game;
	
	public LifeObserver(GameOfLife game) {
		this.game = game;
	}
	
	public abstract void update();
}
