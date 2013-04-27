
package jbedit.classFileStructure;

import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.frames.FrameException;

public class MethodSaver
{
     public static void saveElements(Method methods[], DataOutputStream mainOutput) 
            throws IOException, FrameException
     {
         for (int i = 0; i < methods.length; i++)
         {
             methods[i].selfSave(mainOutput);
         }
     }
}
