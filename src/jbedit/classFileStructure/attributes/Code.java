
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class Code extends AbstractAttribute
{
    private int max_stack; //(short)
    private int max_locals;//(short)
    private int code_length;
    private LinkedList<Integer> code;//(byte)
    private int exceptions_table_length;//(short)
    private LinkedList<exception_table_element> exception_table;
    private int attributes_count;//(short)
    private LinkedList<AbstractAttribute> attributes;

    public int getMax_stack() 
    {
        return max_stack;
    }

    public void setMax_stack(int max_stack) 
    {
        this.max_stack = max_stack;
    }

    public int getMax_locals() 
    {
        return max_locals;
    }

    public void setMax_locals(int max_locals) 
    {
        this.max_locals = max_locals;
    }

    public int getCode_length() 
    {
        return code_length;
    }

    public void setCode_length(int code_length) 
    {
        this.code_length = code_length;
    }

    public LinkedList<Integer> getCode() 
    {
        return code;
    }

    public void setCode(LinkedList<Integer> code) 
    {
        this.code = code;
    }

    public int getExceptions_table_length() 
    {
        return exceptions_table_length;
    }

    public void setExceptions_table_length(int exceptions_table_length) 
    {
        this.exceptions_table_length = exceptions_table_length;
    }

    public LinkedList<exception_table_element> getException_table() 
    {
        return exception_table;
    }

    public void setException_table(LinkedList<exception_table_element> exception_table) 
    {
        this.exception_table = exception_table;
    }

    public int getAttributes_count() 
    {
        return attributes_count;
    }

    public void setAttributes_count(int attributes_count) 
    {
        this.attributes_count = attributes_count;
    }

    public LinkedList<AbstractAttribute> getAttributes() 
    {
        return attributes;
    }

    public void setAttributes(LinkedList<AbstractAttribute> attributes) 
    {
        this.attributes = attributes;
    }

    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2; //max_stack
        result += 2; //max_locals
        result += 4; //code_length
        result += code_length * 1; //code[]
        result += 2; //exceptions_table_length
        for (int i = 0; i < exceptions_table_length; i++)
        {
            result += exception_table.get(i).getRealLength();
        }
        result += 2; //attributes_count
        for (int i = 0; i < attributes_count; i++) //attributes[]
        {
            result += attributes.get(i).getRealLength();
        }
        
        return result;
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
        max_stack = mainInput.readUnsignedShort();
        max_locals = mainInput.readUnsignedShort();
        code_length = mainInput.readInt();
        code = new LinkedList<Integer>();
        
        //mainInput.read(code);
        for (int i = 0; i < code_length; i++)
        {
            code.add(mainInput.readUnsignedByte());
        }
        
        exceptions_table_length = mainInput.readUnsignedShort();
        exception_table = new LinkedList<exception_table_element>();
        for (int i = 0; i < exceptions_table_length; i++)
        {
            exception_table.add(new exception_table_element());
            exception_table.get(i).selfLoad(mainInput);
        }
        attributes_count = mainInput.readUnsignedShort();
        attributes = AttributeLoader.loadElements(mainInput, pool, attributes_count);
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException, FrameException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(max_stack);
        mainOutput.writeShort(max_locals);
        mainOutput.writeInt(code_length);
        
        for (int i = 0; i < code_length; i++)
        {
            mainOutput.writeByte(code.get(i));
        }
        
        mainOutput.writeShort(exceptions_table_length);
        for (int i = 0; i < exceptions_table_length; i++)
        {
            exception_table.get(i).selfSave(mainOutput);
        }
        mainOutput.writeShort(attributes_count);
        AttributeSaver.saveElements(attributes, mainOutput);
        
        
    }
    
    
    public class exception_table_element
    {
        public int start_pc; //(short)
        public int end_pc; //(short)
        public int handler_pc; //(short)
        public int catch_type; //(short)
        
        public int getRealLength()
        {
            return 2 + 2 + 2 + 2;
        }
        
        public void selfLoad(DataInputStream mainInput) throws IOException
        {
            start_pc = mainInput.readUnsignedShort();
            end_pc = mainInput.readUnsignedShort();
            handler_pc = mainInput.readUnsignedShort();
            catch_type = mainInput.readUnsignedShort();
        }
        
        public void selfSave(DataOutputStream mainOutput) throws IOException
        {
            mainOutput.writeShort(start_pc);
            mainOutput.writeShort(end_pc);
            mainOutput.writeShort(handler_pc);
            mainOutput.writeShort(catch_type);
        }
    }
}
