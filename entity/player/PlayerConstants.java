package entity.player;

import static constants.Constants.SCALE;

public class PlayerConstants {

    
    public static final int DEFAULT_WIDTH = 32, DEFAULT_HEIGHT = 32;
    public static final int WIDTH = (int)(DEFAULT_WIDTH*SCALE), HEIGHT = (int)(DEFAULT_HEIGHT*SCALE);
    public static final int NINJA_FROG = 0, MASK_DUDE = 1, PINK_MAN = 2;
    public static final float JUMP_SPEED = -4.5f;

    public static final int IDLE = 0;
    public static final int JUMP = 1;
    public static final int DOUTBLE_JUMP = 2;
    public static final int RUN = 3;
    public static final int WALL_JUMP = 4;
    public static final int HIT = 5;
    public static final int FALL = 6;
    public static final int APPEARING = 7;
    public static final int DISAPPEARING = 8;
    public static final int[] ANI_COUNT = {11, 1, 6, 12, 5, 7, 1, 7, 7};
    public static final int[][] ANI_DEFAULT_SIZE = 
    {
        {32, 32}, {32, 32}, {32, 32}, {32, 32}, {32, 32}, {32, 32}, {32, 32}, {96, 96}, {96, 96}
    };

    public static final String[][] ANIMATION_URL = {
        {
            "/image/Main Characters/Ninja Frog/Idle (32x32).png",
            "/image/Main Characters/Ninja Frog/Jump (32x32).png",
            "/image/Main Characters/Ninja Frog/Double Jump (32x32).png",
            "/image/Main Characters/Ninja Frog/Run (32x32).png",
            "/image/Main Characters/Ninja Frog/Wall Jump (32x32).png",
            "/image/Main Characters/Ninja Frog/Hit (32x32).png",
            "/image/Main Characters/Ninja Frog/Fall (32x32).png",
            "/image/Main Characters/Appearing (96x96).png",
            "/image/Main Characters/Disappearing (96x96).png"
        },
        {   
            "/image/Main Characters/Mask Dude/Idle (32x32).png",
            "/image/Main Characters/Mask Dude/Jump (32x32).png",
            "/image/Main Characters/Mask Dude/Double Jump (32x32).png",
            "/image/Main Characters/Mask Dude/Run (32x32).png",
            "/image/Main Characters/Mask Dude/Wall Jump (32x32).png",
            "/image/Main Characters/Mask Dude/Hit (32x32).png",
            "/image/Main Characters/Mask Dude/Fall (32x32).png",
            "/image/Main Characters/Appearing (96x96).png",
            "/image/Main Characters/Disappearing (96x96).png"
        },
        {
            "/image/Main Characters/Pink Man/Idle (32x32).png",
            "/image/Main Characters/Pink Man/Jump (32x32).png",
            "/image/Main Characters/Pink Man/Double Jump (32x32).png",
            "/image/Main Characters/Pink Man/Run (32x32).png",
            "/image/Main Characters/Pink Man/Wall Jump (32x32).png",
            "/image/Main Characters/Pink Man/Hit (32x32).png",
            "/image/Main Characters/Pink Man/Fall (32x32).png",
            "/image/Main Characters/Appearing (96x96).png",
            "/image/Main Characters/Disappearing (96x96).png"
        }
    };
}
