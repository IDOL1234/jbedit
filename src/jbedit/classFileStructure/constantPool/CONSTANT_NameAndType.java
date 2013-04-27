
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_NameAndType extends CONSTANTPoolElement
{
    private int name_index; //utf8 (short)
    private int descriptor_index; //utf8 (short)

    public int getName_index() 
    {
        return name_index;
    }

    public void setName_index(int name_index) 
    {
        this.name_index = name_index;
    }

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
        return 12;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException 
    {
        name_index = mainInput.readUnsignedShort(); 
        descriptor_index = mainInput.readUnsignedShort();     
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeShort(name_index);
        mainOutput.writeShort(descriptor_index);
    }
}
