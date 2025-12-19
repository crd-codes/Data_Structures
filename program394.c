// Doubly LL
// $ for change or new from singly LL

#include<stdio.h>
#include<stdlib.h>

#pragma pack(1)
struct node
{
    int data;
    struct node *next;
    struct node *prev;          // $
};

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;

void InsertFirst(PPNODE first, int no)
{

}

void InsertLast(PPNODE first, int no)
{
    
}

void InsertAtPos(PPNODE first, int no, int pos)
{
    
}

void DeleteFirst(PPNODE first)
{
    
}

void DeleteLast(PPNODE first)
{
    
}

void DeleteAtPos(PPNODE first, int pos)
{
    
}

void Display()
{

}

int Count()
{
    return 0;
}

int main()
{
    PNODE head = NULL;

    return 0;
}