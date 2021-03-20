//TC - O(n log k)
//SC - O(k)
//points = [[1,3],[-2,2]], k = 1

class Solution {
    public int[][] kClosest(int[][] points, int K) {        
        //init max heap with k elements, output
        PriorityQueue<int[]> pq = new PriorityQueue<>(K, (p1, p2) -> p2[2] - p1[2]);        
        int[][] output = new int[K][2];
        
        //iterate over points
        for(int i=0; i<points.length; i++){
            int distance = (int)Math.pow(points[i][0], 2) + (int)Math.pow(points[i][1], 2); 
            
                if(pq.isEmpty() || pq.size()<K)
                    pq.add(new int[]{points[i][0], points[i][1], distance});    
                else{
                    if(distance < pq.peek()[2]){
                        pq.poll();
                        pq.add(new int[]{points[i][0], points[i][1], distance});
                    }                 
                }
        }

        //pop k times to get k closest points, put popped element[0], element[1]  
        int i = K-1;
        while(!pq.isEmpty()){
            int[] point = pq.poll();
            output[i][0] = point[0];
            output[i][1] = point[1];
            i--;
        }
        
        //return output
        return output;
    }

}