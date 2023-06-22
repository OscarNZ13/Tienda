//CREATE AND UPDATE

//"documento" referenciamos el DOM de la pagina
$(document).on("click", ".open-modal", function () {
    const currentProductId = Number($(this).attr('idproduct'));

    if (currentProductId) {
        const currentProduct = products.find(x => x.id === currentProductId);
        $("#id").val(currentProduct.id);
        $("#id_categoria").val(currentProduct.id_categoria);
        $("#descripcion").val(currentProduct.descripcion);
        $("#detalle").val(currentProduct.detalle);
        $("#precio").val(currentProduct.precio);
        $("#existencias").val(currentProduct.existencias);
        $("#ruta_imagen").val(currentProduct.ruta_imagen);
    }
});

$(document).on("click", "#saveProduct", function () {
    $("#formProduct").submit();
})

//Delete
$(document).on("click", ".btnDeleteProduct", function () {
    const currentProductId = Number($(this).attr('idproduct'));
    const currentProduct = products.find(x => x.id === currentProductId);
    $.ajax({
        url: 'product/delete',
        contentType: "application/json",
        dataType: 'json',
        type: 'POST',
        success: function (result) { //Quitar y mejoraf eel location reload
            location.reload();
        },
        //here we are serialization the object
        data: JSON.stringify(currentProduct)
    });
})