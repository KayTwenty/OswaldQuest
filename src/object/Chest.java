package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import main.gamePanel;

public class Chest extends SuperObject {
    gamePanel gp;

    public Chest(gamePanel gp) {
        this.gp = gp;

        name = "Chest";
        description = "A sturdy box";

        // Load the image from the resources folder
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/chest.png")));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
