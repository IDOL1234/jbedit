
package jbedit.classFileStructure.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BootstrapMethodElement
{
    private int bootstrap_method_ref; //(short)
    private int num_bootstrap_arguments; //(short)
    private int bootstrap_arguments[]; //(short)

    public int getBootstrap_method_ref()
    {
        return bootstrap_method_ref;
    }

    public void setBootstrap_method_ref(int bootstrap_method_ref)
    {
        this.bootstrap_method_ref = bootstrap_method_ref;
    }

    public int getNum_bootstrap_arguments()
    {
        return num_bootstrap_arguments;
    }

    public void setNum_bootstrap_arguments(int num_bootstrap_arguments)
    {
        this.num_bootstrap_arguments = num_bootstrap_arguments;
    }

    public int[] getBootstrap_arguments()
    {
        return bootstrap_arguments;
    }

    public void setBootstrap_arguments(int bootstrap_arguments[])
    {
        this.bootstrap_arguments = bootstrap_arguments;
    }
    
    public int getRealLength()
    {
        int result = 2 + 2;
        result += 2 * bootstrap_method_ref;
        return result;
    }
    
    public void selfLoad(DataInputStream mainInput) throws IOException
    {
        bootstrap_method_ref = mainInput.readUnsignedShort();
        num_bootstrap_arguments = mainInput.readUnsignedShort();
        bootstrap_arguments = new int[num_bootstrap_arguments];
        for (int i = 0; i < num_bootstrap_arguments; i++)
        {
            bootstrap_arguments[i] = mainInput.readUnsignedShort();
        }
    }
    
    public void selfSave(DataOutputStream mainOutput) throws IOException
    {
        mainOutput.writeShort(bootstrap_method_ref);
        mainOutput.writeShort(num_bootstrap_arguments);
        
        for (int i = 0; i < num_bootstrap_arguments; i++)
        {
            mainOutput.writeShort(bootstrap_arguments[i]);
        }
    }
}
