
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataOutputStream;
import java.io.IOException;

public class ElementSaver
{
    public static void saveElements(element_value element[], DataOutputStream mainOutput) 
            throws IOException
    {
        for (int i = 0; i < element.length; i++)
        {
            saveElement(element[i], mainOutput);
        }
    }
    
    
    public static void saveElement(element_value element, DataOutputStream mainOutput) 
            throws IOException
    {
        mainOutput.writeByte(element.getTag()); //TODO: Перенести в selfSave
        element.selfSave(mainOutput);
    }
}
