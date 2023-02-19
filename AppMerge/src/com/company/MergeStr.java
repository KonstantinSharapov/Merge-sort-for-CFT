public class MergeStr {

    private Comparable[] theArray;
    private int nElems;

    public MergeStr(){}
    public MergeStr(String[] str){
        nElems = str.length;
        theArray = new Comparable[nElems];
        for (int i = 0; i < nElems; i++) {
            theArray[i] = delWorkSpace(str[i]);
        }
    }
    public int length(){
        return nElems;
    }
    public Object[] getTheArray(){
        return theArray;
    }
    //проверить v < w ?
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    public void display(){
        for (int i = 0; i < nElems; i++)
            System.out.print(theArray[i]+" ");
        System.out.println();
    }
    private String delWorkSpace(String s){
        String result = "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] !=' ')
                result = result.concat(String.valueOf(arr[i]));
        }
        return result;
    }
    // восходящая сортировка
    // в первом мы увеличиваем размер в два раза
    // во втором мы проходим левую и правую часть подмассива, потом слияние и так далее
    public void sort() {
        for (int len = 1; len < nElems; len *= 2)
            for (int left = 0; left < nElems-len; left += len+len) {
                int mid  = left+len-1;
                int right = Math.min(left+len+len-1, nElems-1);
                merge(theArray,left,mid,right);
            }
    }
    //сортировка слиянием на месте
    private void merge(Comparable[] arr, int start, int mid, int end) {
        int start2 = mid + 1;
        // Если прямое слияние уже отсортировано
        if (less(arr[mid], arr[start2])) {
            return;
        }
        // проходим по двум частям единого массива
        // от начала к середине и от середины до конца
        while (start <= mid && start2 <= end) {
            // Если один элемент находится в нужном месте, то все збс
            if (less(arr[start],arr[start2])) {
                start++;
            }
            //отныне конец это маленькое, а начало большое
            else {
                Comparable cur = arr[start2];
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

