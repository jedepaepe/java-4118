public class DemoSum {

    public static void main(String[] args) {
        System.out.println("La somme de 1 à 10 est " + sum(1, 10));
        System.out.println("La somme de 20 à 37 est " + sum(20, 37));
        System.out.println("La somme de 35 à 49 est " + sum(35, 49));
    }

    static int sum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; ++i) {
            sum += i;
        }
        return sum;
    }
}
