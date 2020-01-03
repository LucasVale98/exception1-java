package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Numero do Quarto");
		int numero = sc.nextInt();
		System.out.println("Data do Check-In (dd/MM/yyyy)");
		Date checkIn = SDF.parse(sc.next());
		System.out.println("Data do Check-Out (dd/MM/yyyy)");
		Date checkOut = SDF.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data do checkOut é maior que a data de checkIn.");
		}else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Digite a data para atualizar a reserva");
			System.out.println("Data do Check-In (dd/MM/yyyy)");
			checkIn = SDF.parse(sc.next());
			System.out.println("Data do Check-Out (dd/MM/yyyy)");
			checkOut = SDF.parse(sc.next());
			
			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: A atulização na reseva so pode ser de datas futuras");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Data do checkOut é maior que a data de checkIn.");
			}else {
				reserva.atulizarReserva(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
			
		}
		
		sc.close();
	}
}
