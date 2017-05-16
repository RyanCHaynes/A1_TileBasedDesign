package dev.SummerStudy.secondEngine.states;

import java.awt.Graphics;

import dev.SummerStudy.secondEngine.Game;
import dev.SummerStudy.secondEngine.entities.Player;
import dev.SummerStudy.secondEngine.gfx.Assets;

public class GameState extends State{

	private Player player;
	
	public GameState(Game game){
		super(game);
		player = new Player(game, 100,100);
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.mage, 0, 0, null);
		player.render(g);
	}
	
}
