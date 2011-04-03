/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;

import gameengine.display.ApplicationFrame;

/**
 *
 * @author Alex
 */
public class Main extends ApplicationFrame
{

    public Main(String title, int width, int height)
    {
        super(title, width, height);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Main main = new Main("fatal game tragedy", 1024, 768);
        main.run();
    }
}
