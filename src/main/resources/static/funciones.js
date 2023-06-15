function eliminar(id) {
	Swal.fire({
		title: 'Está seguro?',
		text: "No es posible revertir esta acción!",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Sí, elimnar!'
	}).then((OK) => {
		if (OK.isConfirmed) {
			$.ajax({
				url: "/eliminar/" + id,
				success: function(res) {
					console.log(res);
				}
			});
			Swal.fire(
				'Eliminar!',
				'La persona selecionada ha sido eliminada.',
				'success'
			).then((ok) => {
				if (ok) {
					location.href = "/listar";
				}
			});
		}
	})
}
