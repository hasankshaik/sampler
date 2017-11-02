public class Fibonocci {

    // Fib series : 0,1,1,2,3,5,8,13
    //              0,1,1,2,3,5,8,13

    public static void main(String[] args) {

        simpleFib(8);
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(recursiveFib(i)+",");
        }

    }

    public static long recursiveFib(int n) {
        if (n <= 1) return n;
        else return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

    public static void simpleFib(int count) {
        int x1 = 0;
        int x2 = 1;
        System.out.print(x1 + "," + x2);
        for (int i = 0; i < count - 2; i++) {
            int temp = x2 + x1;
            x1 = x2;
            x2 = temp;
            System.out.print("," + temp);
        }
    }


}