class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();
        int[] prev=intervals[0];
        ans.add(prev);
        int curr[]=new int[2];
        int end=prev[1];
        for(int i=1;i<intervals.length;i++){
            curr=intervals[i];
            if(prev[1]>=curr[0])
                prev[1]=Math.max(prev[1],curr[1]);
            else{
                ans.add(curr);
                prev=curr;
            }
        }
       int res[][]=new int[ans.size()][2];
       int k=0;
       for(int[] x:ans){
        res[k][0]=x[0];
        res[k][1]=x[1];
        k++;
       }
       return res;
    }
}