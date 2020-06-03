package domain;
/**
 * Datum klasse. Houdt een dag, maand en jaar bij.
 *
 */
public class Datum implements Comparable<Datum>
{
    private int day;
    private int month;
    private int year;

    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    /**
     * Constructor.
     * 
     * @param   day
     *              Dag
     * @param   month
     *              Maand
     * @param   year
     *              Jaar
     *              
     * @throws  IllegalArgumentException
     *              Bij ongeldige argumenten
     */
    public Datum( int day, int month, int year )
    {
        if ( !isValidDate( day, month, year ) )
        {
            throw new IllegalArgumentException();
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Gaat na of het gegeven jaar een schrikkeljaar is.
     * 
     * @param   year
     *              Jaar
     *              
     * @return  <code>true</code> indien het gegeven jaar een schrikkeljaar is,
     *          <code>false</code> in het andere geval.
     */
    public static boolean isLeapYear(int year)
    {
        return year % 4 == 0;
    }

    /**
     * Geeft het aantal dagen in de maand van dat jaar terug.
     * 
     * @param   month
     *              Maand
     * @param   year
     *              Jaar
     *              
     * @return  Aantal dagen in de maand.
     * 
     * @throws  IllegalArgumentException
     *              Bij ongeldige parameterwaarden
     */
    public static int numberOfDaysInMonth(int month, int year)
    {
        switch ( month )
        {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;

        case 2:
            return isLeapYear( year ) ? 29 : 28;

        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Gaat na of de gegeven datum geldig is.
     * 
     * @param   day
     *              Dag
     * @param   month
     *              Maand
     * @param   year
     *              Jaar
     *              
     * @return  <code>true</code> indien het geldig is, <code>false</code> in het andere geval.
     */
    public static boolean isValidDate(int day, int month, int year)
    {
        return month >= 1 && month <= 12 && day >= 1 && day <= numberOfDaysInMonth( month, year );
    }

    /**
     * Geeft de dag terug.
     * 
     * @return  Dag
     */
    public int getDay()
    {
        return this.day;
    }

    /**
     * Geeft de maand terug.
     * 
     * @return  Maand
     */
    public int getMonth()
    {
        return this.month;
    }

    /**
     * Geeft het jaar terug
     * 
     * @return  Jaar
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * Gaat na of deze datum voor de andere datum valt.
     * 
     * @param   other
     *              Andere datum
     *              
     * @return  <code>true</code> indien deze datum voor de andere datum valt,
     *          <code>false</code> in het andere geval.
     * 
     * @throws  IllegalArgumentException
     *              Indien other <code>null</code> is
     */
    public boolean isBefore(Datum other)
    {
        if ( other == null )
        {
            throw new IllegalArgumentException();
        }
        else if ( this.year < other.year )
        {
            return true;
        }
        else if ( this.year == other.year )
        {
            if ( this.month < other.month )
            {
                return true;
            }
            else if ( this.month == other.month )
            {
                return this.day < other.day;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Gaat na of deze datum na de andere datum valt.
     * 
     * @param   other
     *              Andere datum
     *              
     * @return  <code>true</code> indien huidige datum na de andere datum valt,
     *          <code>false</code> in het andere geval.
     * 
     * @throws  IllegalArgumentException
     *              Indien other <code>null</code> is
     */
    public boolean isAfter(Datum other)
    {
        if ( other == null )
        {
            throw new IllegalArgumentException();
        }
        else
        {
            return other.isBefore( this );
        }
    }

    /**
     * Gaat na of de datum gelijk is aan een andere datum
     * 
     * @param   that
     *              Andere datum
     *              
     * @return  <code>true</code> indien beide datums gelijk zijn,
     *          <code>false</code> in het andere geval
     *          
     * @throws  IllegalArgumentException
     *              Indien that <code>null</code> is
     */
    public boolean isSameDate(Datum that)
    {
        if ( that == null )
        {
            throw new IllegalArgumentException();
        }
        else
        {
            return this.day == that.day && this.month == that.month && this.year == that.year;
        }
    }

    /**
     * Geeft de datum die een dag later valt dat de huidige.
     * 
     * @return  De dag erna
     */
    public Datum nextDay()
    {
        int day = this.day;
        int month = this.month;
        int year = this.year;

        day++;

        if ( day > numberOfDaysInMonth( month, year ) )
        {
            day = 1;
            month++;

            if ( month > DECEMBER )
            {
                month = 1;
                year++;
            }
        }

        return new Datum( day, month, year );
    }

    /**
     * Geeft de datum die een gegeven aantal dagen in de toekomst valt.
     * 
     * @param   nDays
     *              Aantal dagen
     *              
     * @return  Datum die het gegeven aantal dagen verder in de toekomst ligt
     * 
     * @throws  IllegalArgumentException
     *              Indien nDays negatief is
     */
    public Datum advanceDays(int nDays)
    {
        if ( nDays < 0 )
        {
            throw new IllegalArgumentException();
        }
        else
        {
            Datum current = this;

            while ( nDays > 0 )
            {
                current = current.nextDay();
            }
            
            return current;
        }
    }
    
    /**
     * Berekent het aantal dagen tussen de huidige en de gegeven.
     * Tussen vandaag en morgen is er 1 dag.
     * 
     * @param   other
     *              Andere datum.
     *              
     * @return  Aantal dagen
     * 
     * @throws  IllegalArgumentException
     *              Indien other <code>null</code> is of indien other niet verder in de tijd ligt dan this
     */
    public int daysUntil(Datum other)
    {
        if ( other == null || other.isBefore( this ) )
        {
            throw new IllegalArgumentException();
        }
        else
        {
            int count = 0;
            Datum current = this;
            
            while ( !current.isSameDate( other ))
            {
                ++count;
                current = current.nextDay();
            }
            
            return count;
        }
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Datum other = (Datum) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}

	@Override
	public int compareTo(Datum d) {
		if ( d == null) return 1;
		else if (this.isBefore(d)) return -1;
		else if (this.isAfter(d)) return 1;
		return 0;
	}
    
    
}
