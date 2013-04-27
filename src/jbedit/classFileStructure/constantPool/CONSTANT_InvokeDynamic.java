
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_InvokeDynamic extends CONSTANTPoolElement
{
    private int bootstrap_method_attr_index; // указывает на метод из bootstrap_methods (short)
    private int name_and_type_index; // ссылка на описание (short)

    public int getBootstrap_method_attr_index() 
    {
        return bootstrap_method_attr_index;
    }

    public void setBootstrap_method_attr_index(int bootstrap_method_attr_index) 
    {
        this.bootstrap_method_attr_index = bootstrap_method_attr_index;
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
        return 18;
    }

    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException 
    {
        bootstrap_method_attr_index = mainInput.readUnsignedShort();
        name_and_type_index = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeShort(bootstrap_method_attr_index);
        mainOutput.writeShort(name_and_type_index);
    }
}
