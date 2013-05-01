
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class Annotation
{
    private int type_index; //(short)
    private int num_element_value_pairs; //(short)
    private LinkedList<element_value_pair> element_value_pairs;

    public int getType_index()
    {
        return type_index;
    }

    public void setType_index(int type_index)
    {
        this.type_index = type_index;
    }

    public int getNum_element_value_pairs()
    {
        return num_element_value_pairs;
    }

    public void setNum_element_value_pairs(int num_element_value_pairs)
    {
        this.num_element_value_pairs = num_element_value_pairs;
    }

    public LinkedList<element_value_pair> getElement_value_pairs()
    {
        return element_value_pairs;
    }

    public void setElement_value_pairs(LinkedList<element_value_pair> element_value_pairs)
    {
        this.element_value_pairs = element_value_pairs;
    }
    

    public int getRealLength()
    {
        int result = 2 + 2;;
        for (int i = 0; i < num_element_value_pairs; i++)
        {
            result += element_value_pairs.get(i).getRealLength();
        }
        return result;
    }
    
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        type_index = mainInput.readUnsignedShort();
        num_element_value_pairs = mainInput.readUnsignedShort();
        
        element_value_pairs = new LinkedList<element_value_pair>();
        
        for (int i = 0; i < num_element_value_pairs; i++)
        {
            element_value_pairs.add(new element_value_pair());
            element_value_pairs.get(i).selfLoad(mainInput);
        }
    }
    
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(type_index);
        mainOutput.writeShort(num_element_value_pairs);
        
        for (int i = 0; i < num_element_value_pairs; i++)
        {
            element_value_pairs.get(i).selfSave(mainOutput);
        }
    }    
}
