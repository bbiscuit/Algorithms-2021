#include "sorts.h"

void sorts::insertion_sort(int* arr, ull size) {
    for (ull j = 1; j < size; j++) {
        int key = arr[j];
        int i = j - 1;

        while (i >= 0 && arr[i] > key) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = key; 
    }
}

void swap(int* arr, ull item1, ull item2) {
    int temp = arr[item1];
    arr[item1] = arr[item2];
    arr[item2] = temp;
}

ull partition(int* arr, ull size , ull first, ull last) {
    int pivot = arr[last];
    ull lower = first;
    ull upper = last-1;

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

void quickSort(int* arr, ull size, ull first, ull last){
    if (first < last) {
        ull mid = partition(arr, size, first, last);
        quickSort(arr, size, first, mid-1);
        quickSort(arr, size, mid, last);
    }
}

void sorts::quick_sort(int* arr, ull size) {
    ull first,last;
    first = 0;
    last = size;
    quickSort(arr,size,first,last);
}
