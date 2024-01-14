package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import main.gamePanel;

public class Key extends SuperObject {
    gamePanel gp;

    public Key(gamePanel gp) {
        this.gp = gp;

        name = "Key";
        description = "It must unlock something";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/key.png")));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
