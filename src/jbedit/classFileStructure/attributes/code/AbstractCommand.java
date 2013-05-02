
package jbedit.classFileStructure.attributes.code;

import jbedit.classFileStructure.attributes.code.constants.AbstractConstant;

public abstract class AbstractCommand
{
    /**
     * Возвращает список операндов, добавляемых на стека, начиная с 0 элемента.
     */
    public abstract AbstractConstant[] getPositiveReaction(MainStack stack);
    
    /**
     * Возвращает список операндов, забираемых со стека, начиная с 0 элемента.
     */
    public abstract AbstractConstant[] getNegativeReaction(MainStack stack);
    
    public boolean checkStack(MainStack stack)
    {
        
        return false;
    };
}
