import java.awt.*;


public class EventHandler {
    GamePanel gp;
    Rectangle evenReact;
    int evenReactDefaultX, evenReactDefaultY;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        evenReact = new Rectangle();
        evenReact.x = 34;
        evenReact.y = 36;
        evenReact.width = 4;
        evenReact.height = 4;
        evenReactDefaultX = evenReact.x;
        evenReactDefaultY = evenReact.y;
    }

    public void checkEvent() {

        // if (hit(34, 36, "any") == true) {
        //     teleport(gp.gameState);
        // }

    }

    public boolean hit(int eventCol, int eventRow, String reqDirection) {
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        evenReact.x = eventCol * gp.tileSize + evenReact.x;
        evenReact.y = eventRow * gp.tileSize + evenReact.y;

        if (gp.player.solidArea.intersects(evenReact)) {
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;
            }

        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        evenReact.x = evenReactDefaultX;
        evenReact.y = evenReactDefaultY;
        return hit;
    }

    public void teleport(int gameState) {
        gp.gameState = gameState;
        gp.player.worldX = gp.tileSize * 34;
        gp.player.worldY = gp.tileSize * 4;
    }

//    public void drawString(Graphics2D g2) {
//        g2.setColor(new Color(9, 9, 9, 128));
//        g2.fillRect(0, 0, gp.screenWidth, gp.screeHeight);
//
//        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
//        String text1 = "Teleport";
//        int x = gp.tileSize*2;
//        int y = gp.tileSize * 2;
//        g2.setColor(Color.white);
//        g2.drawString(text1, x, y);
//    }
}
