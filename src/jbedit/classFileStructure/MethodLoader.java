
package jbedit.classFileStructure;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class MethodLoader
{
        public static LinkedList<Method> loadElements(DataInputStream mainInput, 
                LinkedList<CONSTANTPoolElement> pool, int num) 
            throws IOException, FrameException
    {
        LinkedList<Method> result= new LinkedList<Method>();
        for (int i = 0; i < num; i++)
        {
            result.add(loadElement(mainInput, pool));
        }
        return result;
    }
    
    public static Method loadElement(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool)
            throws IOException, FrameException
    {
        Method element = new Method();
        element.selfLoad(mainInput, pool);
        return element;
    }
}
