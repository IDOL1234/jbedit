
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class PoolElementSaver
{
    public static void saveElements(LinkedList<CONSTANTPoolElement> pool, DataOutputStream mainOutput) throws IOException // Возвращает пул констант
    {
        for (int i = 1; i < pool.size(); i++)  // 1 взято из спецификации
        {
            pool.get(i).selfSave(mainOutput);
        }
    }
}
