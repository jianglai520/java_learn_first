package com.jianglai.learn.stage02;

/**
 * 矩阵类 Matrix
 */
public class Matrix {
    private int rows;
    private int cols;
    private int[][] data;

    /**
     * 构造方法：创建指定行列的矩阵
     * @param rows 行数
     * @param cols 列数
     */
    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("行数和列数必须大于0");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    /**
     * 初始化矩阵元素
     * @param values 二维数组，用于初始化矩阵；若为null则全部置为0
     */
    public void initValue(int[][] values) {
        if (values != null) {
            if (values.length != rows) {
                throw new IllegalArgumentException("初始化数据的行数与矩阵行数不一致");
            }
            for (int i = 0; i < rows; i++) {
                if (values[i].length != cols) {
                    throw new IllegalArgumentException("初始化数据的列数与矩阵列数不一致");
                }
                for (int j = 0; j < cols; j++) {
                    data[i][j] = values[i][j];
                }
            }
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i][j] = 0;
                }
            }
        }
    }

    /**
     * 矩阵加法：返回两个矩阵相加后的新矩阵
     * @param other 另一个矩阵
     * @return 相加后的新矩阵
     */
    public Matrix add(Matrix other) {
        checkSameSize(other, "相加");
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    /**
     * 矩阵减法：返回两个矩阵相减后的新矩阵
     * @param other 另一个矩阵
     * @return 相减后的新矩阵
     */
    public Matrix sub(Matrix other) {
        checkSameSize(other, "相减");
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    /**
     * 检查两个矩阵尺寸是否一致
     */
    private void checkSameSize(Matrix other, String opName) {
        if (other == null) {
            throw new IllegalArgumentException("参与" + opName + "的矩阵不能为null");
        }
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("矩阵" + opName + "要求行列数相同");
        }
    }

    /**
     * 返回矩阵的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append("[ ");
            for (int j = 0; j < cols; j++) {
                sb.append(data[i][j]);
                if (j < cols - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            if (i < rows - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * 比较两个矩阵是否相同
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Matrix other = (Matrix) obj;
        if (this.rows != other.rows || this.cols != other.cols) return false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.data[i][j] != other.data[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + rows;
        result = 31 * result + cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result = 31 * result + data[i][j];
            }
        }
        return result;
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
}
