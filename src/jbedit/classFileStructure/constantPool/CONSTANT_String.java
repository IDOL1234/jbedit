
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_String extends CONSTANTPoolElement
{
    private int string_index; // ссылка на utf8 (short)

    public int getString_index() 
    {
        return string_index;
    }

    public void setString_index(int string_index) 
    {
        this.string_index = string_index;
    }

    @Override
    public int getTag() 
    {
        return 8;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException 
    {
        string_index = mainInput.readUnsignedShort();   
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeShort(string_index);
    }
}
