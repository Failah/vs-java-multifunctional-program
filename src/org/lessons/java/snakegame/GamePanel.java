package org.lessons.java.snakegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 75;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 3;
	int applesEaten = 0;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	boolean timerControl = false;
	javax.swing.Timer timer;
	Random random;

	public GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(new Color(0, 51, 0));
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}

	public void startGame() {
		newApple();
		running = true;
		timer = new javax.swing.Timer(DELAY, this);
		// timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			draw(g);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw(Graphics g) throws FileNotFoundException {
		if (running) {
			// apple style
			g.setColor(Color.yellow);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

			for (int i = 0; i < bodyParts; i++) {
				if (i == 0) {
					// snake head style
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					// snake body style
					g.setColor(new Color(25, 180, 0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			// score ingame style
			g.setColor(Color.red);
			g.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
					g.getFont().getSize());
		} else {
			gameOver(g);
		}
	}

	public void newApple() {
		appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
	}

	public void move() {
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}

		switch (direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
	}

	public void checkApple() {
		if ((x[0] == appleX) && y[0] == appleY) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}

	public void checkCollisions() {
		// check body collisions
		for (int i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}

		// check border collisions
		if (x[0] < 0 || x[0] > SCREEN_WIDTH || y[0] < 0 || y[0] > SCREEN_HEIGHT) {
			running = false;
		}

		if (!running) {
			timer.stop();
		}
	}

	public void gameOver(Graphics g) throws FileNotFoundException {

		// show game over
		g.setColor(Color.red);
		g.setFont(new Font("Monospaced Bold", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT * 1 / 3);

		// show funny death messages
		List<String> borderCollisionMsg = new ArrayList<>();
		List<String> bodyCollisionMsg = new ArrayList<>();
		Random rand = new Random();
		String deathMsg;
		Scanner scanner = new Scanner(new File(
				"C:/Users/Valerio/Desktop/Boolean/Java/Workspace1/vs-java-multifunctional-program/src/org/lessons/java/snakegame/randomdeathmessages.txt"));
		while (scanner.hasNextLine()) {
			borderCollisionMsg.add(scanner.nextLine());
		}
		deathMsg = borderCollisionMsg.get(rand.nextInt(borderCollisionMsg.size()));
		g.setColor(Color.red);
		g.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
		FontMetrics metrics3 = getFontMetrics(g.getFont());
		g.drawString(deathMsg, (SCREEN_WIDTH - metrics3.stringWidth(deathMsg)) / 2, SCREEN_HEIGHT / 2);

		// show score
		g.setColor(Color.red);
		g.setFont(new Font("Monospaced Bold", Font.BOLD, 35));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Your score: " + applesEaten,
				(SCREEN_WIDTH - metrics1.stringWidth("Your score: " + applesEaten)) / 2, SCREEN_HEIGHT * 2 / 3);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (!timerControl) {
				timer.start();
				timerControl = true;
			}
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if (direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if (direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if (direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
	}

}
