package main;

import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel implements Runnable {
    // Screen settings
    final int originalTitleSize = 16; // 16x16 tile
    final int scale = 3;

    final int tileSize = originalTitleSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;

    public gamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            // System.out.println("The game loop is running.");

            // 1 Update: Update information such as characters positions

            // 2 Draw: Draw the screen with the update information


        }
    }

    public void update() {

    }

    public void paintComponent() {

    }
}
