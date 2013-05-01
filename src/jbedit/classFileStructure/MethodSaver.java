
package jbedit.classFileStructure;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.frames.FrameException;

public class MethodSaver
{
     public static void saveElements(LinkedList<Method> methods, DataOutputStream mainOutput) 
            throws IOException, FrameException
     {
         for (int i = 0; i < methods.size(); i++)
         {
             methods.get(i).selfSave(mainOutput);
         }
     }
}
