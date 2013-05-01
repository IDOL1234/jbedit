
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class SourceFile extends AbstractAttribute
{
    private int sourceIndex; //(short)

    public int getSourceIndex()
    {
        return sourceIndex;
    }

    public void setSourceIndex(int sourceIndex)
    {
        this.sourceIndex = sourceIndex;
    }

    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2;
        return result;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
        sourceIndex = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(sourceIndex);
    }
}
