#include<iostream>
#include<string>
#include<time.h>
#include<vector>
#include<algorithm>
using namespace std;
int checkForNineEleven(int a[], int n)
{
    int isNineEleven=1;
    for(int i=0;i<n;i++)
    {
        if(a[i]==9)
            continue;
        else
        {
            return 0;
        }
    }
    return isNineEleven;
}
void incrementByOne(int a[],int n)
{
    int i=n-1;
    int last=a[i]+1;
    if(last<=9)
    {
        a[i]=last;
        return;
    }
    else
    {
        //pass carry to left
        a[i]=0;
        incrementByOne(a,n-1);
    }
return;
}
int checkPalindrome(int a[], int n)
{
    int l=0;
    int r=n-1;
    while(l<r)
    {
        if(a[l]==a[r])
            {

            }
        else
        {
            return 0;
        }
        l++;
        r--;
    }
    return 1;
}
int main()
{
		int input,t=0;
		cin>>input;
		while(t<input)
        {
    //////////////////////////////
            string strTemp;
            cin>>strTemp;
            //check for leading zeros
            int i=0;
            if(strTemp[i]=='0')
            {
                while(strTemp[i]=='0')
                    i++;
            }
            string str=strTemp.substr(i,strTemp.length());
            vector<int> arr;

            arr.reserve(str.size());
            transform(begin(str),end(str),back_inserter(arr),
                      [](char c){
                        return c-'0';
                      }
            );
            int *a=&arr[0];
            if(checkForNineEleven(a,str.length()))
            {
                int sizeOfNewArr = str.length()+1;
                int NewArr[sizeOfNewArr];
                NewArr[0]=1;
                NewArr[sizeOfNewArr-1]=1;
                for(int k=1;k<sizeOfNewArr-1;k++)
                    NewArr[k]=0;
                for(int it=0;it<sizeOfNewArr;it++)
                    cout<<NewArr[it];
                cout<<endl;
                t++;
                continue;
            }
            else
            {
                int isFound = 0;
                while(!isFound)
                {
                    incrementByOne(a,str.length());
                    isFound=checkPalindrome(a,str.length());
                }
                for(int h=0;h<str.length();h++)
                {
                    cout<<a[h];
                }
                cout<<endl;
            }
     /////////////////////////////
                t++;
        }
        return 0;
}
