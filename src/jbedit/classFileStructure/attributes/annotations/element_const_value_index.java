
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class element_const_value_index extends element_value
{
    private int const_value_index; //(short)

    public int getConst_value_index()
    {
        return const_value_index;
    }

    public void setConst_value_index(int const_value_index)
    {
        this.const_value_index = const_value_index;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2;
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        const_value_index = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(const_value_index);
    }
}
