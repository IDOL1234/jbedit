
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.attributes.annotations.Annotation;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class RuntimeInvisibleAnnotations extends AbstractAttribute
{
    private int num_annotations; //(short)
    private Annotation annotations[];

    public int getNum_annotations()
    {
        return num_annotations;
    }

    public void setNum_annotations(int num_annotations)
    {
        this.num_annotations = num_annotations;
    }

    public Annotation[] getAnnotations()
    {
        return annotations;
    }

    public void setAnnotations(Annotation[] annotations)
    {
        this.annotations = annotations;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2;
        for (int i = 0; i < num_annotations; i++)
        {
            result += annotations[i].getRealLength();
        }
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, CONSTANTPoolElement pool[]) throws IOException, FrameException
    {
        num_annotations = mainInput.readUnsignedShort();
        annotations = new Annotation[num_annotations];
        for (int i=0; i < num_annotations; i++)
        {
            annotations[i] = new Annotation();
            annotations[i].selfLoad(mainInput);
        }
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(num_annotations);
        for (int i = 0; i < num_annotations; i++)
        {
            annotations[i].selfSave(mainOutput);
        }
    }
}
