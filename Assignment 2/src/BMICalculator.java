import java.util.Scanner;
public class BMICalculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input weight in kgs: ");
        double weight = sc.nextDouble();
        System.out.print("Input height in meters: ");
        double height = sc.nextDouble();
        double BMI = weight / (height * height);
        System.out.print("The Body Mass Index is " + BMI + " kg/m2");
        
    }
}