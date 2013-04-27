
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class Exceptions extends AbstractAttribute
{
    private int number_of_exceptions; //(short)
    private int exception_index_table[]; //(short)

    public int getNumber_of_exceptions()
    {
        return number_of_exceptions;
    }

    public void setNumber_of_exceptions(int number_of_exceptions)
    {
        this.number_of_exceptions = number_of_exceptions;
    }

    public int[] getException_index_table()
    {
        return exception_index_table;
    }

    public void setException_index_table(int[] exception_index_table)
    {
        this.exception_index_table = exception_index_table;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2; //number_of_exceptions
        result += number_of_exceptions * 2; //exception_index_table[]
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, CONSTANTPoolElement pool[]) throws IOException
    {
        number_of_exceptions = mainInput.readUnsignedShort();
        exception_index_table = new int[number_of_exceptions];
        
        for (int i = 0; i < number_of_exceptions; i++)
        {
            exception_index_table[i] = mainInput.readUnsignedShort();
        }
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(number_of_exceptions);
        for (int i = 0; i < number_of_exceptions; i++)
        {
            mainOutput.writeShort(exception_index_table[i]);
        }
    }
}
