package com.vitorlipe.demoajax.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
@Entity(name = Promocao.NAME)
@Table(name = "promocao",schema = "demoajax")
public class Promocao implements Serializable {
	

	private static final long serialVersionUID = 1L;

	public static final String NAME = "demoajax_promocao";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	@Column(name = "titulo",nullable = false)
	private String titulo;
	
	@Column(name = "site",nullable = false)
	private String site;
	
	@Column(name = "link_imagem",nullable = false)
	private String imagem;
	
	@Column(name = "link_promocao",nullable = false)
	private String linkPromocao;
	
	@NumberFormat(style = Style.CURRENCY,pattern = "#,##0.00")
	@Column(name = "preco",nullable = false)
	private BigDecimal precoPromocao;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "total_likes")
	private Integer likes;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro",nullable = false)
	private Date dataCadastro;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	
	
	

	@Override
	public String toString() {
		return "Promocao [id=" + id + ", titulo=" + titulo + ", site=" + site + ", imagem=" + imagem + ", linkPromocao="
				+ linkPromocao + ", precoPromocao=" + precoPromocao + ", descricao=" + descricao + ", likes=" + likes
				+ ", dataCadastro=" + dataCadastro + ", categoria=" + categoria + "]";
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getLinkPromocao() {
		return linkPromocao;
	}

	public void setLinkPromocao(String linkPromocao) {
		this.linkPromocao = linkPromocao;
	}

	public BigDecimal getPrecoPromocao() {
		return precoPromocao;
	}

	public void setPrecoPromocao(BigDecimal precoPromocao) {
		this.precoPromocao = precoPromocao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	 
	
	
	

}
