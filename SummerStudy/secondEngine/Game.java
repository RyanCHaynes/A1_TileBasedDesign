package dev.SummerStudy.secondEngine;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.SummerStudy.secondEngine.display.Display;
import dev.SummerStudy.secondEngine.gfx.Assets;
import dev.SummerStudy.secondEngine.states.GameState;
import dev.SummerStudy.secondEngine.states.MenuState;
import dev.SummerStudy.secondEngine.states.State;

public class Game implements Runnable{

	private Display display;
	private Thread thread;
	private boolean running = false;
	public int width, height;
	public String title;
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void tick(){
		if(State.getState() != null)
			State.getState().tick();
	}
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null)
			State.getState().render(g);

		bs.show();
		g.dispose();
	}
	
	private void init(){
		display = new Display(title, width, height);
		Assets.init();
		
		gameState = new GameState();
		menuState = new MenuState();
		State.setState(gameState);
	}
	
	public void run(){
		init();
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double deltaTime = 0;
		long currentTime;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks =0;
		
		while(running){
			currentTime = System.nanoTime();
			deltaTime += (currentTime - lastTime)/timePerTick;
			timer += currentTime - lastTime;
			lastTime = currentTime;
			
			if(deltaTime >= 1){
				tick();
				render();
				ticks++;
				deltaTime--;
			}
		}
		
		
		stop();
	}
	
	public synchronized void start(){
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e) {
			
		}
	}
}
