class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0)
            return new ArrayList<List<Integer>>();
        
        ArrayList<List<Integer>> pascal = new ArrayList<List<Integer>>();        
        
        pascal.add(Arrays.asList(1));
        
        for(int i=2; i<=numRows; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            
            for(int j=0; j<i; j++){
                
                if(j==0 || j==i-1)
                    row.add(1);
                else
                    row.add(pascal.get(i-2).get(j-1) + pascal.get(i-2).get(j));
            }
            
            pascal.add(row);
        }
        
        return pascal;
    }
}