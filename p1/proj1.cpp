#include <iostream>
#include "sorts.h"
#include <stdlib.h>

using namespace std;

bool test_sortedness(int* arr, ar_size size) {
    for (ar_size i = 1; i < size; i++) {
        if (arr[i] < arr[i - 1]) {
            return false;
        }
    }

    return true;
}

int* random_array(ar_size size) {
    int* arr = new int[size];
    for (ar_size i = 0; i < size; i++) {
        arr[i] = rand();
    }

    return arr;
}

bool test_quicksort(ar_size size){
    // I. Create an array of randomly sized elements.
    // II. Run the array through the insertion sort algorithm.
    // III. Test whether or not it is sorted.

    // I. Create an array of randomly sized elements.
    int* arr = random_array(size);

    // II. Run the array through the insertion sort algorithm.
    sorts::quick_sort(arr, size);

    // III. Test whether or not it is sorted.
    bool result = test_sortedness(arr, size);

    delete[] arr;

    return result;
}

bool test_insertion(ar_size size) {
    // I. Create an array of randomly sized elements.
    // II. Run the array through the insertion sort algorithm.
    // III. Test whether or not it is sorted.

    // I. Create an array of randomly sized elements.
    int* arr = random_array(size);

    // II. Run the array through the insertion sort algorithm.
    sorts::insertion_sort(arr, size);

    // III. Test whether or not it is sorted.
    bool result = test_sortedness(arr, size);

    delete[] arr;

    return result;
}

int main() {
    srand(0);
    cout << "quicksort test: " << test_quicksort(100000000) << endl;
    cout << "insertion test: " << test_insertion(10000) << endl;
}