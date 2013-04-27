
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class CONSTANTPoolElement 
{
    private int number;

    
    public abstract int getTag();
    public abstract void selfLoad(DataInputStream mainInput) throws IOException;
    public abstract void selfSave(DataOutputStream mainOutput) throws IOException;

    public int getNumber() 
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }
}
