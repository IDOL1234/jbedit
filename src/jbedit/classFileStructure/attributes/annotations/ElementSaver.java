
package jbedit.classFileStructure.attributes.annotations;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class ElementSaver
{
    public static void saveElements(LinkedList<element_value> element, DataOutputStream mainOutput) 
            throws IOException
    {
        for (int i = 0; i < element.size(); i++)
        {
            saveElement(element.get(i), mainOutput);
        }
    }
    
    
    public static void saveElement(element_value element, DataOutputStream mainOutput) 
            throws IOException
    {
        mainOutput.writeByte(element.getTag()); //TODO: Перенести в selfSave
        element.selfSave(mainOutput);
    }
}
