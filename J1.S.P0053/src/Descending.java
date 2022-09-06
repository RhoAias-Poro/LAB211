
public class Descending {
     public Descending(Integer[] arrNeedSort)
    {
        //Sort Descending
        int arrNeedSortLength = arrNeedSort.length; 
        int swap;
        System.out.println("----- Descending -----");
        for(int i = 0; i < arrNeedSortLength; i++)
        {
           for(int j = 0; j < arrNeedSortLength - 1 - i; j++)
           {
               if(arrNeedSort[j] < arrNeedSort[j+1])
               {
                   swap = arrNeedSort[j];
                   arrNeedSort[j] = arrNeedSort[j+1];
                   arrNeedSort[j+1] = swap; 
               }
           }
        }
        
        // print
        String result = "";
        for(int i = 0; i < arrNeedSortLength; i++)
        {
            result += ("[" + arrNeedSort[i] + "]");
            if(i != arrNeedSortLength - 1) result += "<-";
        }
        System.out.println(result);
    }  
}
