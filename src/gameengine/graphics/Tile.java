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

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
}