//TC - O(n log n)
//SC - O(n)

//Ex: [[7,10],[2,4]]

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //base cases
        if(intervals==null || intervals.length==0 || intervals[0].length==0)
            return 0;
        
        //sort intervals acc to start time
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);
        
        //init a min heap which compares end times for meetings
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] meeting : intervals){
            if(!pq.isEmpty() && pq.peek()<=meeting[0])
                pq.poll();
            
            pq.add(meeting[1]);
        }
                
        //return heap size as minRoomsRequired
        return pq.size();   
    }
}