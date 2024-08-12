import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String>namelist =new ArrayList<>();
        namelist.add("Vishakha");
        namelist.add("Anjali");
        namelist.add("Sakib");
        namelist.add("Pratibha");
        namelist.add("Vishakha");

        for(String name : namelist){
            System.out.println(name);
        }
        System.out.println(namelist.get(1));
        System.out.println(namelist.get(namelist.size()/2));
        Collections.sort(namelist);
        System.out.println(namelist);

        for(int i= namelist.size()-1; i>=0; i--){
            System.out.println(namelist.get(i));
        }

//duplication
       for(int i =0; i<namelist.size(); i++){
        for(int j= i+1; j<namelist.size(); j++){

        if (namelist.get(i)==namelist.get(j)) {
          System.out.println(namelist.get(i));
            
        } 
            
       }
    }
    }

}
