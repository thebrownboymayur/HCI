import java.util.*;

class PriorityScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] pid = new int[n], arrivalTime = new int[n], burstTime = new int[n], 
              priority = new int[n], completionTime = new int[n], 
              turnAroundTime = new int[n], waitingTime = new int[n];
        float totalWait = 0, totalTurn = 0;

        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.print("Arrival, Burst and Priority for process " + (i + 1) + ": ");
            arrivalTime[i] = sc.nextInt();
            burstTime[i] = sc.nextInt();
            priority[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arrivalTime[i] > arrivalTime[j] || (arrivalTime[i] == arrivalTime[j] && priority[i] > priority[j])) {
                    int temp = arrivalTime[i]; arrivalTime[i] = arrivalTime[j]; arrivalTime[j] = temp;
                    temp = burstTime[i]; burstTime[i] = burstTime[j]; burstTime[j] = temp;
                    temp = priority[i]; priority[i] = priority[j]; priority[j] = temp;
                    temp = pid[i]; pid[i] = pid[j]; pid[j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            completionTime[i] = i == 0 ? arrivalTime[i] + burstTime[i] :
                                Math.max(arrivalTime[i], completionTime[i - 1]) + burstTime[i];
            turnAroundTime[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnAroundTime[i] - burstTime[i];
            totalWait += waitingTime[i];
            totalTurn += turnAroundTime[i];
        }

        System.out.println("\nPID\tArrival\tBurst\tPriority\tCompletion\tTurnaround\tWaiting");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t\t%d\t\t%d\t\t%d\n", pid[i], arrivalTime[i], burstTime[i], 
                               priority[i], completionTime[i], turnAroundTime[i], waitingTime[i]);
        }

        System.out.printf("\nAvg Waiting Time: %.2f\nAvg Turnaround Time: %.2f\n", totalWait / n, totalTurn / n);
    }
}
