
package jbedit.core.drivers.constantPoolDrivers;

import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_Utf8;

public class UTF8_DRIVER
{
    public static String getString(CONSTANT_Utf8 utf, CONSTANTPoolElement pool[])
    {
        return utf.getString();
    }
    
    public static void setString(CONSTANT_Utf8 utf, String str, CONSTANTPoolElement pool[])
    {
        utf.setLength(str.length());
        utf.setString(str);
    }
}
