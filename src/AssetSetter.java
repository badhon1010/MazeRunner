public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
     public void setObject(){
        // Clear all objects before loading new ones
        for(int i = 0; i < gp.obj.length; i++){
            gp.obj[i] = null;
        }

        if(gp.currentMap == 1) {
            gp.obj[0] = new OBJ_Key();
            gp.obj[0].worldX = 35* gp.tileSize;
            gp.obj[0].worldY = 3* gp.tileSize;

            gp.obj[1] = new OBJ_Key();
            gp.obj[1].worldX = 2*gp.tileSize;
            gp.obj[1].worldY = 2* gp.tileSize;

            gp.obj[2] = new OBJ_Key();
            gp.obj[2].worldX = 2*gp.tileSize;
            gp.obj[2].worldY = 35 * gp.tileSize;

            gp.obj[7] = new OBJ_Key();
            gp.obj[7].worldX = 36*gp.tileSize;
            gp.obj[7].worldY = 35* gp.tileSize;

            gp.obj[3] = new OBJ_Door();
            gp.obj[3].worldX = 19*gp.tileSize;
            gp.obj[3].worldY = 5* gp.tileSize;

            gp.obj[4] = new OBJ_Door();
            gp.obj[4].worldX = 19*gp.tileSize;
            gp.obj[4].worldY = 8 * gp.tileSize;

            gp.obj[5] = new OBJ_Door();
            gp.obj[5].worldX = 19*gp.tileSize;
            gp.obj[5].worldY = 11 * gp.tileSize;

            gp.obj[8] = new OBJ_Door();
            gp.obj[8].worldX = 19*gp.tileSize;
            gp.obj[8].worldY = 14 * gp.tileSize;

            gp.obj[6] = new OBJ_Chest();
            gp.obj[6].worldX = 19*gp.tileSize;
            gp.obj[6].worldY = 1 * gp.tileSize;

            gp.obj[9] = new OBJ_Door1();
            gp.obj[9].worldX = 33*gp.tileSize;
            gp.obj[9].worldY = 36 * gp.tileSize;

            gp.obj[10] = new OBJ_Door2();
            gp.obj[10].worldX = 6*gp.tileSize;
            gp.obj[10].worldY = 36* gp.tileSize;

            gp.obj[11] = new OBJ_Door3();
            gp.obj[11].worldX = 6*gp.tileSize;
            gp.obj[11].worldY = 4 * gp.tileSize;

            gp.obj[12] = new OBJ_Door4();
            gp.obj[12].worldX = 33*gp.tileSize;
            gp.obj[12].worldY = 4 * gp.tileSize;
        }
        else if (gp.currentMap == 2) {
            // Keys hidden in the maze
            gp.obj[0] = new OBJ_Key();
            gp.obj[0].worldX = 5 * gp.tileSize;
            gp.obj[0].worldY = 27 * gp.tileSize;

            gp.obj[1] = new OBJ_Key();
            gp.obj[1].worldX = 35 * gp.tileSize;
            gp.obj[1].worldY = 27 * gp.tileSize;

            // Doors blocking the castle bridge
            gp.obj[2] = new OBJ_Door();
            gp.obj[2].worldX = 19 * gp.tileSize;
            gp.obj[2].worldY = 24 * gp.tileSize;

            gp.obj[3] = new OBJ_Door();
            gp.obj[3].worldX = 20 * gp.tileSize;
            gp.obj[3].worldY = 24 * gp.tileSize;

            // Final chest inside the castle
            gp.obj[6] = new OBJ_Chest();
            gp.obj[6].worldX = 19 * gp.tileSize;
            gp.obj[6].worldY = 15 * gp.tileSize;
        }
    }
}
