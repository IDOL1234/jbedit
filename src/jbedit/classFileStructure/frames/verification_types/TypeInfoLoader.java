
package jbedit.classFileStructure.frames.verification_types;

import java.io.DataInputStream;
import java.io.IOException;

public class TypeInfoLoader
{
    public static AbstractTypeInfo[] loadElements(DataInputStream mainInput, int count) throws IOException
    {
        AbstractTypeInfo[] result = new AbstractTypeInfo[count];
        
        for (int i = 0; i < count; i++)
        {
//            if ((i != 0) && ((result[i-1] instanceof Double_variable_info) || (result[i-1] instanceof Long_variable_info)))
//            {
//                result[i] = new TYPE_FICTIVE(); // странная ошибка. Неполное соответствие спецификации.
//            }
//            else
            {
                result[i] = loadElement(mainInput);
            }
        }
        
        return result;
    }
    
    public static AbstractTypeInfo loadElement(DataInputStream mainInput) throws IOException
    {
        int type = mainInput.readUnsignedByte(); //(byte)
        
        AbstractTypeInfo element;
        
        switch (type)
        {
            case 0:
            {
                element = new Top_variable_info();
                break;
            }
            case 1:
            {
                element = new Integer_variable_info();
                break;
            }
            case 2:
            {
                element = new Float_variable_info();
                break;
            }
            case 3:
            {
                element = new Double_variable_info();
                break;
            }
            case 4:
            {
                element = new Long_variable_info();
                break;
            }
            case 5:
            {
                element = new Null_variable_info();
                break;
            }
            case 6:
            {
                element = new UninitializatedThis_variable_info();
                break;
            }
            case 7:
            {
                element = new Object_variable_info();
                break;
            }
            case 8:
            {
                element = new Uninitializated_variable_info();
                break;
            }
            default:
            {
                throw new IllegalStateException("Тип verification info + " + type + " не поддерживается.");
            }
        }
        
        if (System.getProperty("debug") != null && System.getProperty("debug").equalsIgnoreCase("true"))
            System.out.println("Loading TypeInfo    " + element.getClass().getSimpleName());
        
        element.selfLoad(mainInput);
        return element;
    }
}
