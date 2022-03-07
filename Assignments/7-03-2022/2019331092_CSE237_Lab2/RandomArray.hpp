#include <vector>
#include <ctime>
#include <cstdlib>

const int MIN_VAL = -100000000;
const int MAX_VAL = 100000000;

using namespace std;

vector<int> getRandomArray(int size)
{
    srand(time(0));
    vector<int> arr(size);
    for(int i = 0 ; i < size ; i++)
        arr[i] = rand();
    return arr;
}