package br.com.informaticaf1.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.informaticaf1.models.FotoProduto;
import br.com.informaticaf1.repository.FotosProdutos;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class FotoProdutoService {

	@Autowired
	private FotosProdutos fotosProdutos;

	@Transactional(readOnly=false)
	public void saveOrUpdate(FotoProduto file) {

		this.fotosProdutos.save(file);
	}

	//metodo para ter acesso ao objeto fotoProduto apartir de um insert, 
	//vai como multipart file e transforma em um objeto
	public FotoProduto getFotoProdutoByUpload(MultipartFile file) {

		FotoProduto fotoProduto = new FotoProduto();

		if (file != null && file.getSize() > 0) {
			try {
				fotoProduto.setTitulo(file.getOriginalFilename());
				fotoProduto.setTipo(file.getContentType());
				fotoProduto.setFotoProduto(file.getBytes());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fotoProduto;
	}

	//busca por id
	public FotoProduto findById(Short id) {
		
		return fotosProdutos.findOne(id);
	}

}
