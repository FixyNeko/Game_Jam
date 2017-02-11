package fr.gagoi.game.graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Display extends JFrame implements Runnable {

	private static final String TITLE = "GAME";

	private ScreenCanvas canvas;
	private boolean isRunning = true;
	private Thread t;
	private int fps;

	public Display() {
		canvas = new ScreenCanvas();
		setTitle(TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400, 800);
		setResizable(false);
		getContentPane().add(canvas);
		setVisible(true);
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		long startTimeFPS = System.currentTimeMillis();
		// System.currentTimeMillis();
		// long lastTimeFrame = System.currentTimeMillis();
		// long lastFrameTime = System.currentTimeMillis();

		while (isRunning) {

			long renderBegin = System.currentTimeMillis();
			canvas.render();
			long renderEnd = System.currentTimeMillis();
			

			long t = 1000 / 60 - (renderEnd - renderBegin);
			if (t > 0)
				try {
					Thread.sleep(t);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			long deltaFPS = System.currentTimeMillis() - startTimeFPS;
			fps++;
			if (deltaFPS >= 1000) {
				setTitle(TITLE + " | fps=" + fps);
				startTimeFPS = System.currentTimeMillis();
				fps = 0;
			}

		}
	}

	public ScreenCanvas getCanvas() {
		return canvas;
	}
}
