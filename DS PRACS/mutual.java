import java.util.*;
import java.io.*;

class Centralized 
{
    public static void main(String args[]) throws IOException   
    {    
        int cs = 0; /*cs will be allotted the value of the process number .
                    if cs==0 , critical section isnt occupied by any process*/
        
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nEnter The Number of Processes : ");
        int nop = sc.nextInt();
        System.out.print("\nChoose the co-ordinator process : ");
        int cord = sc.nextInt();
        ArrayList<Integer> queue = new ArrayList();
        int bharahua = 0;
        int pn = 0;
        do
        {
            System.out.println("***** PROCESSES *****");
            for(int i = 0 ; i < nop ; i++)
            {
                if(i+1 != cord)
                    System.out.println("Process " + (i+1));
            }
            if(cs == 0)
            {
                System.out.println("No process in critical section");
            }
            else
            {
                System.out.println("Process " + cs + " in critical section");
            }
            if(queue.isEmpty())
            {
                System.out.println("Queue is empty");
            }
            else
            {
                System.out.println("Queue: " + queue);
            }
            System.out.print("\nEnter Process number for action (0 to EXIT) : ");
            pn=sc.nextInt();
            if(pn>0 && pn!=cord && pn<=nop)
            {
                if(pn!=cs)
                {
                    System.out.println("Do you want to request critical section ? (Y/N)");
                    char ans = sc.next().charAt(0);
                    if(ans=='y' || ans=='Y')
                    {
                        System.out.println("Process " + pn + " sends request message to Coordinator");
                        int j;
                        for(j = 0; j < queue.size(); j++ )
                        {
                            if(queue.get(j) == pn)
                                break;
                        }
                        if(j < queue.size())
                        {
                            System.out.println("Process " + pn + " already in queue");
                            continue;
                        }
                        if(cs == 0)
                        {
                            cs=pn;
                            System.out.println("Process " + pn + " alloted Critical Section");
                            System.out.println("Coordinator sends reply message to Process " + pn);
                        }
                        else
                        {
                            queue.add(pn);
                            System.out.println("Process " + pn + " added to queue");
                        }                    
                    }
                    else
                    {
                        continue;
                    }  
                }
                else
                {
                    System.out.flush();
                    System.out.println("Do you want to release critical section ? (Y/N)");
                    char ans = sc.next().charAt(0);
                    if(ans=='y' || ans=='Y')
                    {                       
                        System.out.println("Process " + pn + " released Critical Section");
                        System.out.println("Process " + pn + " sends release message to Coordinator ");
                        if(queue.isEmpty())
                        {
                            cs = 0;                        
                            System.out.println("Critical Section Empty");
                        }
                        else
                        {
                            cs = queue.get(0);                        
                            System.out.println("Coordinator sends reply message to Process " + cs);
                            System.out.println("Process " + cs + " alloted Critical Section");
                            queue.remove(0);
                        }
                    }
                    else
                    {
                        continue;
                    }
                }
            }
            else
            {
                System.out.println("Invalid Input :(");
            }
        }while(pn != 0);
    }
}