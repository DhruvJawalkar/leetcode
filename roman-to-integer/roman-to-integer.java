class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int i=0;
        int sum=0; 
        
        while(i<s.length()-1){ 
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
                sum -= map.get(s.charAt(i));
            else
                sum += map.get(s.charAt(i));
           
            i++;
        }
        
        sum += map.get(s.charAt(i));
        
        return sum;        
    }
}