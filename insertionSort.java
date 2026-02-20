// Insertion Sort

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

        void InsertionSort();
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

void ArrayX :: InsertionSort()
{
    int i = 0, j = 0;
    int Selected = 0;

    for(i = 1; i < iSize; i++)
    {
        for(j = i-1, Selected = Arr[i]; (j >= 0) && (Arr[j] > Selected); j--)
        {
            Arr[j+1] = Arr[j];
        }

        Arr[j+1] = Selected;
    }
}   // End of InsertionSort


int main()
{   
    int iValue = 0;
    
    cout<<"Enter the number of elements : \n";
    cin>>iValue;

    ArrayX aobj(iValue);

    aobj.Accept();

    cout<<"Data Before Sorting\n";

    aobj.Display();
    

    aobj.InsertionSort();

    cout<<"\nData After Sorting\n";
    
    aobj.Display();

    return 0;
}
