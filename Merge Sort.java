import java.util.*;
public class Main{
    public static void conquer(int[] arr,int si,int mid,int ei){
        int merged[]=new int[ei-si+1];
        int idx1=si;
        int idx2=mid+1;
        int i=0;
        while(idx1<=mid && idx2<=ei){
            if(arr[idx1]<=arr[idx2]){
                merged[i++]=arr[idx1++];
            }
            else{
                merged[i++]=arr[idx2++];
            }
            
        }
        while(idx1<=mid){
            merged[i++]=arr[idx1++];
        }
        while(idx2<=ei){
            merged[i++]=arr[idx2++];
        }
        for(int m=0,j=si;m<merged.length;m++,j++){
            arr[j]=merged[m];
            
        }
    }
    public static void divide(int[] arr,int si,int ei){
        int mid=si+(ei-si)/2;
        if(si>=ei){
            return;
        }
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
        
    }
    
	public static void main(String[] args) {
		int arr[]={7,1,3,5,9,6};
		divide(arr,0,arr.length-1);
		List<Integer> newlist=new ArrayList<>();
		for(int i=0;i<arr.length;i++){
		    newlist.add(arr[i]);
		}
		System.out.println(newlist);
		
	}
}
