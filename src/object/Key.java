package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Key extends SuperObject {
    public Key() {
        name = "Key";
        description = "It must unlock something";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/key.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
