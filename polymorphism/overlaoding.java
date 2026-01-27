class Helper {
    static int Multiply (int a , int b ){
        return a * b ;
    }

    static double Multiply (double a , double b ){
        return a * b;
    }
}

public class overlaoding {
    public static void main(String[] args) {
        System.out.println(Helper.Multiply(2,5));
        System.out.println(Helper.Multiply(2.4, 5.65));
    }
}
