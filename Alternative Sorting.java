class Solution
{
    ArrayList<Long> alternateSort(long arr[] ,int N)
    {
        if(arr==null || arr.length==0)
            return new ArrayList<Long>();

        if(arr.length==1)
            return new ArrayList<Long>(Arrays.asList(arr[0]));

        ArrayList<Long> output = new ArrayList<>();
        Arrays.sort(arr);

        int i = 0, j = N-1;
        while (i < j) {
            output.add(arr[j--]);
            output.add(arr[i++]);
        }

        if (N % 2 != 0)
            output.add(arr[i]);

        return output;
    }
}