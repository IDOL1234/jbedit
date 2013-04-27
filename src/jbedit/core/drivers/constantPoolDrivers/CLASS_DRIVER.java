
package jbedit.core.drivers.constantPoolDrivers;

import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_Class;
import jbedit.classFileStructure.constantPool.CONSTANT_Utf8;

public class CLASS_DRIVER
{
    public static String getClassName(CONSTANT_Class cnst, CONSTANTPoolElement pool[])
    {
        CONSTANT_Utf8 utf = CONSTANT_POOL_DRIVER.getUtf8Value(cnst.getName_index(), pool);
        return utf.getString();
    }
}
