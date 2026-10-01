import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Door4 extends SuperObject{
    public OBJ_Door4(){
        name = "door4";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/door1.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
