package com.sergiozella.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sergiozella.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimanto;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;

	public PagamentoComBoleto() {
		super();
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimanto,
			Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimanto = dataVencimanto;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimanto() {
		return dataVencimanto;
	}

	public void setDataVencimanto(Date dataVencimanto) {
		this.dataVencimanto = dataVencimanto;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
