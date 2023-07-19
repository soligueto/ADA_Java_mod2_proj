package tech.ada.dao;

public class RegistroDao {


	private Long id;
	private Integer ano;
	private String codMunicipio;
	private String uf;
	private String sigla;
	private String municipio;
	private String dep;
	private String local;
	private String codFuncionamento;

	public RegistroDao() {
		super();
	}

	public RegistroDao(long id, int ano, String codMunicipio, String uf, String sigla, String municipio,
			String dep, String local, String codFuncionamento) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public String toString() {
        return "Registro [id = " + id 
        		+ "| Ano = " + ano 
        		+ "| CodMunicípio = " + codMunicipio 
        		+ "| UF = " + uf 
        		+ "| Sigla = " + sigla
        		+ "| Município = " + municipio
        		+ "| Dep = " + dep
        		+ "| Local = " + local
        		+ "| Status = " + codFuncionamento
        		+"]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(String codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getCodFuncionamento() {
		return codFuncionamento;
	}

	public void setCodFuncionamento(String codFuncionamento) {
		this.codFuncionamento = codFuncionamento;
	}
}
