package entity;

import java.awt.image.BufferedImage;

import level.Level;

public class Entity {

    public float xPos, yPos, playerSpeed = 1.6f;
    public int width, height, aniSpeed = 6;
    public int aniIndex = 0, aniCount = 0, direction = 0;
    public BufferedImage[][] animations;
    public int[] aniImgNum;
    public Level levelData;

    public Entity(float xPos, float yPos, int width, int height)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }
}
