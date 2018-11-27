import java.util.Scanner;

public class Shuffle{

    //Static Variables
    static int counter = 0;
    static int[] first;
    static int[] second;

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
    
        //Get size of deck
        System.out.print("Enter the size of the deck:\t");
        int size = sc.nextInt();

        //Initialize size
        int[] orig = init(size);
        int[] ch = init(size);
        if(size % 2 == 0)//Even
        {
            first = new int[size/2];
            second = new int[size/2];
        }else//Odd
        {
            first = new int[(size/2) + 1];
            second = new int[size/2];
        }
        //Shuffle algorithm
        shuffle(orig, ch);

        System.out.println("\nCounter:\t"+ counter);

        sc.close();
    }

    private static int[] init(int size)
    {
        //Create array with size
        int[] arr = new int[size];
        
        //Input numerical numbers
        for(int i=0; i < arr.length; i++)
        {
            arr[i] = i;
        }
        
        return arr;
    }
        
    private static int shuffle(int[] orig, int[] change)
    {
        //Use to break recursion
        boolean same = true;

        //Fill first array
        System.out.println("\nFIRST");
        for(int i=0; i < first.length; i++)
        {
            System.out.print(change[i] +" ");
            first[i] = change[i];
        }
        //Fill second array
        System.out.println("\nSECOND");
        for(int i=0; i < second.length; i++)
        {
            System.out.print(change[i + first.length] +" ");
            second[i] = change[i + first.length];
        }
        //Refill change arr with new ordering
        for(int i=0; i < change.length; i++)
        {
            if(i % 2 == 0)
            {
                change[i] = first[i/2];
            }
        }
        for(int i=0; i < change.length; i++)
        {
            if(i % 2 == 1)
            {
                change[i] = second[(i -1)/2];
            }
        }
        //Check if any spots are different and print new ordering
        System.out.println("\nDeck together");
        for(int i=0; i < change.length; i++)
        {
            if(orig[i] != change[i])
            {
                same = false;
            }
            System.out.print(change[i] +" ");
        }
        counter++;
        
        //Break recursion
        if(same && counter!=0)
        {
            return counter;
        }else//Reshuffle
        {
            shuffle(orig, change);
        }
        
        return -1;
    }
}