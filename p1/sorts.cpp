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

void sorts::quick_sort(int* arr, ull size) {

}