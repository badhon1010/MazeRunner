import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Door3 extends SuperObject{
    public OBJ_Door3(){
        name = "door3";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/door1.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
