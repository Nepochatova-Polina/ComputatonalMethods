
public class MainClass {
    public static double[][] matrix = {{2, 1, -1, 0}, {1, 3, 0, 1}, {-1, 0, 2, 1}, {0, 1, 1, 4}};
    public static double[] arrayB = {1, -3, -2, -5};

    public static void main(String[] args) {
        double det = InverseM.determinant(matrix);
        System.out.println("********** Determinant: **********\n" + det);
        double[][] inverseMatrix = InverseM.inverse(matrix);
        System.out.println("********** Inverse matrix: **********");
        InverseM.display(inverseMatrix);
        System.out.println("********** Matrix norm and cond(A) **********");
        NormNumb.condNum(matrix,inverseMatrix);
        Gauss.GaussFunc(matrix,arrayB);
        Jacobi.JacobiFunc(matrix,arrayB);
    }
}
