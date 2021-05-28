package br.com.controlefrota.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.Empresa;
import br.com.controlefrota.repository.EmpresaRepository;
import br.com.controlefrota.service.CadastroDeEmpresa;

@Service
public class EmpresaServiceEJB implements CadastroDeEmpresa {
	@Autowired
	EmpresaRepository empresaRepository;

	@Override
	public Empresa cadastrarEmpresa(Empresa empresa) {

		if (empresa.getCNPJ() == null || empresa.getNome() == null) {
			throw new NullPointerException("Preencha todos os campos");
		}
		Empresa e = empresaRepository.findByCNPJ(empresa.getCNPJ());
		if (e != null && e.isDeleted() == false) {
			throw new ServiceException("Empresa já cadastrada");
		}
		if (e != null && e.isDeleted() == true) {
			empresa.setId(e.getId());
			empresa.setDeleted(false);
			empresa.setDataDeCriacao(LocalDate.now());
			return empresaRepository.save(empresa);
		} else {
			if (empresa.getCNPJ().equals("00000000000000") || empresa.getCNPJ().equals("11111111111111")
					|| empresa.getCNPJ().equals("22222222222222") || empresa.getCNPJ().equals("33333333333333")
					|| empresa.getCNPJ().equals("44444444444444") || empresa.getCNPJ().equals("55555555555555")
					|| empresa.getCNPJ().equals("66666666666666") || empresa.getCNPJ().equals("77777777777777")
					|| empresa.getCNPJ().equals("88888888888888") || empresa.getCNPJ().equals("99999999999999")
					|| empresa.getCNPJ().length() != 14) {

				throw new ServiceException("CNPJ inválido");
			}
			empresa.setDataDeCriacao(LocalDate.now());
			empresa.setDeleted(false);
			return empresaRepository.save(empresa);
		}
	}

	@Override
	public List<Empresa> findAll() {
		return empresaRepository.findByDeleted(false);
	}

	@Override
	public Empresa findById(long id) {
		Empresa empresa = empresaRepository.findById(id);

		if (empresa == null) {
			throw new ServiceException("Empresa não encontrada.");
		}

		return empresa;
	}

	@Override
	public void delete(long id) {
		Empresa e = empresaRepository.findById(id);

		if (e == null) {
			throw new NullPointerException("Empresa não encontrada!");
		} else {
			e.setDeleted(true);
			empresaRepository.save(e);
		}

	}

	@Override
	public Empresa findByCNPJ(String cnpj) {
		Empresa empresa = empresaRepository.findByCNPJ(cnpj);

		if (empresa == null) {
			throw new ServiceException("Empresa não encontrada.");
		}

		return empresa;
	}

}