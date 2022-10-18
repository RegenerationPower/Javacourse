/*
 Тема:  Масиви в мові програмування Java.

Мета:  Ознайомлення з масивами та використання основних методів їх обробки в мові програмування Java. Здобуття навичок у використанні масивів в мові програмування Java.

Завдання

    Визначити C5 як остачу від ділення номера залікової книжки студента на 5, C7 як остачу від ділення номера залікової книжки студента на 7, C11 як остачу від ділення номера залікової книжки студента на 11.
    В залежності від C5 визначити дію, що виконується з матрицею(ями):
    C5 	Дія з матрицею(ями)
    0 	C=a×B, a - const
    1 	C=Bт
    2 	C=A+B
    3 	C=A⊕B
    4 	C=A×B
    В залежності від C7 визначити тип елементів матриці:
    C7 	Тип елементів матриці
    0 	double
    1 	byte
    2 	short
    3 	int
    4 	long
    5 	char
    6 	float
    В залежності від C11 визначити дію з матрицею С:
    C11 	Дія з матрицею С
    0 	Обчислити суму найменших елементів кожного стовпця матриці
    1 	Обчислити суму найменших елементів кожного рядка матриці
    2 	Обчислити суму найбільших елементів кожного стовпця матриці
    3 	Обчислити суму найбільших елементів кожного рядка матриці
    4 	Обчислити суму найбільших елементів в рядках матриці з парними номерами та найменших елементів в рядках матриці з непарними номерами
    5 	Обчислити суму найбільших елементів в рядках матриці з непарними номерами та найменших елементів в рядках матриці з парними номерами
    6 	Обчислити суму найбільших елементів в стовпцях матриці з парними номерами та найменших елементів в стовпцях матриці з непарними номерами
    7 	Обчислити суму найбільших елементів в стовпцях матриці з непарними номерами та найменших елементів в стовпцях матриці з парними номерами
    8 	Знайти середнє значення елементів кожного рядка матриці
    9 	Знайти середнє значення елементів кожного стовпчика матриця
    10 	Знайти середнє значення елементів матриці
    Створити клас, який складається з виконавчого методу, що виконує дію з матрицею(ями) (п.2) із зазначеним типом елементів (п.3) та дію із результуючою матрицею С (п.4). Вивести на екран результати першої та другої дій. Необхідно обробити всі виключні ситуації, що можуть виникнути під час виконання програмного коду. Всі змінні повинні бути описані та значення їх задані у виконавчому методі.

Лаб 1
Виконав студент групи ІО-04 Возниця Дмитро 0403
Варіант:
C5=3(C=A⊕B )
C7=4(long )
C11=7(Обчислити суму найбільших елементів в стовпцях матриці з непарними номерами та найменших елементів в стовпцях матриці з парними номерами)
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean catchment = false;
        boolean catchment1 = false;
        int rows = 0;
        int columns = 0;
        do {
            System.out.println("Enter the number of rows: ");
            if (scan.hasNextInt()) {
                rows = scan.nextInt();
                catchment = true;
                do{
                    System.out.println("Enter the number of columns: ");
                    if (scan.hasNextInt()) {
                        columns = scan.nextInt();
                        catchment1 = true;
                    }
                    else {
                        scan.nextLine();
                        System.out.println("Enter a valid Integer value");
                    }
                }while (!catchment1);
            } else {
                scan.nextLine();
                System.out.println("Enter a valid Integer value");
            }
        } while (!catchment);
        long[][] matrix1 = new long[rows][columns];
        long[][] matrix2 = new long[rows][columns];
        long[][] matrix3 = new long[rows][columns];

        if (rows == 0 | columns == 0) {
            System.out.println("rows and/or columns can't be 0");
        } else {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    matrix1[i][j] = randomNumbers();
                }
            }

            for (int i = 0; i < matrix2.length; i++) {
                for (int j = 0; j < matrix2[i].length; j++) {
                    matrix2[i][j] = randomNumbers();
                }
            }

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    matrix3[i][j] = matrix1[i][j] ^ matrix2[i][j];
                }
            }
            System.out.println("First matrix: ");
            printMatrix(matrix1);
            System.out.println("Second matrix: ");
            printMatrix(matrix2);
            System.out.println("Third matrix: ");
            printMatrix(matrix3);

            try {
                System.out.println("Sum of the maximum values in odd-numbered columns: " + findMaximum(matrix3));
                System.out.println("Sum of the minimum values in even-numbered columns: " + findMinimum(matrix3));
            } catch (Exception e) {
                String msg = e.getMessage();
            }
        }
    }

    //fill matrix with random numbers
    public static int randomNumbers() {
        Random r = new Random();
        return r.nextInt(100);}
    //print matrix
    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    //find the maximum values in odd-numbered columns
    public static long findMaximum(long[][] matrix) throws Exception {
        long result = 0;
        long  max;
        try{
            for (int i = 1; i < matrix[0].length; i += 2)
            {
                max = matrix[0][i];
                for (int j = 1 ; j < matrix.length; j++)
                {
                    max = Math.max(max, matrix[j][i]);
                }
                result += max;
                System.out.println("Maximum value in "+i+" numbered column: "+max);
            }
        }catch (Exception e){
            throw new Exception("Incorrect input");
        }
        return result;
    }
    //find the minimum values in even-numbered columns
    public static long findMinimum(long[][] matrix) throws Exception {
        long result = 0;
        long  min;
        try{
            for (int i = 0; i < matrix[0].length; i += 2)
            {
                min = matrix[0][i];
                for (long[] longs : matrix) {
                    min = Math.min(min, longs[i]);
                }
                result += min;
                System.out.println("Minimum value in "+i+" numbered column: "+min);
            }
        }catch (Exception e){
            throw new Exception("Incorrect input");
        }
        return result;
    }
}