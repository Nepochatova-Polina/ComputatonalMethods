package Lab2;

public class Jacobi {
    public static double eps = 0.0005;

    public static void JacobiFunc(double[][] matrix, double[] arrayB) {
        System.out.println("********** Lab2.Jacobi method **********");
        int arrSize = 4,iter = 0;
        double[] TempX = new double[arrSize];
        double norm;
        double[] X = {0, 0, 0, 0};
        if (JacobiTrue(matrix)) {
            do {
                for (int i = 0; i < arrSize; i++) {
                    TempX[i] = arrayB[i];
                    for (int g = 0; g < arrSize; g++) {
                        if (i != g)
                            TempX[i] -= matrix[i][g] * X[g];
                    }
                    TempX[i] /= matrix[i][i];
                }
                norm = Math.abs(X[0] - TempX[0]);
                for (int h = 0; h < arrSize; h++) {
                    if (Math.abs(X[h] - TempX[h]) > norm)
                        norm = Math.abs(X[h] - TempX[h]);
                    X[h] = TempX[h];
                }
                iter++;
            } while (norm > eps); //while ||xn-x(n-1)|| > 0,005
            X[2] = 0;
        }

        for (int i = 0; i < arrSize; i++) {
            System.out.println("x" + i + " = " + X[i]);
        }
        System.out.println("Iter: " + iter);
    }
    //Check matrix
    public static boolean JacobiTrue(double[][] matrix){
        double []maxX = new double[4];
        for (int i = 0; i < 4; i++) {
            double max = 0;
            for (int j = 0; j < 4; j++) {
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                }
            }
            maxX[i] = max;
        }
        for (int i = 0; i < 4; i++) {
            double sum = 0;
            for (int j = 0; j < 4; j++) {
                if(matrix[i][j] != maxX[i]){
                    sum += Math.abs(matrix[i][j]);
                }
            }
            if(sum > Math.abs(maxX[i])){
                return false;
            }
        }
        return true;
    }
}
