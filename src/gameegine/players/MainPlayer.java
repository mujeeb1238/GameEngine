/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameegine.players;

import gameengine.enums.PlayerStatus;
import java.awt.Color;

/**
 *
 * @author Alex
 */
public class MainPlayer
{
    private int width = 32, height = 32;
    private PlayerStatus xStatus = PlayerStatus.STOP_RIGHT;
    private PlayerStatus yStatus = PlayerStatus.STOP_UP;
    private int xSpeed = 1;
    private int ySpeed = 1;
    private int x, y;
    private Color color = Color.RED;

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public PlayerStatus getXStatus()
    {
        return xStatus;
    }

    public PlayerStatus getYStatus()
    {
        return yStatus;
    }
    
    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getxSpeed()
    {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed)
    {
        this.xSpeed = xSpeed;
    }

    public int getySpeed()
    {
        return ySpeed;
    }

    public void setySpeed(int ySpeed)
    {
        this.ySpeed = ySpeed;
    }

    public Color getColor()
    {
        return color;
    }

    public void walkRight()
    {
        if (this.xStatus != PlayerStatus.WALK_RIGHT)
        {
            this.xStatus = PlayerStatus.WALK_RIGHT;
        }
    }

    public void walkLeft()
    {
        if (this.xStatus != PlayerStatus.WALK_LEFT)
        {
            this.xStatus = PlayerStatus.WALK_LEFT;
        }
    }

    public void walkUp()
    {
        if (this.yStatus != PlayerStatus.WALK_UP)
        {
            this.yStatus = PlayerStatus.WALK_UP;
        }
    }

    public void walkDown()
    {
        if (this.yStatus != PlayerStatus.WALK_DOWN)
        {
            this.yStatus = PlayerStatus.WALK_DOWN;
        }
    }

    public void stopH()
    {
        if (this.xStatus == PlayerStatus.WALK_RIGHT)
        {
            this.xStatus = PlayerStatus.STOP_RIGHT;
        }
        else if (this.xStatus == PlayerStatus.WALK_LEFT)
        {
            this.xStatus = PlayerStatus.STOP_LEFT;
        }
    }

    public void stopV()
    {
        if (this.yStatus == PlayerStatus.WALK_UP)
        {
            this.yStatus = PlayerStatus.STOP_UP;
        }
        else if (this.yStatus == PlayerStatus.WALK_DOWN)
        {
            this.yStatus = PlayerStatus.STOP_DOWN;
        }
    }

    public void updatePosition()
    {
//        x += xSpeed;
//        y += ySpeed;
    }

    @Override
    public String toString()
    {
        return "PLAYER x:" + this.getX() + " y:" + this.getY();
    }
}
