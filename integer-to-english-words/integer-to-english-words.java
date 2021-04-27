class Solution {
        private String[] lessThanTwenty = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        
        String numberInWords = "";
        int n = num;
        int idx = 0;
        
        String[] placeValue = new String[]{"", "Thousand", "Million", "Billion"};
        
        while(n>0){
            String tripletInWords = helper(n%1000);
            tripletInWords = tripletInWords.trim();
            
            if(tripletInWords.length()>0)
                numberInWords = tripletInWords + " " + placeValue[idx] + " " + numberInWords;
            
            n /= 1000;
            idx++;
        }
        
        return numberInWords.trim();
    }
    
    private String helper(int n){
        if(n<20)
            return lessThanTwenty[n];
        else if(n<100)
            return tens[n/10] +" "+ helper(n%10);
        else
            return lessThanTwenty[n/100] + " Hundred " + helper(n%100);
    }
}