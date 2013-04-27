
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class element_array_value extends element_value
{
    private int num_values; //(short)
    private element_value values[];

    public int getNum_values()
    {
        return num_values;
    }

    public void setNum_values(int num_values)
    {
        this.num_values = num_values;
    }

    public element_value[] getValues()
    {
        return values;
    }

    public void setValues(element_value[] values)
    {
        this.values = values;
    }

    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2;
        for (int i = 0; i < num_values; i++)
        {
            result += values[i].getRealLength();
        }
        return result;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        num_values = mainInput.readUnsignedShort();
        values = ElementLoader.loadElements(mainInput, num_values);
    }
    
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(num_values);
        ElementSaver.saveElements(values, mainOutput);
    }
}
