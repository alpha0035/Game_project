package middleware;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadAnimation {

    public static BufferedImage loadImage(String url)
    {
        BufferedImage image = null;
        InputStream file = LoadAnimation.class.getResourceAsStream(url);
        try
        {
            image = ImageIO.read(file);
        }catch(Exception e)
        {
            System.out.println("ERR");
            System.out.println(e);
        }
        return image;
    }

    public static BufferedImage[][] loadAllAnimations(String[] animationURL, int[] imageAnimationCount, int[][] aniDefaultSize)
    {
        BufferedImage[][] animations = new BufferedImage[animationURL.length][];
        BufferedImage originalImage;
        for(int i = 0; i < animationURL.length; i++)
        {
            animations[i] = new BufferedImage[imageAnimationCount[i]];
            originalImage = loadImage(animationURL[i]);
            for(int j = 0; j < imageAnimationCount[i]; j++)
            {
                animations[i][j] = originalImage.getSubimage(j*aniDefaultSize[i][0], 0, aniDefaultSize[i][0], aniDefaultSize[i][1]);
            }
        }

        // animations[7] = new BufferedImage[7];
        // originalImage = loadImage(animationURL[7]);
        // animations[7][0] = originalImage.getSubimage(0, 0, 96, 96);
        // animations[7][1] = originalImage.getSubimage(102, 3, 89, 89);
        // animations[7][2] = originalImage.getSubimage(206, 12, 72, 72);
        // animations[7][3] = originalImage.getSubimage(316, 27, 42, 42);
        // animations[7][4] = originalImage.getSubimage(424, 39, 18, 18);
        // animations[7][5] = originalImage.getSubimage(516, 34, 28, 28);
        // animations[7][6] = originalImage.getSubimage(614, 34, 24, 28);

        // animations[8] = new BufferedImage[7];
        // originalImage = loadImage(animationURL[8]);

        // animations[8][0] = originalImage.getSubimage(38, 33, 21, 29);
        // animations[8][1] = originalImage.getSubimage(134, 33, 21, 29);
        // animations[8][2] = originalImage.getSubimage(232, 40, 16, 16);
        // animations[8][3] = originalImage.getSubimage(316, 28, 40, 40);
        // animations[8][4] = originalImage.getSubimage(398, 14, 69, 68);
        // animations[8][5] = originalImage.getSubimage(486, 5, 86, 86);
        // animations[8][6] = originalImage.getSubimage(576, 0, 96, 96);

        return animations;
    }
}
