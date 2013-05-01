
package jbedit.core.drivers.constantPoolDrivers;

import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_NameAndType;

public class NAMEANDTYPE_DRIVER
{
    public static String getClassName(CONSTANT_NameAndType cnst, LinkedList<CONSTANTPoolElement> pool)
    {
        return CONSTANT_POOL_DRIVER.getUtf8Value(cnst.getName_index(), pool).getString();
    }
    
    public static String getDescriptor(CONSTANT_NameAndType cnst, LinkedList<CONSTANTPoolElement> pool)
    {
        return CONSTANT_POOL_DRIVER.getUtf8Value(cnst.getDescriptor_index(), pool).getString();
    }
    
    
}
