package entidades;

import java.util.Date;

public class HoraDeContrato {
    private Date date;
    private double valorPorHora;
    private Integer horasTrab;

    public HoraDeContrato() {
    }

    public HoraDeContrato(Date date, double valorPorHora, Integer horasTrab) {
        this.date = date;
        this.valorPorHora = valorPorHora;
        this.horasTrab = horasTrab;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Integer getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(Integer horasTrab) {
        this.horasTrab = horasTrab;
    }
    public double valorTotal(){
        return valorPorHora * horasTrab;
    }
}
