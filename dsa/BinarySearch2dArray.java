import java.util.Arrays;

public class BinarySearch2dArray {
    public static void main(String[] args) {
        int[][] matrix={{1,1},{2,2}};
        System.out.println(Arrays.toString(search(matrix, 3)));
    }
    public static int[] binarysearch2darray(int[][] matrix,int row,int cstart,int cend,int target){
        while(cstart<=cend){
            int mid= cstart+(cend-cstart)/2;
            if(matrix[row][mid]==target){
                return new int[]{row,mid};
            }
            if(matrix[row][mid]<target){
                cstart=mid+1;
            }
            else{
                cend=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    static int[] colsearch(int[][] matrix,int rstart,int rend, int target){
        while(rstart<=rend){
            int mid=rstart+(rend-rstart)/2;
            if(matrix[mid][0]==target){
                return new int[]{mid,0};
            }
            if(matrix[mid][0]<target){
                rstart=mid+1;
            }
            else{
                rend=mid-1;
            }
        }
        return new int[] {-1,-1};
    }
    static int[] search(int[][]matrix,int target){
        if(matrix==null) return new int[]{-1,-1};
        int row=matrix.length;
        int cols=matrix[0].length;
        if(row==1){
            return binarysearch2darray(matrix, 0,0, cols-1, target);
        }
        if(cols==1){
            return colsearch(matrix, 0, row-1, target);
        }
        int rstart=0;
        int rend=row-1;
        int cmid=cols/2;
        //run the loop till 2 rows are remaining
        while(rstart<(rend-1)){
            int mid= rstart+(rend-rstart)/2;
            if(matrix[mid][cmid]==target){
                return new int[]{mid,cmid};
            }
            if(matrix[mid][cmid]<target){
                rstart=mid;
            }
            else{
                rend=mid;
            }
        }
        if(matrix[rstart][cmid]==target){
            return new int[]{rstart,cmid};
        }
        if(matrix[rstart+1][cmid]==target){
            return new int[]{rstart+1,cmid};
        }
        if(target<=matrix[rstart][cmid-1]){
            return binarysearch2darray(matrix, rstart, 0, cmid-1, target);
        }
        if(target>= matrix[rstart][cmid+1] && target<=matrix[rstart][cols-1]){
            return binarysearch2darray(matrix, rstart, cmid+1, cols-1, target);
        }
        if(target<=matrix[rstart+1][cmid-1]){
            return binarysearch2darray(matrix, rstart+1, 0, cmid-1, target);
        }
        else{
            return binarysearch2darray(matrix, rstart, cmid+1, cols-1, target);
        }
    }
}
