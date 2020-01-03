package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reserva(Integer numeroQuarto, Date chechIn, Date checkOut) {
		super();
		this.numeroQuarto = numeroQuarto;
		this.checkIn = chechIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getChechIn() {
		return checkIn;
	}

	public void setChechIn(Date chechIn) {
		this.checkIn = chechIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MICROSECONDS);
	}
	
	public void atulizarReserva(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	
	@Override
	public String toString() {
		return "Quarto: " + 
				numeroQuarto +
				", chech-In " +
				SDF.format(checkIn) +
				", chech-Out " +
				SDF.format(checkIn) +
				", " +
				duracao() +
				" noites.";
	}
}
