
package jbedit;

import jbedit.classFileStructure.ClassFile;
import jbedit.classFileStructure.ClassFileLoader;
import jbedit.classFileStructure.ClassFileLoaderException;
import jbedit.classFileStructure.ClassFileSaver;
import jbedit.classFileStructure.frames.FrameException;

public class Main 
{
    
    public static void main(String[] args) throws ClassFileLoaderException, FrameException
    {
        System.setProperty("debug", "true");    
        
        ClassFile clazz = null;
        
        clazz = ClassFileLoader.Load("c:/abb.class");
        
        ClassFileSaver.Save(clazz, "c:/TESTIFICATE.class", true);
        
        System.out.println("done");
    }
    
}