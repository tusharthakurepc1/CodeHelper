package com.CP;

import com.Matrix;

public class MatrixExponential {
    public static void main(String[] args) {
        int n = 6;
//                0 1 1 2 3 5
//        Matrix T = new Matrix(2);
//        T.identityMatrix();
//        T.matrix.get(0).add(0, 1);
//        T.matrix.get(0).add(1, 1);
//        T.matrix.get(1).add(0, 1);
//        T.matrix.get(1).add(1, 0);
//        System.out.println("T Matrix: ");       T.display();
//        Matrix res = fibonacci1MatrixExponential(T, n);
//        res.display();

        Matrix T = new Matrix(3);
        T.identityMatrix();
        T.matrix.get(0).add(0, 1);
        T.matrix.get(0).add(1, 1);
        T.matrix.get(0).add(2, 1);
        T.matrix.get(1).add(0, 1);
        T.matrix.get(1).add(1, 0);
        T.matrix.get(1).add(2, 0);
        T.matrix.get(2).add(0, 0);
        T.matrix.get(2).add(1, 1);
        T.matrix.get(2).add(2, 0);
//        T.display();

        Matrix res = fibonacci2MatrixExponential(T, 4);
        res.display();

    }

    /*
    Fibonacci Exponentiation having complexity Time: O(log N)
    having the recurrence relation are: f(n) = f(n-1) + f(n-2)
     */
    public static Matrix fibonacci1MatrixExponential(Matrix T, int n){
        if(n == 0){
            Matrix temp = new Matrix(n);
            temp.identityMatrix();
            return temp;
        }
        if(n == 1){
            return T;
        }

        Matrix temp = fibonacci1MatrixExponential(T, n/2);
        Matrix res = matrixMul(temp, temp);

        if((n & 1) == 1){
//            For Odd
            res = matrixMul(res, T);
        }

        return res;
    }

    public static Matrix fibonacci2MatrixExponential(Matrix T, int n){
        if(n == 0){
            Matrix temp = new Matrix(n);
            temp.identityMatrix();
            return temp;
        }
        if(n == 1 || n == 2){
            return T;
        }

        Matrix temp = fibonacci2MatrixExponential(T, n/2);
        Matrix res = matrixMul(temp, temp);

        if((n & 1) == 1){
//            If the n is odd so multiply once again
            res = matrixMul(res, T);
        }

        return res;
    }


    public static Matrix matrixMul(Matrix a, Matrix b){       //Time Complexity is O(n^3) if row == col
        int r1 = a.row;
        int c1 = a.col;
        int r2 = b.row;
        int c2 = b.col;

        if(c1 != r2){
            return null;
        }

        Matrix res = new Matrix(r1, c2);

        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                int temp = 0;
                for(int k = 0;k< c1;k++){
                    temp += a.matrix.get(i).get(k) * b.matrix.get(k).get(j);
                }
                res.matrix.get(i).add(j, temp);
            }
        }

        return res;
    }
}


