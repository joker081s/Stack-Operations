import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Set the height of stack : " );
        int stackHeight = sc.nextInt();
        sc.nextLine();
        int choice;
        int top = -1;
        List<Integer> myList = new ArrayList<>();
        boolean quit = false;
        commands();
        while(!quit) {
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 0 :
                    commands();
                    break;
                case 1 :
                    top = push(myList, top, stackHeight);
                    break;
                case 2 :
                    top = pop(myList, top);
                    break;
                case 3 :
                    displayStack(myList, top);
                    break;
                case 4 :
                    quit = true;
                    System.out.println("exiting...\nexited successfully");
                    break;
                default :
                    System.out.println("Error 02 : \n\tWrong choice :(\n\tPlease enter right choice :)");
                    break;
            }
        }
    }
    public static int push(List<Integer> arr, int top, int height) {
        if (top >= height - 1) {
            System.out.println("Error 01 :\n\tStack Overflow Exception\n\tStack is full!! :(");
            return 4;
        }
        System.out.print("PUSH Operation : \n\tEnter the value to push into stack : ");
        int val = sc.nextInt();
        ++top;
        arr.add(top, val);
        return top;
    }
    public static int pop(List<Integer> arr, int top) {
        if (top <= -1) {
            System.out.println("Error -1 : \n\tStack Underflow Exception\n\tStack is empty!! :(");
            return -1;
        }
        int x = arr.get(top);
        System.out.println("POP Operation : \n\tValue popped from stack : " + x);
        arr.remove(top);
        --top;
        return top;
    }
    public static void displayStack(List<Integer> arr, int top) {
        if (top <= -1) {
            System.out.println("Error 0 : \n\tStack is empty!! :(");
            return;
        }
        int[] str = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            str[i] = arr.get(i);
        }
        System.out.println("Stack : \n\t" + Arrays.toString(str));
    }
    public static void commands() {
        System.out.println("Choices : \n\t0 --> to print commands\n\t1 --> to push value in stack\n\t2 --> to pop value from stack\n\t3 --> display current stack\n\t4 --> to exit from program");
    }
}