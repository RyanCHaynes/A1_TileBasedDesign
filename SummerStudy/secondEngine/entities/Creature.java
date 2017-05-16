package dev.SummerStudy.secondEngine.entities;



public abstract class Creature extends Entity {

	
	public static final int DEFAULT_HEALTH =10;
	public static final float DEFAULT_SPEED =3.0f;
	public static final int DEFAULT_CRETURE_WIDTH = 64,
							DEFAULT_CRETURN_HEIGHT = 64;
	protected float xMove, yMove;
	protected int health;
	protected float speed; 
	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove =0;
		yMove = 0;
	}
	public void move(){
		x += xMove;
		y += yMove;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
}
