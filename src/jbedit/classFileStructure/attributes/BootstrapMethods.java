
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class BootstrapMethods extends AbstractAttribute
{
    private int num_bootstrap_methods; //(short)
    private LinkedList<BootstrapMethodElement> bootstrap_methods;

    public int getNum_bootstrap_methods()
    {
        return num_bootstrap_methods;
    }

    public void setNum_bootstrap_methods(int num_bootstrap_methods)
    {
        this.num_bootstrap_methods = num_bootstrap_methods;
    }

    public LinkedList<BootstrapMethodElement> getBootstrap_methods()
    {
        return bootstrap_methods;
    }

    public void setBootstrap_methods(LinkedList<BootstrapMethodElement> bootstrap_methods)
    {
        this.bootstrap_methods = bootstrap_methods;
    }
    
    @Override
    public int getRealLength()
    {
        int result = getHeaderSize();
        result += 2; // num_bootstrap_methods
        for (int i = 0; i < num_bootstrap_methods; i++)
        {
            result += bootstrap_methods.get(i).getRealLength();
        }
        
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, LinkedList<CONSTANTPoolElement> pool) throws IOException, FrameException
    {
        num_bootstrap_methods = mainInput.readUnsignedShort();
        bootstrap_methods = new LinkedList<BootstrapMethodElement>();
        for (int i=0; i < num_bootstrap_methods; i++)
        {
            bootstrap_methods.set(i, new BootstrapMethodElement());
            bootstrap_methods.get(i).selfLoad(mainInput);
        }
    }
    
    @Override
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(getAttribute_name_index());
        mainOutput.writeInt(getRealInternalLength());
        mainOutput.writeShort(num_bootstrap_methods);
        for (int i = 0; i < num_bootstrap_methods; i++)
        {
            bootstrap_methods.get(i).selfSave(mainOutput);
        }
    }
    
}
