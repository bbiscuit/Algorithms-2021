#include "sorts.h"


void sorts::insertion_sort(int* arr, ar_size size) {
    for (ar_size j = 1; j < size; j++) {
        int key = arr[j];
        int i = j - 1;

        while (i >= 0 && arr[i] > key) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = key; 
    }
}

void swap(int* arr, ar_size item1, ar_size item2) {
    int temp = arr[item1];
    arr[item1] = arr[item2];
    arr[item2] = temp;
}

ar_size partition(int* arr, ar_size size , ar_size first, ar_size last) {
    int pivot = arr[last];
    ar_size lower = first;
    ar_size upper = last-1;

    while (lower <= upper) {
            while (lower <= upper && arr[upper] >= pivot)
                upper--;
            while (lower <= upper && arr[lower] <= pivot)
                lower++;
            if (lower < upper)
                swap(arr, lower, upper);
            
    }
    swap(arr, lower, last);
    return lower;
}

void quickSort(int* arr, ar_size size, ar_size first, ar_size last){
    if (first < last) {
        ar_size mid = partition(arr, size, first, last);
        quickSort(arr, size, first, mid-1);
        quickSort(arr, size, mid+1, last);
    }
}

void sorts::quick_sort(int* arr, ar_size size) {
    ar_size first,last;
    first = 0;
    last = size - 1;
    quickSort(arr,size,first,last);
}
