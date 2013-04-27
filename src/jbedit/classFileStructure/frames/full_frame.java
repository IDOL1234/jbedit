
package jbedit.classFileStructure.frames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.frames.verification_types.AbstractTypeInfo;
import jbedit.classFileStructure.frames.verification_types.TypeInfoLoader;
import jbedit.classFileStructure.frames.verification_types.TypeInfoSaver;

public class full_frame extends AbstractStackMapFrame
{
    private int frame_type;
    private int offset_delta; //(short)
    private int number_of_locals; //(short)
    private AbstractTypeInfo locals[];
    private int number_of_stack_item; //(short)
    private AbstractTypeInfo stack[];

    @Override
    public int getFrame_type()
    {
        return frame_type;
    }

    @Override
    public void setFrame_type(int frame_type) throws FrameException 
    {
        if (frame_type != 255)
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

    public int getNumber_of_locals()
    {
        return number_of_locals;
    }

    public void setNumber_of_locals(int number_of_locals)
    {
        this.number_of_locals = number_of_locals;
    }

    public AbstractTypeInfo[] getLocals()
    {
        return locals;
    }

    public void setLocals(AbstractTypeInfo[] locals)
    {
        this.locals = locals;
    }

    public int getNumber_of_stack_item()
    {
        return number_of_stack_item;
    }

    public void setNumber_of_stack_item(int number_of_stack_item)
    {
        this.number_of_stack_item = number_of_stack_item;
    }

    public AbstractTypeInfo[] getStack()
    {
        return stack;
    }

    public void setStack(AbstractTypeInfo[] stack)
    {
        this.stack = stack;
    }
    
    @Override
    public int getRealLength()
    {
        int result = 1;
        result += 2;
        result += 2;
        for (int i = 0; i < number_of_locals; i++)
        {
            result += locals[i].getRealLength();
        }
        result += 2;
        for (int i = 0; i < number_of_stack_item; i++)
        {
            result += stack[i].getRealLength();
        }
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        offset_delta = mainInput.readUnsignedShort();
        number_of_locals = mainInput.readUnsignedShort();
        locals = TypeInfoLoader.loadElements(mainInput, number_of_locals);
        number_of_stack_item = mainInput.readUnsignedShort();
        stack = TypeInfoLoader.loadElements(mainInput, number_of_stack_item);
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeByte(frame_type);
        mainOutput.writeShort(offset_delta);
        mainOutput.writeShort(number_of_locals);
        TypeInfoSaver.saveElements(locals, mainOutput);
        mainOutput.writeShort(number_of_stack_item);
        TypeInfoSaver.saveElements(stack, mainOutput);
    }
            
}
