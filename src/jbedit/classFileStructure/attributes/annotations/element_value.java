/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class element_value
{
    private int tag; //(byte)

    public int getTag()
    {
        return tag;
    }

    public void setTag(int tag)
    {
        this.tag = tag;
    }

    public int getHeaderSize()
    {
        return 1;
    };

    public abstract int getRealLength();
    
    public abstract void selfLoad(DataInputStream mainInput) throws IOException;
    
    public abstract void selfSave(DataOutputStream mainOutput) throws IOException;
}