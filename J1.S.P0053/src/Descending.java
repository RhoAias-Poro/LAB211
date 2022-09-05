/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Descending {
     public Descending(Integer[] arrNeedSort)
    {
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
        String result = "";
        for(int i = 0; i < arrNeedSortLength; i++)
        {
            result += ("[" + arrNeedSort[i] + "]");
            if(i != arrNeedSortLength - 1) result += "<-";
        }
        System.out.println(result);
    }  
}
