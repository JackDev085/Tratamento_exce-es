package Modelo.entidades;

import java.text.SimpleDateFormat;
import java.time.Duration;
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

	public String alterarData(Date checkIn, Date checkOut) {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "As datas a serem atualizadas devem ser futuras";
		}
		if (!checkOut.after(checkIn)) {
			return "A data de saída tem que ser depois da data de entrada";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Quarto " + NumeroQuarto +""
				+ ", Check-In= " + sdf.format(checkIn) + ", check-Out= "
				+ sdf.format(checkOut)+"" + duracao() + " Noites ";
	}

}
