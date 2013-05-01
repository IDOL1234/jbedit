
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class element_class_info_index extends element_value
{
    private int class_info_index; //(short)

    public int getClass_info_index()
    {
        return class_info_index;
    }

    public void setClass_info_index(int class_info_index)
    {
        this.class_info_index = class_info_index;
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
        class_info_index = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(class_info_index);
    }
}
