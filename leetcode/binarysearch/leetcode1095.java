public class leetcode1095 {
    interface MountainArray {
        public int get(int index);
        public int length();
    }
    public static void main(String[] args) {
        
    } 
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakIndex(mountainArr);
        int leftSearch = binarySearch(mountainArr, target, 0, peakIndex);
        if (leftSearch != -1) {
            return leftSearch;
        }
        return binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length() - 1);
    }
     public int findPeakIndex(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int binarySearch(MountainArray mountainArr, int target, int left, int right) {
        boolean isAsc = mountainArr.get(left) < mountainArr.get(right);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            }
            if (isAsc) {
                if (target < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }   
}