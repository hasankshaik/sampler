public class Singleton{
    public static void main(String[] args) {
        SingletonObj.geSingleton().printMe();
    }
}


class SingletonObj {
    private static final SingletonObj singleton = new SingletonObj();

    private SingletonObj(){

    }

    public void printMe(){
        System.out.println("I am singleton.");
    }

    public static SingletonObj geSingleton(){
        return singleton;
    }
}




