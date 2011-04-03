package gameengine.listeners;

import gameegine.players.MainPlayer;
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

    private static MainPlayer player;

    public InputKeyManager(MainPlayer thePlayer)
    {
        player = thePlayer;
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT:
                player.setxSpeed(2);
                break;
            case KeyEvent.VK_LEFT:
                player.setxSpeed(-2);
                break;

            case KeyEvent.VK_UP:
                player.setySpeed(-2);
                break;
            case KeyEvent.VK_DOWN:
                player.setySpeed(2);
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
                player.setxSpeed(0);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                player.setySpeed(0);
                break;


        }
        e.consume();
    }
}
