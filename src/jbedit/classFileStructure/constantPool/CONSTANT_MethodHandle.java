
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_MethodHandle extends CONSTANTPoolElement
{
    private int refrence_kind; // 1..9 (byte)
    private int refrence_index; // тип зависит от refrence_kind (short)

    public int getRefrence_kind() 
    {
        return refrence_kind;
    }

    public void setRefrence_kind(int refrence_kind) 
    {
        this.refrence_kind = refrence_kind;
    }

    public int getRefrence_index() 
    {
        return refrence_index;
    }

    public void setRefrence_index(int refrence_index) 
    {
        this.refrence_index = refrence_index;
    }

    @Override
    public int getTag() 
    {
        return 15;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException 
    {
        refrence_kind = mainInput.readUnsignedByte();   
        refrence_index = mainInput.readUnsignedShort();   
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
        mainOutput.writeByte(refrence_kind);
        mainOutput.writeShort(refrence_index);
    }
}
