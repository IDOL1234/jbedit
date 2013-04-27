
package jbedit.classFileStructure;

import java.io.*;
import jbedit.classFileStructure.attributes.AbstractAttribute;
import jbedit.classFileStructure.attributes.AttributeLoader;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.PoolElementLoader;
import jbedit.classFileStructure.frames.FrameException;

public class ClassFileLoader 
{
    public static ClassFile Load(String fileName) throws ClassFileLoaderException, FrameException
    {
        DataInputStream mainInput = getMainInputStream(fileName);
        ClassFile classFile;
        
        try
        {
            classFile = new ClassFile();
            
            classFile.setMagic(mainInput.readInt()); // заголовок
            classFile.setMinor(mainInput.readUnsignedShort());
            classFile.setMajor(mainInput.readUnsignedShort());
            
            classFile.setConstant_pool_count(mainInput.readUnsignedShort()); // пул констант
            CONSTANTPoolElement constantPool[] = PoolElementLoader.loadElements(
                    mainInput, classFile.getConstant_pool_count());
            classFile.setConstantPool(constantPool);
            
            classFile.setAccess_flags(mainInput.readUnsignedShort()); // флаги доступа
            
            classFile.setThis_class(mainInput.readUnsignedShort()); // this и super
            classFile.setSuper_class(mainInput.readUnsignedShort());
            
            classFile.setInterfaces_count(mainInput.readUnsignedShort()); // интерфейсы
            int interfaces[] = new int[classFile.getInterfaces_count()];
            for (int i=0; i < classFile.getInterfaces_count(); i++)
            {
                interfaces[i] = mainInput.readUnsignedShort();
            }
            classFile.setInterfaces(interfaces);
            
            classFile.setFileds_count(mainInput.readUnsignedShort()); // поля
            Field[] fields = FieldLoader.loadElements(mainInput, constantPool, classFile.getFileds_count());
            classFile.setField_info(fields);
            
            classFile.setMethods_count(mainInput.readUnsignedShort()); // методы
            Method methods[] = MethodLoader.loadElements(mainInput, constantPool, classFile.getMethods_count());
            classFile.setMethods(methods);
            
            classFile.setAttribute_count(mainInput.readShort()); // атрибуты
            AbstractAttribute attributes[] = AttributeLoader.loadElements(mainInput, constantPool, classFile.getAttribute_count());
            classFile.setAtributes(attributes);
            
            
            
            
            
            
            
            
            
        }
        catch(EOFException ex)
        {
            throw new ClassFileLoaderException("Неожиданный конец файла", ex);
        }
        catch(IOException ex)
        {
            throw new ClassFileLoaderException("Ошибка загрузки файла: ", ex);
        }
        catch(FrameException ex)
        {
            throw new ClassFileLoaderException("Ошибка структуры файла", ex);
        }
        catch(IllegalStateException ex)
        {
            throw new ClassFileLoaderException("Ошибка структуры файла: ", ex);
        }
        catch(Exception ex)
        {
            throw new ClassFileLoaderException("Неизвестная ошибка: ", ex);
        }
        return classFile;
    }
    
    
    
    public static DataInputStream getMainInputStream(String fileName) throws ClassFileLoaderException
    {
        File file = new File(fileName);
        
        if (!file.exists())
            throw new ClassFileLoaderException("Файл \"" + fileName + "\" не найден.");
                
        if (file.isDirectory())
            throw new ClassFileLoaderException("Can't load directory");
        
        if (!file.canRead())
            throw new ClassFileLoaderException("Can't read from " + fileName);
        
        java.io.FileInputStream inputStream;
        try 
        {
            inputStream = new java.io.FileInputStream(file);
        } 
        catch (FileNotFoundException ex) 
        {
            throw new ClassFileLoaderException(ex);
        }
        return new java.io.DataInputStream(inputStream);
    }
    
    public static int[] loadInterfaces(DataInputStream mainInput, int num) throws IOException
    {
        int result[] = new int[num];
        for (int i = 0; i < num; i++)
        {
            result[i] = mainInput.readUnsignedShort();
        }
        return result;
    }
}
