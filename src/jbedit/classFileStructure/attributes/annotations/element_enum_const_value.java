
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class element_enum_const_value extends element_value
{
    private int type_name_index; //(short)
    private int const_name_index; //(short)

    public int getType_name_index()
    {
        return type_name_index;
    }

    public void setType_name_index(int type_name_index)
    {
        this.type_name_index = type_name_index;
    }

    public int getConst_name_index()
    {
        return const_name_index;
    }

    public void setConst_name_index(int const_name_index)
    {
        this.const_name_index = const_name_index;
    }

    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2;
        result += 2;
        return result;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        type_name_index = mainInput.readUnsignedShort();
        const_name_index = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(type_name_index);
        mainOutput.writeShort(const_name_index);
    }
}
