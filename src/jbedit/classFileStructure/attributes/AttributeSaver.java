
package jbedit.classFileStructure.attributes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.frames.FrameException;

public class AttributeSaver
{
    public static void saveElements(LinkedList<AbstractAttribute> attributes, DataOutputStream mainOutPut) 
            throws IOException, FrameException
    {
        for (int i = 0; i < attributes.size(); i++)
        {
            attributes.get(i).selfSave(mainOutPut);
        }
    }
}
