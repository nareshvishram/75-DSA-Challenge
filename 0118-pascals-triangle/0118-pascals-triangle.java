class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(Arrays.asList(1));
        if(n==1)
            return res;
        res.add(Arrays.asList(1,1));
        if(n==2)
            return res;
        if(n==2)
            return res;
        List<Integer> prev=new ArrayList<>();
        prev.add(1);
        prev.add(1);
        n-=2;
        
        while(n-->0){
            List<Integer> tmp=new ArrayList<>();
            tmp.add(1);
            for(int i=0;i<prev.size()-1;i++){
                tmp.add(prev.get(i)+prev.get(i+1));
            }
            tmp.add(1);
            prev=tmp;
            res.add(tmp);
        }
        return res;
    }
}