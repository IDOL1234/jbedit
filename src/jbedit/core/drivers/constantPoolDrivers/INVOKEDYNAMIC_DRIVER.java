
package jbedit.core.drivers.constantPoolDrivers;

import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_InvokeDynamic;
import jbedit.classFileStructure.constantPool.CONSTANT_NameAndType;

public class INVOKEDYNAMIC_DRIVER
{
    public static String getName(CONSTANT_InvokeDynamic cnst, LinkedList<CONSTANTPoolElement> pool)
    {
        CONSTANT_NameAndType nat = CONSTANT_POOL_DRIVER.getNameAndTypeValue(cnst.getName_and_type_index(), pool);
        return NAMEANDTYPE_DRIVER.getClassName(nat, pool);
    }
    
    public static String getType(CONSTANT_InvokeDynamic cnst, LinkedList<CONSTANTPoolElement> pool)
    {
        CONSTANT_NameAndType nat = CONSTANT_POOL_DRIVER.getNameAndTypeValue(cnst.getName_and_type_index(), pool);
        return NAMEANDTYPE_DRIVER.getDescriptor(nat, pool);
    }
}
