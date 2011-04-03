/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine.graphics;

import gameengine.enums.TileName;

/**
 *
 * @author Alex
 */
public class Plane
{

    private int height;
    private int width;
    private int depth;
    private Tile[][] tiles;

    public Plane(int depth, int width, int height)
    {
        this.depth = depth;
        this.width = width;
        this.height = height;

        this.tiles = new Tile[width][height];
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                this.tiles[x][y] = new Tile(TileName.white);
            }
        }
    }

    public Plane(int aDepth, char[][] levelPlane)
    {
        this.depth = aDepth;
        this.width = levelPlane.length;
        this.height = levelPlane[0].length;

        this.tiles = new Tile[width][height];
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                this.tiles[x][y] = new Tile(levelPlane[x][y]);
            }
        }
    }

    public Tile getTile(int x, int y)
    {
        return tiles[x][y];
    }
}
