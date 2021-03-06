package gameengine.graphics;

import gameengine.enums.TileName;
import java.awt.Color;

/**
 *
 * @author Alex
 */
public class Tile
{

    private TileName name;
    private Color color = Color.WHITE;
    private boolean collision = true;

    public Tile(TileName theTileName)
    {
        name = theTileName;
        switch (theTileName)
        {
            case black:
                color = Color.BLACK;
                break;
            case red:
                color = Color.RED;
                break;
            case green:
                color = Color.GREEN;
                break;
        }
    }

    Tile(char c)
    {
        switch (c)
        {
            case '1':
                color = Color.BLACK;
                break;
            case '2':
                color = Color.GRAY;
                break;
            case '3':
                color = Color.LIGHT_GRAY;
                break;
            case ' ':
            case '0':
                color = Color.WHITE;
                collision = false;
                break;
        }
    }

    public boolean isCollision()
    {
        return collision;
    }
    
    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
}
