package main;

import object.Boots;
import object.Chest;
import object.Door;
import object.Key;

public class objectLoader {
    gamePanel gp;

    public objectLoader(gamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        // Spawn key on cords
        gp.obj[0] = new Key(gp);
        gp.obj[0].worldX = 22 * gp.tileSize;
        gp.obj[0].worldY = 8 * gp.tileSize;

        // Spawn second key on cords
        gp.obj[1] = new Key(gp);
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 41 * gp.tileSize;

        // Spawn third key on cords
        gp.obj[2] = new Key(gp);
        gp.obj[2].worldX = 38 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        // Spawn first door
        gp.obj[3] = new Door(gp);
        gp.obj[3].worldX = 10 * gp.tileSize;
        gp.obj[3].worldY = 11 * gp.tileSize;

        // Spawn second door
        gp.obj[4] = new Door(gp);
        gp.obj[4].worldX = 23 * gp.tileSize;
        gp.obj[4].worldY = 37 * gp.tileSize;

        // Spawn treasure chest
        gp.obj[5] = new Chest(gp);
        gp.obj[5].worldX = 10 * gp.tileSize;
        gp.obj[5].worldY = 8 * gp.tileSize;

        // Spawn boots
        gp.obj[7] = new Boots(gp);
        gp.obj[7].worldX = 37 * gp.tileSize;
        gp.obj[7].worldY = 42 * gp.tileSize;

    }
}
