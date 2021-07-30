package com.company.main;

import com.company.Phone;

public class Main {
/*
https://mvnrepository.com/artifact/com.sun.istack/istack-commons-runtime/4.0.1
  NoDefClass Hatasi alirsan buradan indir
*/

    public static void main(String[] args) {
        // write your code here
        Phone phone1 = new Phone("111");
        Phone phone2 = new Phone("222");
        Phone phone3 = new Phone("333");

//        phone1.sendMessage(phone3.getNumber());
        phone1.sendMessage(phone3.getNumber());
//        phone1.sendMessage(phone3.getNumber());
//        phone1.callPhone(phone2.getNumber(), true);

//        phone2.sendMessage(phone3.getNumber());
//        phone3.callPhone(phone2.getNumber(), true);
        phone2.callPhone(phone3.getNumber(), false);

       /* for(int i=0;i<100;i++){
        phone2.callPhone(phone3.getNumber(), false);
        }*/
//

    }
}
