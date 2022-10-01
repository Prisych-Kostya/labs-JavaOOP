import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Уведіть рядок: ");

        Scanner sc= new Scanner(System.in);
        String numbers = sc.nextLine();

        StringCalculator calculator = new StringCalculator();

        try
        {
            int sum = calculator.getSum(numbers);
            System.out.println("Сума = " + sum);
        }
        catch (Exception e)
        {
            System.out.println("Упс, щось пішло не так... Спробуйте ще раз!");
        }
    }
}