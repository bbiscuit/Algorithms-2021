#pragma once

typedef unsigned long long ull;

namespace sorts {

    void insertion_sort(int* arr, ull size);

    void swap(int* arr, ull item1, ull item2);

    void partition(int* arr, ull size , ull first, ull last);

    void quickSort(int* arr, ull size, ull first, ull last);

    void quick_sort(int* arr, ull size);

}