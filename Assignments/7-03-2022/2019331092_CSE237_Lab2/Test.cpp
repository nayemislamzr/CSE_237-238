#include "MergeSort.hpp"
#include "QuickSort.hpp"
#include "RandomArray.hpp"
#include <chrono>

using namespace std::chrono;

const int MAX_ARRAY_SIZE = 10000;
const int MAX_TESTS = 1000;

int quickSortStressTesting(int tests)
{
    auto start = std::chrono::high_resolution_clock::now();
    for (int i = 0; i < tests; i++)
    {
        vector<int> randomArray = getRandomArray(MAX_ARRAY_SIZE);
        quick_sort(randomArray, 0, MAX_ARRAY_SIZE - 1);
    }
    auto end = std::chrono::high_resolution_clock::now();
    auto duration = duration_cast<seconds>(end - start);
    return duration.count();
}

int mergeSortStressTesting(int tests)
{
    auto start = std::chrono::high_resolution_clock::now();
    for (int i = 0; i < tests; i++)
    {
        vector<int> randomArray = getRandomArray(MAX_ARRAY_SIZE);
        merge_sort(randomArray, 0, MAX_ARRAY_SIZE - 1);
    }
    auto end = std::chrono::high_resolution_clock::now();
    auto duration = duration_cast<seconds>(end - start);
    return duration.count();   
}

int main()
{
    cout << "The QuickSort took " << quickSortStressTesting(MAX_TESTS) << " seconds to execute.\n";
    cout << "The MergeSort took " << mergeSortStressTesting(MAX_TESTS) << " seconds to execute.\n";
}