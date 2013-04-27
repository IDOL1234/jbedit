
package jbedit.core.drivers.constantPoolDrivers;

import jbedit.classFileStructure.constantPool.CONSTANT_Long;

public class LONG_DRIVER
{
    public static long getLongValue(CONSTANT_Long cnst)
    {
        return cnst.getLow_bytes() + ((long)cnst.getHigh_bytes() << 32);
    }
    
    public static void setLongValue(CONSTANT_Long cnst, long num)
    {
        int low = 0;
        int high = 0;
        
        low = (int) (num & 0x00000000ffffffff);
        high = (int) (num >> 32);
        
        cnst.setLow_bytes(low);
        cnst.setHigh_bytes(high);
    }
}
