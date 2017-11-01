package oct.ts.tryfinallyreturn;

public class TryFinalReturn {

    public static void main(String[] args) {
        
        TryFinalReturn a = new TryFinalReturn();
        System.out.println(a.DoubleReturn());           //finally
    }
    
    public String DoubleReturn()
    {
        try
        {
            return "try";
        }
        finally
        {
            return "finally";
        }
    }

}
