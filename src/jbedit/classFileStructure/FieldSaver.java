
package jbedit.classFileStructure;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.frames.FrameException;

public class FieldSaver
{
    public static void saveElements(LinkedList<Field> fields, DataOutputStream mainOutPut) 
            throws IOException, FrameException
    {
        for (int i = 0; i < fields.size(); i++)
        {
            fields.get(i).selfSave(mainOutPut);
        }
    }
}
