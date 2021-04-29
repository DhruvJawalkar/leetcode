/*
TC - O(M * N log N), M is max length of log, N is #logs
SC - O(M log N)
*/
class Solution {
    private class LogsComparator implements Comparator<String>{
        @Override
        public int compare(String log1, String log2){
            int idx1 = log1.indexOf(" ");
            int idx2 = log2.indexOf(" ");
            
            boolean log1IsDigitType = Character.isDigit(log1.charAt(idx1+1)); 
            boolean log2IsDigitType = Character.isDigit(log2.charAt(idx2+1));
            
            if(log1IsDigitType && log2IsDigitType){
                return 0;
            }
            else if(log1IsDigitType){
                return 1;
            }
            else if(log2IsDigitType){
                return -1;
            }
            else{
                String log1Content = log1.substring(idx1+1);
                String log2Content = log2.substring(idx2+1);
                
                if(log1Content.equals(log2Content)){
                    String log1Identifier = log1.substring(0, idx1);
                    String log2Identifier = log2.substring(0, idx2);
                    return log1Identifier.compareTo(log2Identifier);
                }
                else{
                    return log1Content.compareTo(log2Content);   
                }
            }
        }
    }
    
    public String[] reorderLogFiles(String[] logs) {
        //base case
        if(logs.length==1)
            return logs;
        
        Arrays.sort(logs, new LogsComparator());
        
        return logs;
    }
}