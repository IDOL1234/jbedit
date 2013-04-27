
package jbedit.core.drivers.constantPoolDrivers;

import jbedit.classFileStructure.constantPool.CONSTANT_Float;



public class FLOAT_DRIVER
{
    public static Float getFloatValue(CONSTANT_Float cnst)
    {
        return Float.intBitsToFloat(cnst.getBytes());
    }
    
    public static void setFloatValue(CONSTANT_Float cnst, int num)
    {
        cnst.setBytes(Float.floatToIntBits(num));
    }
}
