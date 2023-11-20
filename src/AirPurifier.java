//Design

/*
field :
Model_name (string)
Serial_Number (string)
Power_Supply (bool)

Dust_Value (int)
Dust_sensor (bool)
Switch_Sensor_on_off (bool)

Mode (int 1-3 silent heal max)
Fan_speed (string speed[] = {High Medium Low})\

Current_state (bool on/off)

method :
-check model , have chang mode if it's pro model

//do both model
-check Switch , open when switch on and have power
-change fan speed, high speed if dust more than 60 ; medium when 40 low when 20
(auto)
-check Serial number, return Serial number

//do in pro
-check mode; always high when max mode, always low when silent

//do in special diy
always high
*/

import java.util.Scanner;

abstract public class AirPurifier
{
    private String model_name, serial_number;
    protected boolean current_state;
    protected boolean power;
    private boolean dust_sensor;

//    Scanner input;

    public AirPurifier(String model,String serial_number)
    {
        model_name = model;
        if(!model_name.equals("diy model")) dust_sensor = true;
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
        System.out.println("Now your Air Purifier was turned off");
    }

    protected void clear_terminal(){System. out. print("\033[H\033[2J");}

    abstract protected void status();

    abstract protected void working();
}
