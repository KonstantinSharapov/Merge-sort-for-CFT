package com.company;

public class MergeInt {

    private long[] theArray;
    private int nElems;

    //передаем массив строк в массив чисел
    public MergeInt(String[] arr){
        theArray = new long[arr.length];
        nElems = 0;
        for (String ect: arr){
            if (!containLeter(ect)){
                theArray[nElems] = Integer.parseInt((onlyInt(ect)));
                nElems++;
            }
        }
    }
    public int length(){
        return nElems;
    }
    public long[] getTheArray(){
        return theArray;
    }
    public void display(){
        for (int i = 0; i < nElems; i++)
            System.out.print(theArray[i]+" ");
        System.out.println();
    }
    //проверка на наличие прочих символов в строке
    private boolean containLeter(String string){
        for (int i = 0; i < string.length(); ++i) {
            if (Character.isLetter(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    //выбираем только числа из строк
    private String onlyInt(String str){
        String result = "";
        char[] arr = str.toCharArray();
        for (char ect: arr) {
            if (Character.isDigit(ect)){
                result = result.concat(String.valueOf(ect));
            }
        }
        return result;
    }
    // восходящая сортировка
    // в первом мы увеличиваем размер в два раза
    // во втором мы проходим левую и правую часть подмассива, потом слияние и так далее
    public void sort(){
        for (int len = 1; len < nElems; len *= 2)
            for (int left = 0; left < nElems - len; left +=len+len){
                int mid = left + len - 1;
                int right = Math.min(left+len+len-1,nElems-1);
                merge(theArray,left, mid, right);
            }
    }
    //сортировка слиянием на месте
    private void merge(long[] arr, int start, int mid, int end) {
        int start2 = mid + 1;
        // Если прямое слияние уже отсортировано
        if (arr[mid] <= arr[start2]) {
            return;
        }
        // проходим по двум частям единого массива
        // от начала к середине и от середины до конца
        while (start <= mid && start2 <= end) {
            // Если один элемент находится в нужном месте, то все збс
            if (arr[start] <= arr[start2]) {
                start++;
            }
            //отныне конец это маленькое, а начало большое
            else {
                long cur = arr[start2];
                int index = start2;
                // сдвиг всех элементов в отношении одного
                // двигаемся от конца к началу и делаем перезапись
                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = cur;
                // обновление точек и продвижение вперед
                start++;
                mid++;
                start2++;
            }
        }
    }
}

