package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.player.Player;
import items.Fruit;
import level.Level;
import level.Level_1;
import middleware.*;

import static constants.Constants.*;

public class GamePanel extends JPanel{

    public float xPos = 0, yPos = 0;
    public int width, height;
    public Player player;
    public Level levelData;
    public Fruit fruit;

    private int maxRightTranslate, maxBottomTranslate;

    public GamePanel(int playerName)
    {
        levelData = new Level_1();
        player = new Player(playerName, levelData);
        width = levelData.panelWidth;   height = levelData.panelHeight;
        maxRightTranslate = width - GAME_WINDOW_WIDTH;
        maxBottomTranslate = height - GAME_WINDOW_HEIGHT + 30;

        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus(); 

        fruit = new Fruit(levelData.fruitList);

        this.addKeyListener(new PlayerController(player, this));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        updatePos();            
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(xPos, yPos);
        levelData.draw(g);
        player.render(g);
        fruit.drawFruits(g);
    }

    public void updatePos()
    {
        if(player.direction == 0)
        {
            if(xPos > -maxRightTranslate)
            {
                if(player.xPos + xPos > GAME_WINDOW_WIDTH/2 - 30)
                {
                    xPos -= player.playerSpeed;
                }
            }
        }else if(player.direction == 1){
            if(xPos < 0)
            {
                if(player.xPos + xPos < GAME_WINDOW_WIDTH/2 - 30)
                {
                    xPos += player.playerSpeed;
                }
            }
        }

        if(player.inAir)
        {
            if(player.jumpSpeed >= 0)
            {
                if(yPos > -maxBottomTranslate)
                {
                    if(player.yPos + yPos > GAME_WINDOW_HEIGHT/2 )
                    {

                        yPos -= player.jumpSpeed;
                    }
                }
            }else{
                if(yPos < 0)
                {
                    if(player.yPos + yPos < GAME_WINDOW_HEIGHT/2)
                    {
                        yPos -= player.jumpSpeed;
                    }
                }
            }
        }
    }
}