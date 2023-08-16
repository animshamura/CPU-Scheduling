import java.util.*;
class Roundrobin { 
  public static void roundRobin(String p[], int a[],int b[], int n){ 
    
    int res = 0; 
    int resc = 0; 
    
    
    String seq = new String(); 
    
    int res_b[] = new int[b.length]; 
    int res_a[] = new int[a.length]; 
    
    for (int i = 0; i < res_b.length; i++) { 
      res_b[i] = b[i]; 
      res_a[i] = a[i]; 
    } 
    
    
    int t = 0; 
    
    int w[] = new int[p.length]; 
    
    
    int comp[] = new int[p.length]; 
    
    while (true) { 
      boolean flag = true; 
      for (int i = 0; i < p.length; i++) { 
        
        
        if (res_a[i] <= t) { 
          if (res_a[i] <= n) { 
            if (res_b[i] > 0) { 
              flag = false; 
              if (res_b[i] > n) { 
                
                
                t = t + n; 
                res_b[i] = res_b[i] - n; 
                res_a[i] = res_a[i] + n; 
                if(i==0) seq += p[i];
                else seq += "->" + p[i]; 
              } 
              else { 
                
                t = t + res_b[i]; 
                
                
                comp[i] = t - a[i]; 
                
                
                w[i] = t - b[i] - a[i]; 
                res_b[i] = 0; 
                
                
                if(i==0) seq += p[i];
                else seq += "->" + p[i]; 
              } 
            } 
          } 
          else if (res_a[i] > n) { 
            
            
            for (int j = 0; j < p.length; j++) { 
              
              
              if (res_a[j] < res_a[i]) { 
                if (res_b[j] > 0) { 
                  flag = false; 
                  if (res_b[j] > n) { 
                    t = t + n; 
                    res_b[j] = res_b[j] - n; 
                    res_a[j] = res_a[j] + n; 
                    if(j==0) seq += p[j];
                    else seq += "->" + p[j]; 
                  } 
                  else { 
                    t = t + res_b[j]; 
                    comp[j] = t - a[j]; 
                    w[j] = t - b[j] - a[j]; 
                    res_b[j] = 0; 
                    if(j==0) seq += p[j];
                    else seq += "->" + p[j]; 
                  } 
                } 
              } 
            } 
            
            
            if (res_b[i] > 0) { 
              flag = false; 
              
              
              if (res_b[i] > n) { 
                t = t + n; 
                res_b[i] = res_b[i] - n; 
                res_a[i] = res_a[i] + n; 
                if(i==0) seq += p[i];
                else seq += "->" + p[i]; 
              } 
              else { 
                t = t + res_b[i]; 
                comp[i] = t - a[i]; 
                w[i] = t - b[i] - a[i]; 
                res_b[i] = 0; 
                if(i==0) seq += p[i];
                else seq += "->" + p[i]; 
              } 
            } 
          } 
        } 
        
        
        else if (res_a[i] > t) { 
          t++; 
          i--; 
        } 
      } 
      
      if (flag) { 
        break; 
      } 
    } 
    
    System.out.println("Process      Turn arround time      Waiting time"); 
    for (int i = 0; i < p.length; i++) { 
      System.out.println(" " + p[i] + "\t\t" + comp[i] + "\t\t" + w[i]); 
      
      res = res + w[i]; 
      resc = resc + comp[i]; 
    } 
    
    System.out.println("Average waiting time is " + (float)res / p.length); 
    System.out.println("Average compilation  time is " + (float)resc / p.length); 
    System.out.println("The sequence is like that " + seq); 
  } 
  
  public static void main(String args[]){ 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of processes.");
    int n = sc.nextInt(); 
    int arrivaltime[] = new int [n];
    int bursttime[] = new int [n];
    String name [] = new String[n];
    System.out.println("Enter arrival time and burst time of every process.");
    int i = 0;
    while(i < n){
      arrivaltime[i] = sc.nextInt();
      bursttime[i]  = sc.nextInt();
      name[i] = "p"+Integer.toString(i+1);
      i++;
    }
    
    System.out.println("Enter quantum time of each process.");
    int q = sc.nextInt(); 
    roundRobin(name, arrivaltime, bursttime, q); 
  } 
} 