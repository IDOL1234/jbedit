
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PoolElementLoader 
{
    public static CONSTANTPoolElement[] loadElements(DataInputStream mainInput, int count) throws IOException // Возвращает пул констант
    {
        CONSTANTPoolElement pool[] = new CONSTANTPoolElement[count];
        for (int i = 1; i < count; i++)
        {
            if ((i != 1) && ((pool[i-1] instanceof CONSTANT_Double) || (pool[i-1] instanceof CONSTANT_Long)))
            {
                    pool[i] = new CONSTANT_FICTIVE(); // эти типы занимают 2 ячейки
            }
            else
            {
                pool[i] = loadElement(mainInput, i);
            }
        }
        return pool;
    }
    
    private static CONSTANTPoolElement loadElement(DataInputStream mainInput, int num) throws IOException
    {
        CONSTANTPoolElement element;
        
        int type = mainInput.readUnsignedByte();
        
        switch(type)
        {
            case (1):
            {
                element = new CONSTANT_Utf8();
                element.setNumber(num);
                break;
            }
            case (3):
            {
                element = new CONSTANT_Integer();
                element.setNumber(num);
                break;
            }
            case (4):
            {
                element = new CONSTANT_Float();
                element.setNumber(num);
                break;
            }
            case (5):
            {
                element = new CONSTANT_Long();
                element.setNumber(num);
                break;
            }
            case (6):
            {
                element = new CONSTANT_Double();
                element.setNumber(num);
                break;
            }
            case (7):
            {
                element = new CONSTANT_Class();
                element.setNumber(num);
                break;
            }
            case (8):
            {
                element = new CONSTANT_String();
                element.setNumber(num);
                break;
            }
            case (9):
            {
                element = new CONSTANT_fieldRef();
                element.setNumber(num);
                break;
            }
            case (10):
            {
                element = new CONSTANT_Methodref();
                element.setNumber(num);
                break;
            }
            case (11):
            {
                element = new CONSTANT_InterfaceMethodref();
                element.setNumber(num);
                break;
            }
            case (12):
            {
                element = new CONSTANT_NameAndType();
                element.setNumber(num);
                break;
            }
            case (15):
            {
                element = new CONSTANT_MethodHandle();
                element.setNumber(num);
                break;
            }
            case (16):
            {
                element = new CONSTANT_MethodType();
                element.setNumber(num);
                break;
            }
            case (18):
            {
                element = new CONSTANT_InvokeDynamic();
                element.setNumber(num);
                break;
            }
            default:
            {
                throw new IllegalStateException("Тип " + type + " в пуле констант не поддерживается.");
            }   
        }
        
        element.selfLoad(mainInput);
        
        if (System.getProperty("debug") != null && System.getProperty("debug").equalsIgnoreCase("true"))
        {
            System.out.print("Loading Constant № " + num + ", type: " + element.getClass().getSimpleName());
            if (element instanceof CONSTANT_Utf8)
                System.out.println(", value: " + ((CONSTANT_Utf8)element).getString());
            else
                System.out.println(); 
        }
           
        
        
        return element;
    }
}
