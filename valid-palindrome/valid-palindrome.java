class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0)
            return true;
        
        int low=0, high=s.length()-1;
 
        while(low<high){
            while(low<high && !Character.isLetterOrDigit(s.charAt(low)))
                low++;
            while(low<high && !Character.isLetterOrDigit(s.charAt(high)))
                high--;
            
            if(low<high && Character.toLowerCase(s.charAt(low))!=Character.toLowerCase(s.charAt(high))){
                return false;
            }
            else{
                low++;
                high--;
            } 
        }
        
        return true;
    }
}