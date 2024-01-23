package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import main.gamePanel;

public class Door extends SuperObject {
    gamePanel gp;

    public Door(gamePanel gp) {
        this.gp = gp;

        name = "Door";
        description = "A wooden door";

        // Load the image from the resources folder
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/door.png")));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set collision true for door object
        collision = true;
    }

}
