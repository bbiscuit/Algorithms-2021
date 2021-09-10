#include <iostream>
#include "sorts.h"
#include <stdlib.h>
#include <chrono>
#include <tuple>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>

using namespace std;
using namespace std::chrono;

typedef duration<nanoseconds> nanotime;
typedef tuple<ar_size, unsigned long long, unsigned long long> size_ins_quick;
typedef tuple<ar_size, unsigned long long> SizeByRuntime;

void log_data(vector<size_ins_quick> data, string filepath) {
    // I. Declare variables.
    // II. LOOP THROUGH the data vector...
        // A. Append the data piece as a row in the CSV
        // in the following format:
        // [# run, insertion nanoseconds, quick nanoseconds]
    // III. Write the file.

    // I. Declare variables.
    stringstream ss;
    ofstream f;

    // I. LOOP THROUGH the data vector...
    for (auto& e : data) {
        // A. Append the data piece as a row in the CSV
        // in the following format:
        // [# run, insertion nanoseconds, quick nanoseconds]
        ss << get<0>(e) << ',' << get<1>(e) << ',' << get<2>(e) << '\n';

    }

    // II. Write the file.
    try {
        f.open(filepath);
        f << ss.str();
    }
    catch (...) {
        f.close();
    }
}

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

unsigned long long run_insertion(int* arr, ar_size size) {
    auto begin = steady_clock::now();
    sorts::insertion_sort(arr, size);
    auto end = steady_clock::now();

    return duration_cast<nanoseconds>(end - begin).count();
}

unsigned long long run_quick(int* arr, ar_size size) {
    auto begin = steady_clock::now();
    sorts::quick_sort(arr, size);
    auto end = steady_clock::now();

    return duration_cast<nanoseconds>(end - begin).count();
}

void run_tests(vector<size_ins_quick>& data, bool run_i, bool run_q, unsigned short rerun_count, ar_size min_size, ar_size max_size, ar_size size_step) {
    for (ar_size i = min_size; i <= max_size; i += size_step) {
        double avg_ins = 0.0;
        double avg_quick = 0.0;

        cout << "size: " << i << endl;

        for (unsigned short j = 0; j < rerun_count; j++) {
            int* ins = random_array(i);
            int* quick = clone_array(ins, i);

            if (run_i) {
                avg_ins += run_insertion(ins, i) / (double)rerun_count;
            }
            if (run_q) {
                auto result = run_quick(quick, i);
                avg_quick += result / (double)rerun_count;
            }

            delete[] ins;
            delete[] quick;
        }

        data.push_back(make_tuple(i, (unsigned long long)avg_ins, (unsigned long long)avg_quick));
    }
}


/*
tuple<unsigned long long, unsigned long long> run_test(ar_size size) {
    // I. Generate the arrays necessary.
    int* ins_arr = random_array(size);
    int* quick_arr = clone_array(ins_arr, size);

    // II. Run the test, while recording the timespan for both.
    // auto begin = system_clock::now();
    //unsigned long begin = duration_cast<nanoseconds>(high_resolution_clock::now().time_since_epoch()).count();
    auto begin = std::chrono::steady_clock::now();
    sorts::insertion_sort(ins_arr, size);
    auto end = std::chrono::steady_clock::now();
    //unsigned long end = duration_cast<nanoseconds>(high_resolution_clock::now().time_since_epoch()).count();
    // auto end = system_clock::now();
    // auto result_ins = end - begin;
    //unsigned long result_ins = end - begin;
    auto result_ins = end - begin;

    begin = std::chrono::steady_clock::now();
    //begin = duration_cast<nanoseconds>(high_resolution_clock::now().time_since_epoch()).count();
    sorts::quick_sort(quick_arr, size);
    end = std::chrono::steady_clock::now();
    //end = duration_cast<nanoseconds>(high_resolution_clock::now().time_since_epoch()).count();
    //unsigned long result_quick = end - begin;
    auto result_quick = end - begin;

    delete[] ins_arr;
    delete[] quick_arr;

    return make_tuple(duration_cast<nanoseconds>(result_ins).count(), duration_cast<nanoseconds>(result_quick).count());
}
*/

int main(int argc, char** argv) {
    srand(time(0));

    vector<size_ins_quick> data;

    // quick:
    // run_tests(data, false, true, 3, 0, 250000, 1000);
    // run_tests(data, false, true, 3, 260000, 500000, 10000);
    // run_tests(data, false, true, 3, 600000, 1000000, 100000);
    

    // insertion:
    // run_tests(data, false, true, 3, 0, 3000, 5);
    // run_tests(data, false, true, 3, 3100, 10000, 100);
    // run_tests(data, false, true, 3, 11000, 50000, 1000);
    // run_tests(data, false, true, 3, 60000, 100000, 10000);

    // compare:
    run_tests(data, true, true, 100, 1, 200, 1);

    // run_tests(data, true, true, 3, 1, 200, 1);

    log_data(data, "iq_compare.csv");
}
