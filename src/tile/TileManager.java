package tile;

import main.UtilityTool;
import main.gamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {
    gamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(gamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("map/world01v2.txt");
    }

    // Get tile image
    public void getTileImage() {
        // Grass Tiles
        setup(0, "0", false);

        // Wall Tiles
        setup(1, "1", true);

        // Water Tiles
        setup(2, "2", true);

        // Earth Tile
        setup(3, "3", false);

        // Tree Tiles
        setup(4, "4", true);

        // Sand Tiles
        setup(5, "5", false);
    }

    // Setup tile image
    public void setup(int index, String imageName, boolean collision) {
        UtilityTool uTool = new UtilityTool();

        try {
            String imagePath = "/tiles/" + imageName + ".png";

            // Check if the resource exists
            if (getClass().getResource(imagePath) == null) {
                System.err.println("Error: Resource not found - " + imagePath);
            } else {
                tile[index] = new Tile();
                tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/tiles/" + imageName + ".png")));
                tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
                tile[index].collision = collision;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading image for index " + index + ": " + imageName, e);
        }
    }

    // Load map from text file
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
            throw new RuntimeException("Error reading map file: " + filePath, e);
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
