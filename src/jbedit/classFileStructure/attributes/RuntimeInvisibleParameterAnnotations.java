
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

/**
 *
 * @author Кирилл
 */
public class RuntimeInvisibleParameterAnnotations extends AbstractAttribute
{
    private int num_parameters; //(byte)
    private LinkedList<parameter_annotations_table> parameter_annotations;

    public int getNum_parameters()
    {
        return num_parameters;
    }

    public void setNum_parameters(int num_parameters)
    {
        this.num_parameters = num_parameters;
    }

    public LinkedList<parameter_annotations_table> getParameter_annotations()
    {
        return parameter_annotations;
    }

    public void setParameter_annotations(LinkedList<parameter_annotations_table> parameter_annotations)
    {
        this.parameter_annotations = parameter_annotations;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 1;
        for (int i = 0; i < num_parameters; i++)
        {
            result += parameter_annotations.get(i).getRealLength();
        }
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
        num_parameters = mainInput.readUnsignedByte();
        parameter_annotations = new LinkedList<parameter_annotations_table>();
        for (int i = 0; i < num_parameters; i++)
        {
            parameter_annotations.add(new parameter_annotations_table());
            parameter_annotations.get(i).selfLoad(mainInput);
        }
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeByte(num_parameters);
        for (int i = 0; i < num_parameters; i++)
        {
            parameter_annotations.get(i).selfSave(mainOutput);
        }
    }
}
