
package jbedit.classFileStructure.frames.verification_types;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class TypeInfoSaver
{
    public static void saveElements(LinkedList<AbstractTypeInfo> elements, DataOutputStream mainOutput) throws IOException
    {
        for (int i = 0; i < elements.size(); i++)
        {
            elements.get(i).selfSave(mainOutput);
        }
    }
}
