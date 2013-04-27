
package jbedit.classFileStructure;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.attributes.AbstractAttribute;
import jbedit.classFileStructure.attributes.AttributeLoader;
import jbedit.classFileStructure.attributes.AttributeSaver;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.constantPool.CONSTANT_Utf8;
import jbedit.classFileStructure.frames.FrameException;

public class Method
{
    private short access_flags;
    private short name_index;
    private short descriptor_index;
    private short attributes_count;
    private AbstractAttribute attributes[];

    public short getAccess_flags()
    {
        return access_flags;
    }

    public void setAccess_flags(short access_flags)
    {
        this.access_flags = access_flags;
    }

    public short getName_index()
    {
        return name_index;
    }

    public void setName_index(short name_index)
    {
        this.name_index = name_index;
    }

    public short getDescriptor_index()
    {
        return descriptor_index;
    }

    public void setDescriptor_index(short descriptor_index)
    {
        this.descriptor_index = descriptor_index;
    }

    public short getAttributes_count()
    {
        return attributes_count;
    }

    public void setAttributes_count(short attributes_count)
    {
        this.attributes_count = attributes_count;
    }

    public AbstractAttribute[] getAttributes()
    {
        return attributes;
    }

    public void setAttributes(AbstractAttribute[] attributes)
    {
        this.attributes = attributes;
    }
    
    public void selfLoad(DataInputStream mainInput, CONSTANTPoolElement pool[])
            throws IOException, FrameException
    {
        access_flags = mainInput.readShort();
        name_index = mainInput.readShort();
        descriptor_index = mainInput.readShort();
        attributes_count = mainInput.readShort();
        if (System.getProperty("debug") != null && System.getProperty("debug").equalsIgnoreCase("true"))
            System.out.println("Loading method      " + ((CONSTANT_Utf8)(pool[name_index])).getString());
        
        attributes = AttributeLoader.loadElements(mainInput, pool, attributes_count);
    }
    
    public void selfSave(DataOutputStream mainOutput) throws IOException, FrameException
    {
        mainOutput.writeShort(access_flags);
        mainOutput.writeShort(name_index);
        mainOutput.writeShort(descriptor_index);
        mainOutput.writeShort(attributes_count);
        AttributeSaver.saveElements(attributes, mainOutput);
        
    }
}
