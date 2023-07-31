package entity;

import main.gamePanel;
import main.keyHandler;

public class Player extends Entity {
    gamePanel gp;
    keyHandler keyH;

    public Player(gamePanel gp, keyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    // Set the default values for the Player entity
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }
}
