import java.util.Scanner;

abstract public class AirPurifier
{
    private String model_name, serial_number;
    protected boolean current_state;
    protected boolean power;

//    Scanner input;

    public AirPurifier(String model,String serial_number)
    {
        model_name = model;
        this.serial_number = serial_number;
//        Scanner input = new Scanner(System.in);
    }

    public String about_me()
    {
        return ("Model Name : "+model_name+"\nSerial Number : "+ serial_number);
    }
    public void check_plug()
    {
        if(power)
        {
            System.out.println("You already plugged");
        }
        else
        {
            System.out.println("You plug it");
            power_set(true);
        }
    }
    public void toggle_switch()
    {
//        current_state = (current_state)? false: true;
        if(!current_state && power)
        {
            current_state = true;
            System.out.println("You turn it on");
            open();
        }
        else
        {
            System.out.println("Not have enough power");
        }
    }

    protected void power_set(boolean power)
    {
        this.power = power;
    }

    protected void doNothing()
    {
        System.out.println("do nothing");
    }

    protected void open()
    {
        current_state = true;

        while(current_state)
        {
            status();
            working();
        }
    }

    protected void close()
    {
        current_state = false;
        System.out.println("Now your Air Purifier turned off");
    }

    protected void clear_terminal(){System. out. print("\033[H\033[2J");}

    abstract protected void status();

    abstract protected void working();
}
