package Lab2;

import java.util.List;

public class utility {
    static double[] solve_Gauss(double[][] matrixA, double[] matrixB) {
        System.out.println("********** Gauss method **********");
        int lines = 4, columns = 4,iter = 0;
        double[] x = new double[lines];
        int[] index = new int[lines];

        for (int i = 0; i < lines; i++) {
            index[i] = i;
        }

        int k = 0;
        double Determinant = 1;
        while (k < lines) {
            // find max el
            double maxElement = Math.abs(matrixA[k][k]);
            int maxIndex = k;
            for (int j = k; j < columns; j++) {
                if (Math.abs(matrixA[k][j]) > maxElement) {
                    maxElement = Math.abs(matrixA[k][j]);
                    maxIndex = j;
                }
            }
            Determinant *= maxElement;
            if (maxIndex != k) {
                int tempIndex = index[k];
                index[k] = maxIndex;
                index[maxIndex] = tempIndex;
            }
            if (maxElement == 0) {
                System.out.println("System is unresolved\n");
            }

            for (int i = 0; i < lines; i++) {
                double temp = matrixA[i][k];
                matrixA[i][k] = matrixA[i][maxIndex];
                matrixA[i][maxIndex] = temp;
            }

            double tempArray = matrixA[k][k];
            matrixB[k] /= tempArray;
            for (int j = k + 1; j < columns; j++) {
                matrixA[k][j] /= tempArray;
            }

            for (int i = k + 1; i < lines; i++) {
                matrixB[i] -= matrixB[k] * matrixA[i][k];
                double temp = matrixA[i][k];
                for (int j = k; j < columns; j++) {
                    matrixA[i][j] -= matrixA[k][j] * temp;
                }
            }
            k++;
            iter++;
        }

        for (int i = lines - 1; i >= 0; i--) {
            for (int j = columns - 1; j > i; j--) {
                matrixB[i] -= matrixA[i][j] * matrixB[j];
            }

        }

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++) {
                if (index[j] == i) {
                    x[i] = matrixB[j];
                }
            }
        }

        return x;
    }


}
