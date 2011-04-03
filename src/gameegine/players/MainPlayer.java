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
    private int weight = 1;
    private Color color = Color.RED;

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
}
