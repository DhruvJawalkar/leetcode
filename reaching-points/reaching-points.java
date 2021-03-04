class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx>=sx && ty>=sy){
            if(tx==sx && ty==sy)
                return true;
            
            if(tx==ty)
                return false;
            
            if(tx>ty){
                if(ty>sy)
                    tx=tx%ty;
                else return (tx-sx)%ty==0;
            }
                
            else if(ty>tx){
                if(tx>sx)
                    ty=ty%tx;                             
                else return (ty-sy)%tx==0;
            }
        }
        
        return false;

    }
}