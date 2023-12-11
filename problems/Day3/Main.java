class Main
{
    public static void main(String args[])
    {
        //  int arr[]={4,3,2,1};
        // System.out.println(binarySearch(arr,7));
        //  selectionSort(arr);
        // bubbleSort(arr);
        // insertionSort(arr);
        // int arr1[]={10,100,500};
        // int arr2[]={4,7,9,25,30,300,450};
       // mergeTwoSorted(arr1, arr2);
        // mergeTwoSorted2(arr1, arr2);
        int arr1[]={6,2,4};
        int arr2[]={7,5,6};
        //rotateLeftByk2(arr, 2);
        //rotateLeftByk3(arr, 2);
        //zerosAtEnd2(arr);
        // secondLargest0(arr);
        // System.out.println(checkRotation(arr));
        // sort012Ap3(arr);
        sumTwoArrays(arr1, arr2);

    }
    static int binarySearch(int arr[],int value)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==value)
                return mid;
            else if(arr[mid]>value)
                end=mid-1;
            else 
                start=mid+1;
        }
        return -1;
    }
    static void display(int arr[])
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    static void selectionSort(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            int min=Integer.MAX_VALUE;
            int minIndex=i;
            for(int j=i;j<arr.length;j++)
            {
                if(arr[j]<min)
                {
                    min=arr[j];
                    minIndex=j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
        display(arr);
    }
    static void bubbleSort(int arr[])
    {
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        display(arr);
    }
    static void insertionSort(int arr[])
    {
        for(int i=1;i<arr.length;i++)
        {
            int temp=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>temp)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        display(arr);
    }
    static void mergeTwoSorted(int arr1[],int arr2[])
    {
        int newArray[]=new int[arr1.length+arr2.length];
        for(int i=0;i<arr1.length;i++)
        {
            newArray[i]=arr1[i];
        }
        int k=arr1.length;
        for(int i=0;i<arr2.length;i++)
        {
            newArray[k]=arr2[i];
            k++;
        }
        selectionSort(newArray);
    }
    static void mergeTwoSorted2(int arr1[],int arr2[])
    {
        int newArray[]=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]>arr2[j])
            {
                newArray[k++]=arr2[j];
                j++;
            }
            else    
            {
                newArray[k++]=arr1[i];
                i++;
            }
        }
        while(i<arr1.length)
        {
            newArray[k++]=arr1[i++];
        }
        while(j<arr2.length)
        {
            newArray[k++]=arr2[j++];
        }
        display(newArray);
    }
    static void zerosAtEnd(int arr[])
    {
        int newArray[]=new int[arr.length];
        int k=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
                newArray[k++]=arr[i];
        }
        while(k<arr.length)
            newArray[k++]=0;
        display(newArray);
    }
    static void zerosAtEnd2(int[] arr)
    {
        int i=0;
        int k=0;
        while(i<arr.length)
        {
            if(arr[i]!=0)
            {
                int temp=arr[k];
                arr[k]=arr[i];
                arr[i]=temp;
                i++;
                k++;
            }
            else
                i++;
        }
        display(arr);
    }
    static void rotateLeftByk(int[] arr,int k)
    {
        int len=arr.length;
        int temp=0;
        for(int j=0;j<k;j++)
        {
            temp=arr[0];
            for(int i=1;i<len;i++)
            {
                arr[i-1]=arr[i];
            }
             arr[len-1]=temp;
        }
        display(arr);
    }
    static void rotateLeftByk2(int arr[],int k)
    {
        int tempArr[]=new int[k];
        for(int i=0;i<k;i++)
            tempArr[i]=arr[i];
        int i=0;
        for(i=0;i<arr.length-k;i++)
        {
            arr[i]=arr[i+k];
        }
        int ki=0;
        while(i<arr.length)
            arr[i++]=tempArr[ki++];
        display(arr);
    }
    static void reverse(int arr[],int start,int n)
    {
        for(int i=start;i<((n-2+start)/2)+1;i++)
        {
            int temp=arr[i];
            arr[i]=arr[n-i-1+start];
            arr[n-i-1+start]=temp;
        }
    }
    static void rotateLeftByk3(int arr[],int k)
    {
        reverse(arr,0,arr.length);
        reverse(arr,0, arr.length-k);
        reverse(arr,arr.length-k, arr.length);
        display(arr);
    }
    static void secondLargest(int arr[])
    {
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                secMax=max;
                max=arr[i];
            }
            else if(arr[i]!=max && arr[i]>secMax)
                secMax=arr[i];
        }
        System.out.println(secMax);
    }
    static void secondLargest0(int arr[])
    {
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=max && arr[i]>secMax)
            {
                secMax=arr[i];
            }
        }
        System.out.println(secMax);
    }
    static int checkRotation(int arr[])
    {
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]>arr[i+1])
                return i+1;
        }
        return 0;
    }
    static void sort012Ap1(int arr[])
    {
        int countZeros=0;
        int countOnes=0;
        int countTwos=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
                countZeros++;
            else if(arr[i]==1)
                countOnes++;
            else 
                countTwos++;
        }
        int i=0;
        while(i<countZeros)
        {
            arr[i++]=0;
        }
        int k=0;
        while(k<countOnes)
        {
            arr[i++]=1;
            k++;
        }
        int l=0;
        while(l<countTwos)
        {
            arr[i++]=2;
            l++;
        }
        display(arr);
    }
    static void sort012Ap2(int arr[])
    {
        int tempArray[]=new int[arr.length];
        int start=0;
        int end=arr.length-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                tempArray[start++]=0;
            }
            else if(arr[i]==2)
            {
                tempArray[end--]=2;
            }
        }
        for(int i=start;i<=end;i++)
        {
            tempArray[i]=1;
        }
        display(tempArray);
    }
    static void sort012Ap3(int arr[])
    {
        int nz=0;
        int nt=arr.length-1;
        for(int i=0;i<=nt;)
        {
            if(arr[i]==0)
            {
                int temp=arr[nz];
                arr[nz]=arr[i];
                arr[i]=temp;
                nz++;
                i++;
            }
            else if(arr[i]==2)
            {
               int temp=arr[nt];
                arr[nt]=arr[i];
                arr[i]=temp;
                nt--; 
            }
            else 
                i++;
        }
        display(arr);
    }
    static void sumTwoArrays(int arr1[],int arr2[])
    {
        int len1=arr1.length,len2=arr2.length;
        int max=Math.max(len1,len2);
        int resultedArray[]=new int[max+1];
        int index1=len1-1;
        int index2=len2-1;
        int index3=max;
        int carry=0;
        int sum=0;
        while(index1>=0 && index2>=0)
        {
            sum=arr1[index1--]+arr2[index2--]+carry;
            resultedArray[index3--]=sum%10;
            carry=sum/10;
        }
        while(index1>=0)
        {
            int sum1=arr1[index1--]+carry;
            resultedArray[index3--]=sum1%10;
            carry=sum1/10;
        }
        while(index2>=0)
        {
            int sum1=arr2[index2--]+carry;
            resultedArray[index3--]=sum1%10;
            carry=sum1/10;
        }
        resultedArray[0]=carry;
        display(resultedArray);
    }
}