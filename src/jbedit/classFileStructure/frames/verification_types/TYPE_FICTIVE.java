
package jbedit.classFileStructure.frames.verification_types;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TYPE_FICTIVE extends AbstractTypeInfo
{

    @Override
    public int getTag()
    {
        return -1;
    }
    
    @Override
    public int getRealLength()
    {
        return -1;
    }

    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        //nope.
    }
    
}
