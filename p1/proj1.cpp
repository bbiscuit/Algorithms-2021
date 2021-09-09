#include <iostream>
#include "sorts.h"
#include <stdlib.h>
#include <chrono>
#include <tuple>
#include <string>

using namespace std;
using namespace std::chrono;

typedef duration<nanoseconds> nanotime;

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

int* clone_array(int* arr, ar_size size) {
    int* arr2 = new int[size];

    for (ar_size i = 0; i < size; i++) {
        arr2[i] = arr[i];
    }

    return arr2;
}

tuple<unsigned long, unsigned long> run_test(ar_size size) {
    // I. Generate the arrays necessary.
    int* ins_arr = random_array(size);
    int* quick_arr = clone_array(ins_arr, size);

    // II. Run the test, while recording the timespan for both.
    // auto begin = system_clock::now();
    unsigned long begin = duration_cast<nanoseconds>(system_clock::now().time_since_epoch()).count();
    sorts::insertion_sort(ins_arr, size);
    unsigned long end = duration_cast<nanoseconds>(system_clock::now().time_since_epoch()).count();
    // auto end = system_clock::now();
    // auto result_ins = end - begin;
    unsigned long result_ins = end - begin;

    begin = duration_cast<nanoseconds>(system_clock::now().time_since_epoch()).count();
    sorts::quick_sort(quick_arr, size);
    end = duration_cast<nanoseconds>(system_clock::now().time_since_epoch()).count();
    unsigned long result_quick = end - begin;

    delete[] ins_arr;
    delete[] quick_arr;

    return make_tuple(result_ins, result_quick);
}

int main(int argc, char** argv) {
    srand(time(0));
    ar_size size;
    if (argc > 1) {
        size = stoi(argv[1]);
    }
    else {
        size = 500;
    }

    auto result = run_test(size);

    cout << "ins runtime: " << get<0>(result) << endl;
    cout << "quick runtime: " << get<1>(result) << endl;
}
