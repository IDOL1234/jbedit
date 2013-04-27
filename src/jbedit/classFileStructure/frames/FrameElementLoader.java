
package jbedit.classFileStructure.frames;

import java.io.DataInputStream;
import java.io.IOException;

public class FrameElementLoader
{
    public static AbstractStackMapFrame[] loadElements(DataInputStream mainInput, int count)
            throws IOException, FrameException
    {
        
        AbstractStackMapFrame result[] = new AbstractStackMapFrame[count];
        for (int i=0; i < count; i++)
        {
            result[i] = loadElement(mainInput);
        }
        
        return result;
    }

    
    private static AbstractStackMapFrame loadElement(DataInputStream mainInput) throws IOException, FrameException
    {
        AbstractStackMapFrame element = null;
        int type = mainInput.readUnsignedByte(); // byte
        if (type >= 0 && type <= 63)
        {
            element = new same_frame();
        }
        else if (type >= 64 && type <= 127)
        {
            element = new same_locals_1_stack_item_frame();
        }
        else if (type == 247)
        {
            element = new same_locals_1_stack_item_frame_extended();
        }
        else if (type >= 248 && type <= 250)
        {
            element = new chop_frame();
        }
        else if (type == 251)
        {
            element = new same_frame_extended();
        }
        else if (type >= 252 && type <= 254)
        {
            element = new append_frame();
        }
        else if (type == 255)
        {
            element = new full_frame();
        }
        else
        {
            throw new IllegalStateException("Тип фрейма " + type + " не поддерживается");
        }
        
        element.setFrame_type(type);
        if (System.getProperty("debug") != null && System.getProperty("debug").equalsIgnoreCase("true"))
            System.out.println("Loading frame:      " + element.getClass().getSimpleName());
        
        element.selfLoad(mainInput);
        
        return element;
    }
}
