
package jbedit.classFileStructure.frames.verification_types;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Uninitializated_variable_info extends AbstractTypeInfo
{
    private int offset; //(short)
    @Override
    public int getTag()
    {
        return 8;
    }

    public int getOffset()
    {
        return offset;
    }

    public void setOffset(int offset)
    {
        this.offset = offset;
    }
    
    @Override
    public int getRealLength()
    {
        return getHeaderSize() + 2;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        offset = mainInput.readUnsignedShort();
    }  
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeShort(offset);
    }
}
