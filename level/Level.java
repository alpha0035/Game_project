package level;

import java.awt.Graphics;
import java.util.ArrayList;

import entity.enemy.Enemy;
import items.SpecificFruit;
import middleware.Background;
import terrain.SpecificTerrain;
import terrain.Terrain;

public class Level {
    public int panelWidth, panelHeight;
    public int playerXPos, playerYPos;
    public ArrayList<SpecificTerrain> terrainList;
    public ArrayList<SpecificTerrain> [][] terrainData;
    public ArrayList<SpecificFruit> fruitList;
    public ArrayList<Enemy> enemyList;

    public Background background;
    public Terrain terrain = new Terrain();

    public Level(int w, int h)
    {
        panelHeight = h;
        panelWidth = w;
        background = new Background(Background.BROWN_BACKGROUND, panelWidth, panelHeight);
    }

    public void draw(Graphics g)
    {
        background.drawBackground(g);
        terrain.drawTerrain(g, terrainList);
        drawEnemy(g);
    }

    private void drawEnemy(Graphics g)
    {
        for(Enemy i : enemyList)
        {
            i.drawEnemy(g);
        }
    }
}
