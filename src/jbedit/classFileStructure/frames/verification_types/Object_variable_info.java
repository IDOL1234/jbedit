
package jbedit.classFileStructure.frames.verification_types;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Object_variable_info extends AbstractTypeInfo
{
    private int cpool_index; //(short)

    public int getCpool_index()
    {
        return cpool_index;
    }

    public void setCpool_index(int cpool_index)
    {
        this.cpool_index = cpool_index;
    }
    
    @Override
    public int getTag()
    {
        return 7;
    } 
    
    @Override
    public int getRealLength()
    {
        return getHeaderSize() + 2;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        cpool_index = mainInput.readUnsignedShort();
    } 
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeShort(cpool_index);
    }
}
