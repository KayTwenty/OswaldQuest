package main;

import object.Key;

public class objectLoader {
    gamePanel gp;
    public objectLoader(gamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        // Spawn Key on cords
        gp.obj[0] = new Key();
        gp.obj[0].worldX = 22 * gp.tileSize;
        gp.obj[0].worldY = 9 * gp.tileSize;

        // Spawn Second Key on cords
        gp.obj[0] = new Key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 41 * gp.tileSize;
    }
}
