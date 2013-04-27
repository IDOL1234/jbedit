
package jbedit.core.constants;

public class IArrayRefrence extends IConstant
{
    private IConstant value;

    public IConstant getValue()
    {
        return value;
    }

    public void setValue(IConstant value)
    {
        this.value = value;
    }
}
