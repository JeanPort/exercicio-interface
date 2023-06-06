package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Contract;
import models.entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		System.out.println("Numero: ");
		int numero = scanner.nextInt();
		
		System.out.println("Data (DD/MM/YYYY): ");
		LocalDate date = LocalDate.parse(scanner.next(), dateTimeFormatter);
		
		System.out.println("Valor do contrato: ");
		double valorContrato = scanner.nextDouble();
		
		Contract contract = new Contract(numero, date, valorContrato);
		
		System.out.println("Entre com o numero de parcelas: ");
		int numeroParcela = scanner.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, numeroParcela);
		
		System.out.println("Parcelas: ");
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		
		
		
		
		scanner.close();
	}

}
