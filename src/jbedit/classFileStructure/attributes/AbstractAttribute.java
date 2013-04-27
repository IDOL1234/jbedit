
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public abstract class AbstractAttribute 
{
    private int attribute_name_index; // utf8 (short)
    private int attribute_lenght; // не включает в себя эти 2 переменные

    public int getAttribute_name_index() 
    {
        return attribute_name_index;
    }

    public void setAttribute_name_index(int attribute_name_index) 
    {
        this.attribute_name_index = attribute_name_index;
    }

    public int getAttribute_lenght() 
    {
        return attribute_lenght;
    }
    
    public abstract int getRealLength(); // Необходимо переопределить.
    
    public int getRealInternalLength()
    {
        return getRealLength() - getHeaderSize();
    }

    protected int getHeaderSize()
    {
        return 2 + 4; // sizeof(attribute_name_index) + sizeof(attribute_lenght)
    }

    public void setAttribute_lenght(int attribute_lenght) 
    {
        this.attribute_lenght = attribute_lenght;
    }
    
    public abstract void selfLoad(DataInputStream mainInput, CONSTANTPoolElement pool[]) throws IOException, FrameException;
    
    public abstract void selfSave(DataOutputStream mainOutput) throws IOException, FrameException;

    
}
