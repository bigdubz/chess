package com.mygdx.chess;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		int s = (int) (Lwjgl3ApplicationConfiguration.getDisplayMode().height*0.9f);
		config.setWindowedMode(s, s);
		config.setResizable(false);
		config.setForegroundFPS(60);
		config.setTitle("Chess");
		config.useVsync(true);
		config.setBackBufferConfig(8,8,8,8,16,0,8);
		new Lwjgl3Application(new Main(s), config);
	}
}
