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

    public void load(String levelFileName)
    {
        ArrayList<ArrayList<Character>> buffer = new ArrayList<ArrayList<Character>>();

        try
        {
            String fullLevelFileName = "gameengine/levels/" + levelFileName;
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

        // remise en forme
        System.out.println(buffer.size());
        System.out.println(buffer.get(0).size());

        level = new char[1][buffer.get(0).size()][buffer.size()];
        System.out.println(buffer.get(0).size());

        for (int i = 0; i < buffer.size(); i++)
        {
            for (int j = 0; j < buffer.get(i).size(); j++)
            {
                System.out.println(i + " " + j);
                level[0][j][i] = buffer.get(i).get(j);
            }
        }
    }
}
