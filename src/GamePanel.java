import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //screen settings
    final  int orignalTileSize = 16;
    final int scale = 3;
     public final int tileSize = orignalTileSize*scale;  //48*48
     public final int maxScreenCol =  16 ;
     public final int maxScreenRow = 12;
     public final int screenWidth = tileSize*maxScreenCol;  //768
     public final int screeHeight = tileSize*maxScreenRow;  //576

    public  final int maxWorldCol = 40;
    public  final int maxWorldRow = 40;
    public  final int worldWidth = tileSize * maxScreenCol;
    public  final int worldHeight = tileSize * maxScreenRow;

    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler KeyH =  new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter =  new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    public Player player  = new Player(this,KeyH);
    public SuperObject obj[] = new SuperObject[15];

    //GameState
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int titleState = 0;
    public final int mazeState1 = 3;
    public final int mazeState2 = 4;
    public final int mazeState3 = 5;
    public final int mazeState4 = 6;
    public final int mapSelectState = 7;
    
    public int currentMap = 1;
    public final int maxMap = 2;

    public GamecClient socketClient;





    public GamePanel(){
         this.setPreferredSize(new Dimension(screenWidth, screeHeight));
         this.setBackground(Color.black);
         this.setDoubleBuffered(true);
         this.addKeyListener(KeyH);
         this.setFocusable(true);
     }

     public void setupGame(){
         aSetter.setObject();
         gameState = titleState;
         playMusic(0);
     }
//    public void initializeConnection() {
//         if(JOptionPane.showConfirmDialog(this,"Do you want to run the server")==0){
//            socketServer = new GameServer(this);
//            socketServer.start();
//        }

//        socketClient = new GamecClient(this,"localhost");
//        socketClient.start();
//        socketClient.sendData("ping".getBytes());

  //  }


    public void setGameThread() {
        gameThread =  new Thread(this);
        gameThread.start();
       // initializeConnection();

    }

    public void run (){

         double drawInterval = 1000000000/FPS;
         double delta = 0;
         long lastTime = System.nanoTime();
         long currentTime;

         while (gameThread != null){
             currentTime = System.nanoTime();
             delta += (currentTime - lastTime)/ drawInterval;
             lastTime = currentTime;
             if(delta >= 1){
                 update();
                 repaint();
                 delta--;
             }
         }
    }
         public void update(){

        if (gameState == playState){
            player.update();
        }
        if(gameState == pauseState){
            //nothing
        }

    }


        public void paintComponent(Graphics g){
         super.paintComponent(g);

         Graphics2D g2 = (Graphics2D)g;

         if(gameState == titleState){
                 ui.draw(g2);
         }
         else {
             tileM.draw(g2);
             for (int i = 0; i < obj.length; i++){
                 if(obj[i]!=null){
                     obj[i].draw(g2, this);
                 }
             }
             player.draw(g2);
             ui.draw(g2);
         }




         g2.dispose();
        }
        public void playMusic(int i){
        try{
            music.setFile(i);
            music.play();
            music.loop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        public void stopMusic(){
        music.stop();
        }
        public void playSE(int i ){
        try{
            se.setFile(i);
            se.play();
        }catch (Exception e ){
            e.printStackTrace();
        }
        }

    }

