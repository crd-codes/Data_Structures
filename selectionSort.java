// Selection Sort

#define INC_ORDER 1
#define DEC_ORDER 2

#include<iostream>
using namespace std;

class ArrayX
{
    public:
        int *Arr;
        int iSize;
        bool Sorted;

        ArrayX(int no);
        ~ArrayX();

        void Accept();
        void Display();

        void SelectionSort();
};

ArrayX :: ArrayX(int no)
{
    cout<<"Inside constructor\n";
    iSize = no;
    Arr = new int[iSize];
    Sorted = true;
}

ArrayX :: ~ArrayX()
{
    cout<<"Inside destructor\n";
    delete [] Arr;
}

void ArrayX :: Accept()
{
    int iCnt = 0;

    cout<<"Enter the elements : \n";
    cin>>Arr[iCnt];

    // iSize = 10
    //0   1    2   3   4   5   6   7   8   9
    //12  10  17  24  28  36  38  52  52  65
    for(iCnt = 1; iCnt < iSize; iCnt++)
    {
        cin>>Arr[iCnt];

        if(Arr[iCnt - 1] > Arr[iCnt])
        {
            Sorted = false;
        }
    }
}

void ArrayX :: Display()
{
    int iCnt = 0;

    cout<<"Elements of the array are : \n";

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        cout<<Arr[iCnt]<<"\t";
    }
    cout<<"\n";
}

/*
    Pass 1 : 1  2  3   4
    Pass 2 : 2  3   4
    Pass 3 : 3   4
    Pass 4 : 4
*/

void ArrayX :: SelectionSort()
{
    int i = 0, j = 0, temp = 0;
    int min_index = 0;

    for(i = 0; i < iSize-1; i++)
    {
        min_index = i;

        for(j = i+1; j < iSize; j++)
        {
            if(Arr[j] < Arr[min_index])
            {
                min_index = j;
            }
        }

        if(i != min_index)
        {
            temp = Arr[i];
            Arr[i] = Arr[min_index];
            Arr[min_index] = temp;
        }
    }
}

int main()
{   
    int iValue = 0;
    
    cout<<"Enter the number of elements : \n";
    cin>>iValue;

    ArrayX aobj(iValue);

    aobj.Accept();

    cout<<"Data Before Sorting\n";

    aobj.Display();

    
    aobj.SelectionSort();

    cout<<"\nData After Sorting\n";
    
    aobj.Display();

    return 0;
}
