
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class LineNumberTable extends AbstractAttribute
{
    private int line_number_table_length; //(short)
    private LinkedList<line_number_element> line_number_table;

    public int getLine_number_table_length()
    {
        return line_number_table_length;
    }

    public void setLine_number_table_length(int line_number_table_length)
    {
        this.line_number_table_length = line_number_table_length;
    }

    public LinkedList<line_number_element> getLine_number_table()
    {
        return line_number_table;
    }

    public void setLine_number_table(LinkedList<line_number_element> line_number_table)
    {
        this.line_number_table = line_number_table;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2;
        for (int i = 0; i < line_number_table_length; i++)
        {
            result += line_number_table.get(i).getRealLength();
        }
        return result;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
        line_number_table_length = mainInput.readUnsignedShort();
        line_number_table = new LinkedList<line_number_element>();
        for (int i = 0; i < line_number_table_length; i++)
        {
            line_number_table.add(new line_number_element());
            line_number_table.get(i).selfLoad(mainInput, pool);
        }
    }    
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(line_number_table_length);
        for (int i = 0; i < line_number_table_length; i++)
        {
            line_number_table.get(i).selfSave(mainOutput);
        }
    }
    
    public class line_number_element
    {
        public int start_pc; //(short)
        public int line_number; //(short)
        
        public int getRealLength()
        {
            int result = 2 + 2;
            return result;
        }
        
        public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException
        {
            start_pc = mainInput.readUnsignedShort();
            line_number = mainInput.readUnsignedShort();
        }
        
        public void selfSave(DataOutputStream mainOutput) throws IOException
        {
            mainOutput.writeShort(start_pc);
            mainOutput.writeShort(line_number);
        }
    }

    
}
