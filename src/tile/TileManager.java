package tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import javax.imageio.ImageIO;

import main.gamePanel;

public class TileManager {
    gamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(gamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("map/world01v2.txt");
    }

    public void getTileImage() {
        try {
            // Grass Tile
            tile[0] = new Tile();
            tile[0].image =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("tiles/0.png")));

            // Wall Tile
            tile[1] = new Tile();
            tile[1].image =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("tiles/1.png")));
            tile[1].collision = true;

            // Water Tile
            tile[2] = new Tile();
            tile[2].image =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("tiles/2.png")));
            tile[2].collision = true;

            // Earth Tile
            tile[3] = new Tile();
            tile[3].image =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("tiles/3.png")));

            // Tree Tile
            tile[4] = new Tile();
            tile[4].image =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("tiles/4.png")));
            tile[4].collision = true;

            // Sand Tile
            tile[5] = new Tile();
            tile[5].image =  ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("tiles/5.png")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            // As long a tile is in boundary, it will draw it
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
