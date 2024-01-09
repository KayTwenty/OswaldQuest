package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Door extends SuperObject {
    public Door() {
        name = "Door";
        description = "A wooden door";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/door.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set collision true for door object
        collision = true;
    }

}
