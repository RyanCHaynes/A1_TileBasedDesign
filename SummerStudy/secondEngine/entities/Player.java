package dev.SummerStudy.secondEngine.entities;

import java.awt.Graphics;

import dev.SummerStudy.secondEngine.gfx.Assets;

public class Player extends Creature{

	public Player(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.mage, (int)x, (int)y, null);
	}

}
