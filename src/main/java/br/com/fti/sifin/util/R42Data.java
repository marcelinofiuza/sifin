package br.com.fti.sifin.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/****************************************************************************
 * Metodos para trabalhos com datas
 * 
 * @author Bob-Odin - 20/03/2017
 ****************************************************************************/
public class R42Data {

	/****************************************************************************
	 * Verdadeiro se a {@link Date} inicial for maior que a {@link Date} final
	 * 
	 * @return 20/03/2017 - 01/03/2017 => false ou 01/03/2017 - 20/03/2017 =>
	 *         true
	 ****************************************************************************/
	public static boolean inicialMaiorFinal(Date inicio, Date fim) {

		if (inicio.after(fim)) {
			return true;
		} else {
			return false;
		}

	}

	/****************************************************************************
	 * Verdadeiro se o periodo 1 estiver em conflito com periodo 2
	 ****************************************************************************/
	public static boolean conflitoPeriodos(Date inicio1, Date fim1, Date inicio2, Date fim2) {

		// verifica se inicio2 está entre periodo1
		if (inicio2.after(inicio1) && inicio2.before(fim1)) {
			return true;
		}

		// verifica se fim2 está entre periodo1
		if (fim2.after(inicio1) && fim2.before(fim1)) {
			return true;
		}

		// verifica se inicio1 está entre periodo2
		if (inicio1.after(inicio2) && inicio1.before(fim2)) {
			return true;
		}

		// verifica se fim1 está entre periodo2
		if (fim1.after(inicio2) && fim1.before(fim2)) {
			return true;
		}

		// verifica se existe datas iguais entre os dois periodos
		if (inicio1.compareTo(inicio2) == 0 || inicio1.compareTo(fim2) == 0 || fim1.compareTo(inicio2) == 0
				|| fim1.compareTo(fim2) == 0) {
			return true;
		}

		return false;
	}

	/****************************************************************************
	 * Adiciona dias a uma Data retorna nova data Ex. 20/03/2017 + 01 =>
	 * 21/03/2017 20/03/2017 + 15 => 04/04/2017
	 ****************************************************************************/
	public static Date adicionaDias(final Date data, final int dias) {

		// Através do Calendar, trabalhamos a data informada e adicionamos 1 dia
		// nela
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.DATE, +dias);

		// Obtemos a data alterada
		return c.getTime();
	}

	/****************************************************************************
	 * Transforma Data em String (dd/MM/yyyy)
	 ****************************************************************************/
	public static String dateToString(Date data) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data.getTime());

	}

	/****************************************************************************
	 * Transforma String em Data
	 ****************************************************************************/
	public static Date stringToDate(String data) throws Exception {

		SimpleDateFormat sdf;
		String novaData = R42Util.removePontos(data);

		if (novaData.length() == 6) {
			sdf = new SimpleDateFormat("ddMMyy");
		} else if (novaData.length() == 8) {
			sdf = new SimpleDateFormat("ddMMyyyy");
		} else {
			throw new Exception("A String não é uma data inválida");
		}

		try {
			return sdf.parse(novaData);			
		} catch (Exception e) {
			throw new Exception("A String não é uma data inválida");
		}

	}


	/****************************************************************************
	 * Retorna a data atual
	 ****************************************************************************/
	public static Date dataAtual() {
		Calendar hoje = Calendar.getInstance();
		return hoje.getTime();
	}

	/****************************************************************************
	 * Retorna o primeiro dia do mes
	 ****************************************************************************/
	public static Date inicioMes(Date data) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		int primeiro = gc.getActualMinimum(GregorianCalendar.DAY_OF_MONTH);
		gc.set(GregorianCalendar.DATE, primeiro);
		return gc.getTime();
	}

	/****************************************************************************
	 * Retorna o ultimo dia do mes
	 ****************************************************************************/
	public static Date fimMes(Date data) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		int ultimo = gc.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		gc.set(GregorianCalendar.DATE, ultimo);
		return gc.getTime();
	}

	/****************************************************************************
	 * Retorna uma data, com base um dia e uma data Base
	 ****************************************************************************/
	public static Date montaData(Date dataBase, Integer dia) {

		if (dia == 0) {
			return dataBase;
		}

		Date novaData = null;
		String strData = dateToString(dataBase);
		String base = strData.substring(2);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			novaData = sdf.parse(dia.toString() + base);
			strData = dateToString(novaData);
			String basenova = strData.substring(2);
			if (!base.equalsIgnoreCase(basenova)) {
				novaData = fimMes(dataBase);
			}
		} catch (Exception e) {
			novaData = fimMes(dataBase);
		}

		return novaData;
	}

}
