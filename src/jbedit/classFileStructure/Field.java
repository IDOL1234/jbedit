
package jbedit.classFileStructure;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.attributes.AbstractAttribute;
import jbedit.classFileStructure.attributes.AttributeLoader;
import jbedit.classFileStructure.attributes.AttributeSaver;
import jbedit.classFileStructure.frames.FrameException;

public class Field 
{
    private int access_flags; //(short)
    private int name_index; //(short)
    private int descriptor_index;//(short)
    private int attributes_count;//(short)
    private AbstractAttribute attributes[];

    public int getAccess_flags() 
    {
        return access_flags;
    }

    public void setAccess_flags(int access_flags) 
    {
        this.access_flags = access_flags;
    }

    public int getName_index() 
    {
        return name_index;
    }

    public void setName_index(int name_index) 
    {
        this.name_index = name_index;
    }

    public int getDescriptor_index() 
    {
        return descriptor_index;
    }

    public void setDescriptor_index(int descriptor_index) 
    {
        this.descriptor_index = descriptor_index;
    }

    public int getAttributes_count() 
    {
        return attributes_count;
    }

    public void setAttributes_count(int attributes_count) 
    {
        this.attributes_count = attributes_count;
    }

    public AbstractAttribute[] getAttributes() 
    {
        return attributes;
    }
    
    public AbstractAttribute getAttribute(int num) 
    {
        return attributes[num];
    }

    public void setAttributes(AbstractAttribute[] attributes) 
    {
        this.attributes = attributes;
    }
    
    public void selfLoad(DataInputStream mainInput, CONSTANTPoolElement[] pool) throws IOException, FrameException
    {
        access_flags = mainInput.readUnsignedShort();
        name_index = mainInput.readUnsignedShort();
        descriptor_index = mainInput.readUnsignedShort();
        attributes_count = mainInput.readUnsignedShort();
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
