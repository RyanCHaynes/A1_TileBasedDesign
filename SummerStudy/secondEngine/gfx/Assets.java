package dev.SummerStudy.secondEngine.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage mage;
	private static final int width =32, height = 32;
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/bloodTemplarRagemancer.png"));
		mage = sheet.crop(0, 0, width, height);
	}

}
