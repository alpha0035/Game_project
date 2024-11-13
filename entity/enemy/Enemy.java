package entity.enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

public abstract class Enemy {
    public float x, y, fx, fy, removeVX = 1, removeVY = -2, removeG = 0.08f; //fx, fy vị trí ban đầu 
    public int w, h, range;
    public BufferedImage[][] animations;
    public int aniCount, aniIndex, currentAni, direction, aniSpeed;
    public float enemySpeed;
    public boolean removed = false;
    public ArrayList<Enemy> enemyList;

    public Enemy(float x, float y, int range, int w, int h)
    {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        fx = x;
        fy = y;
        this.range = range;
    }

    public abstract void drawEnemy(Graphics g);
    public abstract void remove(ArrayList<Enemy> enemyList);
}
