package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalho {
    private String name;
    private NiveisDoFuncionario nivel;
    private double SalarioBasico;

    private Departamento departamento;
    private List<HoraDeContrato> contratos = new ArrayList<>();

    public Trabalho(String nomeDoTrabalhador, String s, double salarioBase, Departamento departamento) {
    }

    public Trabalho(String name, NiveisDoFuncionario nivel, double salarioBasico, Departamento departamento) {
        this.name = name;
        this.nivel = nivel;
        SalarioBasico = salarioBasico;
        this.departamento = departamento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NiveisDoFuncionario getNivel() {
        return nivel;
    }

    public void setNivel(NiveisDoFuncionario nivel) {
        this.nivel = nivel;
    }

    public double getSalarioBasico() {
        return SalarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        SalarioBasico = salarioBasico;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<HoraDeContrato> getContratos() {
        return contratos;
    }

    public void AdicionarContrato(HoraDeContrato contrato) {
        contratos.add(contrato);
    }

    public void RemoverContra(HoraDeContrato contrato) {
        contratos.remove(contrato);
    }

    public double RendaTrabalhador(int ano, int mes) {
        double soma = SalarioBasico;
        Calendar call = Calendar.getInstance();
        for (HoraDeContrato c : contratos) {
            call.setTime(c.getDate());
            int c_ano = call.get(Calendar.YEAR);

            int c_mes = 1 + call.get(Calendar.MONTH);
            if (ano == c_ano && mes == c_mes) {
                soma += c.valorTotal();
            }
        }
        return soma;

    }
}
