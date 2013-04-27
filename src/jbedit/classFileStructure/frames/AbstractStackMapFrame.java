
package jbedit.classFileStructure.frames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class AbstractStackMapFrame 
{
    public abstract void setFrame_type(int frame_type) throws FrameException;
    public abstract int getFrame_type();
    public abstract void selfLoad(DataInputStream mainInput) throws IOException;
    public abstract void selfSave(DataOutputStream mainOutput) throws IOException;
    public abstract int getRealLength();
}
