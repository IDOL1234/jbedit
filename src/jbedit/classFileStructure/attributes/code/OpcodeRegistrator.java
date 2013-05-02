
package jbedit.classFileStructure.attributes.code;

import java.util.concurrent.atomic.AtomicBoolean;

public class OpcodeRegistrator
{
    private static AtomicBoolean inited = new AtomicBoolean(false);
    private static Class codes[] = new Class[256];
    private static void init()
    {
        if (inited.getAndSet(true))
            return;
        
        
      
    }
    
    private static void registerCommand (Class command, int opcode)
    {
        if (codes[opcode] == null)
        {
            codes[opcode] = command;
        }
        else
        {
            throw new IllegalStateException("Конфликт кодов операций: ячейка " + opcode + 
                    " уже занята командой" + codes[opcode].getSimpleName());
        }
    }
    
    public static AbstractCommand getByOpcode(int code) throws InstantiationException, IllegalAccessException
    {
        init();
        
        Class clazz = codes[code];
        if (clazz == null)
            throw new IllegalArgumentException("Несуществующий или недопустимый опкод.");
        return (AbstractCommand)clazz.newInstance();
    }
    
}
