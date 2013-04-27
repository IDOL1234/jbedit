
package jbedit.classFileStructure.frames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FrameElementSaver
{
    public static void saveElements(AbstractStackMapFrame entries[], DataOutputStream mainOutput)
            throws IOException
    {
        for (int i = 0; i < entries.length; i++)
        {
            entries[i].selfSave(mainOutput);
        }
    }
}
