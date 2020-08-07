import java.io.File;//imports file class
import java.io.PrintWriter;//imports printWriter class
import java.util.ArrayList;//imports arrayList Class
import java.util.Scanner;//imports scanner class
import java.io.FileNotFoundException;//imports filenotfoundexception class
public class Neighborhood {
    public static void inRead(ArrayList<Neighbor> x, Scanner in, int num) throws FileNotFoundException //method that reads input file into an ArrayList of type Neighbor
    {
        if (num == 1){
        int count = 0;//keeps track of each "neighbor" in ArrayList
        String name = null;// variable for name in input file
        int age = 0;// variable for age in input file
        String pn = null;// variable for phone number in input file
        int income = 0;// variable for income in input file
        String address = null;// variable for address in input file
        int fee = 0;// variable for name in fee file
        while (in.hasNextLine())//populates variables from "NeighborList" file
        {                      //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
            name = in.next();
            age = in.nextInt();
            pn = in.next();
            income = in.nextInt();
            address = in.next();
            fee = in.nextInt();
            Neighbor n = new Neighbor(name, age, pn, income, address, fee);//instantiates an instance of neighbor
            x.add(n);//adds information from above to ArrayList x of type Neighbor
            count++;//keeps track of each "neighbor" in ArrayList
        }
        in.close();
        }
        else
        {
            ArrayList<String> x2 = new ArrayList<String>();
            while(in.hasNextLine())
            {
                System.out.println(in.nextLine());//calls outPrint method(for output file)
            }
            System.out.println();
            while(in.hasNextLine())//creates a new array
            {
                String ln = in.nextLine();
                x2.add(ln);
            }
            in.close();
        }
    }


    public static void outPrint(ArrayList<Neighbor> aL)throws FileNotFoundException//method used to print output to the output text file
    {
        String temp = "src/output.txt"; //initializes variable to hold location for output file
        PrintWriter out = new PrintWriter(temp);//instantiates printWriter class
        Scanner in = new Scanner(temp);
        for (int i = 0; i < aL.size(); i++)//for loop that does the printing to the file↓↓↓↓↓↓↓↓↓↓
        {
            out.print(aL.get(i).getName() + "\t" + aL.get(i).getAge() + "\t" + aL.get(i).getPhone() + "\t" + aL.get(i).getInc() + "\t" + aL.get(i).getStreet() + " \t" + aL.get(i).getFees());//prints to output file
            out.println();
        }

        out.close();
    }


    public static void choice(int c, ArrayList<Neighbor> aL) {//method for each choice from the menu chosen by user
        switch (c) {

            case 1:
                printReport(aL);
                break;

            case 2:
                addNeighbor(aL);
                break;

            case 3:
                deleteNeighbor(aL);
                break;

            case 4:
                Scanner uInput = new Scanner(System.in);
                System.out.println("enter name: ");
                String name = uInput.next();
                find(name, aL);
                break;

            case 5:
                addFee(aL);
                break;

            case 6:
                changeNum(aL);
                break;
        }
    }

public static void printReport(ArrayList<Neighbor> aL)//prints the full report of all objects
    {
        for (Neighbor x: aL)
        {
            System.out.println(x.getName() + "\t" + x.getAge() + "\t" + x.getPhone() +"\t" + x.getInc() + "\t" + x.getStreet() + " \t" + x.getFees());
        }
    }


    public static int find(String f, ArrayList<Neighbor>aL )//finds the name of an object
    {
        boolean found = false;
        int count = 0;
        for (int i = 0; i < aL.size(); i++)//for statement that loops through each object in the arraylist
        {
            if(f.equals(aL.get(i).getName()))//if statement that compares the input with the name attribute of each object until the name is found
            {
                found = true;
                count = i;
                System.out.println(aL.get(count).getName() + "\t" + aL.get(count).getAge() + "\t" + aL.get(count).getPhone() +"\t" + aL.get(count).getInc() + "\t" + aL.get(count).getStreet() + "\t" + aL.get(count).getFees());

            }
        }
        if(found)
        {
            return count;//returns position of object if found
        }
        else
            {
                return -1;//returns -1 if not found
            }
    }

    public static void addNeighbor(ArrayList<Neighbor> aL)//adds object to arraylist
    {
        Scanner in = new Scanner(System.in);//prompts to the user ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        System.out.println("enter a name: ");
        String name = in.next();
        System.out.println("enter an age: ");
        int age = in.nextInt();
        System.out.println("enter a phone number:");
        String pNumber = in.next();
        System.out.println("enter income: ");
        int income = in.nextInt();
        System.out.println("enter an address: ");
        String address = in.next();
        System.out.println("enter fee: ");
        int fee = in.nextInt();
        Neighbor n = new Neighbor(name, age, pNumber, income, address, fee);//instantiates an instance of neighbor
        aL.add(n);//adds information from above to ArrayList x of type Neighbor
        boolean verify = aL.get(aL.size()-1).checkObject(name, age, pNumber, income, address, fee);//verifies that there are no typos
        if(verify == true)//if no typo, neighbor gets added
        {
            System.out.println("Neighbor added!");
            System.out.println(n.getName() + "\t" + n.getAge() + "\t" + n.getPhone() + "\t" + n.getInc() + "\t" + n.getStreet() + " \t" + n.getFees());
        }
        else//if bad input, the method starts over
            {
                System.out.println("bad input!");
                aL.remove(aL.size()-1);
                addNeighbor(aL);
            }

    }


    public static void deleteNeighbor(ArrayList<Neighbor> aL)//deletes a neighbor based on user input
    {
        Scanner in = new Scanner(System.in);
        System.out.println("who are you looking for? ");
        String name = in.next();
        int pos = find(name, aL);
        if(pos > -1 && pos <aL.size())
        {
            System.out.println("Removed");
            aL.remove(pos);
        }
        else//restarts method if bad input
            {
                System.out.println("This person does not exist. Try again.");
                deleteNeighbor(aL);
            }

    }

    public static void addFee(ArrayList<Neighbor> aL)//adds fee to object
    {
        Scanner in = new Scanner(System.in);
        System.out.println("who are you looking for? ");
        String name = in.next();
        int pos = find(name, aL);//calls find method to find person
        System.out.println("How much are the fees?");
        int f = in.nextInt();
        aL.get(pos).setCharges(f);//calls setCharges method to add input with current charges
        System.out.println(aL.get(pos).getName()+ "\t" + aL.get(pos).getFees());//sout's the object name and new fees
    }


    public static void changeNum(ArrayList<Neighbor> aL)//changes an objects phone number
    {
        Scanner in = new Scanner(System.in);
        System.out.println("who are you looking for? ");
        String name = in.next();
        int pos = find(name, aL);//finds the name of object
        System.out.println("What would you like to change the number to? ");
        String f = in.next();
        boolean ver = aL.get(pos).setNum(f);//changes the number
        System.out.println(aL.get(pos).getName() + aL.get(pos).getPhone());//sout's the name and new phone number
    }


    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Neighbor> neigh = new ArrayList<Neighbor>();
        File input = new File("src/NeighborList.txt");//instantiates file class using "NeighborList"
        Scanner in1 = new Scanner(input);//allows reading from input file "NeighborList"
        inRead(neigh, in1, 1);//calls inRead method and sends parameters necessary parameters
        outPrint(neigh);//calls outPrint method which prints each neighbor to the screen

        File input2 = new File("src/output.txt");
        Scanner in2 = new Scanner(input2);
        inRead(neigh, in2, 2);//second call of inRead method

        Scanner uInput = new Scanner(System.in);
        int option = 0;//menu option that loops until input is 7↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        do {
            System.out.println("Please choose which option you want:");
            System.out.println("1. Print report of neighbors");
            System.out.println("2. Add neighbor");
            System.out.println("3. Delete neighbor");
            System.out.println("4. Find a neighbor");
            System.out.println("5. Add fees to neighbor's charges");
            System.out.println("6. Change phone number");
            System.out.println("7. Exit");
            option = uInput.nextInt();
            choice(option, neigh);
            System.out.println();
            }while (option != 7) ;
        outPrint(neigh);//prints to output file
        printReport(neigh);//prints final report to screen
        }
    }

