import java.util.Scanner;

public class Main {


    public static int expression(String temp){

        while(temp.contains("(")){

        int open = temp.lastIndexOf("(");
        int close = temp.indexOf(")", open);

        String part = temp.substring(open + 1 , close);

        int answer = expression(part);

        temp = temp.replace("(" + part + ")" , answer + "");
        }

        // NOT
        while (temp.contains("!0") || temp.contains("!1")) {
            temp = temp.replace("!0", "1");
            temp = temp.replace("!1", "0");
        }

        // AND
        while (temp.contains("1&1") || temp.contains("1&0") || temp.contains("0&1") || temp.contains("0&0")) {
            temp = temp.replace("1&1", "1");
            temp = temp.replace("1&0", "0");
            temp = temp.replace("0&1", "0");
            temp = temp.replace("0&0", "0");
        }

        // OR
        while (temp.contains("1|1") || temp.contains("1|0") || temp.contains("0|1") || temp.contains("0|0")) {
            temp = temp.replace("1|1", "1");
            temp = temp.replace("1|0", "1");
            temp = temp.replace("0|1", "1");
            temp = temp.replace("0|0", "0");

        }
        return Integer.parseInt(temp);
    
    }


    public static void main(String [] args){
        
        Scanner scan = new Scanner(System.in);

        System.out.println("__________________________________\n");

        System.out.print("Enter the expression >>> ");
        


        String input = scan.nextLine();
        input = input.replace(" ","");
        input = input.toUpperCase();

        System.out.println("__________________________________\n");
        System.out.println("Your expression is " + input);
        System.out.println("__________________________________\n\n");


        int A;
        int B;
        int C;

        System.out.println("A\tB\tC\t|\tF");
        System.out.println("----------------------------------");

        int count1 = 0;
        int count0 = 0;

        for(int i = 0 ; i <= 7 ; i++){
            A = i / 4;
            B = (i / 2) % 2;
            C = i % 2;

            String temp = input;
            temp = temp.replace("A", A + "");
            temp = temp.replace("B", B + "");
            temp = temp.replace("C", C + "");

            int F = expression(temp);

            if (F == 1)
                count1++;
            
            else
                count0++;
            

            System.out.println( A +"\t"+ B +"\t"+ C +"\t|\t"+ F);
        }
        System.out.println("\n__________________________________");

        System.out.print("\nResult >>> "); 


        if (count1 == 8) {
            System.out.println("Tautology ");
        } 
        else if (count0 == 8) {
            System.out.println("Contradiction ");
        } 
        else {
            System.out.println("Contingent ");
        }

        System.out.println("__________________________________\n");

        scan.close();
        }
}

