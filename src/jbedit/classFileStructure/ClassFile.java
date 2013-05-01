
package jbedit.classFileStructure;

import java.util.LinkedList;
import jbedit.classFileStructure.attributes.AbstractAttribute;
import jbedit.classFileStructure.constantPool.CONSTANTPoolElement;


public class ClassFile 
{
    private int magic;
    private int major; //(short)
    private int minor; //(short)
    private int constant_pool_count; //(short)
    private LinkedList<CONSTANTPoolElement> constantPool;
    private int access_flags; //(short)
    private int this_class; //(short)
    private int super_class; //(short)
    private int interfaces_count; //(short)
    private LinkedList<Integer> interfaces; //(short)
    private int fileds_count; //(short)
    private LinkedList<Field> field_info;
    private int methods_count; //(short)
    private LinkedList<Method> methods;
    private int attribute_count; //(short)
    private LinkedList<AbstractAttribute> atributes;
    


    
    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) 
    {
        if (magic != 0xCAFEBABE)
            throw new IllegalArgumentException("Wrong file signature.");
        this.magic = magic;
    }

    public int getMajor() 
    {
        return major;
    }

    public void setMajor(int major) 
    {
        this.major = major;
    }

    public int getMinor() 
    {
        return minor;
    }

    public void setMinor(int minor) 
    {
        this.minor = minor;
    }

    public int getConstant_pool_count() 
    {
        return constant_pool_count;
    }

    public void setConstant_pool_count(int constant_pool_count) 
    {
        if (constant_pool_count < 0)
            throw new IllegalArgumentException("constant_pool_count must not be < 0!");
        this.constant_pool_count = constant_pool_count;
    }

    public int getAccess_flags() 
    {
        return access_flags;
    }

    public void setAccess_flags(int access_flags) 
    {
        this.access_flags = access_flags;
    }

    public LinkedList<CONSTANTPoolElement> getConstantPool() 
    {
        return constantPool;
    }

    public void setConstantPool(LinkedList<CONSTANTPoolElement> constantPool) 
    {
        this.constantPool = constantPool;
    }
    
    public CONSTANTPoolElement getConstantPoolElement(int num)
    {
        return constantPool.get(num);
    }

    public int getThis_class() 
    {
        return this_class;
    }

    public void setThis_class(int this_class) 
    {
        this.this_class = this_class;
    }

    public int getSuper_class() 
    {
        return super_class;
    }

    public void setSuper_class(int super_class) 
    {
        this.super_class = super_class;
    }

    public int getInterfaces_count() 
    {
        return interfaces_count;
    }

    public void setInterfaces_count(int interfaces_count) 
    {
        this.interfaces_count = interfaces_count;
    }

    public LinkedList<Integer> getInterfaces() 
    {
        return interfaces;
    }
    
    public int getInterface(int num) 
    {
        return interfaces.get(num);
    }

    public void setInterfaces(LinkedList<Integer> interfaces) 
    {
        this.interfaces = interfaces;
    }

    public int getFileds_count() 
    {
        return fileds_count;
    }

    public void setFileds_count(int fileds_count) 
    {
        this.fileds_count = fileds_count;
    }

    public LinkedList<Field> getField_info()
    {
        return field_info;
    }

    public void setField_info(LinkedList<Field> field_info)
    {
        this.field_info = field_info;
    }

    public int getMethods_count()
    {
        return methods_count;
    }

    public void setMethods_count(int methods_count)
    {
        this.methods_count = methods_count;
    }

    public LinkedList<Method> getMethods()
    {
        return methods;
    }

    public void setMethods(LinkedList<Method> methods)
    {
        this.methods = methods;
    }

    public int getAttribute_count()
    {
        return attribute_count;
    }

    public void setAttribute_count(int attribute_count)
    {
        this.attribute_count = attribute_count;
    }

    public LinkedList<AbstractAttribute> getAtributes()
    {
        return atributes;
    }

    public void setAtributes(LinkedList<AbstractAttribute> atributes)
    {
        this.atributes = atributes;
    }
}
