package progama;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Modelo.entidades.Reserva;

public class Principal {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Número do quarto?: ");
		int number = sc.nextInt();

		System.out.println("Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.println("Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data de saída tem que ser depois da data de entrada");
		} else {
			Reserva reserva = new Reserva(number, checkIn, checkOut);
			System.out.println(reserva);

			System.out.println();
			System.out.println("Insira uma data para alterar a reserva:");

			System.out.println("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());

			System.out.println("Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			reserva.alterarData(checkIn, checkOut);

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: As datas a serem atualização devem ser futuras");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: A data de saída tem que ser depois da data de entrada");
			} else {
				reserva.alterarData(checkIn, checkOut);
				System.out.println(reserva);
			}
		}
		sc.close();
	}

}
