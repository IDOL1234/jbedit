
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.attributes.annotations.Annotation;

public class parameter_annotations_table
{
    private int num_annotations; //(short)
    private LinkedList<Annotation> annotations;

    public int getNum_annotations()
    {
        return num_annotations;
    }

    public void setNum_annotations(int num_annotations)
    {
        this.num_annotations = num_annotations;
    }

    public LinkedList<Annotation> getAnnotations()
    {
        return annotations;
    }

    public void setAnnotations(LinkedList<Annotation> annotations)
    {
        this.annotations = annotations;
    }
    
    public int getRealLength()
    {
        int result = 2;
        for (int i = 0; i < num_annotations; i++)
        {
            result += annotations.get(i).getRealLength();
        }
        return result;
    }

    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        num_annotations = mainInput.readUnsignedShort();
        annotations = new LinkedList<Annotation>();
        for (int i=0; i < num_annotations; i++)
        {
            annotations.add(new Annotation());
            annotations.get(i).selfLoad(mainInput);
        }
    }
    
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(num_annotations);
        for (int i = 0; i < num_annotations; i++)
        {
            annotations.get(i).selfSave(mainOutput);
        }
        
        
    }
}