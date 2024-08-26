package com.mistake.day5.demo6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Observer;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/day5.demo6/info.xml");
        Properties properties = new Properties();
        properties.loadFromXML(fileInputStream);
        int range = Integer.parseInt(properties.getProperty("range"));
        String reflectClassName = properties.getProperty("reflect");
        int limit = Integer.parseInt(properties.getProperty("limit"));
        int nums = Integer.parseInt(properties.getProperty("nums"));
        String address = properties.getProperty("address");
        Factor factor = new Factor(limit, nums, address);
        fileInputStream.close();

        Subject subject = new Subject();
        Observer observer1 = new DataObserver();
        Observer observer2 = new AbnormalObserver();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.setFactor(factor);
        //  ISimuData<Integer> sdobj = (ISimuData) Class.forName(reflectClassName).newInstance();
        // sdobj.open();
        int i = 0;
        while (Boolean.TRUE) {

            subject.setData( i);
            i++;
            if (i>10){
                return;
            }
            try {
                Thread.sleep(range * 100);
            } catch (Exception e) {
            }
        }
    }
}
