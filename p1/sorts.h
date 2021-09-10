#pragma once

typedef long int ar_size;

namespace sorts {
    enum class PivotChoice {
        last,
        middle,
        median
    };


    void insertion_sort(int* arr, ar_size size);

    void quick_sort(int* arr, ar_size size, PivotChoice choice = PivotChoice::last);

}