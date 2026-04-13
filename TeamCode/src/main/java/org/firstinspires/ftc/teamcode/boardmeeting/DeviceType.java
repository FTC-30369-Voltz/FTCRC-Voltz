package org.firstinspires.ftc.teamcode.boardmeeting;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.HashMap;

/* Notes for others: This is a template class. That allows programmers to write code to
* handle, in this case, any kind of hardware device without having to make a bunch of other classes.
*/
public class DeviceType<C> {
    public HashMap<String, C> devices;

    public Class<C> cClass;
    public DeviceType(Class<C> cClass){
        /* Hopefully avoiding null problems here by initializing the "devices"
        * and "cClass" variables before doing anything with them.
        */
        this.devices = new HashMap<String, C>();
        this.cClass = cClass;
    }

    public C addItem(HardwareMap map, String name)
    {
        /* Gets the "cClass" (or, say, DcMotor.class) device in the HardwareMap
        * associated with this function's "name" input, and then puts it in
        * the "devices" hashmap with the same key as the device's name in the
        * drive hub's current profile.
        */
        this.devices.put(name, map.get(this.cClass, name));
        return this.devices.get(name);
    }
    public C getItem(String name)
    {
        // Queries the device associated with this function's "name" input.
        return this.devices.get(name);
    }
}