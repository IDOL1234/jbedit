
package jbedit.core.drivers.constantPoolDrivers;

import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_InterfaceMethodref;
import jbedit.classFileStructure.constantPool.CONSTANT_MethodHandle;
import jbedit.classFileStructure.constantPool.CONSTANT_Methodref;
import jbedit.classFileStructure.constantPool.CONSTANT_fieldRef;

public class METHODHANDLE_DRIVER
{
    @Deprecated
    public static String getClassName(CONSTANT_MethodHandle cnst, CONSTANTPoolElement pool[])
    {
        CONSTANTPoolElement attr = CONSTANT_POOL_DRIVER.getRawValue(cnst.getRefrence_index(), pool);
        if (cnst.getRefrence_kind() < 5)
        {
            CONSTANT_fieldRef fattr;
        }
        else if (cnst.getRefrence_kind() >= 5 && cnst.getRefrence_kind() < 9)
        {
            CONSTANT_Methodref mattr;
        }
        else
        {
            CONSTANT_InterfaceMethodref iattr = (CONSTANT_InterfaceMethodref)attr;
            return INTERFACEMETHODREF_DRIVER.getClassName(iattr, pool);
        }
        
        return null;
    }
}
