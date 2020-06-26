$(document).ready(function() {
	$("#linkPromocao").change(function() {
		var url = $(this).val();

		if (url.length > 7) {
			$.ajax({
				url : "/meta/info",
				method : "POST",
				cache : false,
				data : {url : url},
				beforeSend: function(){
					limparDados();
					$("#loader-img").addClass("loader");
				},
				success : function(data) {
					preencherFormulario(data)
				},
				statusCode:{
					404: function(){
						$("#alert").addClass("alert alert-danger");
						$("#alert").text("Não foi possivel carregar as informações ");
						$("#linkImagem").attr("src","/images/promo-dark.png");
					}
				},
				error : function() {
					$("#alert").addClass("alert alert-danger");
					$("#alert").text(" Ops, ocorreu um erro inesperado !");
					$("#linkImagem").attr("src","/images/promo-dark.png");
				},
				complete:function(){
					$("#loader-img").removeClass("loader");
				}
			});
		}

	});
	
	
	/*
	 * Submite do Formulario
	 */
	$("#form-add-promo").submit(function(ev){
		ev.preventDefault();
		
		var promocao = {};
		
		promocao.titulo = $("#titulo").val();
		
		promocao.site = $("#site").text();
		
		promocao.imagem = $("#linkImagem").attr("src");

		promocao.descricao = $("#descricao").val();

		promocao.precoPromocao = $("#preco").val();

		promocao.categoria = $("#categoria").val();

		promocao.linkPromocao = $("#linkPromocao").val();
        
		$.ajax({
			method:"POST",
			data:promocao,
			url:"/promocao/salvar",
			success:function(){
				$("#alert").addClass("alert alert-success");
				$("#alert").text("Promoção salva com sucesso ! ");
				resetFormulario();
			},
			error:function(xhr){
				console.log(xhr.responseText);
				$("#alert").addClass("alert alert-danger");
				$("#alert").text("Erro ao salvar promoção ! ");
			}			
		});
		
		console.log(promocao);
		
	});
	
	
	
	
	
	/*
	 * Funções Utilitarias 
	 */
	function preencherFormulario(data) {
		$("#titulo").val(data.titulo);
		$("#site").text(data.site);
		$("#linkImagem").attr("src", data.imagem);
	}
	
	function limparDados(){
		$("#alert").removeClass("alert alert-danger alert-success ");
		$("#alert").text("");
		$("#titulo").val("");
		$("#site").val("");	
		$("#linkImagem").attr("src","");
	}
	
	function resetFormulario(){
		$("#form-add-promo").each(function(){
			this.reset();
		});
		$("#site").text("");
		$("#linkImagem").attr("src","/images/promo-dark.png");
	}


});