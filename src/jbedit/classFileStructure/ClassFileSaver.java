
package jbedit.classFileStructure;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import jbedit.classFileStructure.attributes.AbstractAttribute;
import jbedit.classFileStructure.attributes.AttributeSaver;
import jbedit.classFileStructure.constantPool.PoolElementSaver;
import jbedit.classFileStructure.frames.FrameException;

public class ClassFileSaver
{
    public static void Save(ClassFile classFile, String fileName, boolean overwrite) throws ClassFileLoaderException, FrameException
    {
        DataOutputStream mainOutput = getMainOutputStream(fileName, overwrite);
        
        try
        {
            mainOutput.writeInt(classFile.getMagic());
            
            mainOutput.writeShort(classFile.getMinor());
            mainOutput.writeShort(classFile.getMajor());
            
            mainOutput.writeShort(classFile.getConstant_pool_count());
            PoolElementSaver.saveElements(classFile.getConstantPool(), mainOutput);
            
            mainOutput.writeShort(classFile.getAccess_flags());
          
            mainOutput.writeShort(classFile.getThis_class());
            mainOutput.writeShort(classFile.getSuper_class());
            
            mainOutput.writeShort(classFile.getInterfaces_count());
            for (int i = 0; i < classFile.getInterfaces_count(); i++)
            {
                mainOutput.writeShort(classFile.getInterface(i));
            }
            
            mainOutput.writeShort(classFile.getFileds_count());
            FieldSaver.saveElements(classFile.getField_info(), mainOutput);
            
            mainOutput.writeShort(classFile.getMethods_count());
            MethodSaver.saveElements(classFile.getMethods(), mainOutput);
            
            mainOutput.writeShort(classFile.getAttribute_count());
            AbstractAttribute[] attributes = classFile.getAtributes();
            AttributeSaver.saveElements(attributes, mainOutput);
            
            
        }
        catch (IOException | FrameException ex)
        {
            throw new ClassFileLoaderException("Неизвестная ошибка: ", ex);
        }
    }
    
    
    
    public static DataOutputStream getMainOutputStream(String fileName, boolean overwrite) throws ClassFileLoaderException
    {
        File file = new File(fileName);
        
        if (file.exists())
        {
            if (overwrite)
            {
                 file.delete();
            }
            else
            {
                throw new ClassFileLoaderException("Файл \"" + fileName + "\" уже существует.");
            }
        }
        
        if (file.isDirectory())
            throw new ClassFileLoaderException("Can't save file as directory");
        
        try
        {
            file.createNewFile();
        } 
        catch (IOException ex)
        {
           throw new ClassFileLoaderException(ex);
        }
        
        if (!file.canWrite())
            throw new ClassFileLoaderException("Can't write to " + fileName);
        
        java.io.FileOutputStream outputStream;
        try 
        {
            outputStream = new java.io.FileOutputStream(file);
        } 
        catch (FileNotFoundException ex) 
        {
            throw new ClassFileLoaderException(ex);
        }
        return new java.io.DataOutputStream(outputStream);
    }
}
