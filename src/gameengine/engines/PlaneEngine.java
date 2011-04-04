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
    private int cameraXPosition = 0;
    private int cameraYPosition = 0;

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
        // gestion des quatres coins du player
        /*
         *  http://www.cokeandcode.com/collisiontilemaps
         * 
         *  °-------°
         *  |       |
         *  |       |
         *  °-------°
         */
        int playerWidthCells = (int) Math.floor(thePlayer.getWidth() / 32);
        int playerHeighCells = (int) Math.floor(thePlayer.getHeight() / 32);

        int xTopLeft, xTopRight, xBottomLeft, xBottomRight;
        int yTopLeft, yTopRight, yBottomLeft, yBottomRight;

        xTopLeft = (thePlayer.getX() + cameraXPosition) / 32;
        yTopLeft = (thePlayer.getY() + cameraYPosition) / 32;
        xTopRight = (thePlayer.getX() + cameraXPosition + thePlayer.getWidth()) / 32;
        yTopRight = (thePlayer.getY() + cameraYPosition) / 32;

        int planeX, planeY;
        
        planeX = (int) Math.ceil((thePlayer.getX() + cameraXPosition) / 32);
        planeY = (int) Math.ceil((thePlayer.getY() + cameraYPosition) / 32);
        
        switch(thePlayer.getXStatus())
        {
            case WALK_RIGHT:
//                if (! planes[0].getTile(planeX + playerWidthCells, planeY).isCollision()
//                        && ! planes[0].getTile(planeX + playerWidthCells, planeY + playerHeighCells).isCollision())
                    this.cameraXPosition += thePlayer.getxSpeed();
//                else
//                    System.out.println(planeX + " " + planeY);
                break;
            case WALK_LEFT:
//                if (! planes[0].getTile(planeX, planeY).isCollision()
//                        && ! planes[0].getTile(planeX, planeY).isCollision())
                    this.cameraXPosition -= thePlayer.getxSpeed();
//                else
//                    System.out.println(planeX + " " + planeY);
                break;
        }

        switch(thePlayer.getYStatus())
        {
            case WALK_UP:
                if (! planes[0].getTile(xTopLeft, yTopLeft).isCollision()
                        && ! planes[0].getTile(xTopRight, yTopRight).isCollision())
                    this.cameraYPosition -= thePlayer.getySpeed();
                else
                    System.out.println(planeX + " " + planeY);
                break;
            case WALK_DOWN:
                if (! planes[0].getTile(planeX, planeY + playerHeighCells).isCollision())
                    this.cameraYPosition += thePlayer.getySpeed();
                else
                    System.out.println(planeX + " " + planeY);
        }
    }


    public Tile getTile(int z, int x, int y)
    {
        return planes[z].getTile(x, y);
    }
}
