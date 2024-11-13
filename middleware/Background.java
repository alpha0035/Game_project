package middleware;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

import static constants.Constants.*;

public class Background{

//------------------------------------BACKGROUND-----------------------------------------//
public static final String BLUE_BACKGROUND = "/image/Background/Blue.png";
public static final String BROWN_BACKGROUND = "/image/Background/Brown.png";
public static final String GRAY_BACKGROUND = "/image/Background/Gray.png";
public static final String GREEN_BACKGROUND = "/image/Background/Green.png";
public static final String PINK_BACKGROUND = "/image/Background/Pink.png";
public static final String PURPLE_BACKGROUND = "/image/Background/Purple.png";
public static final String YELLOW_BACKGROUND = "/image/Background/Yellow.png";
//------------------------------------BACKGROUND-----------------------------------------//

    private BufferedImage background, vSubBackground, hSubBackground;
    private int panelWidth, panelHeight;
    private int tilesInHeight, tilesInWidth;

    public Background(String backgroundColor, int w, int h)
    {
        background = LoadAnimation.loadImage(backgroundColor);
        panelHeight = h;
        panelWidth = w;
        tilesInWidth = (int)(panelWidth/TILE_SIZE);
        tilesInHeight = (int)(panelHeight/TILE_SIZE);
        vSubBackground = background.getSubimage(0, 0, (int)((1.0*panelWidth/TILE_SIZE - tilesInWidth)*background.getWidth()), background.getHeight());
        hSubBackground = background.getSubimage(0, 0, background.getWidth(), (int)((1.0*panelHeight/TILE_SIZE - tilesInHeight)*background.getHeight()));
    }

    public void drawBackground(Graphics g)
    {

        for(int i = 0; i < tilesInHeight; i++)
        {
            for(int j = 0; j < tilesInWidth; j++)
            {
                g.drawImage(background, j*TILE_SIZE, i*TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
            }
        }

        for(int i = 0; i <= tilesInHeight; i++)
        {
            g.drawImage(vSubBackground, tilesInWidth*TILE_SIZE, i*TILE_SIZE,panelWidth - tilesInWidth*TILE_SIZE, TILE_SIZE, null);
        }
        for(int i = 0; i < tilesInWidth; i++)
        {
            g.drawImage(hSubBackground, i*TILE_SIZE, tilesInHeight*TILE_SIZE, TILE_SIZE, panelHeight - tilesInHeight*TILE_SIZE, null);
        }
    }

}
