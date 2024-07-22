public class Reversed_string {
    public static void main(String[] args){
        String str = "Hello Programming!!";
        String result = "";
        char ch;

        for(int i = 0; i<str.length(); i++){
            ch= str.charAt(i);
            result = ch + result;

        }
        System.out.println("Reverse string = "+ result );

    }

}
