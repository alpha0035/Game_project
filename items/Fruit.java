package items;

import java.util.ArrayList;

import middleware.LoadAnimation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Fruit {
    public static final int APPLE = 0;
    public static final int BANANA = 1;
    public static final int CHERRY = 2;
    public static final int KIWI = 3;
    public static final int MELON = 4;
    public static final int ORANGE = 5;
    public static final int PINEAPPLE = 6;
    public static final int STRAWBRRY = 7;
    public static final int COLLECTED = 8;
    public static final int[] ANI_COUNT = {17, 17, 17, 17, 17, 17, 17, 17, 6};
    public static final String[] IMG_URL = 
    {
        "/image/items/Fruits/Apple.png",
        "/image/items/Fruits/Bananas.png",
        "/image/items/Fruits/Cherries.png",
        "/image/items/Fruits/Kiwi.png",
        "/image/items/Fruits/Melon.png",
        "/image/items/Fruits/Orange.png",
        "/image/items/Fruits/Pineapple.png",
        "/image/items/Fruits/Strawberry.png",
        "/image/items/Fruits/Collected.png"
    };
    public static final int[][] FRUIT_DEFAULT_SIZE = {
        {32, 32},  {32, 32},  {32, 32},  {32, 32},  {32, 32},  {32, 32},  {32, 32},  {32, 32},  {32, 32}
    };
    public BufferedImage[][] fruitAnimation;
    public ArrayList<SpecificFruit> fruitList;
    private int aniIndex = 0, aniCount = 0, aniSpeed = 6;
    public Fruit(ArrayList<SpecificFruit> fruitList)
    {
        this.fruitList = fruitList;
        fruitAnimation = LoadAnimation.loadAllAnimations(IMG_URL, ANI_COUNT, FRUIT_DEFAULT_SIZE);
    }

    public void drawFruits(Graphics g)
    {            
        for(SpecificFruit i : fruitList)
        {
            g.drawImage(fruitAnimation[i.fruit][aniIndex], i.x, i.y, i.w, i.h, null);
        }
        aniCount++;
        if(aniCount > aniSpeed)
        {
            aniCount = 0;
            aniIndex++;
            if(aniIndex >= 17) aniIndex = 0;

        }
    }
}
