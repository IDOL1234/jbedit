/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jbedit.classFileStructure.attributes.code;

import jbedit.classFileStructure.attributes.code.constants.AbstractConstant;
import jbedit.classFileStructure.attributes.code.constants.Cinteger;
import jbedit.classFileStructure.attributes.code.constants.Crefrence;


public class aaload extends AbstractCommand
{
    @Override
    public int getTag()
    {
        return 50;
    }
    
    @Override
    public AbstractConstant[] getPositiveReaction(MainStack stack)
    {
        AbstractConstant result[] = new AbstractConstant[2];
        result[0] = new Cinteger();
        result[1] = new Crefrence();
        return result;
    }

    @Override
    public AbstractConstant[] getNegativeReaction(MainStack stack)
    {
        AbstractConstant result[] = new AbstractConstant[1];
        result[0] = new Crefrence();
        return result;
    }

    @Override
    public void selfLoad()
    {
        
    }
    
}
