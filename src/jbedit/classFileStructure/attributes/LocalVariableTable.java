
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class LocalVariableTable extends AbstractAttribute
{
    private int local_variable_table_length; //(short)
    private LinkedList<LocalVariableTableElement> local_variable_table;

    public int getLocal_variable_table_length()
    {
        return local_variable_table_length;
    }

    public void setLocal_variable_table_length(int local_variable_table_length)
    {
        this.local_variable_table_length = local_variable_table_length;
    }

    public LinkedList<LocalVariableTableElement> getLocal_variable_table()
    {
        return local_variable_table;
    }

    public void setLocal_variable_table(LinkedList<LocalVariableTableElement> local_variable_table)
    {
        this.local_variable_table = local_variable_table;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2;
        for (int i = 0; i < local_variable_table_length; i++)
        {
            result += local_variable_table.get(i).getRealLength();
        }
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
        local_variable_table_length = mainInput.readUnsignedShort();
        local_variable_table = new LinkedList<LocalVariableTableElement>();
        for (int i = 0; i < local_variable_table_length; i++)
        {
            local_variable_table.add(new LocalVariableTableElement());
            local_variable_table.get(i).selfLoad(mainInput, pool);
        }
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(local_variable_table_length);
        for (int i = 0; i < local_variable_table_length; i++)
        {
            local_variable_table.get(i).selfSave(mainOutput);
        }
    }
        
    
    
    public class LocalVariableTableElement
    {
        public int start_pc; //(short)
        public int length; //(short)
        public int name_index; //(short)
        public int descriptor_index; //(short)
        public int index; //(short)
        
        public int getRealLength()
        {
            int result = 2 * 5;
            return result;
        }
        
        public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException
        {
            start_pc = mainInput.readUnsignedShort();
            length = mainInput.readUnsignedShort();
            name_index = mainInput.readUnsignedShort();
            descriptor_index = mainInput.readUnsignedShort();
            index = mainInput.readUnsignedShort();
        }
        public void selfSave(DataOutputStream mainOutput) throws IOException
        {
            mainOutput.writeShort(start_pc);
            mainOutput.writeShort(length);
            mainOutput.writeShort(name_index);
            mainOutput.writeShort(descriptor_index);
            mainOutput.writeShort(index);
        }
    }
}
