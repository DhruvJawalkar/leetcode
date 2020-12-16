//Implemented using backtracking TC: O(4^N) N is length of digits in worst case (7,9), 
//SC: O(N) for recursion callstack and stringbuilder to form intermediate result 
class Solution {
    List<String> output;
    
    public List<String> letterCombinations(String digits) {
        output = new ArrayList<>();
        
        if(digits==null || digits.length()==0)
            return output;
        
        HashMap<Character, List<Character>> mapping = new HashMap<>(){
            {
                put('2', new ArrayList<Character>(Arrays.asList('a','b','c')));
                put('3', new ArrayList<Character>(Arrays.asList('d','e','f')));
                put('4', new ArrayList<Character>(Arrays.asList('g','h','i')));
                put('5', new ArrayList<Character>(Arrays.asList('j','k','l')));
                put('6', new ArrayList<Character>(Arrays.asList('m','n','o')));
                put('7', new ArrayList<Character>(Arrays.asList('p','q','r','s')));
                put('8', new ArrayList<Character>(Arrays.asList('t','u','v')));
                put('9', new ArrayList<Character>(Arrays.asList('w','x','y','z')));
            }
        };
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        helper(digits, idx, mapping, sb);
        
        return output;
    }
    
    private void helper(String digits, int idx, HashMap<Character, List<Character>> mapping, StringBuilder sb){
        if(idx==digits.length()){
            output.add(sb.toString());
            return;
        }
        
        List<Character> chars = mapping.get(digits.charAt(idx));
        for(char ch : chars){
            sb.append(ch);
            helper(digits, idx+1, mapping, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}