import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String messeage = " ";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public boolean gameRunning1 = false;
    public boolean gameRunning2 = false;
    public boolean gameRunning3 = false;
    public boolean gameRunning4 = false;
    public int commandNum =0;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.PLAIN, 80);

        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }
    public void showmessage(String text){
        messeage = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        if (gp.gameState == gp.titleState) {
            drawTiltleState();
        }
        else if (gp.gameState == gp.mapSelectState) {
            drawMapSelectState();
        }

        if (gp.gameState == gp.playState) {
            // do playstate stuff later
        }
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        if (gameRunning1 == true) {
            gp.gameState = gp.mazeState1;
            if (gp.gameState == gp.mazeState1) {
                drawmazeState1();
            }
        }
        if (gameRunning2 == true) {
            gp.gameState = gp.mazeState2;
            if (gp.gameState == gp.mazeState2) {
                drawmazeState2();
            }
        }
        if (gameRunning3 == true) {
            gp.gameState = gp.mazeState3;
            if (gp.gameState == gp.mazeState3) {
                drawmazeState3();
            }
        }
        if (gameRunning4 == true) {
            gp.gameState = gp.mazeState4;
            if (gp.gameState == gp.mazeState4) {
                drawmazeState4();
            }
        }
        if(gameFinished == true){

            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);

            String text;
            int textLength;
            int x;
            int y;

            text = "You Made it!!!!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
             x = gp.screenWidth/2 - textLength/2;
             y = gp.screeHeight/2 - (gp.tileSize*3);
             g2.drawString(text, x, y);


            g2.setFont(arial_80B);
            g2.setColor(Color.YELLOW);
            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screeHeight/2 + (gp.tileSize*3);
            g2.drawString(text, x, y);

            gp.gameThread = null;

        }

        else{
            if(gp.gameState == gp.playState){
                g2.setFont(arial_40);
                g2.setColor(Color.WHITE);
                g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
                g2.drawString("x "+ gp.player.hasKey, 74, 65);
            }
            else {

                if(messageOn == true){
                    g2.setFont(g2.getFont().deriveFont(30F));
                    g2.drawString(messeage, gp.tileSize/2, gp.tileSize*5);

                    messageCounter++;

                    if(messageCounter > 120){
                        messageCounter =0;
                        messageOn = false;
            }


                }
            }
        }

    }

    public void drawmazeState1(){
        g2.setColor(new Color(9, 9, 9, 128));
        g2.fillRect(0,0, gp.screenWidth, gp.screeHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
        String text1 = "I speak without a mouth and hear without ears.";
        String text2 =  " I have no body, but I come alive with the wind. What am I?";
        int x = 0;
        int y = gp.tileSize*2;
        g2.setColor(Color.white);
        g2.drawString(text1,x, y);
        g2.drawString(text2,x+25, y+25);
//        g2.setColor(Color.lightGray);
//        g2.drawString(text1,x,y);
//        g2.setColor(Color.lightGray);
//        g2.drawString(text2,x+25,y+25);

        String text3 = "An Echo";
        x  = getXforCenteredText(text3);
        y += gp.tileSize*3.5;
        g2.drawString(text3,x,y);
        if(commandNum == 0){
            g2.drawString(">",x-gp.tileSize, y );
        }

        String text4 = "Shadow";
        x  = getXforCenteredText(text4);
        y += gp.tileSize;
        g2.drawString(text4,x,y);
        if(commandNum == 1){
            g2.drawString(">",x-gp.tileSize, y );
        }
        String text5 = "WHisper";
        x  = getXforCenteredText(text5);
        y += gp.tileSize;
        g2.drawString(text5,x,y);
        if(commandNum == 2){
            g2.drawString(">",x-gp.tileSize, y );
        }
        String text6 = "Ghost";
        x  = getXforCenteredText(text6);
        y += gp.tileSize;
        g2.drawString(text6,x,y);
        if(commandNum == 3){
            g2.drawString(">",x-gp.tileSize, y );
        }
    }
    public void drawmazeState2(){
        g2.setColor(new Color(9, 9, 9, 128));
        g2.fillRect(0,0, gp.screenWidth, gp.screeHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
        String text10 = "I’m light as a feather, yet the strongest man can’t hold me";
        String text20 =  " for much longer than a minute. What am I?";
        int x = 0;
        int y = gp.tileSize*2;
        g2.setColor(Color.white);
        g2.drawString(text10,x, y);
        g2.drawString(text20,x+25, y+25);
//        g2.setColor(Color.lightGray);
//        g2.drawString(text1,x,y);
//        g2.setColor(Color.lightGray);
//        g2.drawString(text2,x+25,y+25);

        String text3 = "Breath";
        x  = getXforCenteredText(text3);
        y += gp.tileSize*3.5;
        g2.drawString(text3,x,y);
        if(commandNum == 0){
            g2.drawString(">",x-gp.tileSize, y );
        }

        String text4 = "Water";
        x  = getXforCenteredText(text4);
        y += gp.tileSize;
        g2.drawString(text4,x,y);
        if(commandNum == 1){
            g2.drawString(">",x-gp.tileSize, y );
        }
        String text5 = "WHisper";
        x  = getXforCenteredText(text5);
        y += gp.tileSize;
        g2.drawString(text5,x,y);
        if(commandNum == 2){
            g2.drawString(">",x-gp.tileSize, y );
        }
        String text6 = "Time";
        x  = getXforCenteredText(text6);
        y += gp.tileSize;
        g2.drawString(text6,x,y);
        if(commandNum == 3){
            g2.drawString(">",x-gp.tileSize, y );
        }
    }
    public void drawmazeState3(){
        g2.setColor(new Color(9, 9, 9, 128));
        g2.fillRect(0,0, gp.screenWidth, gp.screeHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
        String text1 = "I have keys but no locks. I have space but no room.";
        String text2 =  "You can enter, but you can’t go outside. What am I?";
        int x = 0;
        int y = gp.tileSize*2;
        g2.setColor(Color.white);
        g2.drawString(text1,x, y);
        g2.drawString(text2,x+25, y+25);
//        g2.setColor(Color.lightGray);
//        g2.drawString(text1,x,y);
//        g2.setColor(Color.lightGray);
//        g2.drawString(text2,x+25,y+25);

        String text3 = "KeyBoard";
        x  = getXforCenteredText(text3);
        y += gp.tileSize*3.5;
        g2.drawString(text3,x,y);
        if(commandNum == 0){
            g2.drawString(">",x-gp.tileSize, y );
        }

        String text4 = "Book";
        x  = getXforCenteredText(text4);
        y += gp.tileSize;
        g2.drawString(text4,x,y);
        if(commandNum == 1){
            g2.drawString(">",x-gp.tileSize, y );
        }
        String text5 = "Library";
        x  = getXforCenteredText(text5);
        y += gp.tileSize;
        g2.drawString(text5,x,y);
        if(commandNum == 2){
            g2.drawString(">",x-gp.tileSize, y );
        }
        String text6 = "House";
        x  = getXforCenteredText(text6);
        y += gp.tileSize;
        g2.drawString(text6,x,y);
        if(commandNum == 3){
            g2.drawString(">",x-gp.tileSize, y );
        }
    }
    public void drawmazeState4(){
        g2.setColor(new Color(9, 9, 9, 128));
        g2.fillRect(0,0, gp.screenWidth, gp.screeHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
        String text1 = "I can be cracked, made, told, and played. What am I?";
        int x = 0;
        int y = gp.tileSize*2;
        g2.setColor(Color.white);
        g2.drawString(text1,x, y);
        String text3 = "Joke";
        x  = getXforCenteredText(text3);
        y += gp.tileSize*3.5;
        g2.drawString(text3,x,y);
        if(commandNum == 0){
            g2.drawString(">",x-gp.tileSize, y );
        }

        String text4 = "Glass";
        x  = getXforCenteredText(text4);
        y += gp.tileSize;
        g2.drawString(text4,x,y);
        if(commandNum == 1){
            g2.drawString(">",x-gp.tileSize, y );
        }
        String text5 = "Drum";
        x  = getXforCenteredText(text5);
        y += gp.tileSize;
        g2.drawString(text5,x,y);
        if(commandNum == 2){
            g2.drawString(">",x-gp.tileSize, y );
        }
        String text6 = "Egg";
        x  = getXforCenteredText(text6);
        y += gp.tileSize;
        g2.drawString(text6,x,y);
        if(commandNum == 3){
            g2.drawString(">",x-gp.tileSize, y );
        }
    }


    public void drawTiltleState(){

        g2.setColor(new Color(70,120,80));
        g2.fillRect(0,0, gp.screenWidth, gp.screeHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,90F));
        String text = "Maze Runner";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;

        g2.setColor(Color.black);
        g2.drawString(text,x+5, y+5);
        g2.setColor(Color.lightGray);
        g2.drawString(text,x,y);

        x = gp.screenWidth/2 - (gp.tileSize*2)/2;
        y+=gp.tileSize*2;
        g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null );

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "New Game";
        x  = getXforCenteredText(text);
        y += gp.tileSize*3.5;
        g2.drawString(text,x,y);
        if(commandNum == 0){
            g2.drawString(">",x-gp.tileSize, y );
        }

        text = "Continue";
        x  = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 1){
            g2.drawString(">",x-gp.tileSize, y );
        }
        text = "Quit";
        x  = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 2){
            g2.drawString(">",x-gp.tileSize, y );
        }
    }

    public void drawMapSelectState(){
        g2.setColor(new Color(70,120,80));
        g2.fillRect(0,0, gp.screenWidth, gp.screeHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,90F));
        String text = "Select Map";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;

        g2.setColor(Color.black);
        g2.drawString(text,x+5, y+5);
        g2.setColor(Color.lightGray);
        g2.drawString(text,x,y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "Map 1 (Standard)";
        x  = getXforCenteredText(text);
        y += gp.tileSize*5;
        g2.drawString(text,x,y);
        if(commandNum == 0){
            g2.drawString(">",x-gp.tileSize, y );
        }

        text = "Map 2 (Island)";
        x  = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 1){
            g2.drawString(">",x-gp.tileSize, y );
        }

        text = "Back";
        x  = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 2){
            g2.drawString(">",x-gp.tileSize, y );
        }
    }

    public void drawPauseScreen(){

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "Paused";
        int x = getXforCenteredText(text);
        int y = gp.screeHeight/2;
                g2.drawString(text, x, y);

    }
    public int getXforCenteredText(String text){
        int x;
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth/2-length/2;
        return x;
    }
}
