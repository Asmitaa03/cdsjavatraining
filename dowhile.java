import java.util.*;

public class dowhile {
    public static void main(String[] args) {
    
        int sum = 0;
        int number = 0;

        Scanner sc = new Scanner(System.in);

        do {
            
            sum += number;
            System.out.println("Enter a number");
            number = sc.nextInt();
          } while(number >= 0); 
             
          System.out.println("Sum = " + sum);
          sc.close();
        }
      }

    


