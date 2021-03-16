package homework2;

public class Calc {
    public static void main(String[] args) {
        System.out.println("Введите операцию по шаблону Аргумент Операция Аргумент. Пример 1+1,2*2,3-1,4/2.");
        System.out.println(new ScannerAnalyzer()
                .getOperation(System.in)
                .toString()
        );
    }
}
