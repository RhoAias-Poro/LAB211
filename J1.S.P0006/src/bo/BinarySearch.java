package bo;

public class BinarySearch {
    private int[] array;

    public BinarySearch(int[] array) {
        this.array = array;
    }

    private int search(int left, int right, int searchNumber) {
        while(left <= right) {
            int middle = left + (right - left)/2;
            if (middle == searchNumber) return middle;
            if (array[middle] > searchNumber) right = middle - 1;
            else if (array[middle] < searchNumber) left = middle + 1;
        }
        return -1;
    }

    public int getSearchNumber(int searchNumber) {
        return search(0, array.length - 1, searchNumber);
    }
}
