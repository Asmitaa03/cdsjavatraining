public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        // to control the errors 
       // int a = 100/0;
        //ySystem.out.println(a);
       /* try {
            int b = 100/0;
            System.out.println(b);
        } catch (Exception e) {
           
            System.out.println(e);
        }
        // problem statement 2 -> NumberFormatException
        String name ="Asmita";
        try {
            int i = Integer.parseInt(name);
        System.out.println(i);
            
        } catch (Exception e) {
           
            System.out.println(e);
        }

        //problem statement 3
        String fullname= null;
        String fname = "";
        if(fullname == fname){
            System.out.println("Equal");
    
        }
        else{
            System.out.println("not equal");
        }

        //problem statement 4 ->ArrayIndexOutOfBoundsException
        int[] array = {1,3,5,7};
        try {
            System.out.println(array[4]);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //problem statement 5-> NullPointerException
        String collegename = null;
        try {
            System.out.println(collegename.length());
            
        } catch (Exception e) {
           
            System.out.println(e);
        }
        */ 
        String name ="Asmita";
       try {
        int b = 100/0;
            System.out.println(b);

        int i = Integer.parseInt(name);
        System.out.println(i);

        String fullname= null;
        String fname = "";

        int[] array = {1,3,5,7};
        System.out.println(array[4]);

        String collegename = null;
        System.out.println(collegename.length());
        
       } catch (ArithmeticException arithmeticException) {
        System.out.println(arithmeticException);
      
       }
       catch (NumberFormatException numberFormatException) {
        System.out.println(numberFormatException);
      
       }
       catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
        System.out.println(arrayIndexOutOfBoundsException);
      
       }
       catch (NullPointerException nullPointerException) {
        System.out.println(nullPointerException);
      
       }
       finally{
        System.out.println("This is finally");
       }

        
    }
}
