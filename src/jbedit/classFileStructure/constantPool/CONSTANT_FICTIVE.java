
package jbedit.classFileStructure.constantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CONSTANT_FICTIVE extends CONSTANTPoolElement
{

    @Override
    public int getTag()
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
        
    }
    
}
