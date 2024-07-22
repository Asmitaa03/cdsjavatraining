public class Repeated_value {
    public static void main(String[] args) {
        String arr[]=new String[]{"Pen","Book","Ink","Book","Ink"};
        System.out.println("Duplicate name in array");
        for(int i=0; i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    System.out.println(arr[j]);
                }
            }
        }

    }
    
}