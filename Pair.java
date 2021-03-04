public class Pair {
    private Character key;
    private Integer value;

    Pair(Character key, Integer value){
        this.key = key;
        this.value= value;
    }
    // standard getters and setters
    public Character getKey(){
        return key;
    }

    public Integer getValue(){
        return value;
    }
}