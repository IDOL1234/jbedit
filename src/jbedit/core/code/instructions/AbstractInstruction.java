
package jbedit.core.code.instructions;

import jbedit.core.code.MainStack;
import jbedit.core.constants.IConstant;

public abstract class AbstractInstruction
{
    public String getMnemonic()
    {
        return getClass().getSimpleName();
    }
    
    /**
     * Возвращает массив с элементами, которые инструкция добавит в стек.
     */
    
    /**
     * Возвращает массив с элементами, которые инструкция заберёт из стека.
     */
    public abstract IConstant[] getPositiveReaction(MainStack stack);
    
    public abstract IConstant[] getNegativeReaction(MainStack stack);
    
    public abstract boolean isValidStack(MainStack stack);
}
