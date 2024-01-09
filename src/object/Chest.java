package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Chest extends SuperObject {
    public Chest() {
        name = "Chest";
        description = "A sturdy box";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/chest.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
