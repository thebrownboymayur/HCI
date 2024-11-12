import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class fifo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int frames = scanner.nextInt();
        System.out.print("Enter length of reference string: ");
        int length = scanner.nextInt();
        
        int[] referenceString = new int[length];
        System.out.print("Enter the reference string: ");
        for (int i = 0; i < length; i++) {
            referenceString[i] = scanner.nextInt();
        }
        
    
        Queue<Integer> queue = new LinkedList<>();
        int pageFaults = 0;
        int pageHits = 0; 
        
        for (int page : referenceString) {
            
            if (!queue.contains(page)) {
              
                if (queue.size() == frames) {
                    queue.poll();
                }
              
                queue.add(page);
                pageFaults++;
                System.out.println("Page " + page + " caused a fault.");
            } else {
                pageHits++; 
                System.out.println("Page " + page + " already in memory (hit).");
            }
        }
        
        System.out.println("Total page faults: " + pageFaults);
        System.out.println("Total page hits: " + pageHits);
        scanner.close();
    }
}
