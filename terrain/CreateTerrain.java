package terrain;

import static terrain.Terrain.*;


import java.util.ArrayList;

public class CreateTerrain {
    public static void createRect(ArrayList<SpecificTerrain> terrainList, int terrain, int x, int y, int w, int h)
    {
        int[][] subTerrain = getSubTerrain(terrain);
        if(w < 1 || h < 1) return;
        for(int i = 1; i < h - 1; i++)
        {
            terrainList.add(new SpecificTerrain(subTerrain[1][0], x, y - 24*(i+1)));
        }
        for(int i = 1; i < w - 1; i++)
        {   
            for(int j = 1; j < h - 1; j++)
            {
                terrainList.add(new SpecificTerrain(subTerrain[1][1], x + i*24, y - 24*(j + 1)));
            }
        }
        for(int i = 1; i < h - 1; i++)
        {
            terrainList.add(new SpecificTerrain(subTerrain[1][2], x + (w-1)*24, y - 24*(i+1)));
        }
        for(int i = 1; i < w - 1; i++)
        {
            terrainList.add(new SpecificTerrain(subTerrain[0][1], x + i*24, y - 24*h));
        }
        for(int i = 1; i < w-1; i++)
        {
            terrainList.add(new SpecificTerrain(subTerrain[2][1], x + i*24, y - 24));
        }

        terrainList.add(new SpecificTerrain(subTerrain[2][0], x, y - 24));
        terrainList.add(new SpecificTerrain(subTerrain[2][2], x + (w-1)*24, y - 24));
        terrainList.add(new SpecificTerrain(subTerrain[0][0], x, y - 24*h));
        terrainList.add(new SpecificTerrain(subTerrain[0][2], x + (w - 1)*24, y - 24*h));
    }

    public static int[][] getSubTerrain(int terrain)
    {
        if(terrain == SUB_SOIL_1)
        {
            return SUB_SOIL_1_DATA;
        }else return null;
    }
}
