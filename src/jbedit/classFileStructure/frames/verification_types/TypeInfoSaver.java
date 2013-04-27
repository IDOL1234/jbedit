
package jbedit.classFileStructure.frames.verification_types;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeInfoSaver
{
    public static void saveElements(AbstractTypeInfo[] elements, DataOutputStream mainOutput) throws IOException
    {
        for (int i = 0; i < elements.length; i++)
        {
            elements[i].selfSave(mainOutput);
        }
    }
}
