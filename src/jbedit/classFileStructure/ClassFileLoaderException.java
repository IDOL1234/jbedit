
package jbedit.classFileStructure;


public class ClassFileLoaderException extends Exception
{

    public ClassFileLoaderException(String message) 
    {
        super(message);
    }

    public ClassFileLoaderException(Throwable cause) 
    {
        super(cause);
    }

    public ClassFileLoaderException(String message, Throwable cause) 
    {
        super(message, cause);
    }
    
    @Override
    public String toString() 
    {
        return super.toString();
    }
}
