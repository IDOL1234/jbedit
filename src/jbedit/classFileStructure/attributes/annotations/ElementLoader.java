
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.LinkedList;

public class ElementLoader
{
    public static LinkedList<element_value> loadElements(DataInputStream mainInput, int num) throws IOException
    {
        LinkedList<element_value> result = new LinkedList<element_value>();
        for (int i = 0; i < num; i++)
        {
            result.add(loadElement(mainInput));
        }
        return result;
    }
    
    public static element_value loadElement(DataInputStream mainInput) throws IOException
    {
        
        int type = mainInput.readUnsignedByte(); //(byte)
        char typeName = (char)type;
        
        element_value result;
        
        switch (typeName)
        {
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'I':
            case 'J':
            case 'S':
            case 'Z':
            case 's':
            {
                result = new element_const_value_index();
                break;
            }
            
            case 'e':
            {
                result = new element_enum_const_value();
                break;
            }
                
            case 'c':
            {
                result = new element_class_info_index();
                break;
            }
                
            case '@':
            {
                result = new element_annotation_value();
                break;
            }
                
            case '[':
            {
                result = new element_array_value();
                break;
            }
            default:
            {
                throw new IllegalStateException("Некорректный тип элемента:" + typeName);
            }
        }
        
        result.setTag(type);
        result.selfLoad(mainInput);
        
        return result;
    }
}
