
package jbedit.classFileStructure;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class FieldLoader
{
    public static LinkedList<Field> loadElements(DataInputStream mainInput,
            LinkedList<CONSTANTPoolElement> pool, int num) 
            throws IOException, FrameException
    {
        LinkedList<Field> result = new LinkedList<Field>();
        for (int i = 0; i < num; i++)
        {
            result.add(loadElement(mainInput, pool));
        }
        return result;
    }
    
    public static Field loadElement(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool)
            throws IOException, FrameException
    {
        Field element = new Field();
        element.selfLoad(mainInput, pool);
        return element;
    }
}
