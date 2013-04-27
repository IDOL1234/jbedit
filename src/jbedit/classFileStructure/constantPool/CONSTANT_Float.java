
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_Float extends CONSTANTPoolElement
{
    private int bytes;

    public int getBytes() 
    {
        return bytes;
    }

    public void setBytes(int bytes) 
    {
        this.bytes = bytes;
    }

    @Override
    public int getTag() 
    {
        return 4;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException 
    {
        bytes = mainInput.readInt();   
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeInt(bytes);
    }
}
