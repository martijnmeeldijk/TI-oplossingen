package db;

public class DbException extends RuntimeException {
	
	public DbException(String message){
		super(message);
	}
	public DbException(String message, Throwable oorzaak){
		super(message, oorzaak);
	}
}
