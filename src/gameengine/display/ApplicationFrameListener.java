/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine.display;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Alex
 */
public class ApplicationFrameListener implements WindowListener
{

    public void windowClosing(WindowEvent e)
    {
        System.out.println("destroy all threads");
        System.out.println("closing");
        System.exit(0);
    }

    public void windowOpened(WindowEvent e)
    {
    }

    public void windowClosed(WindowEvent e)
    {
    }

    public void windowIconified(WindowEvent e)
    {
    }

    public void windowDeiconified(WindowEvent e)
    {
    }

    public void windowActivated(WindowEvent e)
    {
    }

    public void windowDeactivated(WindowEvent e)
    {
    }
}
