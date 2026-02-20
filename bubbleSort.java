// Efficient Bubble Sort
// Sort with option (Increasing & Decreasing)-(with macros)

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

        bool CheckSorted();

        void BubbleSort();
        void BubbleSortEfficient();
        void BubbleSortEfficientX(int iOption);
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

    // Sorted = CheckSorted();     // IMP(skill)
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


// iSize = 10
//0   1    2   3   4   5   6   7   8   9
//12  10  17  24  28  36  38  52  52  65
bool ArrayX :: CheckSorted()
{
    int i = 0;
    bool bFlag = true;

    for(i = 0; i < iSize-1; i++)
    {
        if(Arr[i] > Arr[i+1])
        {
            bFlag = false;
            break;
        }
    }
    return bFlag;
}

// 21 15 18 16 11

void ArrayX :: BubbleSort()
{
    int i = 0, j = 0;
    int temp = 0;
    int pass = 0;
    int time = 0;

    if(Sorted == true)                      // imp filter
    {
        return;
    }

    time = 1;
    for(i = 0, pass = 1; i < iSize - 1; i++, pass++)          // Outer
    {
        for(j = 0; j < iSize - 1 - i; j++, time++)  // Inner
        {
            if(Arr[j] > Arr[j + 1])
            {
                temp = Arr[j];
                Arr[j] = Arr[j + 1];
                Arr[j + 1] = temp;
            }
        }

        cout<<"\nData after pass : "<<i + 1<<"\n";
        Display();
    }
    cout<<"Number passes for bubble sort : "<<pass<<"\n";
    cout<<"Total number of iterations : "<<time<<"\n";

    Sorted = true;                          // imp
}   // End of BubbleSort()

// 21 15 18 16 11

void ArrayX :: BubbleSortEfficient()
{
    int i = 0, j = 0;
    int temp = 0;

    bool bFlag = false;

    /*if(Sorted == true)                      // imp filter
    {
        return;
    }*/

    bFlag = true;
    
    for(i = 0; (i < iSize - 1) && (bFlag == true); i++)          // Outer
    {
        bFlag = false;

        for(j = 0; j < iSize - 1 - i; j++)  // Inner
        {
            if(Arr[j] > Arr[j + 1])
            {
                temp = Arr[j];
                Arr[j] = Arr[j + 1];
                Arr[j + 1] = temp;

                bFlag = true;
            }
        }

        cout<<"\nData after pass : "<<i + 1<<"\n";
        Display();
    }
    cout<<"\nNumber passes for bubble sort : "<<i<<"\n";

    Sorted = true;                          // imp
}

// 1 : Increasing
// 2 : Decreasing
void ArrayX :: BubbleSortEfficientX(int iOption = INC_ORDER)
{
    int i = 0, j = 0;
    int temp = 0;

    bool bFlag = false;

    if(iOption < INC_ORDER || iOption > DEC_ORDER)
    {
        cout<<"Invalid option for sorting\n";
        cout<<"1 : Increasing\n";
        cout<<"2 : Decreasing\n";
    }

    /*if(Sorted == true)                      // imp filter
    {
        return;
    }*/

    bFlag = true;
    
    if(iOption == INC_ORDER)     // Increasing
    {
        for(i = 0; (i < iSize - 1) && (bFlag == true); i++)          // Outer
        {
            bFlag = false;

            for(j = 0; j < iSize - 1 - i; j++)  // Inner
            {
                if(Arr[j] > Arr[j + 1])
                {
                    temp = Arr[j];
                    Arr[j] = Arr[j + 1];
                    Arr[j + 1] = temp;

                    bFlag = true;
                }
            }

            cout<<"\nData after pass : "<<i + 1<<"\n";
            Display();
        }
    }
    else if(iOption == DEC_ORDER)       // Decreasing
    {
        for(i = 0; (i < iSize - 1) && (bFlag == true); i++)          // Outer
        {
            bFlag = false;

            for(j = 0; j < iSize - 1 - i; j++)  // Inner
            {
                if(Arr[j] < Arr[j + 1])
                {
                    temp = Arr[j];
                    Arr[j] = Arr[j + 1];
                    Arr[j + 1] = temp;

                    bFlag = true;
                }
            }

            cout<<"\nData after pass : "<<i + 1<<"\n";
            Display();
        }
    }

    cout<<"\nNumber passes for bubble sort : "<<i<<"\n";

    Sorted = true;                          // imp
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
    
    /*
    aobj.BubbleSort();

    cout<<"\nData After Sorting\n";
    
    aobj.Display();


    aobj.BubbleSortEfficient();   
    
    cout<<"\nData After Sorting\n";
    
    aobj.Display();
    */

    // 1 : Increasing
    // 2 : Decreasing
    aobj.BubbleSortEfficientX(DEC_ORDER);

    cout<<"\nData After Sorting\n";
    
    aobj.Display();

    return 0;
}
