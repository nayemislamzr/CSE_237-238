#include <iostream>
#include <vector>

void merge(std::vector<int> &arr, int start, int end, int mid)
{
    std::vector<int> temp(arr);
    int i, j, k;
    i = j = 0;
    k = start;
    int n = mid - start + 1;
    int m = end - mid;
    while (i < n && j < m)
    {
        if (temp[start + i] < temp[mid + 1 + j])
            arr[k++] = temp[start + i++];
        else
            arr[k++] = temp[mid + 1 + j++];
    }
    while (i < n)
        arr[k++] = temp[start + i++];
    while (j < m)
        arr[k++] = temp[mid + 1 + j++];
}

void merge_sort(std::vector<int> &arr, int start, int end)
{
    if (start >= end)
        return;
    int mid = (start + end) >> 1;
    merge_sort(arr, start, mid);
    merge_sort(arr, mid + 1, end);
    merge(arr, start, end, mid);
}