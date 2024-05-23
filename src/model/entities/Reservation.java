package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // static por que só vai ser usado uma vez

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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

	public String updateDates(Date checkIn, Date checkOut) {		
		Date now = new Date(); // cria data de agora
		if (checkIn.before(now) || checkOut.before(now)) {// se a data de check-in e check-out for antes de agora
															// programa não aceita
			return "Error in reservation: Reservation dates for update must be future dates";
			
		} if (!checkOut.after(checkIn)) {
			
			return "Error in reservation: Reservation dates for update must be future dates";
		}			
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	    return null; // se retornar nulo por que nao deu nenhum erro
	}
	@Override
	public String toString() {
		return "Room "
	           + roomNumber 
	           + ", check-in: " 
	           + sdf.format(checkIn) 
	           + ", checkout: " 
	           + sdf.format(checkOut)
	           + ", "
			   + duration() + " nights";
	}
}
