package factoryDevices;

public class FactoryDevice {
    public static IDevices make(String devicesType){
        IDevices device;
        switch (devicesType.toLowerCase()){
            case "android":
                device = new Android();
                break;
            case "cloud":
                device = new AndroidCloud();
                break;
            default:
                device = new Android();
                break;
        }
        return device;
    }
}
