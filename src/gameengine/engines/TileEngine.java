/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine.engines;

import gameengine.graphics.Tile;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class TileEngine
{
    private static Toolkit theToolKit = Toolkit.getDefaultToolkit();
    private static List tileList = new ArrayList<Tile>();
    private static Image[] imageList;

    public TileEngine()
    {
        init();
    }
    
    private void init()
    {
        imageList = new Image[1];
        imageList[0] = theToolKit.getImage("");
    }
}
