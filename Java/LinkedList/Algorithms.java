import java.io.*;

public class Algorithms
{
    public static void main(String [] args)
    {
        System.out.println(new java.io.InputStreamReader(System.in));
        
        //calculator(new java.io.InputStreamReader(System.in), System.out);
    }
  
    public static void calculator(Reader in, PrintWriter out)
      throws IOException
    {
      Stack stack = new StackAsLinkedList();
      
      int i;
      while((i = in.read()) > 0)
      {
        char c = (char) i;
        
        if(Character.isDigit(c))
        {
          stack.push(new Int(Character.digit(c, 10)));
        }
        else if(c == '+')
        {
          Int arg2 = (Int) stack.pop();
          Int arg1 = (Int) stack.pop();
          stack.push(new Int(arg1.intValue() + arg2.intValue()));
        }
        else if(c == '*')
        {
          Int arg2 = (Int) stack.pop();
          Int arg1 = (Int) stack.pop();
          stack.push(new Int(arg1.intValue() * arg2.intValue()));
        }
        else if(c == '-')
        {
          Int arg2 = (Int) stack.pop();
          Int arg1 = (Int) stack.pop();
          stack.push(new Int(arg1.intValue() - arg2.intValue()));
        }
        else if(c == '/')
        {
          Int arg2 = (Int) stack.pop();
          Int arg1 = (Int) stack.pop();
          
          if(arg2 == 0)
            throw new Exception("Divisor cannot be zero");
          
          stack.push(new Int(arg1.intValue() / arg2.intValue()));
        }
        else if(c == '=')
        {
          Int arg = (Int) stack.pop();
          out.println(arg);
        }
      }
      
    }  
}
