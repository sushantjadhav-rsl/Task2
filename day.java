interface A {
    void code ();
    void run2();
}
public class day implements  A{

    public void code (){
        System.out.println("hello this is sushant");
    }
    public void run2 (){
        System.out.println("form the run ");
    }

    public static void main (){
        day  a = new day () ;
        a.code();
        a.run2 ();
    }
}