package domain;

public final class Date implements Comparable<Date>
{
    private final int day;
    private final int month;
    private final int year;

    public static Date createDMY (int day , int month , int year) {
        return new Date(day, month, year);
    }
    public static Date createMDY (int month , int day , int year) {
        return new Date(day, month, year);
    }

    private Date( int day, int month, int year ) throws IllegalArgumentException {
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }

    

    
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }
    
    public static boolean isLeapYear( int year ) {
    	boolean isLeapYear = false;
    	if( year%4 == 0 ){
        	if(! (year%100 == 0 && year%400 != 0)){
        		isLeapYear = true;
        	}
    	}
        return isLeapYear;
    }
    
    public static boolean isValidDate( int day, int month, int year ) {
        return month >= 1 && 
        		month <= 12 && 
        		day >= 1 && 
        		day <= numberOfDaysInMonth( month, year );
    }  

    public static int numberOfDaysInMonth( int month, int year ) throws IllegalArgumentException {
    	if(month < 1 || month > 12){
    		throw new IllegalArgumentException("Invalid month.");
    	}
    	int nrOfDays = 31;
        switch ( month ) {
	        case 1:
	        case 3:
	        case 5:
	        case 7:
	        case 8:
	        case 10:
	        case 12:
	            break;	
	        case 2:
	        	nrOfDays = isLeapYear( year ) ? 29 : 28;
	        	break;	
	        case 4:
	        case 6:
	        case 9:
	        case 11:
	        	nrOfDays = 30;
	        	break;
        }
        return nrOfDays;
    }

    public boolean isBefore( Date otherDate ) {
        if ( otherDate == null ) {
            throw new IllegalArgumentException("Invalid date.");
        }
        boolean isBefore = false;
        if ( getYear() < otherDate.getYear() ) {
        	isBefore = true;
        } else if ( getYear() == otherDate.getYear() ) {
            if ( getMonth() < otherDate.getMonth() ) {
            	isBefore = true;
            } else if ( getMonth() == otherDate.getMonth() ) {
            	isBefore = getDay() < otherDate.getDay();
            }
        }
        return isBefore;        
    }

    public boolean isAfter( Date otherDate ) {
        if ( otherDate == null ) {
            throw new IllegalArgumentException("Invalid date.");
        }
        return otherDate.isBefore( this );        
    }

    public Date advanceSingleDay() {
        Date date;
        if ( getDay() == numberOfDaysInMonth( getMonth(), getYear() ) ) {
            if ( getMonth() == 12 ) {
                date = new Date( 1, 1, getYear() + 1 );
            } else {
                date = new Date( 1, getMonth() + 1, getYear() );
            }
        } else {
        	date = new Date( getDay() + 1, getMonth() , getYear() );
        }
        return date;
    }
    
    public Date goBackSingleDay()  {
        Date date;
        if ( getDay() == 1 ) {
            if ( getMonth() == 1 ) {
                date = new Date( 31, 12, getYear() - 1 );
            } else {
            	int nrOfDays =  numberOfDaysInMonth( getMonth() - 1, getYear() );
                date = new Date( nrOfDays , getMonth() - 1, getYear() );
            }
        } else {
            date = new Date( getDay() - 1 , getMonth(), getYear() );
        }
        return date;
    }
    private int toDays(){
        int sum = 0;
        for(int j = 0; j < year; j++) {
            for (int i = 1; i < 13; i++) {
                sum += numberOfDaysInMonth(i, j);
            }
        }
        for(int i = 1; i < month; i++){
            sum += numberOfDaysInMonth(i, year);
        }
        sum += day;
        return sum;
    }
    public static String isMijnVerjaardag(Date a){
        return "Het is" + ((a.getDay() == 23 && a.getMonth() == 8)? " " : " niet ") + "mijn verjaardag";
    }
    
    @Override 
    public boolean equals( Object object ) {
    	boolean same = false;
        if ( object instanceof Date ) {
            Date otherDate = (Date) object;
            if(getDay() == otherDate.getDay() &&
            		getMonth() == otherDate.getMonth() &&
            		getYear() == otherDate.getYear()){
            	same = true;
            }
        }
        return same;
    }
    
    @Override 
    public String toString(){
    	String output = getDay()+"/"+getMonth()+"/"+getYear();
    	return output;
    }

    @Override
    public int compareTo(Date other){
        return this.toDays() - other.toDays();
    }
}
