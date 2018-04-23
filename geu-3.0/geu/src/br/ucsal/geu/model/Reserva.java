package br.ucsal.geu.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
	private Integer id;
	private Espaco espaco;
	private String titulo;
	private String descricao;
	private String justificativa;
	private String solicitante;
	private String telefone;
	private LocalDate data;
	private LocalTime inicioHorario;
	private LocalTime fimHorario;

	public Espaco getEspaco() {
		return espaco;
	}

	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getInicioHorario() {
		return inicioHorario;
	}

	public void setInicioHorario(LocalTime inicioHorario) {
		this.inicioHorario = inicioHorario;
	}

	public LocalTime getFimHorario() {
		return fimHorario;
	}

	public void setFimHorario(LocalTime fimHorario) {
		this.fimHorario = fimHorario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
