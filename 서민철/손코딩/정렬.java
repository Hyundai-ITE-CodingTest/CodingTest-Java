import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] array = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		shuffleSort(array);
		selectionSort(array);
		printSortResult(array, "선택 정렬");

		shuffleSort(array);
		insertionSort(array);
		printSortResult(array, "삽입 정렬");

		shuffleSort(array);
		bubbleSort(array);
		printSortResult(array, "버블 정렬");

		shuffleSort(array);
		mergeSort(array, 0, array.length - 1);
		printSortResult(array, "합병 정렬");

		shuffleSort(array);
		mergeSort(array, 0, array.length - 1);
		printSortResult(array, "퀵 정렬");
	}

	public static void selectionSort(int[] array) {
		int size = array.length;

		for (int i = 0; i < size; i++) {
			int minIdx = i;

			for (int j = i; j < size; j++) {
				if (array[minIdx] > array[j]) {
					minIdx = j;
				}
			}

			int tmp = array[i];
			array[i] = array[minIdx];
			array[minIdx] = tmp;
		}
	}

	public static void insertionSort(int[] array) {
		int size = array.length;

		for (int i = 1; i < size; i++) {
			int nowVal = array[i];

			for (int j = i - 1; j >= 0; j--) {
				if (nowVal < array[j]) {
					array[j + 1] = array[j];
					if (j == 0) {
						array[j] = nowVal;
					}
				} else {
					array[j + 1] = nowVal;
					break;
				}
			}
		}
	}

	public static void bubbleSort(int[] array) {
		int size = array.length;

		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size - i; j++) {
				if (array[j - 1] > array[j]) {
					int tmp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

	public static void merge(int[] array, int left, int mid, int right) {
		int[] sorted = new int[array.length];
		int leftIdx = left;
		int rightIdx = mid + 1;
		int idx = left;

		while (leftIdx <= mid && rightIdx <= right) {
			if (array[leftIdx] < array[rightIdx]) {
				sorted[idx] = array[leftIdx];
				leftIdx += 1;
			} else {
				sorted[idx] = array[rightIdx];
				rightIdx += 1;
			}

			idx += 1;
		}

		while (leftIdx <= mid) {
			sorted[idx] = array[leftIdx];
			leftIdx += 1;
			idx += 1;
		}

		while (rightIdx <= right) {
			sorted[idx] = array[rightIdx];
			rightIdx += 1;
			idx += 1;
		}

		for (int i = left; i <= right; i++) {
			array[i] = sorted[i];
		}
	}

	public static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	public static int partition(int[] array, int left, int right) {
		int pivot = array[left];
		int low = left + 1;
		int high = right;

		while (low < high) {
			while (low <= right && array[low] > pivot) {
				low += 1;
			}

			while (low <= right && array[high] < pivot) {
				right -= 1;
			}

			if (low < high) {
				int tmp = array[low];
				array[low] = array[high];
				array[high] = tmp;
			}
		}

		int tmp = array[left];
		array[left] = array[high];
		array[high] = tmp;

		return high;
	}

	public static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int pivot = partition(array, left, right);
			quickSort(array, left, pivot - 1);
			quickSort(array, pivot + 1, right);
		}
	}

	public static void shuffleSort(int[] array) {
		int[] tmp = { 5, 3, 8, 4, 9, 1, 6, 2, 7 };

		System.out.printf("정렬 전:\t");

		for (int i = 0; i < array.length; i++) {
			array[i] = tmp[i];
			System.out.printf("%d ", array[i]);
		}

		System.out.println();
	}

	public static void printSortResult(int[] array, String sortType) {
		int size = array.length;

		System.out.printf("%s:\t", sortType);

		for (int i = 0; i < size; i++) {
			System.out.printf("%d ", array[i]);
		}

		System.out.printf("\n\n");
	}
}