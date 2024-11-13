package terrain;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


import java.awt.Graphics;

import middleware.LoadAnimation;

public class Terrain {

//------------------------------------TERRAIN--------------------------------------------//
public static final String TERRAIN_IMAGE = "/image/Terrain/Terrain (16x16).png";
public static final int[][] TERRAIN_IMAGE_DATA = {
    //{  ,   , Width, Height}
    {0, 0, 48, 48},     {0, 64, 48, 48},    {0, 128, 48, 48},   {96, 0, 48, 48},
    {96, 64, 48, 48},   {96, 128, 48, 48},  {272, 64, 48, 48},  {48, 0, 32, 32},    
    {48, 64, 32, 32},   {48, 128, 32, 32},  {144, 0, 32, 32},   {144, 64, 32, 32},
    {144, 128, 32, 32},

    {192, 0, 48, 16},   {240, 0, 16, 48},   {208, 16, 32, 32},  {192, 16, 16, 16},  
    {192, 64, 48, 16},  {240, 64, 16, 48},  {208, 80, 32, 32},  {192, 80, 16, 16},
    {192, 128, 48, 16},  {240, 128, 16, 48},  {208, 144, 32, 32},  {192, 144, 16, 16},
    {272, 128, 48, 16},  {320, 128, 16, 48},  {288, 144, 32, 32},  {272, 144, 16, 16},

    {272, 0, 48, 6},    {272, 16, 48, 6},   {276, 32, 48, 6},

    //SOIL_1_X_Y
    {96, 0, 16, 16}, {112, 0, 16, 16}, {128, 0, 16, 16},
    {96, 16, 16, 16}, {112, 16, 16, 16}, {128, 16, 16, 16},
    {96, 32, 16, 16}, {112, 32, 16, 16}, {128, 32, 16, 16},
    //SOIL_2_X_Y
    {96, 0, 16, 16}, {112, 0, 16, 16}, {128, 0, 16, 16},
    {96, 16, 16, 16}, {112, 16, 16, 16}, {128, 16, 16, 16},
    {96, 32, 16, 16}, {112, 32, 16, 16}, {128, 32, 16, 16}
};
public static final int STONE_TERRAIN = 0;
public static final int WOOD_TERRAIN = 1;
public static final int TILING_TERRAIN = 2;
public static final int SOIL_1 = 3;
public static final int SOIL_2 = 4;
public static final int SOIL_3 = 5;
public static final int BRICK = 6;

public static final int SMALL_STONE = 7;
public static final int SMALL_WOOD = 8;
public static final int SMALL_TILING = 9;
public static final int SMALL_SOIL_1 = 10;
public static final int SMALL_SOIL_2 = 11;
public static final int SMALL_SOIL_3 = 12;

public static final int SMALL_H_BROWN = 13;
public static final int SMALL_V_BROWN = 14;
public static final int SMALL_BROWN = 15;
public static final int SMALLEST_BROWN = 16;

public static final int SMALL_H_GRAY = 17;
public static final int SMALL_V_GRAY = 18;
public static final int SMALL_GRAY = 19;
public static final int SMALLEST_GRAY = 20;

public static final int SMALL_H_ORANGE = 21;
public static final int SMALL_V_ORANGE = 22;
public static final int SMALL_ORANGE = 23;
public static final int SMALLEST_ORANGE = 24;

public static final int SMALL_H_YELLOW = 25;
public static final int SMALL_V_YELLOW = 26;
public static final int SMALL_YELLOW = 27;
public static final int SMALLEST_YELLOW = 28;

public static final int YELLOW_STICK = 29;
public static final int BROWN_STICK = 30;
public static final int GRAY_STICK = 31;

public static final int[][] SUB_SOIL_1_DATA = {{32, 33, 34}, {35, 36, 37}, {38, 39, 40}};
public static final int SOIL_1_1_1 = 32;
public static final int SOIL_1_1_2 = 33;
public static final int SOIL_1_1_3 = 34;
public static final int SOIL_1_2_1 = 35;
public static final int SOIL_1_2_2 = 36;
public static final int SOIL_1_2_3 = 37;
public static final int SOIL_1_3_1 = 38;
public static final int SOIL_1_3_2 = 39;
public static final int SOIL_1_3_3 = 40;
public static final int SUB_SOIL_1 = 41;

public static final int[][] SUB_SOIL_2_DATA = {{42, 43, 44}, {45, 46, 47}, {48, 49, 50}};
public static final int SOIL_2_1_1 = 42;
public static final int SOIL_2_1_2 = 43;
public static final int SOIL_2_1_3 = 44;
public static final int SOIL_2_2_1 = 45;
public static final int SOIL_2_2_2 = 46;
public static final int SOIL_2_2_3 = 47;
public static final int SOIL_2_3_1 = 48;
public static final int SOIL_2_3_2 = 49;
public static final int SOIL_2_3_3 = 50;
public static final int SUB_SOIL_2 = 51;

//------------------------------------TERRAIN--------------------------------------------//

    BufferedImage[] terrainImage;

    public Terrain()
    {
        BufferedImage image = LoadAnimation.loadImage(TERRAIN_IMAGE);
        terrainImage = new BufferedImage[TERRAIN_IMAGE_DATA.length];
        for(int i = 0; i < TERRAIN_IMAGE_DATA.length; i++)
        {
            terrainImage[i] = image.getSubimage(TERRAIN_IMAGE_DATA[i][0], TERRAIN_IMAGE_DATA[i][1], TERRAIN_IMAGE_DATA[i][2], TERRAIN_IMAGE_DATA[i][3]);
        }
    }

    public void drawTerrain(Graphics g, ArrayList<SpecificTerrain> terrainList)
    {
        for(SpecificTerrain i : terrainList)
        {
            g.drawImage(terrainImage[i.terrain], i.x, i.y, i.width,i.height, null);
        }
    } 

}
