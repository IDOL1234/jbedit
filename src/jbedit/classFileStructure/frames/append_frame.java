
package jbedit.classFileStructure.frames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.frames.verification_types.AbstractTypeInfo;
import jbedit.classFileStructure.frames.verification_types.TypeInfoLoader;
import jbedit.classFileStructure.frames.verification_types.TypeInfoSaver;

public class append_frame extends AbstractStackMapFrame
{
    private int frame_type; // byte
    private int offset_delta; //(short)
    private LinkedList<AbstractTypeInfo> locals;

    @Override
    public int getFrame_type()
    {
        return frame_type;
    }

    @Override
    public void setFrame_type(int frame_type) throws FrameException 
    {
        if (frame_type < 252 || frame_type > 254)
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
    
    public LinkedList<AbstractTypeInfo> getLocals()
    {
        return locals;
    }

    public void setLocals(LinkedList<AbstractTypeInfo> locals) throws FrameException
    {
        if (locals.size() != frame_type - 251)
            throw new FrameException("Неверная размерность");
        this.locals = locals;
    }
    
    @Override
    public int getRealLength()
    {
        int result = 1;
        result += 2;
        for (int i = 0; i < frame_type - 251; i++)
        {
            result += locals.get(i).getRealLength();
        }
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        offset_delta = mainInput.readUnsignedShort();
        locals = TypeInfoLoader.loadElements(mainInput, frame_type - 251);
    } 
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(frame_type);
        mainOutput.writeShort(offset_delta);
        TypeInfoSaver.saveElements(locals, mainOutput);
    }
}
