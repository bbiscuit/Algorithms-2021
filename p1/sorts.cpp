#include "sorts.h"

#include <algorithm>

using namespace std;


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

ar_size partition(int* arr, ar_size size , ar_size first, ar_size last, sorts::PivotChoice choice) {
    int pivot_i = 0;
    int pivot;

    switch (choice) {
        case sorts::PivotChoice::last:
            pivot_i = last;
        break;

        case sorts::PivotChoice::middle:
            pivot_i = last / 2;
        break;

        case sorts::PivotChoice::median:
            int mid = last / 2;
            
            if (arr[first] > arr[last]) {

                if (arr[last] > arr[mid]) {
                    pivot_i = last;
                }
                else if (arr[first] > arr[mid]) {
                    pivot_i = mid;
                }
                else {
                    pivot_i = first;
                }

            }
            else {

                if (arr[first] > arr[mid]) {
                    pivot_i = first;
                }
                else if (arr[last] > arr[mid]) {
                    pivot_i = mid;
                }
                else {
                    pivot_i = last;
                }

            }

        break;
    }

    swap(arr, last, pivot_i);
    pivot = arr[pivot_i];

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

void quickSort(int* arr, ar_size size, ar_size first, ar_size last, sorts::PivotChoice choice){
    if (first < last) {
        ar_size mid = partition(arr, size, first, last, choice);
        quickSort(arr, size, first, mid-1, choice);
        quickSort(arr, size, mid+1, last, choice);
    }
}

ar_size partitionTwo(int* arr, ar_size size , ar_size first, ar_size last) {
    ar_size pivot = arr[last];
    ar_size lowPtr = first - 1;
    for (ar_size i = first; i < (last - 1); i++) {
        if (arr[i] <= pivot){
            lowPtr = lowPtr + 1;
            swap(arr, lowPtr, i);
        }
    }
    lowPtr = lowPtr + 1;
    swap(arr, lowPtr, last);
    return lowPtr;
}

void quickSortTheSecond(int* arr, ar_size size, ar_size first, ar_size last){
    if (first < last) {
        ar_size mid = partitionTwo(arr, size, first, last);
        quickSort(arr, size, first, mid-1);
        quickSort(arr, size, mid+1, last);
    }
}

void sorts::quick_sort(int* arr, ar_size size, sorts::PivotChoice choice) {

    ar_size first,last;
    first = 0;
    last = size - 1;
    quickSort(arr,size,first,last, choice);
}

void sorts::quick_sortPrtTwo(int* arr, ar_size size) {
    ar_size first,last;
    first = 0;
    last = size - 1;
    quickSortTheSecond(arr,size,first,last);
}