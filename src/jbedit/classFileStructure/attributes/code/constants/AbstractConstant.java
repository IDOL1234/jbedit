
package jbedit.classFileStructure.attributes.code.constants;

public abstract class AbstractConstant
{
    public abstract int getTag();

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof AbstractConstant))
        {
            return false;
        }
        return ((AbstractConstant)obj).getTag() == this.getTag();
    }

    @Override
    public int hashCode()
    {
        return getTag();
    }
    
    
}
