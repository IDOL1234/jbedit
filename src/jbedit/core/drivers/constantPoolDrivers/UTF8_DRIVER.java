
package jbedit.core.drivers.constantPoolDrivers;

import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_Utf8;

public class UTF8_DRIVER
{
    public static String getString(CONSTANT_Utf8 utf)
    {
        return utf.getString();
    }
    
    public static void setString(CONSTANT_Utf8 utf, String str)
    {
        utf.setLength(str.length());
        utf.setString(str);
    }
}
