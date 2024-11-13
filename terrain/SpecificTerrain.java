package terrain;

import static constants.Constants.SCALE;
import static terrain.Terrain.TERRAIN_IMAGE_DATA;

public class SpecificTerrain {
    public int terrain, x, y, width, height;
    public SpecificTerrain(int terrain, int x, int y)
    {
        this.terrain = terrain;
        this.x = x;
        this.y = y;
        this.width = (int)(TERRAIN_IMAGE_DATA[terrain][2]*SCALE);
        this.height = (int)(TERRAIN_IMAGE_DATA[terrain][3]*SCALE);
    }
}
