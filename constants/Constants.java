package constants;

public class Constants {

    public static final int FPS = 120;
    public static final double TIME_PER_FRAME = 1000000000.0/FPS;

    public static float GRAVITY = 1.0f;

    public static final float SCALE = 1.5f;
    public static final int TILE_DEFAULT_SIZE = 46, TILES_IN_WIDTH = 20, TILES_IN_HEIGHT = 10;
    public static final int TILE_SIZE = (int)(TILE_DEFAULT_SIZE*SCALE);
    public static final int GAME_WINDOW_WIDTH = TILES_IN_WIDTH*TILE_SIZE, GAME_WINDOW_HEIGHT = TILES_IN_HEIGHT*TILE_SIZE;

    public static final int NINJA_FROG = 0;
    public static final int PINK_MAN = 1;
    public static final int MASK_DUDE = 2;

}
