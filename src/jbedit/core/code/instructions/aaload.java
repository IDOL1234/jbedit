/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jbedit.core.code.instructions;

import jbedit.core.code.MainStack;
import jbedit.core.constants.IArrayRefrence;
import jbedit.core.constants.IConstant;
import jbedit.core.constants.IInteger;


public class aaload extends AbstractInstruction
{

    @Override
    public IConstant[] getPositiveReaction(MainStack stack)
    {
        return null;
    }

    @Override
    public IConstant[] getNegativeReaction(MainStack stack)
    {
        IConstant[] result = new IConstant[2];
        result[0] = new IArrayRefrence();
        result[1] = new IInteger();
        return result;
    }

    @Override
    public boolean isValidStack(MainStack stack)
    {
        return false;
    }
    
}
