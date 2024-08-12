import java.util.Scanner;
public class ConstructorForOperations {
    public static void main(String[] args) {
       System.out.println("Enter a and b");
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
       System.out.println("Enter your choice:\n 1)Addition \n 2)Subtraction \n 3)Multiplication \n 4)Division"); 
       int choice = sc.nextInt();
       Calculator c  = new Calculator(a, b, choice);
    }



}
class Calculator{
  

   public Calculator(int a, int b, int choice){
        this.a = a;
        this.b = b;
        this.choice = choice;
    }
    

    }

