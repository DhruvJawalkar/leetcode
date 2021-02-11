class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        
        Arrays.sort(intervals, (int[] m1, int[] m2) -> m1[0] - m2[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int[] m : intervals){
            if(pq.size()>0 && pq.peek()<=m[0]){
                pq.poll();
            }
            pq.add(m[1]);
        }
        
        return pq.size();
    }
}