package ifam.edu.dra.chatcompromisso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifam.edu.dra.chatcompromisso.model.Compromisso;
import ifam.edu.dra.chatcompromisso.repository.CompromissoRepository;

@Service
public class CompromissoService {

	@Autowired
	CompromissoRepository compromissoRepository;

	public Compromisso criarCompromisso() {
		return null;
	}

	public List<Compromisso> listaCompromissos() {
		return compromissoRepository.findAll();
	}

	public Compromisso listaCompromissosPorId() {
		return null;
	}

	public Compromisso editarCompromisso() {
		return null;
	}

	public void excluirCompromisso(Long id) {
		Optional<Compromisso> optionalCompromisso = compromissoRepository.findById(id);
		if(optionalCompromisso.isPresent())
			compromissoRepository.deleteById(id);
	}

	public Compromisso aceitarCompromisso() {
		return null;
	}

	public Compromisso negarCompromisso() {
		return null;
	}

	public Compromisso cancelarCompromisso() {
		return null;
	}
}
