
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class InnerClasses extends AbstractAttribute
{
    private int number_of_classes; //(short)
    private inner_classes_element[] classes;

    public int getNumber_of_classes()
    {
        return number_of_classes;
    }

    public void setNumber_of_classes(int number_of_classes)
    {
        this.number_of_classes = number_of_classes;
    }

    public inner_classes_element[] getClasses()
    {
        return classes;
    }

    public void setClasses(inner_classes_element[] classes)
    {
        this.classes = classes;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2; //number_of_classes
        for (int i = 0; i < number_of_classes; i++) //classes[]
        {
            result += classes[i].getRealLength();
        }
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, CONSTANTPoolElement pool[]) throws IOException, FrameException
    {
        number_of_classes = mainInput.readUnsignedShort();
        classes = new inner_classes_element[number_of_classes];
        for (int i = 0; i < number_of_classes; i++)
        {
            classes[i] = new inner_classes_element();
            classes[i].selfLoad(mainInput, pool);
        }
        
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(number_of_classes);
        for (int i = 0; i < number_of_classes; i++)
        {
            classes[i].selfSave(mainOutput);
        }
    }
    
    
    
    public class inner_classes_element
    {
        public int inner_class_info_index; //(short)
        public int outer_class_info_index; //(short)
        public int inner_name_index; //(short)
        public int inner_class_access_flags; //(short)
        

        public int getRealLength()
        {
            int result = 2 + 2 + 2 + 2;
            return result;
        }
        
        public void selfLoad(DataInputStream mainInput, CONSTANTPoolElement pool[]) throws IOException
        {
            inner_class_info_index = mainInput.readUnsignedShort();
            outer_class_info_index = mainInput.readUnsignedShort();
            inner_name_index = mainInput.readUnsignedShort();
            inner_class_access_flags = mainInput.readUnsignedShort();
        }
        
        public void selfSave(DataOutputStream mainOutput) throws IOException
        {
            mainOutput.writeShort(inner_class_info_index);
            mainOutput.writeShort(outer_class_info_index);
            mainOutput.writeShort(inner_name_index);
            mainOutput.writeShort(inner_class_access_flags);
        }
        
        
    }
    
        
}
