package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import main.gamePanel;

public class Boots extends SuperObject {
    gamePanel gp;

    public Boots(gamePanel gp) {
        this.gp = gp;

        name = "Boots";
        description = "Make you go faster";

        // Load the image from the resources folder
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/boots.png")));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
