package tech.ada.read;

import java.util.List;

import tech.ada.dto.RegistroDTO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read {

	private static String CAMINHO_ARQUIVO = "src/main/resources/censo_adapt.csv";

	public List<RegistroDTO> reader() throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO));
		ArrayList<RegistroDTO> listaRegistros = new ArrayList<>();
				
            try {
				br.readLine();
	            String linha;
	            while ((linha = br.readLine()) != null) {
	            	String[] dados = linha.split(";");
	            	Long id = Long.parseLong(dados[0].trim());
	            	int ano = Integer.parseInt(dados[1].trim());
	            	String codMunicipio = dados[2].trim();
	            	String uf = dados[3].trim();
	            	String sigla = dados[4].trim();
	            	String municipio = dados[5].trim();
	            	String dep = dados[6].trim();
	            	String local = dados[7].trim();
	            	String codFuncionamento = dados[8].trim();
	            		            	
	            	RegistroDTO registro = new RegistroDTO();
	            	registro.setId(id);
	            	registro.setAno(ano);
	            	registro.setCodMunicipio(codMunicipio);
	            	registro.setUf(uf);
	            	registro.setSigla(sigla);
	            	registro.setMunicipio(municipio);
	            	registro.setDep(dep);
	            	registro.setLocal(local);
	            	registro.setCodFuncionamento(codFuncionamento);
	            	
	            	listaRegistros.add(registro);
	            	
	            }    
			} catch (IOException e) {
				e.printStackTrace();
			} 

            
            return listaRegistros;
	}
	
}
