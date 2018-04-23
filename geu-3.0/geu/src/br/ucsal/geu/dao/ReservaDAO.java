package br.ucsal.geu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.geu.model.Espaco;
import br.ucsal.geu.model.Reserva;
import br.ucsal.util.Conexao;

public class ReservaDAO {

	private Conexao conexao;

	public ReservaDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Reserva> listar() {
		Statement stmt;
		List<Reserva> reservas = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from reservas, espacos where reservas.espaco_id = espaco_id");
			while (rs.next()) {
				Reserva e = new Reserva();
				e.setId(rs.getInt("id"));
				Espaco espaco = new Espaco();
				espaco.setId(rs.getInt("espaco_id"));
				espaco.setIdentificacao(rs.getString("identificacao"));
				espaco.setAndar(rs.getString("andar"));
				e.setEspaco(espaco);
				e.setTitulo(rs.getString("titulo"));
				e.setDescricao(rs.getString("descricao"));
				e.setJustificativa(rs.getString("justificativa"));
				e.setSolicitante(rs.getString("solicitante"));
				e.setTelefone(rs.getString("telefone"));
				e.setData(rs.getDate("data").toLocalDate());
				e.setInicioHorario(rs.getTime("hora_inicio").toLocalTime());
				e.setFimHorario(rs.getTime("hora_fim").toLocalTime());
				reservas.add(e);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reservas;
	}

	public void inserir(Reserva reserva) {
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"insert into reservas (espaco_id, titulo, descricao, justificativa, solicitante, telefone, data, hora_inicio, hora_fim) values (?,?,?,?,?,?,?,?,?);");
			ps.setInt(1, reserva.getEspaco().getId());
			ps.setString(2, reserva.getTitulo());
			ps.setString(3, reserva.getDescricao());
			ps.setString(4, reserva.getJustificativa());
			ps.setString(5, reserva.getSolicitante());
			ps.setString(6, reserva.getTelefone());
			ps.setDate(7, java.sql.Date.valueOf(reserva.getData()));
			ps.setTime(8, java.sql.Time.valueOf(reserva.getInicioHorario()));
			ps.setTime(9, java.sql.Time.valueOf(reserva.getFimHorario()));
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
