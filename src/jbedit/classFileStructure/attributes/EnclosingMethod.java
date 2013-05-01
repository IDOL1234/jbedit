
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class EnclosingMethod extends AbstractAttribute
{
    private int class_index; //(short)
    private int method_index; //(short)

    public int getClass_index()
    {
        return class_index;
    }

    public void setClass_index(int class_index)
    {
        this.class_index = class_index;
    }

    public int getMethod_index()
    {
        return method_index;
    }

    public void setMethod_index(int method_index)
    {
        this.method_index = method_index;
    }

    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2 + 2;
        return result;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
        class_index = mainInput.readUnsignedShort();
        method_index = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(class_index);
        mainOutput.writeShort(method_index);
    }
}
