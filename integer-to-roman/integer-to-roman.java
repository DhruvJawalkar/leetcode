class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        int n = num;
        StringBuilder sb = new StringBuilder();
        int i= 0;
        
        while(n>0 && i<values.length){
            if(n>=values[i]){
                while(n>=values[i]){
                    sb.append(symbols[i]);
                    n -= values[i];
                }    
            }

            i++;    
        }
        
        return sb.toString();
    }
}