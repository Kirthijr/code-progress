//$Id$
// 1.
public class Test {
	static int a[] = {1,4,2,5,10,3,7,9,6,8};
	public static void main(String args[]){
		for(int i=0;i<10;i++){
			System.out.print(a[i]+" ");
		}
//		Find the index where prefix and suffix sums are same
//		Method 1
		int i=0,j=3,s1=0,s2=0;
		while(i<j){
			if(s1<=s2){
				s1+=a[i];
				i++;
			}else{
				s2+=a[j];
				j--;
			}
			if(s1==s2 && i>=j){
				System.out.println(a[i]);
				return;
			}else if(i>j){
				System.out.println("Cannot be done");
			}
		}
		Method 2
		int prefixsum[]= new int[4];
		int suffixsum[]= new int[4];
		prefixsum[0]=a[0];
		suffixsum[3]=a[3];
		for(int i=1,j=2;i<3;i++,j--){
			prefixsum[i]=prefixsum[i-1]+a[i];
			suffixsum[j]=suffixsum[j+1]+a[j];
		}
		for(int i=0;i<4;i++){
			if(prefixsum[i] == suffixsum[i]){
				System.out.println(a[i]);
			}
		}
		System.out.println(5+6+"7");
		System.out.println(5+6+"7"+6+8);
		
	}
}
//$Id$
// 2.

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 134, 10, 6, 40, 56, 78, 100}; // for finding max pair 
		int arr1[] = {2,5,7,35,39,48,70,86}; // for finding given paired sum of sorted array
		
		System.out.println("Nearest sum: "+closestSum(arr1,78));
		System.out.println("Maximum paired sum present? "+isPairedSumPresent(arr1,109));
		System.out.println("Maximum valued pair: "+maxpair(arr));

	}
	public static int closestSum(int[] arr,int k){
		int first=0,second=0,i=0,j=arr.length-1;
		first=arr[0];
		second=arr[1];
		int diff = Math.abs(k-(arr[0]+arr[1]));
		while(i!=j){
			if(Math.abs(k-(arr[i]+arr[j])) < diff){
				first = arr[i];
				second = arr[j];
				diff = Math.abs(k-(arr[i]+arr[j]));
			}
			if(arr[i]+arr[j] > k){
				j--;
			}else{
				i++;
			}
		}
		return first+second;
	}
	public static int pivot(int[] arr,int st,int n){ //finds the number of rotations of a sorted array
		if(n==0){
			return 0;
		}
		int mid = (st+n)/2;
		if(arr[mid]>arr[mid+1]){
			return mid+1;
		}else if(arr[mid]>arr[n]){
			return pivot(arr,mid,n);
		}else{
			return pivot(arr,0,mid-1);
		}
	}
	public static boolean isPairedSumPresent(int[] arr1, int k){ // finds if the given paired sum is present
		boolean present = false;
		int large, small, n= arr1.length;
		small = pivot(arr1,0,n-1); // find the largest number
		large = (small+n-1 )% n;
		while(large!=small){
			if(arr1[large]+arr1[small] == k){
				return true;
			}else if(arr1[large]+arr1[small] > k){
				large = (large-1+n) % n;
			}else{
				small = (small+1) % n;
			}
		}
		
		return present;
	}
	public static int maxpair(int[] arr){ // finds the maximum sum of a pair
		int firstmax,secondmax;
		if(arr[0] > arr[1]){
			firstmax = arr[0];
			secondmax = arr[1];
		}else{
			firstmax = arr[1];
			secondmax = arr[0];
		}
		for(int i=2; i<arr.length; i++){
			if(arr[i]>firstmax){
				secondmax = firstmax;
				firstmax = arr[i];
			}else if(arr[i] > secondmax && arr[i] != firstmax){
				secondmax = arr[i];
			}
		}
		return firstmax+secondmax;
	}
}

// 3.
//$Id$
package practice;

import java.util.HashMap;

public class practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a ="fcrxzwscanmligyxyvym", b="jxwtrhvujlmrpdoqbisbwhmgpmeoke";
//		String a ="showman", b="woman";
		HashMap<Character,Integer> a1 = new HashMap<>();
		HashMap<Character,Integer> b1 = new HashMap<>();
		for(int i=0;i<a.length();i++){
			if(a1.containsKey(a.charAt(i))){
				int key = a1.get(a.charAt(i));
				a1.put(a.charAt(i), key+1);
			}else{
				a1.put(a.charAt(i), 1);
			}
		}
		for(int i=0;i<b.length();i++){
			if(b1.containsKey(b.charAt(i))){
				int key = b1.get(b.charAt(i));
				b1.put(b.charAt(i), key+1);
			}else{
				b1.put(b.charAt(i), 1);
			}
		}
		int count=0;
        for(Character key: a1.keySet()){
        	if(!b1.containsKey(key)){
        		count = count + a1.get(key);
        	}else{
        		count = count + Math.abs(b1.get(key)-a1.get(key));
        		a1.put(key, 0);
        		b1.remove(key);
        		
        	}
        }
        for(Character key: b1.keySet()){
        	if(!a1.containsKey(key) ){
        		count=count+b1.get(key);
        	}else{
        		count = count + Math.abs(b1.get(key)-a1.get(key));
        	}
        }
        System.out.println(count);
	}

}

