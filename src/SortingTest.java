import java.util.Arrays;
import java.util.Random;

public class SortingTest {
    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(50);
        int[] sortedArray = generateSortedArray(50);
        int[] reverseSortedArray = generateReverseSortedArray(50);

        // Test Insertion Sort
        testSortingAlgorithm("Random Array - Insertion Sort", randomArray.clone(), InsertionSort.class);
        testSortingAlgorithm("Sorted Array - Insertion Sort", sortedArray.clone(), InsertionSort.class);
        testSortingAlgorithm("Reverse Sorted Array - Insertion Sort", reverseSortedArray.clone(), InsertionSort.class);

        // Test Selection Sort
        testSortingAlgorithm("Random Array - Selection Sort", randomArray.clone(), SelectionSort.class);
        testSortingAlgorithm("Sorted Array - Selection Sort", sortedArray.clone(), SelectionSort.class);
        testSortingAlgorithm("Reverse Sorted Array - Selection Sort", reverseSortedArray.clone(), SelectionSort.class);
    }

    private static void testSortingAlgorithm(String arrayType, int[] arr, Class<?> sortingClass) {
        System.out.println("Testing " + arrayType + ":");
        try {
            long startTime = System.nanoTime();
            if (sortingClass == InsertionSort.class) {
                InsertionSort.sort(arr);
            } else if (sortingClass == SelectionSort.class) {
                SelectionSort.sort(arr);
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
            System.out.println("Time taken: " + duration + " milliseconds");
            System.out.println("Sorted array: " + Arrays.toString(arr));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100); // Generate random numbers between 0 and 99
        }
        return arr;
    }

    private static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i; // Sorted array
        }
        return arr;
    }

    private static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i; // Reverse sorted array
        }
        return arr;
    }
}
