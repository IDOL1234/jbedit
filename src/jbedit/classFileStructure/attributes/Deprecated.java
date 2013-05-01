
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class Deprecated extends AbstractAttribute
{
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        return result;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        
    }
}
