public class NormNumb {
    public static double MatrixNorm(double[][]matrix){
        double max = 0.0;
        double sum = 0.0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum += Math.abs(matrix[i][j]);
            }
            if(sum > max){
                max = sum;
            }
            sum = 0.0;
        }
        System.out.println("Matrix norm in infinity: " + max);
        return max;
    }
    public static double condNum(double[][] matrix, double[][] inverseMatrix){
        double matrixNorm = MatrixNorm(matrix);
        double inverseMatrixNorm = MatrixNorm(inverseMatrix);
        double result = matrixNorm+inverseMatrixNorm;
        System.out.println("cond(A): " + result);
        return matrixNorm * inverseMatrixNorm;
    }
}
