package entity.enemy;

import static constants.Constants.FPS;
import static constants.Constants.SCALE;

import java.awt.Graphics;
import java.util.ArrayList;

import middleware.LoadAnimation;

public class AngryPig extends Enemy{
    
    public static final int IDLE = 0, HIT_1 = 1, HIT_2 = 2, WALK = 3, RUN = 4;
    public static final int WIDTH = (int)(36*SCALE), HEIGHT = (int)(30*SCALE);
    public static final String[] ANI_URL = 
    {
        "/image/Enemies/AngryPig/Idle (36x30).png",
        "/image/Enemies/AngryPig/Hit 1 (36x30).png",
        "/image/Enemies/AngryPig/Hit 2 (36x30).png",
        "/image/Enemies/AngryPig/walk (36x30).png",
        "/image/Enemies/AngryPig/Run (36x30).png"
    };
    public static final int[] ANI_COUNT = {9, 5, 5, 16, 12};
    public static final int[][] ANI_DEFAULT_SIZE = 
    {
        {36, 30}, {36, 30}, {36, 30}, {36, 30}, {36, 30}
    };

    public AngryPig(float x, float y, int range) {
        super(x, y, range, WIDTH, HEIGHT);
        animations = LoadAnimation.loadAllAnimations(ANI_URL, ANI_COUNT, ANI_DEFAULT_SIZE);
        currentAni = WALK;
        aniCount = 0;
        aniIndex = 0;
        direction = 0;
        aniSpeed = 4;
        enemySpeed = 0.5f;
    }

    @Override
    public void drawEnemy(Graphics g) {
        updatePos();
        g.drawImage(animations[currentAni][aniIndex], (int)(x) + w*direction, (int)y, (int)(w*Math.pow(-1, direction)), h, null);
        aniCount++;
        if(aniCount > aniSpeed)
        {
            aniIndex++;
            if(aniIndex >= ANI_COUNT[currentAni]) aniIndex = 0;
            aniCount = 0;
        }
    }

    private void updatePos() {
        if(currentAni == WALK)
        {
            if(x - fx > range/2)
            {
                direction = 0;
            }else if(x - fx < - range/2){
                direction = 1;
            }
            if(direction == 1) x += enemySpeed;
            else x-= enemySpeed;
        }else if(currentAni == HIT_1)
        {
            x+=removeVX;
            y+=removeVY;
            removeVY += removeG;
        }
    }

    @Override
    public void remove(ArrayList<Enemy> enemyList) {
        aniSpeed = 14;
        removed = true;
        currentAni = HIT_1;
        aniCount = 0;
        aniIndex = 0;
        new Thread(()->{
            try {
                // Thread.sleep(1000/FPS*aniSpeed*ANI_COUNT[HIT_1]);
                Thread.sleep((long)Math.sqrt(((2*removeG*1000 + removeVY*removeVY)/removeG))*1000);
                enemyList.remove(this);
            } catch (Exception e) {
                System.out.println("ERR");
            }
        }).start();;
    }


}
