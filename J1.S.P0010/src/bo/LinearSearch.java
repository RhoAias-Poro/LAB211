package bo;

public class LinearSearch {
    private int[] array;

    public LinearSearch(int[] array)
    {
        this.array = array;
    }

    private int linearSearch(int searchValue) { // use linear search to found
        for (int i = 0; i < array.length; i++) // create a for loop from 0 to length - 1 to perform liner search
        {
            if (searchValue == array[i]) { //if value need to search match the value at the index i
                return i;
            }
        }
        return -1;
    }

    public int getSorted(int searchValue)
    {
       return linearSearch(searchValue);
    }
}
