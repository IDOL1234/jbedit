
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.IOException;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_Utf8;
import jbedit.classFileStructure.frames.FrameException;


public class AttributeLoader
{ 
    public static AbstractAttribute[] loadElements(DataInputStream mainInput,CONSTANTPoolElement[] pool, 
            int num) throws IOException, FrameException
    {
        AbstractAttribute result[] = new AbstractAttribute[num];
        for (int i = 0; i < num; i++)
        {
            result[i] = loadElement(mainInput, pool);
        }
        return result;   
    }
    
    public static AbstractAttribute loadElement(DataInputStream mainInput, CONSTANTPoolElement[] pool) 
            throws IOException, FrameException
    {
        int attr_name_index = mainInput.readUnsignedShort(); // (short)
        int attr_len = mainInput.readInt();
        CONSTANTPoolElement tempName = pool[attr_name_index];
        if (!(tempName instanceof CONSTANT_Utf8))
        {
            throw new IllegalStateException("Некорректный тип константы:" + tempName.toString());
        }
        String name = ((CONSTANT_Utf8)tempName).getString();
        
        if (System.getProperty("debug") != null && System.getProperty("debug").equalsIgnoreCase("true"))
            System.out.println("Loading attribute   " + name); 
        
        AbstractAttribute result = getElementByType(name); // создаётся элемент
        
        result.setAttribute_name_index(attr_name_index);
        result.setAttribute_lenght(attr_len);

        result.selfLoad(mainInput, pool); // самозагрузка
        
        return result;   
    }
    
    private static AbstractAttribute getElementByType(String name)
    {
        AbstractAttribute result;
        
        switch (name)
        {
            case "ConstantValue":
            {
                result = new ConstantValue();
                break;
            }
                
            case "Code":
            {
                result = new Code();
                break;
            }
              
            case "StackMapTable":
            {
                result = new StackMapTable();
                break;
            }
                
            case "Exceptions":
            {
                result = new Exceptions();
                break;
            }
                
            case "InnerClasses":
            {
                result = new InnerClasses();
                break;
            }
                
            case "EnclosingMethod":
            {
                result = new EnclosingMethod();
                break;
            }
                
            case "Synthetic":
            {
                result = new Synthetic();
                break;
            }
                
            case "Signature":
            {
                result = new Signature();
                break;
            }
                
            case "SourceFile":
            {
                result = new SourceFile();
                break;
            }
                
            case "SourceDebugExtension":
            {
                result = new SourceDebugExtension();
                break;
            }
                
            case "LineNumberTable":
            {
                result = new LineNumberTable();
                break;
            }
                
            case "LocalVariableTable":
            {
                result = new LocalVariableTable();
                break;
            }
                
            case "LocalVariableTypeTable":
            {
                result = new LocalVariableTypeTable();
                break;
            }
                
            case "Deprecated":
            {
                result = new Deprecated();
                break;
            }
                
             case "RuntimeVisibleAnnotations":
            {
                result = new RuntimeVisibleAnnotations();
                break;
            }
            
            case "RuntimeInvisibleAnnotations":
            {
                result = new RuntimeInvisibleAnnotations();
                break;
            }
                
            case "RuntimeVisibleParameterAnnotations":
            {
                result = new RuntimeVisibleParameterAnnotations();
                break;
            }
            
            case "RuntimeInvisibleParameterAnnotations":
            {
                result = new RuntimeInvisibleParameterAnnotations();
                break;
            }
                
            case "AnnotationDefault":
            {
                result = new AnnotationDefault();
                break;
            }
                
            case "BootstrapMethods":
            {
                result = new BootstrapMethods();
                break;
            }
                
            default:
            {
                throw new IllegalStateException("Недопустимый тип параметра: " + name);
            }
        }
        
        return result;
    }
}
