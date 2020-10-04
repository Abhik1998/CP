// C++ program for weighted job scheduling using Dynamic Programming. 
#include <iostream> 
#include <algorithm> 
using namespace std; 

// A job has start time, finish time and profit. 
struct Job 
{ 
	int start, finish, profit; 
}; 

// A utility function that is used for sorting events 
// according to finish time 
bool jobComparataor(Job s1, Job s2) 
{ 
	return (s1.finish < s2.finish); 
} 

// Find the latest job (in sorted array) that doesn't 
// conflict with the job[i] 
int latestNonConflict(Job arr[], int i) 
{ 
	for (int j=i-1; j>=0; j--) 
	{ 
		if (arr[j].finish < arr[i].start) 
			return j; 
	} 
	return -1; 
} 

// The main function that returns the maximum possible 
// profit from given array of jobs 
long findMaxProfit(Job arr[], int n) 
{ 
	// Sort jobs according to finish time 
	sort(arr, arr+n, jobComparataor); 

	// Create an array to store solutions of subproblems. table[i] 
	// stores the profit for jobs till arr[i] (including arr[i]) 
	long *table = new long[n]; 
	table[0] = arr[0].profit; 

	// Fill entries in M[] using recursive property 
	for (int i=1; i<n; i++) 
	{ 
		// Find profit including the current job 
		long inclProf = arr[i].profit; 
		int l = latestNonConflict(arr, i); 
		if (l != -1) 
			inclProf =(long)(inclProf + table[l]); 

		// Store maximum of including and excluding 
		table[i] = max(inclProf, table[i-1]); 
	} 

	// Store result and free dynamic memory allocated for table[] 
	long result = table[n-1]; 
	delete[] table; 

	return result; 
} 

// Driver program 
int main() 
{ 
    int n;
    cin >> n;
	Job arr[n];
    int t=n;
    while(t-->0){
        int a,b,c;
        cin >>a>>b>>c;
        arr[n-t-1].start=a;
        arr[n-t-1].finish=b;
        arr[n-t-1].profit=c;
    }
	cout << findMaxProfit(arr, n); 
	return 0; 
} 
