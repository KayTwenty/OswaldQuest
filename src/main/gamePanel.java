package main;

import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel implements Runnable {

    private static final int FPS = 60;
    // Screen settings
    final int originalTitleSize = 16; // 16x16 tile
    final int scale = 3;

    final int tileSize = originalTitleSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    keyHandler keyH = new keyHandler();
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public gamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Aim at 60 FPS
        double drawInterval = 1000000000/FPS; // 0.1666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            // 1 Update: Update information such as characters positions
            update();

            // 2 Draw: Draw the screen with the update information
            repaint();

            try {
                // Checks when how much time remaining until the next draw time
                double remainingTime = nextDrawTime - System.nanoTime();

                // sleep() works in millis seconds we need to convert
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                // When sleep time is over and the thread is awakened
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                // TODO: Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // Draw the player using Graphics2D
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();

    }
}
