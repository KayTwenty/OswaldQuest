package tile;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

import main.gamePanel;

public class TileManager {
    gamePanel gp;
    Tile[] tile;

    public TileManager(gamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];

        getTileImage();
    }

    public void getTileImage() {
        try {
            // Grass Tile
            tile[0] = new Tile();
            tile[0].image =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("tiles/grass.png")));

            // Wall Tile
            tile[1] = new Tile();
            tile[1].image =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("tiles/wall.png")));

            // Water Tile
            tile[2] = new Tile();
            tile[2].image =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("tiles/water.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
