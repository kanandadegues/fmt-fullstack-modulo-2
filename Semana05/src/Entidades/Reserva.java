package Entidades;

import Excecoes.ExcecaoDominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private int numeroQuarto;
    private Date dtEntrada;
    private Date dtSaida;

    public Reserva(Date numeroQuarto, Date dtEntrada, int dtSaida) throws ExcecaoDominio {
        Date hoje = new Date();
        if (dtEntrada.before(hoje) || dtSaida.before(hoje)){
            throw new ExcecaoDominio("Erro: Reservas não podem ser feitas para datas anteriores ao dia de hoje.");
        }
        if (dtSaida.before(dtEntrada)) {
            throw new ExcecaoDominio("Erro: Data de saída não pode ser anterior a data de entrada.");
        }
        this.numeroQuarto = numeroQuarto;
        this.dtEntrada = dtEntrada;
        this.dtSaida = dtSaida;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }
    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
    public Date getDtEntrada() {
        return dtEntrada;
    }
    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }
    public Date getDtSaida() {
        return dtSaida;
    }
    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }

    public static long qtdDiasEstadia(Date dtSaida, Date dtEntrada) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        long diferenca = dtSaida.getTime() - dtEntrada.getTime();

        TimeUnit time = TimeUnit.DAYS;
        long noitesEstadia = time.convert(diferenca, TimeUnit.MILLISECONDS);
        return noitesEstadia;
    }

    @Override
    public String toString() {
        return "Reserva:\n " +
                "Número do quarto: " + numeroQuarto +
                "\n Data de entrada: " + dtEntrada +
                "\n Data de saida=" + dtSaida;
    }

    public void InfosReserva() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Reserva:\n " +
                "Número do quarto: " + numeroQuarto +
                "\n Data de entrada: " + formato.format(dtEntrada) +
                "\n Data de saida: " + formato.format(dtSaida) +
                "\n Período da estadia: " + qtdDiasEstadia(dtSaida,dtEntrada) + " noites."
        );
    }
}
