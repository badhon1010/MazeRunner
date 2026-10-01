import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;


    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code =  e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_SPACE){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            } else if (gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(gp.gameState == gp.titleState){
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum = 2;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>2){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.mapSelectState;
                    gp.ui.commandNum = 0; // reset for map select menu
                }
                if(gp.ui.commandNum == 1){
                    //add later
                }
                if(gp.ui.commandNum == 2){
                    System.exit(0);
                }

            }
        }

        else if(gp.gameState == gp.mapSelectState){
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum = 2;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>2){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){ // Map 1
                    gp.currentMap = 1;
                    gp.tileM.loadMap("/maps/world1.txt");
                    gp.aSetter.setObject();
                    gp.player.setDefaultValues();
                    gp.player.hasKey = 0;
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){ // Map 2
                    gp.currentMap = 2;
                    gp.tileM.loadMap("/maps/world2.txt");
                    gp.aSetter.setObject();
                    gp.player.setDefaultValues();
                    gp.player.hasKey = 0;
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){ // Back
                    gp.gameState = gp.titleState;
                    gp.ui.commandNum = 0;
                }
            }
        }

        else if(gp.gameState == gp.mazeState2){
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum = 3;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>3){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.ui.gameRunning2 = false;
                }
                if(gp.ui.gameRunning2 == false) {

                    gp.gameState = gp.playState;
                    gp.obj[10] = null;
                    gp.playSE(3);
                }
                if(gp.ui.commandNum == 1){
                    gp.ui.gameRunning2 = false;
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){
                    gp.ui.gameRunning2 = false;
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 3){
                    gp.ui.gameRunning2 = false;
                    gp.gameState = gp.playState;
                }
            }
        }

        else if(gp.gameState == gp.mazeState1){
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum = 3;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>3){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.ui.gameRunning1 = false;
                }
                if(gp.ui.gameRunning1 == false) {

                    gp.gameState = gp.playState;
                    gp.obj[9] = null;
                    gp.playSE(3);
                }
                if(gp.ui.commandNum == 1){
                    gp.ui.gameRunning1 = false;
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){
                    gp.ui.gameRunning1 = false;
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 3){
                    gp.ui.gameRunning1 = false;
                    gp.gameState = gp.playState;
                }
            }
        }

        else if(gp.gameState == gp.mazeState3){
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum = 3;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>3){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.ui.gameRunning3 = false;
                }
                if(gp.ui.gameRunning3 == false) {

                    gp.gameState = gp.playState;
                    gp.obj[11] = null;
                    gp.playSE(3);
                    //gp.playMusic(0);
                }
                if(gp.ui.commandNum == 1){
                    gp.ui.gameRunning3 = false;
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){
                    gp.ui.gameRunning3 = false;
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 3){
                    gp.ui.gameRunning3 = false;
                    gp.gameState = gp.playState;
                }
            }
        }
        else if(gp.gameState == gp.mazeState4){
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum = 3;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>3){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.ui.gameRunning4 = false;
                }
                if(gp.ui.gameRunning4 == false) {

                    gp.gameState = gp.playState;
                    gp.obj[12] = null;
                    gp.playSE(3);
                }
                if(gp.ui.commandNum == 1){
                    gp.ui.gameRunning4 = false;
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){
                    gp.ui.gameRunning4 = false;
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 3){
                    gp.ui.gameRunning4 = false;
                    gp.gameState = gp.playState;
                }
            }
        }



        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }

    }
}
