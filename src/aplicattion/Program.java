package aplicattion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program { // PROGRAMA É RUIM POIS A VALIDAÇÃO DA RESERVA TEM QUE SER FEITO NA CLASSE
						// RESERVA E NÃO EM OUTRA

	public static void main(String[] args) throws ParseException { // quando esta o tratamento de exceção o compilador
																	// reclama pois sdf.parse é uma exceção por isso a
																	// necessidadde de tratar a exceção

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in Date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());// sdf.parse transforma o String no formato de date sdf.parse
		System.out.print("Check-out Date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) { // checkOut.after testa se uma data vem depois da outra. simbolo ! = não, entao
										// se não check-out for depois do checkin ok.
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation" + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); // sdf.parse transforma o String no formato de date sdf.parse
			System.out.print("Check-out Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut); // esse método é responsavel por atualizar as
																		// datas
			if (error != null) {
				System.out.println("Error in reservation " + error); // se der diferente de nulo por que deu algum erro
			} 
			else {
				System.out.println("Reservation" + reservation);
			}
		}
		sc.close();
	}
}
