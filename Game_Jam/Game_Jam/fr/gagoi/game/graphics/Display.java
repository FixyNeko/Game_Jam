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
		long startTime = System.currentTimeMillis(), startTimeFPS = System.currentTimeMillis();

		while (isRunning) {
			long currentTime = System.currentTimeMillis(), currentTimeFPS = System.currentTimeMillis();
			long delta = currentTime - startTime, deltaFPS = currentTimeFPS - startTimeFPS;
			if (delta >= 100 / 6) {
				canvas.render();
				startTime = System.currentTimeMillis();
				try {
					long t = 100 / 6 - delta;
					if (t > 0)
						Thread.sleep(100 / 6 - delta);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				fps++;
			}
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
