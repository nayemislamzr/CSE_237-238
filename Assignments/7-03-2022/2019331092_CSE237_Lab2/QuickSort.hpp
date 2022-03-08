#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>

int partition(std::vector<int> &arr, int left, int right)
{
    srand(time(0));
    int randomIndex = rand() % (right - left) + left;
    int value = arr[randomIndex];
    std::vector<int> lesser, greater;
    for (int i = left; i < right; i++)
    {
        if (arr[i] <= value && i != randomIndex)
            lesser.push_back(arr[i]);
        else if (arr[i] > value && i != randomIndex)
            greater.push_back(arr[i]);
    }
    for (int i = 0; i < lesser.size(); i++)
        arr[i + left] = lesser[i];
    arr[left + lesser.size()] = value;
    for (int i = 0; i < greater.size(); i++)
        arr[i + left +  lesser.size() + 1] = greater[i];
    return left + lesser.size();
}

void quick_sort(std::vector<int> &arr, int left, int right)
{
    if (left >= right)
        return;
    int p = partition(arr, left, right);

    quick_sort(arr, left, p - 1);
    quick_sort(arr, p + 1, right);
}