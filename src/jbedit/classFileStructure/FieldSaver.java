
package jbedit.classFileStructure;

import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.frames.FrameException;

public class FieldSaver
{
    public static void saveElements(Field[] fields, DataOutputStream mainOutPut) 
            throws IOException, FrameException
    {
        for (int i = 0; i < fields.length; i++)
        {
            fields[i].selfSave(mainOutPut);
        }
    }
}
