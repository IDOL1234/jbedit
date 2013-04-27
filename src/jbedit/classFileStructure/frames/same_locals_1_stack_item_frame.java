
package jbedit.classFileStructure.frames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.frames.verification_types.AbstractTypeInfo;
import jbedit.classFileStructure.frames.verification_types.TypeInfoLoader;
import jbedit.classFileStructure.frames.verification_types.TypeInfoSaver;

public class same_locals_1_stack_item_frame extends AbstractStackMapFrame
{
    private int frame_type; //(byte)
    private AbstractTypeInfo stack[];

    @Override
    public int getFrame_type() 
    {
        return frame_type;
    }

    @Override
    public void setFrame_type(int frame_type) throws FrameException 
    {
        if (frame_type < 64 || frame_type > 127)
            throw new FrameException("Недопустимый тег фрейма: " + frame_type);
        this.frame_type = frame_type;
    }
    
    public AbstractTypeInfo[] getStack()
    {
        return stack;
    }

    public void setStack(AbstractTypeInfo[] stack) throws FrameException
    {
        if (stack.length != 1)
            throw new FrameException("Неверная размерность.");
        this.stack = stack;
    }
    
    @Override
    public int getRealLength()
    {
        int result = 1;
        for (int i = 0; i < stack.length; i++)
        {
            result += stack[i].getRealLength();
        }
        return result;
    }


    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        stack = TypeInfoLoader.loadElements(mainInput, 1);
    }   
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(frame_type);
        TypeInfoSaver.saveElements(stack, mainOutput);
    }
}
