import java.util.*;
public class SJF_preemptive { 
    static void findWaitingTime(Process proc[], int n, int wt[]){ 
        int rt[] = new int[n]; 
        
        for (int i = 0; i < n; i++) rt[i] = proc[i].bt; 
       
        int complete = 0, t = 0, minm = Integer.MAX_VALUE; 
        int shortest = 0, finish_time; 
        boolean check = false; 
       
        while(complete != n){ 
          
          for (int j = 0; j < n; j++){ 
              if((proc[j].art <= t) && (rt[j] < minm) && rt[j] > 0) { 
                    minm = rt[j]; 
                    shortest = j; 
                    check = true; 
                } 
            } 
       
            if (check == false) { 
                t++; 
                continue; 
            } 
       
            rt[shortest]--; 
       
            minm = rt[shortest]; 
            if (minm == 0) 
                minm = Integer.MAX_VALUE; 
       
            if (rt[shortest] == 0) { 
       
                
                complete++; 
                check = false; 
       
                finish_time = t + 1; 
      
                wt[shortest] = finish_time - 
                             proc[shortest].bt - 
                             proc[shortest].art; 
       
                if (wt[shortest] < 0) 
                    wt[shortest] = 0; 
            }
            t++; 
        } 
    } 
       
    static void findTurnAroundTime(Process proc[], int n, int wt[], int tat[]){ 
        
       for (int i = 0; i < n; i++) tat[i] = proc[i].bt + wt[i]; 
    } 
      
    static void findavgTime(Process proc[], int n){ 
        int wt[] = new int[n], tat[] = new int[n]; 
        int  total_wt = 0, total_tat = 0; 
       
        findWaitingTime(proc, n, wt); 
       
        findTurnAroundTime(proc, n, wt, tat); 
       
    
        System.out.println("Processes       Arrival Time        Burst Time          Waiting Time      Turn Around Time"); 
       
        for (int i = 0; i < n; i++) { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i]; 
            System.out.println(" " + proc[i].pid + "\t\t"+proc[i].art+"\t\t"+ proc[i].bt + "\t\t " + wt[i]+ "\t\t" + tat[i]); 
        } 
       
        System.out.printf("\nAverage waiting time = %.3f\n",((float)total_wt/(float)n)); 
        System.out.printf("Average turn around time = %.3f\n",((float)total_tat /(float)n)); 
    } 
      
   
    public static void main(String[] args){   
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter number of processes.");
         int n = sc.nextInt();
         
         Process proc[] = new Process [n];
         for(int i = 0; i < n; i++) proc[i]= new Process(sc.nextInt(),sc.nextInt(),sc.nextInt());
          
         findavgTime(proc, proc.length); 
    } 
} 