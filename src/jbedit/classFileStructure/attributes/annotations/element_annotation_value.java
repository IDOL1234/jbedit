
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class element_annotation_value extends element_value
{
    private Annotation annotation_value;

    public Annotation getAnnotation_value()
    {
        return annotation_value;
    }

    public void setAnnotation_value(Annotation annotation_value)
    {
        this.annotation_value = annotation_value;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += annotation_value.getRealLength();
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput) throws IOException 
    {
        annotation_value = new Annotation();
        annotation_value.selfLoad(mainInput);
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        annotation_value.selfSave(mainOutput);
    }
}
