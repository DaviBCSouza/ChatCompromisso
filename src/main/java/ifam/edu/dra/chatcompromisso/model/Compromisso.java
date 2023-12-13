package ifam.edu.dra.chatcompromisso.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
public class Compromisso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Contato criador;

	@Column(nullable = false)
	private String titulo;

	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime data;

	@Column(nullable = false)
	private String local;

	@Column(nullable = false)
	private String descricao;

	@ManyToMany
	private List<Contato> participantes;

	@Enumerated(EnumType.STRING)
	private Status status;

	public Compromisso() {
	}

	public Compromisso(Long id, Contato criador, String titulo, LocalDateTime data, String local, String descricao,
			List<Contato> participantes, Status status) {
		this.id = id;
		this.criador = criador;
		this.titulo = titulo;
		this.data = data;
		this.local = local;
		this.descricao = descricao;
		this.participantes = participantes;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contato getCriador() {
		return criador;
	}

	public void setCriador(Contato criador) {
		this.criador = criador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Contato> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Contato> participantes) {
		this.participantes = participantes;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {
		ACEITO, NEGADO, CANCELADO, SOLICITADO, REAGENDADO
	}

	@Override
	public String toString() {
		return "Compromisso [id=" + id + ", criador=" + criador + ", titulo=" + titulo + ", data=" + data + ", local="
				+ local + ", descricao=" + descricao + ", participantes=" + participantes + ", status=" + status + "]";
	}
}
