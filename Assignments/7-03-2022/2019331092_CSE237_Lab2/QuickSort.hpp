#include <vector>

int partition(std::vector<int> &arr, int left, int right)
{
    bool r = true;
    while (left < right)
    {
        if (arr[left] > arr[right])
        {
            r ^= 1;
            std::swap(arr[left], arr[right]);
        }

        if (r)
            right--;
        else
            left++;
    }
    return left;
}

void quick_sort(std::vector<int> &arr, int left, int right)
{
    if (left >= right)
        return;
    int p = partition(arr, left, right);

    quick_sort(arr, left, p - 1);
    quick_sort(arr, p + 1, right);
}