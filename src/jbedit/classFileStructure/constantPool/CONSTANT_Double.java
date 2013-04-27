
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_Double extends CONSTANTPoolElement
{
    private int high_bytes;
    private int low_bytes;

    public long getHigh_bytes() 
    {
        return high_bytes;
    }

    public void setHigh_bytes(int high_bytes) 
    {
        this.high_bytes = high_bytes;
    }
 
    public long getLow_bytes() 
    {
        return low_bytes;
    }

    public void setLow_bytes(int low_bytes) 
    {
        this.low_bytes = low_bytes;
    }

    @Override
    public int getTag() 
    {
        return 6;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException 
    {
        high_bytes = mainInput.readInt();
        low_bytes = mainInput.readInt();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeInt(high_bytes);
        mainOutput.writeInt(low_bytes);
    }
}
