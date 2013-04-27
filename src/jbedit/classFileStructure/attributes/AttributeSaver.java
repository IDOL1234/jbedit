
package jbedit.classFileStructure.attributes;

import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.frames.FrameException;

public class AttributeSaver
{
    public static void saveElements(AbstractAttribute attributes[], DataOutputStream mainOutPut) 
            throws IOException, FrameException
    {
        for (int i = 0; i < attributes.length; i++)
        {
            attributes[i].selfSave(mainOutPut);
        }
    }
}
