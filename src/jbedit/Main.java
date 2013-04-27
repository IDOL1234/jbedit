
package jbedit;

import jbedit.classFileStructure.ClassFileLoaderException;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_Integer;
import jbedit.classFileStructure.frames.FrameException;
import jbedit.core.code.instructions.AbstractInstruction;
import jbedit.core.code.instructions.aaload;
import jbedit.core.drivers.constantPoolDrivers.CONSTANT_POOL_DRIVER;

public class Main 
{
    
    public static void main(String[] args) throws ClassFileLoaderException, FrameException
    {
        //System.setProperty("debug", "true");
        
        
        AbstractInstruction a = new aaload();
        System.out.println(a.getMnemonic());
        
        //ClassFile clazz = null;
        
        //clazz = ClassFileLoader.Load("c:/main.class");
        
        //ClassFileSaver.Save(clazz, "c:/TESTIFICATE.class", true);
        System.out.println("done");
    }
    
}