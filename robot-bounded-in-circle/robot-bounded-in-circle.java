class Solution {
    //TC - O(n), n is instruction length
    //SC - O(1)
    public boolean isRobotBounded(String instructions) {
        //base case
        if(instructions==null || instructions.length()==0)
            return true;
        
        //intialise robot dir, N->0, E->1, S->2, W->3 and postion x=0, y=0
        int robotDir = 0;
        int x=0, y=0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        //iterate over instruction length and update robot dir
        for(char curIns : instructions.toCharArray()){
            if(curIns=='L'){
                robotDir +=3;
                robotDir=robotDir%4;
            }
            else if(curIns=='R'){
                robotDir+=1;
                robotDir=robotDir%4;
            }
            else{
                x+=dirs[robotDir][0];
                y+=dirs[robotDir][1];
            }
        }
        
        //in the end check if robot is facing the same dir as initial, N=0 and not at (0,0)
        //return false
        if(robotDir==0 && (x!=0 || y!=0))
            return false;
        
        //else return true
        else return true;
    }
}