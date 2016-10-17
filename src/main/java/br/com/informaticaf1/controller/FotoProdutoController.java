package br.com.informaticaf1.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.informaticaf1.models.FotoProduto;
import br.com.informaticaf1.service.FotoProdutoService;

@Controller("fotoProduto")
public class FotoProdutoController {

	@Autowired
	private FotoProdutoService fotoService;

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> loadFotoProduto(@PathVariable("id") Short id) {
		
		FotoProduto foto = fotoService.findById(id);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf(foto.getTipo()));
		
		InputStream is = new ByteArrayInputStream(foto.getFotoProduto());
		try {
			return new ResponseEntity<byte[]>(IOUtils.toByteArray(is), headers, HttpStatus.OK);
		} catch (IOException e) {
			
			e.getStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				
				e.getStackTrace();
			}
		}
		return null;
	}
}
