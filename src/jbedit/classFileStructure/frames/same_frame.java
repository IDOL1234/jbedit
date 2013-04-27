
package jbedit.classFileStructure.frames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class same_frame extends AbstractStackMapFrame
{
    private int frame_type;

    @Override
    public int getFrame_type() 
    {
        return frame_type;
    }
    
    @Override
    public void setFrame_type(int frame_type) throws FrameException 
    {
        if (frame_type < 0 || frame_type > 63)
            throw new FrameException("Недопустимый тег фрейма: " + frame_type);
        this.frame_type = frame_type;
    }

    @Override
    public int getRealLength()
    {
        int result = 1;
        return result;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
    }

    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(frame_type);
    }
}
