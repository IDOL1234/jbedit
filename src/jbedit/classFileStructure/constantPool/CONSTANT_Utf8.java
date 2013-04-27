
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_Utf8 extends CONSTANTPoolElement
{
    private int length; // Длина строки (short)
    private int bytes[]; // строка (byte)

    public int getLength() 
    {
        return length;
    }

    public void setLength(int length) 
    {
        this.length = length;
    }

    public int[] getBytes() {
        return bytes;
    }
    
    public String getString()                                                   // UTF8 ONLY!!
    {                                                                           // fix me
        StringBuilder sb = new StringBuilder();
        for (int temp: bytes)
        {
            sb.append((char)temp);
        }
        return sb.toString();
    }
    
    public void setString(String str)
    {
        bytes = new int[str.length()];
        for (int i = 0; i < str.length(); i++)
        {
            bytes[i] = str.charAt(i);
        }
    }

    public void setBytes(int[] bytes) 
    {
        this.bytes = bytes;
    }
    
    @Override
    public int getTag() 
    {
        return 1;
    }

    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        this.length = mainInput.readUnsignedShort();
        this.bytes = new int[length];
        for (int i = 0; i < length; i++)
        {
            this.bytes[i] = mainInput.readUnsignedByte();
        }
        
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeShort(length);
        for (int i = 0; i < length; i++)
        {
            mainOutput.writeByte(bytes[i]);
        }
    }
}
