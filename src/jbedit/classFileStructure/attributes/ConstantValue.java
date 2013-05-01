 
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;

public class ConstantValue extends AbstractAttribute
{
    private int constantvalue_index; // ссылка на константу из пула. (short)

    public int getConstantvalue_index() 
    {
        return constantvalue_index;
    }

    public void setConstantvalue_index(int constantvalue_index)
    {
        this.constantvalue_index = constantvalue_index;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result +=2;
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException
    {
        constantvalue_index = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(constantvalue_index);
    }

}
