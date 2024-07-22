public class RepeatedCharacter {
    public static void main(String[] args){
        String str = " Java Programming";
        char[] ch = str.toCharArray();

        for (int i =0; i< ch.length;i++){
            if(ch[i]== '0')
            continue;
            
            for(int j= i+1; j< ch.length;j++) {
                if (ch[i] == ch[j]) {
                    System.out.println(ch[i] + " ");
                    ch[j] = 0;
                }
            }
        }
    }

}
