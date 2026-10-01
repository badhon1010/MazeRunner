import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final  int screenX;
    public final  int screenY;
    public int hasKey = 0;





    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screeHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX= gp.tileSize * 19;
        worldY=gp.tileSize * 38;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try{

            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/materials/boy_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/materials/boy_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/materials/boy_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/materials/boy_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/materials/boy_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/materials/boy_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/materials/boy_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/materials/boy_right_2.png")));


        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void update(){
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true|| keyH.rightPressed == true) {
            if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            gp.eHandler.checkEvent();

            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            if(collisionOn == false){
                switch (direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }

                spriteCounter = 0;
            }
        }
    }
    public void pickUpObject(int i) {
        if (i != 999) {
            String objectName = gp.obj[i].name;
            switch (objectName) {
                case "key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    //gp.ui.showmessage("You Got A key");
                    break;
                case "door":
                    if (hasKey > 0) {
                        gp.playSE(3);
                        gp.obj[i] = null;
                        hasKey--;
                        //gp.ui.showmessage("You opened a Door");
                    } else {
                        //gp.ui.showmessage("You Need A key");
                    }
                    System.out.println("key: " + hasKey);
                    break;
                case "door1":
                    gp.ui.gameRunning1 = true;
                    break;
                case "door2":
                    gp.ui.gameRunning2  = true;
                    break;
                case "door3":
                    gp.ui.gameRunning3 = true;
                    break;
                case "door4":
                    gp.ui.gameRunning4 = true;
                    break;
                case "chest":
                    if(gp.currentMap < gp.maxMap) {
                        gp.currentMap++;
                        gp.tileM.loadMap("/maps/world" + gp.currentMap + ".txt");
                        gp.aSetter.setObject();
                        setDefaultValues();
                        hasKey = 0;
                        gp.playSE(3);
                    } else {
                        gp.ui.gameFinished = true;
                        gp.playSE(4);
                    }
                    break;
            }
        }
    }

    public void draw(Graphics2D g2){
//        g2.setColor(Color.WHITE);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        switch (direction){
            case "up":
                if(spriteNum==1) {
                    image = up1;
                }
                if(spriteNum==2) {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum==1) {
                    image = down1;
                }
                if(spriteNum==2) {
                image = down2;
            }
                break;
            case "left":
                if(spriteNum==1) {
                    image = left1;
                }
                if(spriteNum==2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum==1) {
                    image = right1;
                }
                if(spriteNum==2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY ,gp.tileSize, gp.tileSize, null);
    }
}
