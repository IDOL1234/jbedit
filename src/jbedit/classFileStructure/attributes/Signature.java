
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class Signature extends AbstractAttribute
{
    private int signature_index; //(short)

    public int getSignature_index()
    {
        return signature_index;
    }

    public void setSignature_index(int signature_index)
    {
        this.signature_index = signature_index;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2;
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, CONSTANTPoolElement pool[]) throws IOException, FrameException
    {
        signature_index = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(signature_index);
    }
    
}
