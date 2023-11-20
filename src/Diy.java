import java.util.Scanner;

public class Diy extends AirPurifier
{
    Diy(String model)
    {
        super(model, "not have serial number");
    }

    @Override
    protected void status()
    {
        System.out.println("Status\nFan speed: HIGH");
    }

    @Override
    protected void working()
    {
        Scanner input_diy = new Scanner(System.in);
        boolean check_input = false;
        System.out.println("Now your Air Purifier is working");

        while (!check_input)
        {
            System.out.println("what should you do: \nUnplug(1), Do nothing (2), turn off (3)");
            int result = 0;
            if(input_diy.hasNextInt()) result = input_diy.nextInt();
            switch (result)
            {
                case 1 -> {close(); check_input = true; power_set(false);}
                case 2 -> doNothing();
                case 3 -> {close(); check_input = true;}
                default -> System.out.println("1-3 in int only");
            }

            input_diy.nextLine();
        }
    }
}
