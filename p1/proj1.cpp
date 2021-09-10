#include "sorts.h"

#include <iostream>
#include <stdlib.h>
#include <chrono>
#include <tuple>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>

using namespace std;
using namespace std::chrono;

typedef tuple<ar_size, unsigned long long, unsigned long long> SizeByInsertionByQuick;
typedef tuple<ar_size, unsigned long long> SizeByRuntime;
typedef tuple<ar_size, unsigned long long, unsigned long long, unsigned long long> SizeByPivotRuntimes;

// CSV LOGGING FUNCTIONS

void logData(vector<SizeByInsertionByQuick> data, string filepath) {
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

void logData(vector<SizeByPivotRuntimes> data, string filepath) {
    // I. Declare variables.
    // II. LOOP THROUGH the data vector...
        // A. Append the data piece as a row in the CSV
        // in the following format:
        // [# run, last pivot ns, middle pivot ns, median pivot ns]
    // III. Write the file.

    // I. Declare variables.
    stringstream ss;
    ofstream f;

    // I. LOOP THROUGH the data vector...
    for (auto& e : data) {
        // A. Append the data piece as a row in the CSV
        // in the following format:
        // [# run, insertion nanoseconds, quick nanoseconds]
        ss << get<0>(e) << ',' << get<1>(e) << ',' << get<2>(e)<< ',' << get<3>(e) << '\n';

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

// ARRAY MANIPULATION

int* randomArray(ar_size size) {
    int* arr = new int[size];
    for (ar_size i = 0; i < size; i++) {
        arr[i] = rand();
    }

    return arr;
}

int* cloneArray(int* arr, ar_size size) {
    int* arr2 = new int[size];

    for (ar_size i = 0; i < size; i++) {
        arr2[i] = arr[i];
    }

    return arr2;
}

// SORT RUNNING FUNCTIONS

unsigned long long runInsertion(int* arr, ar_size size) {
    auto begin = steady_clock::now();
    sorts::insertion_sort(arr, size);
    auto end = steady_clock::now();

    return duration_cast<nanoseconds>(end - begin).count();
}

unsigned long long runQuick(int* arr, ar_size size, sorts::PivotChoice choice = sorts::PivotChoice::last) {
    auto begin = steady_clock::now();
    sorts::quick_sort(arr, size, choice);
    auto end = steady_clock::now();

    return duration_cast<nanoseconds>(end - begin).count();
}

// TEST FUNCTIONS

void runTests(vector<SizeByInsertionByQuick>& data, bool run_i, bool run_q, unsigned short rerun_count, ar_size min_size, ar_size max_size, ar_size size_step) {
    for (ar_size i = min_size; i <= max_size; i += size_step) {
        double avg_ins = 0.0;
        double avg_quick = 0.0;

        cout << "size: " << i << endl;

        for (unsigned short j = 0; j < rerun_count; j++) {
            int* ins = randomArray(i);
            int* quick = cloneArray(ins, i);

            if (run_i) {
                avg_ins += runInsertion(ins, i) / (double)rerun_count;
            }
            if (run_q) {
                auto result = runQuick(quick, i);
                avg_quick += result / (double)rerun_count;
            }

            delete[] ins;
            delete[] quick;
        }

        data.push_back(make_tuple(i, (unsigned long long)avg_ins, (unsigned long long)avg_quick));
    }
}

void runPivotCompare(vector<SizeByPivotRuntimes>& data, unsigned short rerun_count, ar_size min_size, ar_size max_size, ar_size size_step) {
    for (ar_size i = min_size; i <= max_size; i += size_step) {
        double avg_last = 0.0;
        double avg_middle = 0.0;
        double avg_median = 0.0;

        cout << "size: " << i << endl;

        for (unsigned short j = 0; j < rerun_count; j++) {
            int* last = randomArray(i);
            int* middle = cloneArray(last, i);
            int* median = cloneArray(last, i);

            avg_last += runQuick(last, i, sorts::PivotChoice::last) / (double)rerun_count;
            avg_middle += runQuick(middle, i, sorts::PivotChoice::middle) / (double)rerun_count;
            avg_median += runQuick(median, i, sorts::PivotChoice::median) / (double)rerun_count;

            delete[] last;
            delete[] middle;
            delete[] median;
        }

        data.push_back(make_tuple(i, (unsigned long long)avg_last, (unsigned long long)avg_middle, (unsigned long long)avg_median));
    }
}

void runPreSorted(vector<SizeByInsertionByQuick>& data, unsigned short rerun_count, ar_size min_size, ar_size max_size, ar_size size_step) {
    for (ar_size i = min_size; i <= max_size; i += size_step) {
        double avg_ins = 0.0;
        double avg_quick = 0.0;

        cout << "size: " << i << endl;

        for (unsigned short j = 0; j < rerun_count; j++) {
            int* ins = randomArray(i);
            runQuick(ins, i);
            int* quick = cloneArray(ins, i);

            avg_ins += runInsertion(ins, i) / (double)rerun_count;
            auto result = runQuick(quick, i);
            avg_quick += result / (double)rerun_count;

            delete[] ins;
            delete[] quick;
        }

        data.push_back(make_tuple(i, (unsigned long long)avg_ins, (unsigned long long)avg_quick));
    }
}


int main(int argc, char** argv) {
    srand(time(0));

    vector<SizeByInsertionByQuick> data;
    //vector<SizeByPivotRuntimes> data;

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
    // runTests(data, true, true, 100, 1, 500, 1);

    // presorted
    runPreSorted(data, 100, 0, 50, 1);

    // pivot compares:
    //run_pivot_compare(data, 3, 0, 10000, 100);
    //run_pivot_compare(data, 3, 20000, 500000, 10000);
    //run_pivot_compare(data, 3, 600000, 1000000, 100000);

    // run_tests(data, true, true, 3, 1, 200, 1);

    logData(data, "pre_sorted.csv");
}
