package gameengine.display;

import gameegine.players.MainPlayer;
import gameengine.engines.LevelEngine;
import gameengine.engines.PlaneEngine;
import gameengine.engines.PlayerEngine;
import gameengine.graphics.Tile;
import gameengine.listeners.InputKeyManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
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
    private static PlayerEngine thePlayerEngine;
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
        theLevelEngine.load("level-1", 3);
        thePlaneEngine = new PlaneEngine(theLevelEngine.getLevel());
        thePlayerEngine = new PlayerEngine(theLevelEngine.getTheMainPlayer());
        addKeyListener(new InputKeyManager(thePlayerEngine));

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

        thePlaneEngine.updatePosition(thePlayerEngine.getPlayer());

        drawScene(backBuffer);
        drawCharacters(backBuffer);

        backBuffer.dispose();
        strategy.show();

    }

    public void drawScene(Graphics2D backBuffer)
    {
        int startX = 0;
        int startY = 0;

        Color[] colors =
        {
            Color.GREEN, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE
        };

        // effacement de l'ecran
        backBuffer.setColor(Color.WHITE);
        backBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (int z = thePlaneEngine.getPlanesNumber() - 1; z >= 0; z--)
        {
            for (int x = startX; x < thePlaneEngine.getPlanesWidth(); x++)
            {
                for (int y = startY; y < thePlaneEngine.getPlanesHeight(); y++)
                {
                    // affiche l'image
                    Tile tile = thePlaneEngine.getTile(z, x, y);
                    if (tile.isCollision())
                    {
                        backBuffer.setColor(tile.getColor());

                        backBuffer.fillRect(
                                (x * theLevelEngine.getTileSize()) - thePlaneEngine.getCameraXPosition() / (z + 1),
                                (y * theLevelEngine.getTileSize()) - thePlaneEngine.getCameraYPosition() / (z + 1),
                                theLevelEngine.getTileSize(),
                                theLevelEngine.getTileSize());
                    }
                    // affiche la grille
                    if (thePlaneEngine.isDebug())
                    {
                        backBuffer.setColor(colors[z]);
                        Rectangle2D rectangle2 = new Rectangle2D.Double(
                                (x * theLevelEngine.getTileSize()) - thePlaneEngine.getCameraXPosition() / (z + 1),
                                (y * theLevelEngine.getTileSize()) - thePlaneEngine.getCameraYPosition() / (z + 1),
                                theLevelEngine.getTileSize(),
                                theLevelEngine.getTileSize());

                        backBuffer.draw(rectangle2);
                    }
                }
            }
        }


    }

    public void drawCharacters(Graphics2D backBuffer)
    {
        MainPlayer thePlayer = theLevelEngine.getTheMainPlayer();
        backBuffer.setColor(Color.RED);
        backBuffer.fillRect(
                (thePlayer.getX()),
                (thePlayer.getY()),
                thePlayer.getWidth(),
                thePlayer.getHeight());

    }
}
