package inheritance;
class Animal {
    void sound (){
        System.out.println("Animal makes sound ");
    }
}
class  Dog extends Animal {
    void sound (){
        System.out.println("Dog barks");
    }
}
class Sushant extends Animal{
    void sound(){
        System.out.println("sushant is talking");
    }
}
public class test {
    public static void main(String[] args) {
        Animal a;
        a = new Dog();
        a.sound();

        // new object 
        a = new Sushant();
        a.sound();
    }
}
