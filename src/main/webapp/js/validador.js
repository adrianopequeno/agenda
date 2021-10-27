/**
 * validação de formulario
	@author Adriano Pequeno
 */

	function validarCampos() {
		let nome = frmContato.nome.value;
		let fone = frmContato.fone.value;
		
		if(nome === "") {
			alert("Preecha  o campo nome");
			frmContato.nome.focus();
			return false;
		} else if (fone === "") {
			alert("Preecha  o campo Telefone");
			frmContato.nome.focus();
			return false;
		} else {
			document.forms["frmContato"].submit();
		}
	}