
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class SourceDebugExtension extends AbstractAttribute
{
    private LinkedList<Integer> debug_extension; //(byte)

    public LinkedList<Integer> getDebug_extension()
    {
        return debug_extension;
    }

    public void setDebug_extension(LinkedList<Integer> debug_extension)
    {
        this.debug_extension = debug_extension;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += debug_extension.size() * 1;
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
        debug_extension = new LinkedList<Integer>();
        for (int i = 0; i < super.getAttribute_lenght(); i++)
        {
            debug_extension.add(mainInput.readUnsignedByte());
        }
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        for (int i = 0; i < getAttribute_lenght(); i++)
        {
            mainOutput.writeByte(debug_extension.get(i));
        }
    }
    
}
