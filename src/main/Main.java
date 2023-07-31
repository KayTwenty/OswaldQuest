package main;

import javax.swing.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        // Window (JFrame) Properties
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Oswald's Quest");

        // Icon Properties
        URL url = Main.class.getResource("/icons/logo.png");
        assert url != null;
        ImageIcon imgIcon = new ImageIcon(url);
        window.setIconImage(imgIcon.getImage());

        // Add the game panel
        gamePanel gamePanel = new gamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Start the game
        gamePanel.startGameThread();
    }
}