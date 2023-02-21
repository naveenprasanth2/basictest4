package practise5;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String sex;
    private int age;
    List<String> devices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(String device) {
        if (this.devices == null) {
            this.devices = new ArrayList<>();
        }
        this.devices.add(device);
    }


}
