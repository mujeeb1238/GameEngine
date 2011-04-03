package gameengine.display;

import gameengine.engines.LevelEngine;
import gameengine.engines.PlaneEngine;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class ApplicationFrame extends JFrame implements Runnable
{

    private BufferStrategy strategy;
    private static PlaneEngine thePlaneEngine;
    private static LevelEngine theLevelEngine;
    private static boolean gameRunning = true;
    private static int width;
    private static int height;
    
    public ApplicationFrame(String title, int aWidth, int aHeight)
    {
        super(title);

        width = aWidth;
        height = aHeight;
        
        createUI();
        initEngines();
        setVisible(true);

        setIgnoreRepaint(true);
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        addWindowListener(new ApplicationFrameListener());
    }

    private void createUI()
    {
        setSize(width, height);
        center();
    }

    public void center()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;
        setLocation(x, y);
    }

    private void initEngines()
    {
        theLevelEngine = new LevelEngine();
        theLevelEngine.load("level-1-plane-0.lvl");
        thePlaneEngine = new PlaneEngine(theLevelEngine.getLevel());
    }

    public void run()
    {
        while (gameRunning)
        {
            try
            {
                draw();
                Thread.sleep(10);
            }
            catch (InterruptedException ex)
            {
            }
        }
        System.exit(0);
    }

    public void draw()
    {
        Graphics2D backBuffer = (Graphics2D) strategy.getDrawGraphics();
        
        Color[] colors =
        {
            Color.BLUE, Color.RED, Color.GREEN, Color.BLACK, Color.PINK
        };

        // effacement de l'ecran
        backBuffer.setColor(Color.WHITE);
        backBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (int z = thePlaneEngine.getPlanesNumber() - 1; z >= 0; z--)
        {
            for (int x = 0; x < thePlaneEngine.getPlanesWidth(); x++)
            {
                for (int y = 0; y < thePlaneEngine.getPlanesHeight(); y++)
                {
                    // affiche l'image
                    Color tileColor = thePlaneEngine.getTile(z, x, y).getColor();
                    if (tileColor != Color.WHITE)
                    {
                        backBuffer.setColor(tileColor);

                        backBuffer.fillRect(
                                (x * thePlaneEngine.getTileSize()) - thePlaneEngine.getCameraXPosition() / (z + 1),
                                (y * thePlaneEngine.getTileSize()) - thePlaneEngine.getCameraYPosition() / (z + 1),
                                thePlaneEngine.getTileSize(),
                                thePlaneEngine.getTileSize());
                    }

                    // affiche la grille
                    if (thePlaneEngine.isDebug())
                    {
                        backBuffer.setColor(colors[z]);
                        Rectangle2D rectangle2 = new Rectangle2D.Double(
                                (x * thePlaneEngine.getTileSize()) - thePlaneEngine.getCameraXPosition() / (z + 1),
                                (y * thePlaneEngine.getTileSize()) - thePlaneEngine.getCameraYPosition() / (z + 1),
                                thePlaneEngine.getTileSize(),
                                thePlaneEngine.getTileSize());

                        backBuffer.draw(rectangle2);
                    }
                }

            }
        }

        backBuffer.dispose();
        strategy.show();
        
        thePlaneEngine.updatePosition();
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
