public class Jacobi {
    public static double eps = 0.005;

    public static void JacobiFunc(double[][] matrix, double[] arrayB) {
        System.out.println("********** Jacobi method **********");
        int arrSize = 4;
        double[] TempX = new double[arrSize];
        double norm;
        double[] x0 = {0, 0, 0, 0};

        do {
            for (int i = 0; i < arrSize; i++) {
                TempX[i] = arrayB[i];
                for (int g = 0; g < arrSize; g++) {
                    if (i != g)
                        TempX[i] -= matrix[i][g] * x0[g];
                }
                TempX[i] /= matrix[i][i];
            }
            norm = Math.abs(x0[0] - TempX[0]);
            for (int h = 0; h < arrSize; h++) {
                if (Math.abs(x0[h] - TempX[h]) > norm)
                    norm = Math.abs(x0[h] - TempX[h]);
                x0[h] = TempX[h];
            }
        } while (norm > eps);
        for (int i = 0; i < arrSize; i++) {
            System.out.println("x"+i + " = " +x0[i]);
        }
    }
}
