
package jbedit.classFileStructure.frames;

public class FrameException extends Exception
{
    public FrameException(String message) 
    {
        super(message);
    }

    public FrameException(Throwable cause) 
    {
        super(cause);
    }

    public FrameException(String message, Throwable cause)
    {
        super(message, cause);
    }   
}
