
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.AbstractStackMapFrame;
import jbedit.classFileStructure.frames.FrameElementLoader;
import jbedit.classFileStructure.frames.FrameElementSaver;
import jbedit.classFileStructure.frames.FrameException;

public class StackMapTable extends AbstractAttribute
{
    private int number_of_entries; //(short)
    private LinkedList<AbstractStackMapFrame> entries;

    public int getNumber_of_entries()
    {
        return number_of_entries;
    }

    public void setNumber_of_entries(int number_of_entries)
    {
        this.number_of_entries = number_of_entries;
    }

    public LinkedList<AbstractStackMapFrame> getEntries()
    {
        return entries;
    }

    public AbstractStackMapFrame getEntrie(short i)
    {
        return entries.get(i);
    }
    
    public void setEntries(LinkedList<AbstractStackMapFrame> entries)
    {
        this.entries = entries;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2;
        for (int i = 0; i < number_of_entries; i++)
        {
            result += entries.get(i).getRealLength();
        }
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
        number_of_entries = mainInput.readUnsignedShort();
        entries = FrameElementLoader.loadElements(mainInput, number_of_entries);
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(number_of_entries);
        FrameElementSaver.saveElements(entries, mainOutput);
    }
}
