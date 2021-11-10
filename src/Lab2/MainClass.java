package Lab2;

import Lab2.GaussMaxInRow;
import Lab2.InverseM;
import Lab2.Jacobi;
import Lab2.NormNumb;

public class MainClass {
    public static double[][] matrix = {{ 2, 1, -1, 0},
                                    { 1, 3,  0, 1},
                                    {-1, 0,  2, 1},
                                    { 0, 1,  1, 4}};

    public static double[] arrayB = {1, -3, -2, -5};

    public static void main(String[] args) {
        InverseM.display(matrix);
//        Jacobi.JacobiFunc(matrix, arrayB);
//        System.out.println("********** Matrix norm and cond(A) **********");
//        NormNumb.condNum(matrix, inverseMatrix);
//        GaussInverse.inverse(matrix,arrayB);
         double[][] inverse = SolveGauss.solveGauss(matrix,arrayB);
        System.out.println("********** Matrix norm and cond(A) **********");
        NormNumb.condNum(matrix, inverse);
    }
}
