class trapping_rain_water {
  public static void main(String args[]){
    int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println("Trapping rain water result"+trap(arr));
  }
    public int trap(int[] arr) {
        int left, right, maxWater=0, n = arr.length;
        int min[] = new int[n];
        int max[] = new int[n];
        min[0] = arr[0];
        max[n-1] = arr[n-1];
        for(int i=1,j=n-2;i<n-1;i++,j--){
            min[i] = Math.max(arr[i], min[i-1]);
            max[j] = Math.max(max[j+1], arr[j]);
        }
        for(int i=1; i < arr.length-1; i++){
            left = min[i];
            right = max[i];
            if(left < right){
                maxWater = maxWater + left - arr[i];    
            }else {
                maxWater = maxWater + right - arr[i];
            }
        }
        return maxWater;
    }
}
