import java.util.*;

class SJF_non_preemtive{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter numbers of process.");
    int n = sc.nextInt();
    Process proc [] = new Process [n];
    for(int i = 0; i < n; i++) proc[i]= new Process(sc.nextInt(),sc.nextInt());
    ProcessesToBeSorted(proc);
    FindWaitingTime(proc);
    FindTurnAroundTime(proc);
    Print(proc);
  }
  
  static void ProcessesToBeSorted(Process proc []){
    for(int i = 0; i < proc.length; i++){
      for(int j = 0; j < proc.length; j++){
        if(proc[j].bt > proc[i].bt) {
          Process tem = proc[i];
          proc[i] = proc[j];
          proc[j] = tem;
        }
      }
    }
  }
  
  static void FindWaitingTime(Process proc []){
    int sum = 0;
    for(int i = 1; i < proc.length; i++){
        sum+=proc[i-1].bt;
        proc[i].wt = sum;
    }
  }
  
  static void FindTurnAroundTime(Process proc []){
    for(int i = 0; i < proc.length; i++){
        proc[i].tat = proc[i].bt + proc[i].wt;
    }
  }
  
  static void Print(Process proc []){
   
    for(int i = 0; i < proc.length; i++){
      for(int j = 0; j < proc.length; j++){
        if(proc[j].pid > proc[i].pid) {
          Process tem = proc[i];
          proc[i] = proc[j];
          proc[j] = tem;
        }
      }
    }
  
    
    System.out.println("Processes         Burst Time          Waiting Time      Turn Around Time"); 
        int total_wt = 0;
        int total_tat = 0;
        
        for (int i = 0; i < proc.length; i++) { 
            total_wt = total_wt + proc[i].wt; 
            total_tat = total_tat + proc[i].tat ; 
            System.out.println(" " + proc[i].pid +"\t\t"+ proc[i].bt + "\t\t " +proc[i].wt+ "\t\t" +proc[i].tat); 
        }
         System.out.printf("\nAverage waiting time = %.3f\n",((float)total_wt/(float)proc.length)); 
        System.out.printf("Average turn around time = %.3f\n",((float)total_tat /(float)proc.length)); 
  }
}
    
  
  
    
    
    