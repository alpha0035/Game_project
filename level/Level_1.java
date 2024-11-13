package level;

import static terrain.Terrain.*;

import java.util.ArrayList;

import entity.enemy.AngryPig;
import entity.enemy.Enemy;
import items.Fruit;
import items.SpecificFruit;
import terrain.CreateTerrain;
import terrain.SpecificTerrain;

public class Level_1 extends Level {

    public Level_1()
    {
        super(1934, 912);
        playerXPos = 102; playerYPos = 500;
        // Tiles in width = 26(72x72) -> 78(24x24), tiles in height = 12(72x72) -> 36(24x24);

        terrainList = new ArrayList<SpecificTerrain>();
        fruitList = new ArrayList<SpecificFruit>();
        enemyList = new ArrayList<Enemy>();
        //---------------------------------------------------Game Panel Border-----------------------------------------------------
        for(int i = 0; i < 26; i++)
        {
            terrainList.add(new SpecificTerrain(SMALL_H_BROWN, i*72 + 24, 0));
            terrainList.add(new SpecificTerrain(SMALL_H_BROWN, i*72 + 24, panelHeight - 24));
        }
        for(int i = 0; i < 12; i++)
        {
            terrainList.add(new SpecificTerrain(SMALL_V_BROWN, 0, i*72 + 24));
            terrainList.add(new SpecificTerrain(SMALL_V_BROWN, 26*72 + 24, i*72 + 24));
        }
        terrainList.add(new SpecificTerrain(SMALLEST_BROWN, 0, 0));
        terrainList.add(new SpecificTerrain(SMALLEST_BROWN, 0, panelHeight - 24));
        terrainList.add(new SpecificTerrain(SMALLEST_BROWN, 72*26 + 23, 0));
        terrainList.add(new SpecificTerrain(SMALLEST_BROWN, 72*26 + 24, panelHeight - 24));
        //----------------------------------------------------------------------------------------------------------------------
       
            // for(int i = 0; i < 26; i++)
            // {
            //     terrainList.add(new SpecificTerrain(SOIL_1, i*72 + 24, panelHeight - 24 - 72 - 96));
            // }
        CreateTerrain.createRect(terrainList, SUB_SOIL_1, 24, panelHeight - 24, 3, 3);
        CreateTerrain.createRect(terrainList, SUB_SOIL_1, 24 + 72*1, panelHeight - 24, 6, 5);
        CreateTerrain.createRect(terrainList, SUB_SOIL_1, 24 + 72*10, panelHeight - 24, 3, 3);
        CreateTerrain.createRect(terrainList, SUB_SOIL_1, 24 + 72*12, panelHeight - 24 - 72, 6, 3);
        CreateTerrain.createRect(terrainList, SUB_SOIL_1, 24 + 72*9, panelHeight - 24 - 72*3, 6, 3);
        CreateTerrain.createRect(terrainList, SUB_SOIL_1, 24 + 72*15, panelHeight - 24 - 72*2, 6, 2);
        CreateTerrain.createRect(terrainList, SUB_SOIL_1, 24 + 72*4, panelHeight - 24 - 72*2, 9, 3);

        fruitList.add(new SpecificFruit(Fruit.APPLE, 100, 300));

        enemyList.add(new AngryPig(900, panelHeight - 24 - AngryPig.HEIGHT, 150));
        enemyList.add(new AngryPig(900, panelHeight - 24 - 72*2 - AngryPig.HEIGHT, 70));
        intitTerrainData();
    }

    @SuppressWarnings("unchecked")
    private void intitTerrainData()
    {
        terrainData = new ArrayList[(int)(Math.ceil(1.0*panelHeight/100))][(int)(Math.ceil(1.0*panelWidth/100))];
        for(int i = 0; i < terrainData.length; i++)
        {
            for(int j = 0; j < terrainData[0].length; j++)
            {
                terrainData[i][j] = new ArrayList<SpecificTerrain>();
            }
        }
        for(SpecificTerrain i : terrainList)
        {
            int [] x = {i.x/100, (i.x + i.width)/100, (i.x + i.width)/100,i.x/100};
            int [] y = {i.y/100, i.y/100, (i.y + i.height)/100, (i.y + i.height)/100};
 
            for(int k = 0; k < 4; k++)
            {
                if(terrainData[y[k]][x[k]].size() == 0)
                {
                    terrainData[y[k]][x[k]].add(i);
                }else{
                    if(terrainData[y[k]][x[k]].getLast() != i)
                    {
                        terrainData[y[k]][x[k]].add(i);
                    }
                }
            }
        }
    }
}
