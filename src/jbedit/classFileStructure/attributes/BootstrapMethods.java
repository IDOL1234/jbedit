
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;
import jbedit.classFileStructure.frames.FrameException;

public class BootstrapMethods extends AbstractAttribute
{
    private int num_bootstrap_methods; //(short)
    private BootstrapMethodElement bootstrap_methods[];

    public int getNum_bootstrap_methods()
    {
        return num_bootstrap_methods;
    }

    public void setNum_bootstrap_methods(int num_bootstrap_methods)
    {
        this.num_bootstrap_methods = num_bootstrap_methods;
    }

    public BootstrapMethodElement[] getBootstrap_methods()
    {
        return bootstrap_methods;
    }

    public void setBootstrap_methods(BootstrapMethodElement[] bootstrap_methods)
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
            result += bootstrap_methods[i].getRealLength();
        }
        
        return result;
    }

    @Override
    public void selfLoad(DataInputStream mainInput, CONSTANTPoolElement pool[]) throws IOException, FrameException
    {
        num_bootstrap_methods = mainInput.readUnsignedShort();
        bootstrap_methods = new BootstrapMethodElement[num_bootstrap_methods];
        for (int i=0; i < num_bootstrap_methods; i++)
        {
            bootstrap_methods[i] = new BootstrapMethodElement();
            bootstrap_methods[i].selfLoad(mainInput);
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
            bootstrap_methods[i].selfSave(mainOutput);
        }
    }
    
}
