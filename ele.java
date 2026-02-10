import java.io.*;
import java.lang.*;
public class ele {
    public static void main(String args[]) throws IOException {
        DataInputStream d = new DataInputStream(System.in);
        double total = 0;
        System.out.println("Enter the Previous Reading:");
        int pre = Integer.parseInt(d.readLine());
        System.out.println("Enter the Present Reading:");
        int present = Integer.parseInt(d.readLine());
        // BUG FIX 1: Present minus Previous
        int unit = present - pre; 
        System.out.println("Enter the Consumer Type (d for Domestic):");
        String type = d.readLine();
       System.out.println("-----------------------");
        System.out.println("The Usage Slab is :" + unit);
        if (type == 'd') {
            if (unit <= 100) {
                System.out.println("Rate per Unit: RS.4.80");
                total = unit * 4.80;
            } 
            else if (unit <= 200) {
                // BUG FIX 3: Cumulative Calculation
                System.out.println("Rate per Unit: RS.5.80");
                total = (100 * 4.80) + (unit - 100) * 5.80;
            } 
            else {
                 System.out.println("Rate per Unit: RS.6.50");
                total = (100 * 4.80) + (100 * 5.80) + (unit - 200) * 6.50;
            }
        } else {
            // Non-Domestic logic
             System.out.println("Rate per Unit: RS.6.05");
            total = unit * 6.05; 
        }
       System.out.println("The Bill Amount :" + total);
    }
} 
