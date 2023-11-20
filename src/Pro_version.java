import java.util.Scanner;

public class Pro_version extends AirPurifier
{
    private String mode_have[] = {"heal","auto","max"};
    private  String mode = mode_have[1];

    private int dust_value;
    public Pro_version(String model, String serial_number)
    {
        super(model, serial_number);
    }

    @Override
    protected void working()
    {
        Scanner input_pro = new Scanner(System.in);
        System.out.println("Hello, I am pro version and now I am working");

        boolean stop = false;

        while (!stop)
        {
            System.out.println("what should you do: \nUnplug(1), turn off (2), Change mode(3), I think there are a lot of dust here(4), Check my status (5), Do nothing (else)");

            int result = 0;
            if(input_pro.hasNextInt()) result = input_pro.nextInt();

            switch (result)
            {
                case 1 -> {close(); stop = true; power_set(false);}
                case 2 -> {close(); stop = true;}
                case 3 -> set_mode();
                case 4 -> {}
                case 5 -> status();
            }

            input_pro.nextLine();
        }
    }

    @Override
    protected void status()
    {

        System.out.println("\nStatus");
        System.out.println(about_me());
        System.out.println("Fan speed : "+fan_speed(mode));
        System.out.println("Current mode : "+mode+'\n');
    }

//    private String fan_speed(String mode, int dust_value = 0)
//    {
//        if(mode.equals(mode_have[0])) return;
//    }

    private String fan_speed(String mode)
    {
        if(mode.equals(mode_have[0])) return "LOW";
        else if (mode.equals(mode_have[1]))
        {
            return fan_speed(dust_value);
        }
        else return "HIGH";
    }

    private String fan_speed(int dust_value) //use in auto mode
    {
        if(dust_value >= 40) return "HIGH";
        else if (dust_value >= 20) return "MEDIUM";
        else return "LOW";
    }

    private void set_mode()
    {
        boolean not_ok = true;
        Scanner input = new Scanner(System.in);

        while(not_ok)
        {
            System.out.println("I have 3 mode\n");
            int result = 0;
            if(input.hasNextInt()) result = input.nextInt();

            switch (result)
            {
                case 1 -> { mode = mode_have[0]; not_ok = false; }
                case 2 -> { mode = mode_have[1]; not_ok = false; }
                case 3 -> { mode = mode_have[2]; not_ok = false; }
                default -> System.out.println("Bro, 1-2 only");
            }

            input.nextLine();
        }
    }

    private void feel_lot_of_dust()
    {
        if(mode.equals(mode_have[1]))
        {
                
        }

        System.out.println("How many dust do you think now?");


    }
}
