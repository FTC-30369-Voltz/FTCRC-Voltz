package org.firstinspires.ftc.teamcode.boardmeeting;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.HashMap;

public abstract class DeviceType<C> {
    public HashMap<String, C> devices;
    public Class<C> cClass;

    public C addItem(HardwareMap map, String name)
    {
        devices.put(name, map.get(cClass, name));
        return devices.get(name);
    }
    public C getItem(String name)
    {
        return devices.get(name);
    }
}