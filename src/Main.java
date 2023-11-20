import java.util.Scanner;

class Main
{
    static AirPurifier item;
//    static Scanner input = new Scanner(System.in);

    public  static  String serial_number()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Give me a Serial number");
        String sn = input.nextLine();
        return sn;
    }
    public static void  choose()
    {
        Scanner input = new Scanner(System.in);
        boolean input_ok = false;
        while(!input_ok)
        {
            System.out.println("choose your model\nnot Pro(1) Pro(2) DIY(3)");
            int result = 0;

            if(input.hasNextInt()) result = input.nextInt();

            switch (result)
            {
                case 1 -> {}
                case 2 -> {item = new Pro_version("Pro_version",serial_number()); input_ok = true;}
                case 3 -> {item = new Diy("diy model"); input_ok = true;}
                default -> System.out.println("1-3 in int only");
            }
            input.nextLine();
        }
    }

    static public void doing_something()
    {
        boolean working = true;
        while(working)
        {
            System.out.println("What do you want to do after got Air Purifier");

            boolean inputNotOk = true;
            while(inputNotOk)
            {
                System.out.println("plug it(1) kick(2) do nothing(3) turn it on(4) leave it(5)");
                Scanner input = new Scanner(System.in);
                int Result = 0;
                if(input.hasNextInt()) Result = input.nextInt();

                switch (Result)
                {
                    case 1 -> {item.check_plug(); inputNotOk = false;}
                    case 2 -> System.out.println("You doing this for what?");
                    case 3 -> System.out.println("You do nothing");
                    case 4 -> {item.toggle_switch(); inputNotOk = false;}
                    case 5 -> {inputNotOk = false; working = false;}
                    default -> System.out.println("1-5 in int only");
                }

                input.nextLine();
            }
        }
    }

    public static void main(String[] args)
    {
        choose();
        doing_something();
    }
}