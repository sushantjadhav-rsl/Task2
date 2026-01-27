class Perosn {
    void role (){
        System.out.println("I am person ");
    }
}

class father extends Perosn {
    void role (){
        System.out.println("I am father ");
    }
}
public class Geek {
    public static void main(String[] args) {
        Perosn p = new father();
        p.role();
        Perosn s= new Perosn();
        s.role();
        System.out.println("now directly making the calls of the father ");
        father f = new father();
        f.role();
    }
}
