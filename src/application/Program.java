package application;

import java.sql.Struct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.excption.DominioExceptions;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Numero do Quarto");
			int numero = sc.nextInt();
			System.out.println("Data do Check-In (dd/MM/yyyy)");
			Date checkIn = SDF.parse(sc.next());
			System.out.println("Data do Check-Out (dd/MM/yyyy)");
			Date checkOut = SDF.parse(sc.next());

			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Digite a data para atualizar a reserva");
			System.out.println("Data do Check-In (dd/MM/yyyy)");
			checkIn = SDF.parse(sc.next());
			System.out.println("Data do Check-Out (dd/MM/yyyy)");
			checkOut = SDF.parse(sc.next());

			reserva.atulizarReserva(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("Data Ínvalida");
		}catch (DominioExceptions e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Erro inesperado! ");
		}

		sc.close();
	}
}