public class Constructor {
    public static void main(String[] args) {
        A a = new A("Asmita", "singh");

        //a.b = 5;

    }
}

class A{


    public A(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("Belated Happy birthday"+ fname+ lname);
    }

    String  fname;
    String lname;
}
    


