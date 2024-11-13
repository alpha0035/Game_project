package middleware;

import static entity.player.PlayerConstants.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.player.Player;
import main.GamePanel;

import entity.player.PlayerConstants;

public class PlayerController implements KeyListener{

    private Player player;

    public PlayerController(Player p, GamePanel g)
    {
        player = p;        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // System.out.println(e.getKeyChar() + "---" + player.direction + "---" + A);
        // System.out.println("CALL " + e.getKeyChar());
        if(player.currentAni != HIT)
        {
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                player.W = true;
                if(!player.inAir)
                {
                    player.currentAni = JUMP;
                    player.inAir = true;
                    player.jumpSpeed = -4.3f;
                    player.aniCount = 0;
                    player.aniIndex = 0;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                if(!player.D)
                {
                    player.D = true;
                    player.direction = 0;
                    if(player.currentAni != RUN && !player.inAir) 
                    {
                        player.currentAni = RUN;
                        player.aniCount = 0;
                        player.aniIndex = 0;
                    }
                }
            }else if(e.getKeyCode() == KeyEvent.VK_A)
            {
                if(!player.A)
                {
                    player.A = true;
                    player.direction = 1;
                    if(player.currentAni != RUN && !player.inAir) 
                    {
                        player.currentAni = RUN;
                        player.aniCount = 0;
                        player.aniIndex = 0;
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            new Thread(()->{
                try{
                    Thread.sleep(150);
                    player.W = false;
                }
                catch(Exception ex)
                {
                    System.out.println("ERR");
                }
            }).start();
            player.W = false;
        }
        if(!player.inAir)
        {
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                player.D = false;
                if(player.currentAni != PlayerConstants.HIT)
                {
                    if(player.A){player.direction = 1;}
                    else{
                        player.aniCount = 0;
                        player.aniIndex = 0;
                        player.currentAni = IDLE;
                    }
                }
            }else if(e.getKeyCode() == KeyEvent.VK_A)
            {
                player.A = false;
                if(player.currentAni != PlayerConstants.HIT)
                {
                    if(player.D){player.direction = 0;}
                    else{
                        player.aniCount = 0;
                        player.aniIndex = 0;
                        player.currentAni = IDLE;
                    }
                }
            }
        }else
        {            
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                player.D = false;
            }else if(e.getKeyCode() == KeyEvent.VK_A)
            {
                player.A = false;
            }
        }
    }
}
