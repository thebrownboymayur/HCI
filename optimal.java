import java.util.Scanner;

public class optimal {
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

        int[] framesMemory = new int[frames];
        int pageFaults = 0, pageHits = 0;

        for (int i = 0; i < frames; i++) framesMemory[i] = -1;

        for (int i = 0; i < length; i++) {
            int page = referenceString[i];
            boolean hit = false;

          
            for (int j = 0; j < frames; j++) {
                if (framesMemory[j] == page) {
                    hit = true;
                    pageHits++;
                    break;
                }
            }

            if (hit) {
                System.out.println("Page " + page + " already in memory (hit).");
            } else {
                pageFaults++;
                System.out.println("Page " + page + " caused a fault.");

               
                int replaceIndex = -1, farthest = -1;
                for (int j = 0; j < frames; j++) {
                    if (framesMemory[j] == -1) {
                        replaceIndex = j;
                        break;
                    }

                    int nextUse = findNextUse(referenceString, i, framesMemory[j]);
                    if (nextUse == -1) {
                        replaceIndex = j;
                        break;
                    }

                    if (nextUse > farthest) {
                        farthest = nextUse;
                        replaceIndex = j;
                    }
                }

                framesMemory[replaceIndex] = page;
            }
        }

        System.out.println("Total page faults: " + pageFaults);
        System.out.println("Total page hits: " + pageHits);
        scanner.close();
    }

    private static int findNextUse(int[] referenceString, int currentIndex, int page) {
        for (int i = currentIndex + 1; i < referenceString.length; i++) {
            if (referenceString[i] == page) return i;
        }
        return -1;
    }
}
