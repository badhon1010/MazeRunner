import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Door extends SuperObject{
    public OBJ_Door(){
        name = "door";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/door (1).png")));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
