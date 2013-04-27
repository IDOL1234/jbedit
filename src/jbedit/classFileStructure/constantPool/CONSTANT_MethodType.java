
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_MethodType extends CONSTANTPoolElement
{
    private int descriptor_index; // utf8 (short)

    public int getDescriptor_index() 
    {
        return descriptor_index;
    }

    public void setDescriptor_index(int descriptor_index) 
    {
        this.descriptor_index = descriptor_index;
    }

    @Override
    public int getTag() 
    {
        return 16;
    }

    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException 
    {
        descriptor_index = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeShort(descriptor_index);
    }    
    
}
