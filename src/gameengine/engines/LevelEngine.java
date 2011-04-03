/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine.engines;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class LevelEngine
{

    private char[][][] level;

    public char[][][] getLevel()
    {
        return level;
    }

    public void load(String levelName, int planeNumber)
    {

        for (int p = 0; p < planeNumber; p++)
        {
            ArrayList<ArrayList<Character>> buffer = new ArrayList<ArrayList<Character>>();
            try
            {
                String fullLevelFileName = "gameengine/levels/" + levelName + "-plane-" + p + ".lvl";
                //            FileInputStream fstrem = new FileInputStream(levelFileName);
                InputStream fstream = this.getClass().getClassLoader().getResourceAsStream(fullLevelFileName);
                System.out.println(fstream != null);
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                int lineNumber = 0;

                while ((line = br.readLine()) != null)
                {
                    ArrayList<Character> bufferLine = new ArrayList<Character>();

                    for (int i = 0; i < line.length(); i++)
                    {
                        bufferLine.add(line.charAt(i));
                    }

                    buffer.add(bufferLine);
                    lineNumber++;
                }
            }
            catch (IOException ex)
            {
                Logger.getLogger(LevelEngine.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (level == null)
            {
                level = new char[planeNumber][buffer.get(0).size()][buffer.size()];
            }

            for (int i = 0; i < buffer.size(); i++)
            {
                System.out.println("");
                for (int j = 0; j < buffer.get(i).size(); j++)
                {
                    System.out.print(buffer.get(i).get(j) + " ");
                    
                    level[p][j][i] = buffer.get(i).get(j);
                }
            }
            System.out.println("");
        }
    }
}
