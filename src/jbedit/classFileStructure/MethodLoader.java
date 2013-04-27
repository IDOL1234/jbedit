
package jbedit.classFileStructure;

import java.io.DataInputStream;
import java.io.IOException;
import static jbedit.classFileStructure.FieldLoader.loadElement;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class MethodLoader
{
        public static Method[] loadElements(DataInputStream mainInput, CONSTANTPoolElement pool[], int num) 
            throws IOException, FrameException
    {
        Method result[] = new Method[num];
        for (int i = 0; i < num; i++)
        {
            result[i] = loadElement(mainInput, pool);
        }
        return result;
    }
    
    public static Method loadElement(DataInputStream mainInput, CONSTANTPoolElement pool[])
            throws IOException, FrameException
    {
        Method element = new Method();
        element.selfLoad(mainInput, pool);
        return element;
    }
}
