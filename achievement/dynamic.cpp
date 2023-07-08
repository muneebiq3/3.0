#include<iostream>
using namespace std;
main()
{
	int l, arr[l], m=1;
	char y;
	cout<<"Size of Array before: "<<l<<endl<<endl;
	cout<<endl<<"ENTER DATA"<<endl<<endl;
	for(int i=0;i<m;i++)
	{
		cout<<endl<<"Press y: ";
		cin>>y;
		if(y=='y')
		{
			for (int j=l;j==l;j++)
			{
				cout<<"Enter in Array["<<j<<"]: ";cin>>arr[j];	
			}
			m++;
			l++;
		}	
	}
	cout<<endl;
	for(int k=0;k<l;k++)
	{
		cout<<"Array["<<k<<"]: "<<arr[k]<<endl;
	}
	cout<<endl<<"Size of Array after: "<<l;
return 0;
}
