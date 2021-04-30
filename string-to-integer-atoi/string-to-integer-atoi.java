class Solution {
    public int myAtoi(String s) {
        if(s==null || s.length()==0)
            return 0;
        
        int num = 0;
        int i = 0, n = s.length();
        int sign = 1;
        
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            if(s.charAt(i)=='-')
                sign = -1;
            i++;
        }
        
        if(i<n && !Character.isDigit(s.charAt(i)))
            return 0;
        
        while(i<n && Character.isDigit(s.charAt(i))){
            if(num < Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && s.charAt(i)-'0' <= Integer.MAX_VALUE%10))
            num = num*10 + (s.charAt(i)-'0');
            else
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            i++;
        }
        
        return sign*num;
    }
}