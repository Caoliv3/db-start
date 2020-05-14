package bv.com.boavista;

import lombok.Data;

@Data
public class ModelCliente {

	private String id;
	private String nome;
	private String cpf ="";
	private String logradouro = "";
	private String numLogradouro ="";
	private String cidade ="";
	private String estado= "";
	private String status = "";
	
	public ModelCliente(String l) {
		
		String[] linha = l.split(";");
		
		id = linha[0];
		nome = linha[1];
		cpf = linha[2];
		logradouro = linha[3];
		numLogradouro = linha[4];
		cidade = linha[5];
		estado = linha[6];
		status = linha[7];
		
	}
}
