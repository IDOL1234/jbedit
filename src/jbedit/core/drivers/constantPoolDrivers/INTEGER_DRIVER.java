
package jbedit.core.drivers.constantPoolDrivers;

import jbedit.classFileStructure.constantPool.CONSTANT_Float;

public class INTEGER_DRIVER
{
    public static int getIntegerValue(CONSTANT_Float cnst)
    {
        return cnst.getBytes();
    }
    
    public static void setIntegerValue(CONSTANT_Float cnst, int num)
    {
        cnst.setBytes(num);
    }
}
