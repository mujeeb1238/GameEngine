/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine.engines;

import gameegine.players.MainPlayer;
import gameengine.graphics.Plane;
import gameengine.graphics.Tile;

/**
 *
 * @author Alex
 */
public class PlaneEngine
{

    private boolean debug = false;
    private Plane[] planes;
    private int planesWidth;
    private int planesHeight;
    private int planesNumber;
    private int tileSize = 32;
    private int cameraXPosition = 0;
    private int cameraYPosition = 0;
    private int averageXSpeed = 0;
    private int averageYSpeed = 0;

    public boolean isDebug()
    {
        return debug;
    }

    public void setDebug(boolean debug)
    {
        this.debug = debug;
    }

    public int getCameraXPosition()
    {
        return cameraXPosition;
    }

    public int getCameraYPosition()
    {
        return cameraYPosition;
    }

    public int getTileSize()
    {
        return tileSize;
    }

    public Plane[] getPlanes()
    {
        return planes;
    }

    public int getPlanesHeight()
    {
        return planesHeight;
    }

    public int getPlanesNumber()
    {
        return planesNumber;
    }

    public int getPlanesWidth()
    {
        return planesWidth;
    }

    public PlaneEngine(int planesNumber, int planesWidth, int planesHeight)
    {
        this.planesNumber = planesNumber;
        this.planesWidth = planesWidth;
        this.planesHeight = planesHeight;

        planes = new Plane[planesNumber];
        for (int i = 0; i < planesNumber; i++)
        {
            planes[i] = new Plane(i, planesWidth, planesHeight);
        }
    }

    public PlaneEngine(char[][][] level)
    {
        this.planesNumber = level.length;
        this.planesWidth = level[0].length;
        this.planesHeight = level[0][0].length;

        planes = new Plane[planesNumber];
        for (int i = 0; i < planesNumber; i++)
        {
            planes[i] = new Plane(i, level[i]);
        }
    }

    public void updatePosition(MainPlayer thePlayer)
    {
        this.cameraXPosition += thePlayer.getxSpeed();
        this.cameraYPosition += thePlayer.getySpeed();
    }


    public Tile getTile(int z, int x, int y)
    {
        return planes[z].getTile(x, y);
    }
}
