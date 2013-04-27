
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class LocalVariableTypeTable extends AbstractAttribute
{
    private short local_variable_type_table_length;
    private LocalVariableTypeTableElement local_variable_type_table[];

    public short getLocal_variable_type_table_length()
    {
        return local_variable_type_table_length;
    }

    public void setLocal_variable_type_table_length(short local_variable_type_table_length)
    {
        this.local_variable_type_table_length = local_variable_type_table_length;
    }

    public LocalVariableTypeTableElement[] getLocal_variable_type_table()
    {
        return local_variable_type_table;
    }

    public void setLocal_variable_type_table(LocalVariableTypeTableElement[] local_variable_type_table)
    {
        this.local_variable_type_table = local_variable_type_table;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2;
        for (int i = 0; i < local_variable_type_table_length; i++)
        {
            result += local_variable_type_table[i].getRealLength();
        }
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, CONSTANTPoolElement pool[]) throws IOException, FrameException
    {
        local_variable_type_table_length = mainInput.readShort();
        local_variable_type_table = new LocalVariableTypeTableElement[local_variable_type_table_length];
        for (int i = 0; i < local_variable_type_table_length; i++)
        {
            local_variable_type_table[i] = new LocalVariableTypeTableElement();
            local_variable_type_table[i].selfLoad(mainInput, pool);
        }
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(local_variable_type_table_length);
        for (int i = 0; i < local_variable_type_table_length; i++)
        {
            local_variable_type_table[i].selfSave(mainOutput);
        }
    }
    
    
    public class LocalVariableTypeTableElement
    {
        public int start_pc; //(short)
        public int length; //(short)
        public int name_index; //(short)
        public int signature_index; //(short)
        public int index; //(short)
        

        public int getRealLength()
        {
            int result = 2 * 5;
            return result;
        }
        
        public void selfLoad(DataInputStream mainInput, CONSTANTPoolElement pool[]) throws IOException
        {
            start_pc = mainInput.readUnsignedShort();
            length = mainInput.readUnsignedShort();
            name_index = mainInput.readUnsignedShort();
            signature_index = mainInput.readUnsignedShort();
            index = mainInput.readUnsignedShort();
        }
        
        public void selfSave(DataOutputStream mainOutput) throws IOException
        {
            mainOutput.writeShort(start_pc);
            mainOutput.writeShort(length);
            mainOutput.writeShort(name_index);
            mainOutput.writeShort(signature_index);
            mainOutput.writeShort(index);
        }
    }
}
