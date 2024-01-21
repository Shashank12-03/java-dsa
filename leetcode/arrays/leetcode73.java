package arrays;
public class leetcode73 {
    public static void main(String[] args) {
        int[][] matrix={{1,1,1},{1,0,1},{1,1,1}};
        
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        // int[]row=new int[matrix.length];
        // int[] col=new int[matrix[0].length];
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(matrix[i][j]==0){
        //             row[i]=1;
        //             col[j]=1;
        //         }
        //     }
        // }
        // // System.out.println(Arrays.toString(row));
        // // System.out.println(Arrays.toString(col));
        // for(int i=0;i<row.length;i++){
        //     for(int j=0;j<col.length;j++){
        //         if(row[i]==1 || col[j]==1){
        //             matrix[i][j]=0;
        //         }
        //     }
        // }
        // for(int i=0;i<row.length;i++){
        //     for(int j=0;j<col.length;j++){
        //         System.out.println(matrix[i][j]);
        //     }
        // }
        //Optimal
        int col1=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0){
                        matrix[0][j]=0;
                    }
                    col1=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        if(col1==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }
}
