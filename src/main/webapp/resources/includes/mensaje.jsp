<c:if test="${mensaje != null}">
	<div class="alert alert-${mensaje.tipo} alert-dismissible fade show" role="alert">
	 ${mensaje.texto}
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>	