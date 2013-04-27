
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class element_value_pair
{
    private int element_value_index; //(short)
    private element_value value;

    public int getElement_value_index()
    {
        return element_value_index;
    }

    public void setElement_value_index(int element_value_index)
    {
        this.element_value_index = element_value_index;
    }

    public element_value getValue()
    {
        return value;
    }

    public void setValue(element_value value)
    {
        this.value = value;
    }
    

    public int getRealLength()
    {
        int result = 2;
        result += value.getRealLength();
        return result;
    }
    
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        element_value_index = mainInput.readUnsignedShort();
        value = ElementLoader.loadElement(mainInput);
    }
    
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(element_value_index);
        ElementSaver.saveElement(value, mainOutput);
    }
    
}