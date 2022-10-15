import java.util.Arrays;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        System.out.println("Виберіть пункт меню: ");
        System.out.println("1. Створити пусту матрицю");
        System.out.println("2. Створити матрицю заданого розміру");
        System.out.println("3. Створити матрицю-рядок з випадковими значеннями");
        System.out.println("0. Вихід");
        Scanner input = new Scanner(System.in);
        do
        {
            int menu = input.nextInt();
            switch (menu) {
                case (1):
                    Matrix empty = new Matrix();
                    System.out.println("Створили пусту матрицю");
                    int[][] arr = {};
                    System.out.println(Arrays.toString(arr));
                    break;
                case (2):
                    System.out.print("Уведіть кількість рядків матриці: ");
                    Scanner in = new Scanner(System.in);
                    int rows = in.nextInt();
                    System.out.print("Уведіть кількість стовпців матриці: ");
                    int columns = in.nextInt();
                    Matrix matrix = new Matrix(rows, columns);
                    System.out.println("Виберіть метод заповнення матриці:");
                    System.out.println("1. Самостійно");
                    System.out.println("2. Автоматично");
                    int fill = input.nextInt();
                    if (fill == 1)
                    {
                        matrix.readMatrixByUser();
                        matrix.display();
                        System.out.println("Виберіть дії з матрицею: ");
                        System.out.println("1. Повернути розмірність матриці");
                        System.out.println("2. Вивести елемент");
                        System.out.println("3. Вивести рядок");
                        System.out.println("4. Вивести стовпчик");
                        System.out.println("5. Переглянути матрицю");
                        System.out.println("6. Створити копію матриці");
                        System.out.println("7. Транспонувати матрицю");
                        System.out.println("8. Повернутися назад");
                        int opt = input.nextInt();
                        boolean bool = true;
                        while(bool == true)
                        {
                            switch (opt)
                            {
                                case (1):
                                    matrix.printMatrixSize();
                                    break;
                                case (2):
                                    matrix.getElement();
                                    break;
                                case (3):
                                    matrix.getRow();
                                    break;
                                case (4):
                                    matrix.getColumn();
                                    break;
                                case (5):
                                    matrix.display();
                                    break;
                                case(6):
                                    Matrix сopyMatrix = new Matrix();
                                    сopyMatrix.display();
                                    break;
                                case(7):
                                    int[][] transposed = matrix.getTransposedMatrix();
                                    Matrix transposedMatrix = new Matrix(transposed);
                                    transposedMatrix.display();
                                case(8):
                                    bool = false;
                                    break;
                            }
                            int opt1 = input.nextInt();
                            opt = opt1;
                        }
                        break;
                    }
                    else if (fill == 2)
                    {
                        matrix.autoFill(-9, 9);
                        matrix.display();
                        System.out.println("Виберіть дії з матрицею: ");
                        System.out.println("1. Повернути розмірність матриці");
                        System.out.println("2. Вивести елемент");
                        System.out.println("3. Вивести рядок");
                        System.out.println("4. Вивести стовпчик");
                        System.out.println("5. Переглянути матрицю");
                        System.out.println("6. Створити копію матриці");
                        System.out.println("7. Транспонувати матрицю");
                        System.out.println("8. Повернутися назад");
                        int opt = input.nextInt();
                        boolean bool = true;
                        while(bool == true)
                        {
                            switch (opt)
                            {
                                case (1):
                                    matrix.printMatrixSize();
                                    break;
                                case (2):
                                    matrix.getElement();
                                    break;
                                case (3):
                                    matrix.getRow();
                                    break;
                                case (4):
                                    matrix.getColumn();
                                    break;
                                case (5):
                                    matrix.display();
                                    break;
                                case(6):
                                    Matrix сopyMatrix = new Matrix();
                                    сopyMatrix.display();
                                    break;
                                case(7):
                                    int[][] transposed = matrix.getTransposedMatrix();
                                    Matrix transposedMatrix = new Matrix(transposed);
                                    transposedMatrix.display();
                                case(8):
                                    bool = false;
                                    break;
                            }
                            int opt1 = input.nextInt();
                            opt = opt1;
                        }
                        break;
                    }
                    break;
                case (3):
                    Matrix.randomRowMatrix(-100, 100);
                    break;
                case (0):
                    System.exit(0);
                default:
                    System.out.println("Неправильний пункт меню, спробуйте ще раз!");
            }
        } while (true);
    }
}

