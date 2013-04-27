
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_Class  extends CONSTANTPoolElement
{
    private int name_index; // ссылка на utf8 с описанием класса
                            // short

    public int getName_index() 
    {
        return name_index;
    }

    public void setName_index(int name_index) 
    {
        this.name_index = name_index;
    }

    @Override
    public int getTag() 
    {
        return 7;
    }

    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException 
    {
        name_index = mainInput.readUnsignedShort();
    }

    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeShort(name_index);
    }
}
