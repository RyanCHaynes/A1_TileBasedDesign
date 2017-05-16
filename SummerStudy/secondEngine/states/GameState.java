package dev.SummerStudy.secondEngine.states;

import java.awt.Graphics;

import dev.SummerStudy.secondEngine.gfx.Assets;

public class GameState extends State{

	public GameState(){
		
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.mage, 0, 0, null);
		
	}
	
}
