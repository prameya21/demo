import java.util.Arrays;
import java.util.List;
import java.util.*;

public class ExclusiveTimeFunction
{
    /*
    On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.

    We store logs in timestamp order that describe when a function is entered or exited.

    Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.

    A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.

    The CPU is single threaded which means that only one function is being executed at a given time unit.

    Return the exclusive time of each function, sorted by their function id.



    Example 1:



    Input:
    n = 2
    logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
    Output: [3, 4]
    Explanation:
    Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
    Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
    Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time.
    So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
     */
    public int[] exclusiveTime(int n, List<String> logs)
    {
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        String[] t=logs.get(0).split(":");
        st.push(Integer.parseInt(t[0]));
        int prev=Integer.parseInt(t[2]);
        for(int i=1;i<logs.size();i++)
        {
            String[] s=logs.get(i).split(":");
            if(s[1].equals("start"))
            {
                if(!st.isEmpty())
                    res[st.peek()]+=Integer.parseInt(s[2])-prev;
                st.push(Integer.parseInt(s[0]));
                prev=Integer.parseInt(s[2]);
            }
            else
            {
                res[st.peek()]+=Integer.parseInt(s[2])-prev+1;
                prev=Integer.parseInt(s[2])+1;
                st.pop();
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        int[] res=new ExclusiveTimeFunction().exclusiveTime(2,new ArrayList<>(Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6")));
        for(int i:res)
            System.out.println(i);
    }
}
