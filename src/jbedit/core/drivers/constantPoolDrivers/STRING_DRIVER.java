
package jbedit.core.drivers.constantPoolDrivers;

import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_String;
import jbedit.classFileStructure.constantPool.CONSTANT_Utf8;

public class STRING_DRIVER
{
    /**
     * Возвращает содержимое UTF8, связанной со строкой. 
     */
    public static String getString(CONSTANT_String cnst, CONSTANTPoolElement pool[])
    {
        CONSTANT_Utf8 utf = CONSTANT_POOL_DRIVER.getUtf8Value(cnst.getString_index(), pool);
        return utf.getString();
    }
    
    /**
     * На изменяемую константу могут ссылаться другие объекты! Необходимо использовать с осторожностью.
     */
    public static void unsafeSetString(CONSTANT_String cnst, String str, CONSTANTPoolElement pool[])
    {  
        CONSTANT_Utf8 utf = CONSTANT_POOL_DRIVER.getUtf8Value(cnst.getString_index(), pool);
        UTF8_DRIVER.setString(utf, str, pool);
    }
}
