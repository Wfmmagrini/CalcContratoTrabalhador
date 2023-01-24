
import entidades.HoraDeContrato;
import entidades.Trabalho;
import entidades.Departamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        System.out.print("Entre com o nome do departamento: ");
        String NomeDoDepartamento = sc.nextLine();
        System.out.println("Entre com nome do trabalhador: ");

        System.out.print("Nome: ");
        String nomeDoTrabalhador = sc.nextLine();
        System.out.print("Nivel : ");
        String NivelDoTrabalhador = sc.nextLine();
        System.out.println("Salario Base: ");
        double salarioBase = sc.nextDouble();

        Trabalho trabalhador = new Trabalho(nomeDoTrabalhador, NivelDoTrabalhador.valueOf(NivelDoTrabalhador),
                salarioBase, new Departamento(NomeDoDepartamento));

        System.out.print("Quantos contratos o trabalhador tera? ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++){
            System.out.println("Entre com o contrato #"+i+ " data: ");
            System.out.print("Data (DD/MM/YYYY): ");
            Date dataDoContrato = sdf.parse(sc.next());
            System.out.print("Valor por Hora: ");
            double valorPorHora = sc.nextDouble();
            System.out.print("Duraçao do contrato(HORAS): ");
            int horas= sc.nextInt();
            HoraDeContrato contrato = new HoraDeContrato(dataDoContrato, valorPorHora, horas);

            trabalhador.AdicionarContrato(contrato);
        }
        System.out.println();
        System.out.print("Entre com Mes e Ano para Calcular Salario: (MM/YYYY): ");
        String mesEano = sc.next();
        int mes = Integer.parseInt(mesEano.substring(0, 2));
        int ano = Integer.parseInt(mesEano.substring(3));
        System.out.println("Nome: " + trabalhador.getName());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
        System.out.println("Quanto trabalhador ganhou: "+ mesEano + ": "+ String.format("%.2f ", trabalhador.RendaTrabalhador(ano, mes)));

        sc.close();
    }
}