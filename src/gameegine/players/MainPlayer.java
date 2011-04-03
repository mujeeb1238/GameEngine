/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameegine.players;

import java.awt.Color;

/**
 *
 * @author Alex
 */
public class MainPlayer
{
    private int xSpeed = 0;
    private int ySpeed = 0;
    private int x, y;
    private Color color = Color.RED;

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
