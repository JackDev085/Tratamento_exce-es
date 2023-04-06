package Modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer NumeroQuarto;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		super();
		NumeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return NumeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		NumeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	public void alterarData(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut; 
	}

	@Override
	public String toString() {
		return "Quarto "+ NumeroQuarto +""
				+ ", checkIn= " + sdf.format(checkIn) + ", checkOut= " + sdf.format(checkOut);
	}
	
	
}
