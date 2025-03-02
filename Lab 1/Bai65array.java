import java.util.Scanner;
public class Bai65array
{
    public static void hamin(int arr[]) 
    {
        for (int i=0;i<arr.length;i++) 
        {  
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");      
    }
    public static void swap(int arr[],int i,int j) 
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int partition(int arr[],int low,int high) 
        {
            int pivot=arr[high];
            int i=low-1;  
            for(int j=low;j<high;j++) 
            {
                if(arr[j]<pivot) 
                {
                    i++;
                    swap(arr,i,j);
                }
            }
            swap(arr,i+1,high);
            return i+1;
        }
    public static void quicksort(int arr[],int low,int high) 
        {
            if(low<high) 
            {
                int pi=partition(arr,low,high);
                quicksort(arr,low,pi-1);
                quicksort(arr,pi+1,high);
            }
        }
    public static void main(String[] args) 
    {
        Scanner so= new Scanner(System.in);
        System.out.print("Hay nhap so phan tu trong mang: ");
        int n =so.nextInt();
        int mang[]= new int[n];
        System.out.println("Nhap mang: ");
        for (int i = 0; i < n; i++) {
            mang[i] = so.nextInt();
        }
        quicksort(mang,0,n-1);
        System.out.println("Mang duoc sap xap la: ");
        hamin(mang);
        int tong= 0;
        for (int i=0;i<mang.length;i++) 
        {
            tong+=mang[i];
        }
        double average=(double) tong/n;
        System.out.println("Tong cac phan tu trong mang la: "+tong);
        System.out.println("Trung binh cong cac phan tu trong mang la: "+average);
        so.close();
    }
}

