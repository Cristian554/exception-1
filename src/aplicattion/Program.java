package aplicattion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program { // PROGRAMA É RUIM POIS A VALIDAÇÃO DA RESERVA TEM QUE SER FEITO NA CLASSE
						// RESERVA E NÃO EM OUTRA

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in Date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());// sdf.parse transforma o String no formato de date sdf.parse
		System.out.print("Check-out Date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation" + reservation);

		System.out.println();
		System.out.println("Enter data to update the reservation:");
		System.out.print("Check-in Date (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next()); // sdf.parse transforma o String no formato de date sdf.parse
		System.out.print("Check-out Date (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());

		reservation.updateDates(checkIn, checkOut); // esse método é responsavel por atualizar as
		System.out.println("Reservation" + reservation);
		}
	    catch(ParseException e) {
	    	System.out.println("Invalid Date Format");
	    }
		catch(DomainException e){ // foi tratado a exceção
			System.out.println("Error in reservation" + e.getMessage());// mensagem que foi instanciada quando foi criada a exceção no Reservation
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error"); // qualquer outro erro será tratado com a mensagem ao usuário
		}
		sc.close();
	}
}