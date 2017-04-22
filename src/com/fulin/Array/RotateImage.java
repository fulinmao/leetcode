public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // 关于对角线 进行互换
        for(int i=0 ; i < n ;i++){
            for(int j = i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // 列列进行互换 
        for(int i = 0 ; i < (n/2) ;i ++){
            for(int j= 0 ; j < n;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][ n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
        
    }
}
