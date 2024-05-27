package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // static por que só vai ser usado uma vez

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) { // Foi colocado a verificação de datas pois no exemplo tem no construtor a verificalção
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates"); 
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public long duration() { // vai retornar o calculo de milissegundos entre datas
		long diff = checkOut.getTime() - checkIn.getTime(); // get.time devolve a quantidade de mlissegundos daquela
															// data
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException { // para lançar uma exceção usar a
																					// palavra throws
		Date now = new Date(); // cria data de agora
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates"); // esse
																													// metodo
																													// JAVA
			// é quando os argumentos que você passa para o método eles são inválidos.
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
		}
		this.checkIn = checkIn; // lógica de atualizar as datas
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", checkout: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}
}
