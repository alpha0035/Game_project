package main;

import javax.swing.JFrame;

import static constants.Constants.*;

public class GameWindow extends JFrame{

    private GamePanel gamePanel;


    private void gameLoop()
    {
        Thread thread = new Thread(()->{
            @SuppressWarnings("unused")
            short frameRate = 0;
            long lastTimeRepaintCheck = System.nanoTime(), lastTimeFrameRateCheck = System.nanoTime(), currentTime;
            double deltaTimePerFrame = 0;
            while (true) 
            {
                currentTime = System.nanoTime();
                deltaTimePerFrame += (currentTime - lastTimeRepaintCheck)/TIME_PER_FRAME;
                lastTimeRepaintCheck = currentTime;
                if(deltaTimePerFrame >= 1)
                {
                    gamePanel.repaint();
                    deltaTimePerFrame -= 1;
                    frameRate++;
                }
                if(currentTime - lastTimeFrameRateCheck >= 1000000000.0)
                {
                    lastTimeFrameRateCheck = currentTime;
                    // System.out.println(frameRate);
                    frameRate = 0;
                }
            }
        });
        thread.start();
    }

    public GameWindow(String title)
    {
        super(title);
        gamePanel = new GamePanel(NINJA_FROG);

        this.add(gamePanel);
        this.setSize(GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        gameLoop();
    }

}
