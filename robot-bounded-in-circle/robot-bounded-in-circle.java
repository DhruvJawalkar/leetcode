class Solution {
    //TC - O(n), n is instruction length
    //SC - O(1)
    public boolean isRobotBounded(String instructions) {
        //base case
        if(instructions==null || instructions.length()==0)
            return true;
        
        //intialise robot dir, N->0, E->1, S->2, W->3 and postion to [0,0]
        int robotDir = 0;
        int[] robotPos = new int[]{0,0};
        
        //iterate over instruction length and update robot dir
        for(int i=0; i<instructions.length(); i++){
            char ch = instructions.charAt(i);
            
            if(ch=='L'){
                robotDir +=3;
                robotDir=robotDir%4;
            }
            else if(ch=='R'){
                robotDir +=1;
                robotDir=robotDir%4;
            }
            else{
                switch(robotDir){
                    case 0:
                        robotPos[1] += 1; 
                        break;    
                    case 1:
                        robotPos[0] += 1; 
                        break;
                    case 2:
                        robotPos[1] -= 1; 
                        break;    
                    case 3:
                        robotPos[0] -= 1; 
                        break;    
                }
            }
        }
        
        //in the end check if robot is facing the same dir as initial, N=0 and not at (0,0)
        //return false
        if(robotDir==0 && (robotPos[0]!=0 || robotPos[1]!=0))
            return false;
        
        //else return true
        else return true;
    }
}