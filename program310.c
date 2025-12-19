#include<stdio.h>
#include<stdlib.h>

#pragma pack(1)
typedef struct node
{
    int data;
    struct node *next;
}NODE, *PNODE, **PPNODE;

/* typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;  this is as like above structure syntax-cr*/

int main()
{
    PNODE ptr = NULL;

    ptr = (PNODE)malloc(sizeof(NODE)); 
    
    // Use the node

    free(ptr);

    return 0;
}