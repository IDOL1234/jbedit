
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PoolElementSaver
{
    public static void saveElements(CONSTANTPoolElement[] pool, DataOutputStream mainOutput) throws IOException // Возвращает пул констант
    {
        for (int i = 1; i < pool.length; i++)  // 1 взято из спецификации
        {
            pool[i].selfSave(mainOutput);
        }
    }
}
