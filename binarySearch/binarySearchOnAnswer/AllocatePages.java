package binarySearchOnAnswer;

/**
 * ALLOCATE MINIMUM NUMBER OF PAGES:<br><br>
 * <p>
 * Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. <br>
 * Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages<br>
 * assigned to a student is minimum.<br><br>
 *
 * <code>Example :<br><br>
 * <p>
 * Input : pages[] = {12, 34, 67, 90}<br>
 * &nbsp; &nbsp;        m = 2<br>
 * Output : 113<br>
 * Explanation:<br>
 * There are 2 number of students. Books can be distributed <br>
 * in following fashion : <br>
 * 1) [12] and [34, 67, 90]<br>
 * Max number of pages is allocated to student <br>
 * 2 with 34 + 67 + 90 = 191 pages<br>
 * 2) [12, 34] and [67, 90]<br>
 * Max number of pages is allocated to student<br>
 * 2 with 67 + 90 = 157 pages <br>
 * 3) [12, 34, 67] and [90]<br>
 * Max number of pages is allocated to student <br>
 * 1 with 12 + 34 + 67 = 113 pages<br>
 * <p>
 * Of the 3 cases, Option 3 has the minimum pages = 113. </code>
 */
public class AllocatePages {
    /**
     * @param pages pages array
     * @param k     no of students
     * @return max no of pages that can be allocated to a student,such that each student gets to have at least on book
     */
    public static int minAllocationOfPages(int[] pages, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int page : pages) {
            if (page > max)
                max = page;
            sum += page;
        }
        int low = max, high = sum;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(pages, k, mid)) {
                high = mid - 1;
                res = mid;
            } else low = mid + 1;
        }
        return res;
    }

    public static boolean isValid(int[] pages, int k, int maxAllowed) {
        int students = 1;
        int curSum = 0;
        for (int page : pages) {
            curSum += page;
            if (curSum > maxAllowed) {
                students++;
                curSum = page;
            }
            if (students > k)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //113
        //{12,34,67},{90}
        System.out.println(minAllocationOfPages(new int[]{12, 34, 67, 90}, 2));
        //60
        //{10,20,30},{40}
        System.out.println(minAllocationOfPages(new int[]{10, 20, 30, 40}, 2));
    }

}
