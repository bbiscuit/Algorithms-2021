#include <iostream>
#include "sorts.h"
#include <stdlib.h>

using namespace std;

bool test_sortedness(int* arr, ull size) {
    for (ull i = 1; i < size; i++) {
        if (arr[i] < arr[i - 1]) {
            return false;
        }
    }

    return true;
}

int* random_array(ull size) {
    int* arr = new int[size];
    for (ull i = 0; i < size; i++) {
        arr[i] = rand();
    }

    return arr;
}

bool test_insertion(ull size) {
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
    
    cout << "insertion test: " << test_insertion(100000) << endl;
}