
package jbedit.classFileStructure.frames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class FrameElementSaver
{
    public static void saveElements(LinkedList<AbstractStackMapFrame> entries, DataOutputStream mainOutput)
            throws IOException
    {
        for (int i = 0; i < entries.size(); i++)
        {
            entries.get(i).selfSave(mainOutput);
        }
    }
}
