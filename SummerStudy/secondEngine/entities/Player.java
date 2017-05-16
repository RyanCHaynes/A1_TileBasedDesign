package dev.SummerStudy.secondEngine.entities;

import java.awt.Graphics;

import dev.SummerStudy.secondEngine.Game;
import dev.SummerStudy.secondEngine.gfx.Assets;

public class Player extends Creature{
	private Game game;
	public Player(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_CRETURE_WIDTH, Creature.DEFAULT_CRETURN_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
		
		
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.mage, (int)x, (int)y, width, height, null);
	}

}
