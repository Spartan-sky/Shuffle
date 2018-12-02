import java.util.Scanner;
import java.util.ArrayList;

public class Shuffle{

    //Static Variables
    private static ArrayList<Deck> decks = new ArrayList<Deck>();

    public static void main(String []args)
    {
        System.out.println("Creating the first deck:");
        decks.add(new Deck());

        menu();

        System.out.println("Goodbye!");
    }

    private static void menu()
    {
        Scanner sc = new Scanner(System.in);
        int choice=0;
        while(choice != 5)
        {
            System.out.println("1) Create new deck:");
            System.out.println("2) Print mapping for a deck:");
            System.out.println("3) Print size of decks:");
            System.out.println("4) Print mapping of all decks:");
            System.out.println("5) Quit:");
            try
            {
                choice = Integer.parseInt(sc.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Wrong input!");
                choice = 5;
            }

            switch(choice)
            {
                case 1:
                    decks.add(new Deck());
                    break;
                case 2:
                    boolean inDecks = false;
                    int location = 0;
                    while(!inDecks)
                    {
                        System.out.println("These are your deck options:");
                        for(int i=0; i < decks.size(); i++)
                        {
                            System.out.println(i+1 +") deck size: "+ decks.get(i).getSize());
                        }
                        System.out.println("Which one:\t");
                        try
                        {
                            location = Integer.parseInt(sc.nextLine());
                            decks.get(location -1).printMapping();
                            inDecks = true;
                        }
                        catch(Exception e)
                        {
                            System.out.println("Chose outside of deck range");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Here are your decks and sizes:");
                    for(int i=0; i < decks.size(); i++)
                    {
                        System.out.println(i+1 +") deck size: "+ decks.get(i).getSize());
                    }
                    break;
                case 4:
                    System.out.println("Showing mapping for each deck:");
                    for(int i=0; i < decks.size(); i++)
                    {
                        System.out.println(i+1 +") deck:");
                        decks.get(i).printMapping();
                    }
                    System.out.println();
                    break;
            }
        }
        sc.close();
    }
}

class Deck
{
    private ArrayList<Integer> deck = new ArrayList<Integer>();
    private int half, size;

    public Deck()
    {
        Scanner sc = new Scanner(System.in);

        //Get size of deck
        System.out.print("Enter the size of the deck:\t");
        size = sc.nextInt();
        init(size);

        half = deck.size()/2;
    }

    private void init(int size)
    {
        //Input numerical numbers
        for(int i=0; i < size; i++)
        {
            deck.add(i);
        }
    }

    public void printMapping()
    {
        int counter = 1;

        System.out.println("Printing the mapping:");
        System.out.println("----------------------------------------------------");
        for(int i=0; i < deck.size(); i++)
        {
            if(i < half)
            {
                System.out.printf("%2d  --->  %2d\n", i, i*2);
            }else
            {
                System.out.printf("%2d  --->  %2d\n", i, counter);

                //Isn't giving me the last mapping
                // System.out.printf("%2d  --->  %2d\n", i, (i*2) % (size - 1));
                counter+=2;
            }
        }
        System.out.println("----------------------------------------------------");
    }

    public int getSize()
    {
        return size;
    }
}