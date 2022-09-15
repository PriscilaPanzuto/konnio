package net.sobiecki.konnio.model;

public class Busca {
	
	private String select;
	private String buscaTexto;
	
	public Busca(String select, String buscaTexto) {
		this.select = select;
		this.buscaTexto = buscaTexto;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getBuscaTexto() {
		return buscaTexto;
	}

	public void setBuscaTexto(String buscaTexto) {
		this.buscaTexto = buscaTexto;
	}
}
