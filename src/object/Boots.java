package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Boots extends SuperObject {
    public Boots() {
        name = "Boots";
        description = "Make you go faster";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/boots.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
