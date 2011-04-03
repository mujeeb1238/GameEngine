package gameengine.listeners;

import gameegine.players.MainPlayer;
import gameengine.engines.PlayerEngine;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class InputKeyManager implements KeyListener
{

    private static PlayerEngine thePlayerEngine;

    public InputKeyManager(PlayerEngine aPlayerEngine)
    {
        thePlayerEngine = aPlayerEngine;
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT:
                thePlayerEngine.walkRight();
                break;
            case KeyEvent.VK_LEFT:
                thePlayerEngine.walkLeft();
                break;

            case KeyEvent.VK_UP:
                thePlayerEngine.walkUp();
                break;
            case KeyEvent.VK_DOWN:
                thePlayerEngine.walkDown();
                break;

        }
        e.consume();
    }

    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                thePlayerEngine.stopH();
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                thePlayerEngine.stopV();
                break;


        }
        e.consume();
    }
}
