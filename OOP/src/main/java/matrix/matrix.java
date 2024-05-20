package matrix;

class main{
    public static void main(String[] args) {
        matrix matrix1 = new matrix(2, 2);
        matrix1.setValue(0, 0, 11);
        matrix1.setValue(0, 1, 22);
        matrix1.setValue(1, 0, 33);
        matrix1.setValue(1, 1, 44);

        matrix matrix2 = new matrix(2, 2);
        matrix2.setValue(0, 0, 55);
        matrix2.setValue(0, 1, 66);
        matrix2.setValue(1, 0, 77);
        matrix2.setValue(1, 1, 88);

        System.out.println("Первая матрица: ");
        matrix1.printMatrix();
        System.out.println();

        System.out.println("Вторая матрица: ");
        matrix2.printMatrix();
        System.out.println();

        matrix1.multiplyByScalar(8);
        System.out.println();

        matrix1.multiply(matrix2);
    }
}

public class matrix {
    private double[][] matrix;
    private int rows;
    private int columns;

    public matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new double[rows][columns];
    }

    public void setValue(int i, int j, double value) {
        matrix[i][j] = value;
    }

    public void multiplyByScalar(double scalar) {
        matrix result = new matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.setValue(i, j, this.matrix[i][j] * scalar);
            }
        }

        System.out.println("Результат умножения матрицы на скаляр: ");
        result.printMatrix();
    }

    public void multiply(matrix other) {
        matrix result = new matrix(this.rows, other.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }

        System.out.println("Результат умножения матрицы: ");
        result.printMatrix();
    }

    public void printMatrix() {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
