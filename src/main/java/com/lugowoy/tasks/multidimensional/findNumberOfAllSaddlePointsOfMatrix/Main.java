package com.lugowoy.tasks.multidimensional.findNumberOfAllSaddlePointsOfMatrix;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 07.11.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());
    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number of columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        findSaddleNumbersOfMatrix(matrix);

    }

    private static void findSaddleNumbersOfMatrix(Matrix<Integer> matrix) {
        int counterResult = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                int element = matrix.getElement(i, j);
                if (isMinElementInRow(matrix, i, element) && isMaxElementInColumn(matrix, j, element)) {
                    System.out.println("Saddle value under the row index : " + i + " and column index :" + j + " equals : " + element);
                    counterResult++;
                }
            }
        }
        if (counterResult == 0) {
            System.out.println("Matrix does not contain saddle values.");
        }
    }

    private static boolean isMinElementInRow(Matrix<Integer> matrix, int indexRow, int valueToEqual) {
        boolean result = true;
        for (int i = 0; i < matrix.getColumns(); i++) {
            int element = matrix.getElement(indexRow, i);
            if (element < valueToEqual) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean isMaxElementInColumn(Matrix<Integer> matrix, int indexColumn, int valueToEqual) {
        boolean result = true;
        for (int i = 0; i < matrix.getRows(); i++) {
            int element = matrix.getElement(i, indexColumn);
            if (element > valueToEqual) {
                result = false;
                break;
            }
        }
        return result;
    }

}