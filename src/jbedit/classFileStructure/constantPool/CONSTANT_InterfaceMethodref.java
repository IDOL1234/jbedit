
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_InterfaceMethodref extends CONSTANTPoolElement
{
    private int class_index; // ссылка на constant_class (short)
    private int name_and_type_index; // ссылка на описание и тип (short)

    public int getClass_index() 
    {
        return class_index;
    }

    public void setClass_index(int class_index) 
    {
        this.class_index = class_index;
    }

    public int getName_and_type_index() 
    {
        return name_and_type_index;
    }

    public void setName_and_type_index(int name_and_type_index) 
    {
        this.name_and_type_index = name_and_type_index;
    }
    
    @Override
    public int getTag() 
    {
        return 11;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException 
    {
        class_index = mainInput.readUnsignedShort();
        name_and_type_index = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeShort(class_index);
        mainOutput.writeShort(name_and_type_index);
    }
}
