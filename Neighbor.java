public class Neighbor {
    private String name;//instance variables↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    private int age;
    private String pNumber;
    private int income;
    private String address;
    private int fee;
    public Neighbor(String n, int a, String pn, int i, String ad, int f)//constructor for neighbor class
    {
        this.name = n;
        this.age = a;
        this.pNumber = pn;
        formatPhone();
        this.income = i;
        this.address = ad;
        this.fee = f;
    }
    public String getName()//method that returns name of object
    {
        return name;
    }
    public int getAge()//method that returns age of object
    {
        return age;
    }
    public String getPhone()//method that returns phone number of object
    {
        return pNumber;
    }
    public int getInc()//method that returns income of object
    {
        return income;
    }
    public String getStreet()//method that returns address of object
    {
        return address;
    }
    public int getFees()//object that returns fees of object
    {
        return fee;
    }
    public void formatPhone()//method that format the phone number
    {
        String f1 = "(" + this.pNumber.substring(0,3) + ")";
        String f2 = this.pNumber.substring(3,6) + "-";
        String f3 = this.pNumber.substring(7,10);
        this.pNumber = f1 + f2 + f3;
    }
    public boolean checkObject(String n, int a, String p, int i, String s, int f)//method that returns true if the name and phone number are entered correctly
    {
        boolean statement = false;
        boolean ver = verifyName(n);
        if (ver == true)
        {
            ver = verifyPh(p);
            if (ver == true)
            {
                statement = true;
            }
        }
        return statement;
    }
    public boolean verifyName(String n)//This method returns true if the name is typed correctly
    {
        boolean r = true;//variable initially set to return at the end
        while(r)
        {
            for(int i = 0; i < n.length(); i++)//for statement that checks each character in the name
            {
                if (n.charAt(i) < 65 || (n.charAt(i) > 90 && n.charAt(i) < 97) || n.charAt(i) > 121)//compares each of the letters from a-z or A-Z using ascii values
                {
                    r = false;//becomes false if there is a typo
                    break;
                }
            }break;
        }
        return r;
    }
    public boolean verifyPh(String p)//This method returns true if the phone number is typed correctly and has 10 digits
    {
        boolean rstatement = true;//variable initially set to return at the end
        while (rstatement && p.length() == 10) {
            for (int i = 0; i < p.length(); i++) //for statement that checks each character in the phone number
            {
                if (p.charAt(i) < 48 || p.charAt(i) > 57)//compares each of the numbers between 0-9 using ascii values
                {
                    rstatement = false;//becomes false if there is a typo
                    break;
                }
            }
            break;
        }
        return rstatement;
    }
    public void setCharges(int x)//sets new fee to user input in addition to current fees
    {
        this.fee =this.fee + x;
    }
    public boolean setNum(String x)//method that changes the number of object(verifies if number is entered correctly before changing)
    {
        boolean ver = verifyPh(x);
        if(ver)
        {
            this.pNumber = x;
            formatPhone();
        }
        return ver;

    }



}
