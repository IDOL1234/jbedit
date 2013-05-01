
package jbedit.core.drivers.constantPoolDrivers;

import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_Class;
import jbedit.classFileStructure.constantPool.CONSTANT_InterfaceMethodref;
import jbedit.classFileStructure.constantPool.CONSTANT_NameAndType;

public class INTERFACEMETHODREF_DRIVER
{
    public static String getClassName(CONSTANT_InterfaceMethodref cnst, 
            LinkedList<CONSTANTPoolElement> pool)
    {
        CONSTANT_Class clss = CONSTANT_POOL_DRIVER.getClassValue(cnst.getClass_index(), pool);
        return CLASS_DRIVER.getClassName(clss, pool);
    }
    
    public static String getName(CONSTANT_InterfaceMethodref cnst, LinkedList<CONSTANTPoolElement> pool)
    {
        CONSTANT_NameAndType nat = CONSTANT_POOL_DRIVER.getNameAndTypeValue(cnst.getName_and_type_index(), pool);
        return NAMEANDTYPE_DRIVER.getClassName(nat, pool);
    }
    
    public static String getClass(CONSTANT_InterfaceMethodref cnst, LinkedList<CONSTANTPoolElement> pool)
    {
        CONSTANT_NameAndType nat = CONSTANT_POOL_DRIVER.getNameAndTypeValue(cnst.getName_and_type_index(), pool);
        return NAMEANDTYPE_DRIVER.getDescriptor(nat, pool);
    }
    
    
}
