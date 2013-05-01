
package jbedit.classFileStructure.frames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.frames.verification_types.AbstractTypeInfo;
import jbedit.classFileStructure.frames.verification_types.TypeInfoLoader;
import jbedit.classFileStructure.frames.verification_types.TypeInfoSaver;

public class same_locals_1_stack_item_frame_extended extends AbstractStackMapFrame
{
    private int frame_type;
    private int offset_delta; //(short)
    private LinkedList<AbstractTypeInfo> stack;
    
    @Override
    public int getFrame_type()
    {
        return frame_type;
    }

    @Override
    public void setFrame_type(int frame_type) throws FrameException 
    {
        if (frame_type != 247)
            throw new FrameException("Недопустимый тег фрейма: " + frame_type);
        this.frame_type = frame_type;
    }
    
    public LinkedList<AbstractTypeInfo> getStack()
    {
        return stack;
    }

    public void setStack(LinkedList<AbstractTypeInfo> stack) throws FrameException
    {
        if (stack.size() != 1)
            throw new FrameException("Неверная размерность.");
        this.stack = stack;
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
        for (int i = 0; i < stack.size(); i++)
        {
            result += stack.get(i).getRealLength();
        }
        return result;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        offset_delta = mainInput.readUnsignedShort();
        stack = TypeInfoLoader.loadElements(mainInput, 1);
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(frame_type);
        mainOutput.writeShort(offset_delta);
        TypeInfoSaver.saveElements(stack, mainOutput);
    }
}
