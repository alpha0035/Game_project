package entity.player;

import static entity.player.PlayerConstants.*;

import java.awt.Graphics;

import entity.Entity;
import entity.enemy.Enemy;
import level.Level;
import middleware.LoadAnimation;

import terrain.SpecificTerrain;

public class Player extends Entity {

    public int currentAni = APPEARING, enemyDirection = -1;
    public float top, bottom, left, right;
    public float jumpSpeed = 0f, g = 0.08f;
    public boolean inAir = false, A = false, D = false, W = false, downHit = false;

    public  Player(int player, Level levelData)
    {
        super(levelData.playerXPos, levelData.playerYPos, WIDTH, HEIGHT);
        this.levelData = levelData;
        aniImgNum = ANI_COUNT;
        animations = LoadAnimation.loadAllAnimations(ANIMATION_URL[player], ANI_COUNT, ANI_DEFAULT_SIZE);

        top = yPos + 5;
        bottom = top + height - 5;
        left = xPos - 15;            
        right = left + width - 15;
    }

    public void render(Graphics g)
    {
        update();
        g.drawImage(animations[currentAni][aniIndex], (int)(xPos - (25 - 5*direction) + width*direction), 
                    (int)yPos, (int)(width*Math.pow(-1, direction)), height, null);
        aniCount++;
        if(aniCount >= aniSpeed)
        {
            aniIndex++;
            if(aniIndex >= aniImgNum[currentAni])
            {
                aniIndex = 0;
                if(currentAni == APPEARING)
                {
                    currentAni = FALL;
                    inAir = true;
                }else if(currentAni == HIT)
                {
                    if(!downHit)
                    {
                        currentAni = IDLE;
                        aniSpeed = 6;
                    }
                }
            }
            aniCount = 0;
        }
    }

    public void update()
    {
        collisionEnemy();
        if(currentAni == HIT)
        {
            aniSpeed = 10;
            if(direction == 0)
            {
                if(canMove())
                {
                    xPos += playerSpeed;
                    right += playerSpeed;
                    left += playerSpeed;
                }
            }else if(direction == 1)
            {
                if(canMove())
                {
                    xPos -= playerSpeed;
                    right -= playerSpeed;
                    left -= playerSpeed;
                }
            }
        }
        if(canFall() && !inAir && currentAni != APPEARING)
        {
            jumpSpeed = 0;
            currentAni = FALL;
            aniIndex = 0;
            aniCount = 0;
            inAir = true;
        }
        if(W && !inAir && currentAni != HIT)
        {
            jumpSpeed = JUMP_SPEED;
            currentAni = JUMP;
            aniIndex = 0;
            aniCount = 0;
            inAir = true;
        }
        if(inAir)
        {
            if(canJumpFall())
            {
                yPos += jumpSpeed;
                top += jumpSpeed;
                bottom += jumpSpeed;
            }
            if(jumpSpeed >= 0)
            {
                if(inAir) currentAni = FALL;
            }
            jumpSpeed += g;
        }
        
            if((A || D) && currentAni != HIT)
            {
                if(!inAir) currentAni = RUN;
                if(A && !D) direction = 1;
                if(!A && D) direction = 0;
            }
        

        if(direction == 0 && D && currentAni != HIT)
        {
            if(canMove())
            {
                xPos += playerSpeed;
                left += playerSpeed;
                right += playerSpeed;
            }
        }
        else if(direction == 1 && A && currentAni != HIT)
        {
            if(canMove())
            {
                xPos -= playerSpeed;
                left -= playerSpeed;
                right -= playerSpeed;
            }
        }
    }

    private boolean canMove()
    {
        if(direction == 0)
        {
            int x = (int)(right/100), y1 = (int)(top/100), y2 = (int)(bottom/100);
            for(SpecificTerrain i : levelData.terrainData[y1][x])
            {
                if(i.x < left) continue;

                if(!(top >= i.y + i.height || bottom - 5 <= i.y))
                {
                    if((int)(right) + 3 > i.x)
                    {                 
                        return false;
                    }
                }
            }
            for(SpecificTerrain i : levelData.terrainData[y2][x])
            {
                if(i.x < left) continue;
                if(!(top > i.y + i.height || bottom - 5 <= i.y))
                {

                    if((int)(right) + 3 > i.x)
                    {
                        return false;
                    }
                }
            }
        }
        if(direction == 1)
        {
            int x = (int)(left/100), y1 = (int)(top/100), y2 = (int)(bottom/100);
            for(SpecificTerrain i : levelData.terrainData[y1][x])
            {
                if(i.x + i.width > left) continue;
                if(!(top > i.y + i.height || bottom - 5 <= i.y))
                {

                    if(left - 5 <= i.x + i.width)
                    {
                        // System.out.println(3);
                        return false;
                    }
                }
            }
            for(SpecificTerrain i : levelData.terrainData[y2][x])
            {
                if(i.x + i.width > left) continue;
                if(!(top > i.y + i.height || bottom - 5 <= i.y))
                {
                    if(left - 5 <= i.x + i.width)
                    {
                        // System.out.println(3);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean canJumpFall()
    {
        if(inAir)
        {
            if(jumpSpeed < 0)
            {
                int x1 = (int)(left/100), x2 = (int)(right/100), y = (int)(top/100);
                for(SpecificTerrain i : levelData.terrainData[y][x1])
                {
                    if(bottom - 4 <= i.y) continue;
                    if(!(left >= i.x + i.width || right - 3<= i.x))
                    {
                        if(top - 5 <= i.y + i.height)
                        {
                            currentAni = FALL;
                            jumpSpeed = 0;
                            return false;
                        }
                    }
                }
                for(SpecificTerrain i : levelData.terrainData[y][x2])
                {
                    if(bottom - 4 <= i.y) continue;
                    if(!(left >= i.x + i.width || right - 5<= i.x))
                    {
                        if(top - 5 <= i.y + i.height)
                        {
                            // System.out.println("top-" + top + " right-" + right + " bottom-" + bottom + " left-" + left);
                            // System.out.println("x-" + i.x + " y-" + i.y);
                            currentAni = FALL;
                            jumpSpeed = 0;
                            return false;
                        }
                    }
                }
            }else{

                int x1 = (int)(left/100), x2 = (int)(right/100), y = (int)(bottom/100);
                for(SpecificTerrain i : levelData.terrainData[y][x1])
                {
                    if(i.y + i.height <= top) continue;
                    if(!(left >= i.x + i.width || right - 5 <= i.x))
                    {

                        if(bottom + jumpSpeed >= i.y) 
                        {

                            inAir = false;
                            currentAni = IDLE;
                            return false;
                        }
                    }
                }
                for(SpecificTerrain i : levelData.terrainData[y][x2])
                {

                    if(i.y + i.height <= top) continue;
                    if(!(left >= i.x + i.width || right - 5 <= i.x))
                    {
                        // System.out.println("x - " + i.x + " r - " + right );
                        if(bottom + jumpSpeed >= i.y) 
                        {
                            inAir = false;
                            currentAni = IDLE;
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean canFall()
    {
        int x1 = (int)(left/100), x2 = (int)(right/100), y = (int)(bottom/100);
        for(SpecificTerrain i : levelData.terrainData[y][x1])
        {
            if(i.y + i.height <= top) continue;
            if(!(left >= i.x + i.width || right - 5 <= i.x))
            {
                if(bottom + jumpSpeed >= i.y) 
                {
                    inAir = false;
                    if(currentAni != HIT)   currentAni = IDLE; 
                    return false;
                }
            }
        }
        for(SpecificTerrain i : levelData.terrainData[y][x2])
        {
            if(i.y + i.height <= top) continue;
            if(!(left >= i.x + i.width || right - 5 <= i.x))
            {
                if(bottom + jumpSpeed >= i.y) 
                {   
                    inAir = false;
                    if(currentAni != HIT)   currentAni = IDLE; 
                    return false;
                }
            }
        }
        return true;
    }

    private void collisionEnemy()
    {
        for(int i = 0; i < levelData.enemyList.size(); i++)
        {
            Enemy e = levelData.enemyList.get(i);
            if(e.removed) continue;
            if(currentAni == RUN || currentAni == IDLE)
            {
                if(!(top > e.y + e.h || bottom < e.y))
                {
                    if(right > e.x && right < e.x + e.w)
                    {
                        currentAni = HIT;
                        aniCount = 0;
                        aniIndex = 0;
                        direction = 1;
                    }else if(left > e.x && left < e.x + e.w)
                    {
                        currentAni = HIT;
                        aniCount = 0;
                        aniIndex = 0;
                        direction = 0;
                    }
                }
            }
            // {
            //     if(direction == 0)
            //     {
            //         if(!(top > e.y + e.h || bottom < e.y))
            //         {
            //             if(right - 4 > e.x && left < e.x + e.w)
            //             {
            //                 if(true)
            //                 {
            //                     currentAni = HIT;
            //                     aniCount = 0;
            //                     aniIndex = 0;
            //                     direction = 1 - direction;
            //                 }
            //             }
            //         }
            //     }else if(direction == 1)
            //     {
            //         if(!(top > e.y + e.h || bottom < e.y))
            //         {
            //             if(right > e.x && left + 2 < e.x + e.w)
            //             {
            //                 if(true)
            //                 {
            //                     currentAni = HIT;
            //                     aniCount = 0;
            //                     aniIndex = 0;
            //                     direction = 1 - direction;
            //                 }
            //             }
            //         }
            //     }
                // return -1;
            else if(currentAni == FALL || currentAni == JUMP)
            {
                if(!(left >= e.x + e.w || right <= e.x))
                {
                    if(top < e.y + e.h && top > e.y)
                    {
                        if(currentAni != FALL)
                        {
                            aniIndex = 0;
                            jumpSpeed = 0;
                            currentAni = FALL;
                            aniCount = 0;
                            jumpSpeed = 0;
                        }
                    }else if(bottom > e.y && bottom < e.y + e.h)
                    {
                        aniIndex = 0;
                        jumpSpeed = JUMP_SPEED + 2;
                        currentAni = JUMP;
                        aniCount = 0;
                        e.remove(levelData.enemyList);
                    }
                }
            }
            
        }
    }
}
