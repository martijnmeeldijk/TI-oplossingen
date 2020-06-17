package ui;

import domain.Date;

public class Application {
    public static void main(String[] args){
        Date datum = Date.createDMY(23, 8,2000);
        Date plusEen = datum.advanceSingleDay();


        System.out.println(Date.isMijnVerjaardag(plusEen));
    }
}
