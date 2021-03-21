/**
Need a way to store
{
start-end : [time taken]
}
return avg when asked, if exists, else return -1

on checkIn
{
    id : start-station, time
}

on checkout
refer map and store in commuteTimeMap
delete record from checkin

["UndergroundSystem",[],
"checkIn",[10,"Leyton",3],
"checkOut",[10,"Paradise",8]
"getAverageTime",["Leyton","Paradise"]
"checkIn",[5,"Leyton",10]
"checkOut",[5,"Paradise",16]
"getAverageTime",["Leyton","Paradise"]
"checkIn",[2,"Leyton",21]
"checkOut",[2,"Paradise",30]
"getAverageTime"]["Leyton","Paradise"]

C.T
{
LP : [5, 6]

}

CIR
{
}
**/

class UndergroundSystem {
    HashMap<String, ArrayList<Integer>> commuteTime;
    HashMap<Integer, Pair<String, Integer>> checkInRecord;
        
    public UndergroundSystem() {
        this.commuteTime = new HashMap<>();
        this.checkInRecord = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        this.checkInRecord.put(id, new Pair<String, Integer>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> record = checkInRecord.get(id);
        
        String commute = record.getKey() + stationName;
        
        if(!this.commuteTime.containsKey(commute))
            this.commuteTime.put(commute, new ArrayList<Integer>());
        
        this.commuteTime.get(commute).add(t-record.getValue());
        
        this.checkInRecord.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String commute = startStation + endStation;
        
        if(!this.commuteTime.containsKey(commute))
            return -1.0;
        
        double sum = 0;
        
        for(int time : this.commuteTime.get(commute)){
            sum += time;
        }
        
        return sum/this.commuteTime.get(commute).size();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */