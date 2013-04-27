
package jbedit.classFileStructure.frames.verification_types;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class AbstractTypeInfo 
{
    public abstract int getTag();
    
    public abstract int getRealLength();
    
    protected int getHeaderSize()
    {
        return 1; // sizeof(type)
    };
    
    public abstract void selfLoad(DataInputStream mainInput) throws IOException;
    
    public abstract void selfSave(DataOutputStream mainOutput) throws IOException;
}
