
package jbedit.classFileStructure.frames.verification_types;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Null_variable_info extends AbstractTypeInfo
{
    @Override
    public int getTag()
    {
        return 5;
    }
    
    @Override
    public int getRealLength()
    {
        return getHeaderSize();
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
    }   
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
    }
}
