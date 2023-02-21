package practise8;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int age;
    private String sex;
    private List<String> devices;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(String devices) {
        if(this.devices == null){
            this.devices = new ArrayList<>();
        }
        this.devices.add(devices);
    }



}
