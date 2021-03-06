package Lab2;

public class InverseM {

    public static double determinant(double[][] matrix) {
    if (matrix.length != matrix[0].length)
        throw new IllegalStateException("invalid dimensions");

    if (matrix.length == 2)
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

    double det = 0;
    for (int i = 0; i < matrix[0].length; i++)
        det += Math.pow(-1, i) * matrix[0][i]
                * determinant(minor(matrix, 0, i));
    return det;
}

    public static double[][] inverse(double[][] matrix) {
        System.out.println("********** Inverse matrix: **********");

        double[][] inverse = new double[matrix.length][matrix.length];

        // minors and cofactors
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverse[i][j] = Math.pow(-1, i + j)
                        * determinant(minor(matrix, i, j));

        // adjugate and determinant
        double det = 1.0 / determinant(matrix);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }

        return inverse;
    }

    public static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }
    public static void display(double[][] matrix) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.printf("%.6f ", matrix[i][j]);
            System.out.println();
        }
    }


}
