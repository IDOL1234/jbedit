
package jbedit.core.drivers.constantPoolDrivers;

import java.util.LinkedList;
import jbedit.classFileStructure.constantPool.*;

public class CONSTANT_POOL_DRIVER
{
    public static CONSTANTPoolElement getRawValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return pool.get(num);
    }
    
    public static void setValue(CONSTANTPoolElement el, int num, LinkedList<CONSTANTPoolElement> pool)
    {
        pool.set(num, el);
    }
    
    public static CONSTANT_Class getClassValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_Class)pool.get(num);
    }
    
    public static CONSTANT_Double getDoubleValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_Double)pool.get(num);
    }
    
    public static CONSTANT_Float getFloatValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_Float)pool.get(num);
    }
    
    public static CONSTANT_Integer getIntegerValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_Integer)pool.get(num);
    }
    
    public static CONSTANT_InterfaceMethodref getInterfaceMethodRefValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_InterfaceMethodref)pool.get(num);
    }
    
    public static CONSTANT_InvokeDynamic getInvokeDynamicValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_InvokeDynamic)pool.get(num);
    }
    
    public static CONSTANT_Long getLongValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_Long)pool.get(num);
    }
    
    public static CONSTANT_MethodHandle getMethodHandleValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_MethodHandle)pool.get(num);
    }
    
    public static CONSTANT_MethodType getMethodTypeValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_MethodType)pool.get(num);
    }
    
    public static CONSTANT_Methodref getMethodRefValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_Methodref)pool.get(num);
    }
    
    public static CONSTANT_NameAndType getNameAndTypeValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_NameAndType)pool.get(num);
    }
    
    public static CONSTANT_String getStringValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_String)pool.get(num);
    }
    
    public static CONSTANT_Utf8 getUtf8Value(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_Utf8)pool.get(num);
    }
    
    public static CONSTANT_fieldRef getFieldRefValue(int num, LinkedList<CONSTANTPoolElement> pool)
    {
        return (CONSTANT_fieldRef)pool.get(num);
    }
    @Deprecated // Прямые ссылки на эти константы есть не только в самом пуле. Функция только для пакета drivers.
    public static boolean isMultiplyUse(CONSTANTPoolElement el, LinkedList<CONSTANTPoolElement> pool)
    {
        return getRefrences(el, pool).size() > 1;
    }
    
    @Deprecated
    public static void addLast(CONSTANTPoolElement el, LinkedList<CONSTANTPoolElement> pool)
    {
        pool.addLast(el);
    }
    
    
    
    public static LinkedList<CONSTANTPoolElement> getRefrences(CONSTANTPoolElement el, LinkedList<CONSTANTPoolElement> pool)
    {
        LinkedList<CONSTANTPoolElement> list = new LinkedList<CONSTANTPoolElement>();
        for (int i = 0; i < pool.size(); i++)
        {
            CONSTANTPoolElement onCheck = getRawValue(i, pool);
            
            if (onCheck instanceof CONSTANT_Class)
            {
                CONSTANT_Class temp = (CONSTANT_Class)onCheck;
                if (temp.getName_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
            }
            
            if (onCheck instanceof CONSTANT_InterfaceMethodref)
            {
                CONSTANT_InterfaceMethodref temp = (CONSTANT_InterfaceMethodref)onCheck;
                if (temp.getClass_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
                if (temp.getName_and_type_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
            }
            
            if (onCheck instanceof CONSTANT_InvokeDynamic)
            {
                CONSTANT_InvokeDynamic temp = (CONSTANT_InvokeDynamic)onCheck;
                if (temp.getName_and_type_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
            }
            
            if (onCheck instanceof CONSTANT_MethodHandle)
            {
                CONSTANT_MethodHandle temp = (CONSTANT_MethodHandle)onCheck;
                if (temp.getRefrence_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
            }
            
            if (onCheck instanceof CONSTANT_MethodType)
            {
                CONSTANT_MethodType temp = (CONSTANT_MethodType)onCheck;
                if (temp.getDescriptor_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
            }
            
            if (onCheck instanceof CONSTANT_Methodref)
            {
                CONSTANT_Methodref temp = (CONSTANT_Methodref)onCheck;
                if (temp.getClass_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
                if (temp.getName_and_type_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
            }
            
            if (onCheck instanceof CONSTANT_NameAndType)
            {
                CONSTANT_NameAndType temp = (CONSTANT_NameAndType)onCheck;
                if (temp.getDescriptor_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
                if (temp.getName_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
            }
            
            if (onCheck instanceof CONSTANT_String)
            {
                CONSTANT_String temp = (CONSTANT_String)onCheck;
                if (temp.getString_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
            }
            
            if (onCheck instanceof CONSTANT_fieldRef)
            {
                CONSTANT_fieldRef temp = (CONSTANT_fieldRef)onCheck;
                if (temp.getClass_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
                if (temp.getName_and_type_index() == el.getNumber())
                {
                    list.add(onCheck);
                    continue;
                }
            }
        }
        
        return list;
    }
}

