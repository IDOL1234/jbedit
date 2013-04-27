
package jbedit.classFileStructure;

import java.io.DataInputStream;
import java.io.IOException;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class FieldLoader
{
    public static Field[] loadElements(DataInputStream mainInput, CONSTANTPoolElement pool[], int num) 
            throws IOException, FrameException
    {
        Field result[] = new Field[num];
        for (int i = 0; i < num; i++)
        {
            result[i] = loadElement(mainInput, pool);
        }
        return result;
    }
    
    public static Field loadElement(DataInputStream mainInput, CONSTANTPoolElement pool[])
            throws IOException, FrameException
    {
        Field element = new Field();
        element.selfLoad(mainInput, pool);
        return element;
    }
}
