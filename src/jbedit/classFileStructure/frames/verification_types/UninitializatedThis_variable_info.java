
package jbedit.classFileStructure.frames.verification_types;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UninitializatedThis_variable_info extends AbstractTypeInfo
{
    @Override
    public int getTag()
    {
        return 6;
    }
    
    @Override
    public int getRealLength()
    {
        return getHeaderSize();
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        //Здесь нет пасхальных яиц. Честное слово.
    } 
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(getTag());
    }
}
