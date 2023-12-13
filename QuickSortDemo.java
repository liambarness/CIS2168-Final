public class QuickSortDemo {

    // Function to perform QuickSort
    static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            // Recursively sort elements before and after partition
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                // Swap elements at i and j
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;

                // Displaying each swap
                System.out.println("Swapping elements: " + arr[i] + " and " + arr[j]);
            }
        }

        // Swap pivot with element at index i+1
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        // Displaying swap with pivot
        System.out.println("Swapping pivot: " + arr[i+1] + " and " + arr[end]);

        return i+1;
    }

    // Function to print array
    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr, 0, n-1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
