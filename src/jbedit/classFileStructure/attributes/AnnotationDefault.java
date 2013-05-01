
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.attributes.annotations.ElementLoader;
import jbedit.classFileStructure.attributes.annotations.ElementSaver;
import jbedit.classFileStructure.attributes.annotations.element_value;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class AnnotationDefault extends AbstractAttribute
{
    private element_value default_value;

    public element_value getDefault_value()
    {
        return default_value;
    }

    public void setDefault_value(element_value default_value)
    {
        this.default_value = default_value;
    }

    @Override
    public int getRealLength()
    {
        return getHeaderSize() + default_value.getRealLength();
    }
    
    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
        default_value = ElementLoader.loadElement(mainInput);
    }

    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException, FrameException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        ElementSaver.saveElement(default_value, mainOutput);
    }
}