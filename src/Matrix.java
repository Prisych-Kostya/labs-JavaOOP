import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private int rows, columns;
    private int[][] matrix;

    protected Matrix(){
        int[][] matrix = new int[0][];
        rows = 0;
        columns = 0;
    }

    protected Matrix(int rowNum, int columnNum){
        matrix = new int[rowNum][columnNum];
        rows = rowNum;
        columns = columnNum;
    }

    protected Matrix(int[][] origMatrix){
        matrix = new int[origMatrix.length][];
        for(int i = 0; i < origMatrix.length; i++)
            matrix[i] = origMatrix[i].clone();
        rows = origMatrix.length;
        columns = origMatrix[0].length;
    }

    public void printMatrixSize()
    {
        System.out.println(String.format("Розмірність матриці: [%d]x[%d] ", this.rows, this.columns));
    }

    // Function to read matrix
    public void readMatrixByUser() {
        Scanner input = new Scanner(System.in);
        try {
            // Read the matrix values
            System.out.println("Вводьте елементи: ");
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < columns; j++) {
                    System.out.print("A[" + i + "][" + j + "]:  ");
                    matrix[i][j] = input.nextInt();
                }
        }
        catch (Exception e) {
            System.out.println("Щось пішло не так...");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix matrix1)) return false;
        return rows == matrix1.rows && columns == matrix1.columns && Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    public void display()
    {
        System.out.println();
        System.out.println("Матриця: ");
        if(this.matrix.length == 0)
        {
            System.out.println("[ ]");
            return;
        }
        for(int[] row : matrix)
        {
            for(int column : row)
                System.out.print(column + " ");
            System.out.println();
        }
        System.out.println();
    }

    public void getElement()
    {
        System.out.println("Уведіть номер рядка елемента: ");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        System.out.println("Уведіть номер стовпця елемента: ");
        int j = input.nextInt();
        System.out.println(matrix[i-1][j-1]);
    }

    public void getRow()
    {
        try {
            System.out.println("Уведіть номер рядка: ");
            Scanner input = new Scanner(System.in);
            int specificRow = input.nextInt();
            for (int row = 0; row < this.rows; row++)
                System.out.print(matrix[specificRow - 1][row] + " ");
            System.out.println();
        }
        catch (Exception e) {}
    }

    public void getColumn()
    {
        try {
            System.out.println("Уведіть номер стовпця: ");

            Scanner input = new Scanner(System.in);
            int specificColumn = input.nextInt();
            for (int column = 0; column < this.columns; column++)
                System.out.println(matrix[column][specificColumn - 1]);
        }
        catch (Exception e) {}
    }

    public void autoFill(int minValue, int maxValue)
    {
        int diff = maxValue - minValue;
        Random random = new Random();

        for(int i = 0; i < this.rows; i++)
        {
            for(int j = 0; j < this.columns; j++)
            {
            int r = random.nextInt(diff + 1);
            r += minValue;
            matrix[i][j] = r;
            }
        }
    }

    public static void randomRowMatrix(int minValue, int maxValue)
    {
        int diff = maxValue - minValue;
        Random random = new Random();
        System.out.println("Уведіть розмірність матриці-рядка: ");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[][] matrix = new int[1][size];

        for(int i = 0; i < size; i++)
        {
            int t = random.nextInt(diff + 1);
            matrix[0][i] = t;
            t += minValue;
        }

        // printing matrix
        System.out.println("Матриця: ");
        for(int[] row : matrix)
        {
            for (int column : row)
                System.out.print(column + " ");
            System.out.println();
        }
    }

    public int[][] getTransposedMatrix()
    {
        // Transposing the matrix
        int[][] transposedMatrix = new int[columns][rows];
        for(int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
                transposedMatrix[j][i] = matrix[i][j];
        }
        return transposedMatrix;
    }
}
