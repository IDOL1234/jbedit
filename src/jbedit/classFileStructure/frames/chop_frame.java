
package jbedit.classFileStructure.frames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class chop_frame extends AbstractStackMapFrame
{
    private int frame_type;
    private int offset_delta; //(short)

    @Override
    public int getFrame_type()
    {
        return frame_type;
    }

    @Override
    public void setFrame_type(int frame_type) throws FrameException 
    {
        if (frame_type < 248 || frame_type > 250)
            throw new FrameException("Недопустимый тег фрейма: " + frame_type);
        this.frame_type = frame_type;
    }

    public int getOffset_delta()
    {
        return offset_delta;
    }

    public void setOffset_delta(int offset_delta)
    {
        this.offset_delta = offset_delta;
    }
    
    @Override
    public int getRealLength()
    {
        int result = 1;
        result += 2;
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        offset_delta = mainInput.readUnsignedShort();
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(frame_type);
        mainOutput.writeShort(offset_delta);
    }
}
