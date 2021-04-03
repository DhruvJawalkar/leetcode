class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=1 || prerequisites==null || prerequisites.length==0)
            return true;
        
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        
        for(int[] prereq : prerequisites){
            indegree[prereq[0]] += 1; 
            
            if(!adjacencyList.containsKey(prereq[1]))
                adjacencyList.put(prereq[1], new ArrayList<Integer>());    
                
            adjacencyList.get(prereq[1]).add(prereq[0]);
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        
        int count = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int course = queue.poll();
                count++;
                
                if(adjacencyList.containsKey(course)){
                    for(int depCourse : adjacencyList.get(course)){
                        indegree[depCourse] -= 1;

                        if(indegree[depCourse]==0)
                            queue.add(depCourse);
                    }                    
                }

            }
        }
        
        return count == numCourses;
    }
}