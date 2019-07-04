//Arquivo onde estão as chamadas ajax para mostrar informações na tela e para deletar registros.
//Funções para deletar estão no final.

//*********Produtos************//
//Função que carrega todos os produtos no Index
function loadAllProducts(x) {
  var data_file = "http://localhost:8080/product";
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

     if (http_request.readyState === 4 && http_request.status == 200) {
        var jsonObj = JSON.parse(http_request.responseText);
        var tam = jsonObj.length;
        var card = '';
        for(var i = 0; i<tam; i++){
          card += '<li>'+
                    '<div class="card" style="width:200px">'+
                      '<img class="card-img-top" src="images/bio.png" alt="Card image" style="width:100%">'+
                      '<div class="card-body">'+
                      '<h4 class="card-title">' + jsonObj[i].name + '</h4>'+
                      '<p class="card-text">R$ '+jsonObj[i].price+'</p>'+
                      '<a href="product_information.html?id='+jsonObj[i].productId+'" class="btn btn-default color">Ver mais</a>'+
                      '</div>'+
                    '</div>'+
                  '</li>';
        }
        document.getElementById("cards").innerHTML = card;
        if(x == 1){
          document.getElementById("section-content").innerHTML = '<h4 style="color: #808080">Todos os produtos:</h4><br>';
        }
     }  
  }
  http_request.open("GET", data_file, true);
  http_request.send();
}

//Pega o id do produto da url e chama as funções para carregar as informações do produto e do fornecedor
function getProductId(){
  var urlId = location.search.substring(1);
  var idProduct = parseFloat(urlId.substring(3, urlId.length));
  loadInformation(idProduct);
  loadInfoProvider(idProduct);
}

//Carrega as informações do produto na pagina de informações do produto
function loadInformation(idProduct) {
  var data_file = "http://localhost:8080/product/"+idProduct;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

     if (http_request.readyState == 4 && http_request.status == 200) {
        var jsonObj = JSON.parse(http_request.responseText);
        document.getElementById("product-name").innerHTML = jsonObj.name+"<br>";
        document.getElementById("product-description").innerHTML = "<p class='bold'>Descrição: <p>"+ jsonObj.description;
        document.getElementById("product-brand").innerHTML = "<p class='bold'> Marca: </p>"+jsonObj.brand;
        document.getElementById("product-type").innerHTML = "<p class='bold'> Categoria: </p>"+jsonObj.productType.productType; 
        document.getElementById("product-price").innerHTML = "<p class='bold'>Preço:</p>R$"+ jsonObj.price;
     }  
  }
  http_request.open("GET", data_file, true);
  http_request.send();
}

//Funções para apenas um tipo de medicamento!
//Carrega só um tipo de medicamento (para a pagina medicamentos.html e material_medico.html)
function loadType(type){
  var data_file = "http://localhost:8080/product/filter/"+type;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

     if (http_request.readyState === 4 && http_request.status == 200) {
        var jsonObj = JSON.parse(http_request.responseText);
        var tam = jsonObj.length;
        var card = '';
        for(var i = 0; i<tam; i++){
          card += '<li>'+
                    '<div class="card" style="width:200px">'+
                      '<img class="card-img-top" src="images/bio.png" alt="Card image" style="width:100%">'+
                      '<div class="card-body">'+
                      '<h4 class="card-title">' + jsonObj[i].name + '</h4>'+
                      '<p class="card-text">R$ '+jsonObj[i].price+'</p>'+
                      '<a href="product_information.html?id='+jsonObj[i].productId+'" class="btn btn-default color">Ver mais</a>'+
                      '</div>'+
                    '</div>'+
                  '</li>';
        }
        document.getElementById("cards").innerHTML = card;
     }  
  }
  http_request.open("GET", data_file, true);
  http_request.send();

}

//Carrega informações do fornecedor na pagina de produto
function loadInfoProvider(idProduct) {
  var data_file = "http://localhost:8080/product/"+idProduct;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

     if (http_request.readyState == 4 && http_request.status == 200) {
        var jsonObj = JSON.parse(http_request.responseText);

        document.getElementById("provider-trade-name").innerHTML = 'Vendido por: <br> '+jsonObj.provider.tradeName;
        document.getElementById("provider-business-name").innerHTML = "<span class='bold size'>Nome empresarial: </span> "+jsonObj.provider.businessName;
        document.getElementById("cnpj").innerHTML = "<span class='bold size'>CNPJ:</span> "+jsonObj.provider.cnpj;
        document.getElementById("ie").innerHTML = "<span class='bold size'>IE:</span> "+jsonObj.provider.ie;
        document.getElementById("contact-name").innerHTML = "<span class='bold size'>Nome para contato:</span> "+jsonObj.provider.contactName;
        document.getElementById("tel-provider").innerHTML = "<span class='bold size'>Telefone:</span> "+jsonObj.provider.telProvider;
        document.getElementById("e-mail").innerHTML = "<span class='bold size'>E-mail:</span> "+jsonObj.provider.email;
        document.getElementById("address-provider").innerHTML = "<span class='bold size'>Enderço:</span> "+jsonObj.provider.providerAddress+" - "+jsonObj.provider.providerCity+"/"+jsonObj.provider.providerState+"<br>";
      }
    }
  http_request.open("GET", data_file, true);
  http_request.send(); 
}
//***********Funções para produtos até aqui*************//

//*******Pedidos de compra**********//
//Pega o id do pedido de compra da url
function getPurchaseOrderId(){
  var urlId = location.search.substring(1);
  var idPurchase = parseFloat(urlId.substring(3, urlId.length));
  loadPurchaseInformation(idPurchase);
}

//Carrega os detalhes de cada pedido
function loadPurchaseInformation(idPurchase){
  var idCustomer = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/order/"+idCustomer+"/"+idPurchase;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {
     if (http_request.readyState == 4 && http_request.status == 200) {
        var jsonObj = JSON.parse(http_request.responseText);
        document.getElementById("id-purchase").innerHTML = "Código do pedido: "+jsonObj.purchaseOrderId+"<br>";
        document.getElementById("status").innerHTML = "<p class='bold'>Status: <p>"+ jsonObj.orderStatus.orderStatus;
        for(var j =0; j<jsonObj.productOrder.length; j++){
          document.getElementById("products").innerHTML += "<p>Produto: "+jsonObj.productOrder[j].product.name+"</p>"+
                                                          "<p>Preço unit.:"+jsonObj.productOrder[j].product.price+"</p>"+
                                                          "<p>Qtd.:"+jsonObj.productOrder[j].quantityProduct+"</p><hr/>";
        }

        document.getElementById("order-date").innerHTML = "<p class='bold'> Data da compra: </p>"+jsonObj.orderDate; 
        document.getElementById("total").innerHTML = "<p class='bold'>Total:</p>R$"+ jsonObj.total;
        if(jsonObj.orderStatus.statusId == 1){
          document.getElementById("finish-order").innerHTML = "<a href='' class='btn btn-default color wrap floatRight' onclick='hasCard("+jsonObj.purchaseOrderId+")' style='margin-left: 20px'>Fazer pagamento</a>"+
                                                              "<a href='' class='btn btn-default color wrap floatRight' onclick='cancelOrder("+jsonObj.purchaseOrderId+")' >Cancelar pedido</a>";
        }
     }  
  }
  http_request.open("GET", data_file, true);
  http_request.send();
}

//Mostra cada pedido do cliente.
function loadPurchaseOrder(){
  var idCustomer = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/order/"+idCustomer;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

    if (http_request.readyState == 4 && http_request.status == 200 || http_request.status == 204) {
      if(http_request.status == 204){
        document.getElementById("purchase-order").innerHTML = "<p>Você ainda não tem nenhum pedido de compra.</p>";
      }else{
        var json = JSON.parse(http_request.responseText);
        var jsonObj = json.reverse();
        for(var i = 0; i<jsonObj.length; i++){
          document.getElementById("order-list").innerHTML +=  "<li class='infos'><div><p class='size'><span class='bold size'>Número do pedido: </span> "+jsonObj[i].purchaseOrderId+"</p>"+
            "<p class='size'><span class='bold size'>Status: </span> "+jsonObj[i].orderStatus.orderStatus+"</p>"+
            "<p class='size'><span class='bold size'>Valor: </span> "+jsonObj[i].total+"</p>"+
            "<p class='size'><span class='bold size'>Data da compra: </span> "+jsonObj[i].orderDate+"</p>"+
            "<a class='floatRight' href='purchase-information.html?id="+jsonObj[i].purchaseOrderId+"' style='color:black; font-weight: bold'>Detalhes</a>"+
            "</div></li>";
        }
      }                 
    }
  }
  http_request.open("GET", data_file, true);
  http_request.send(); 
}
//*****Funções para pedido de compra até aqui******//

//******Perfil-comprador*********//
//Carrega informações do comprador em sua tela do perfil
function loadInformationCustomer() {
  idCustomer = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/customer/"+idCustomer;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

     if (http_request.readyState == 4 && http_request.status == 200) {
        var jsonObj = JSON.parse(http_request.responseText);
        document.getElementById("customer-name").innerHTML = jsonObj.name+"<br>";
        document.getElementById("customer-cpf").innerHTML = "<br><p class='bold'>CPF:</p> "+jsonObj.cpfCustomer+"<br>";
        document.getElementById("birth").innerHTML = "<p class='bold'>Data de Nascimento:</p> "+jsonObj.dateBirthCustomer+"<br>";
        document.getElementById("customer-tel").innerHTML = "<p class='bold'>Telefone:</p> "+jsonObj.telCustomer+"<br>";
        document.getElementById("customer-cel").innerHTML = "<p class='bold'>Celular:</p> "+jsonObj.celCustomer+"<br>";
        document.getElementById("customer-email").innerHTML = "<p class='bold'>E-mail:</p> "+jsonObj.email+"<br>";
        
        //Carregar endereços do comprador
        if(jsonObj.customerAddress.length == 0){
          document.getElementById("customer-address").innerHTML = 
            '<fieldset id="address-customer">'+
              '<legend class="bold">Endereços de entrega:</legend>'+
              '<p><img src="images/caution.jpg" width="25" height="27"/> Nenhum  endereço cadastrado</p>'
            '</fieldset><br>';
          document.getElementById("warnings").innerHTML += '<a><img src="images/caution.jpg" width="25" height="27"/> Atenção, você não possui nenhum endereço de entrega cadastrado, cadastre para que os fornecedores possam entregar os produtos comprados.</a>';
        }else{
            var address = '<p class="bold">Endereços de entrega:</p><ul><hr>';
            //Enederço do comprador e também formulário para atualizar o mesmo
            for(var i = 0; i<jsonObj.customerAddress.length; i++){
              address+='<li>'+jsonObj.customerAddress[i].customerAddress+'</li> -  '+
                       '<li>'+jsonObj.customerAddress[i].cepCustomer+'</li> - '+
                       '<li>'+jsonObj.customerAddress[i].customerCity+'</li>/'+
                       '<li>'+jsonObj.customerAddress[i].customerState+'</li> - '+
                       '<li>'+jsonObj.customerAddress[i].complementAddressCustomer+'</li>'+
                       '<a class="floatRight" href="profile.html" style="color: black" onclick="deleteAddress('+jsonObj.customerAddress[i].deliveryAddressId+')"><img src="images/delete.png"/></a>'+
                       '<a class="floatRight" data-toggle="collapse" data-target="#address-update'+i+'" style="padding-right: 20px"><img src="images/edit.png"/></a><br/><br>'+
                        '<div id="address-update'+i+'" class="collapse">'+
                         '<form action="#">'+
                            '<ul>'+
                              '<li id="delivery-address" style="width: 30%; padding-right: 10px">'+
                                '<div class="form-group">'+
                                  '<label for="address'+jsonObj.customerAddress[i].deliveryAddressId+'">Endereço: *</label>'+
                                  '<input type="text" class="form-control" id="address'+jsonObj.customerAddress[i].deliveryAddressId+'" placeholder="Endereço completo incluindo número e bairro" name="address" required/>'+
                                '</div>'+
                              '</li>'+
                              '<li id="state" style="width: 30%; padding-right: 10px">'+
                                '<div class="form-group">'+
                                  '<label for="state-customer'+jsonObj.customerAddress[i].deliveryAddressId+'">Estado: *</label>'+
                                    '<select class="form-control"  id="state-customer'+jsonObj.customerAddress[i].deliveryAddressId+'" name="state" required>'+
                                      '<option value=""> </option>'+
                                      '<option value="AC">Acre</option>'+
                                      '<option value="AL">Alagoas</option>'+
                                      '<option value="AP">Amapá</option>'+
                                      '<option value="AM">Amazonas</option>'+
                                      '<option value="BA">Bahia</option>'+
                                      '<option value="CE">Ceará</option>'+
                                      '<option value="DF">Distrito Federal</option>'+
                                      '<option value="ES">Espírito Santo</option>'+
                                      '<option value="GO">Goiás</option>'+
                                      '<option value="MA">Maranhão</option>'+
                                      '<option value="MT">Mato Grosso</option>'+
                                      '<option value="MS">Mato Grosso do Sul</option>'+
                                      '<option value="MG">Minas Gerais</option>'+
                                      '<option value="PA">Pará</option>'+
                                      '<option value="PB">Paraíba</option>'+
                                      '<option value="PR">Paraná</option>'+
                                      '<option value="PE">Pernambuco</option>'+
                                      '<option value="PI">Piauí</option>'+
                                      '<option value="RJ">Rio de Janeiro</option>'+
                                      '<option value="RN">Rio Grande do Norte</option>'+
                                      '<option value="RS">Rio Grande do Sul</option>'+
                                      '<option value="RO">Rondônia</option>'+
                                      '<option value="RR">Roraima</option>'+
                                      '<option value="SC">Santa Catarina</option>'+
                                      '<option value="SP">São Paulo</option>'+
                                      '<option value="SE">Sergipe</option>'+
                                      '<option value="TO">Tocantins</option>'+
                                      '<option value="ES">Estrangeiro</option>'+
                                    '</select>'+
                                '</div>'+ 
                              '</li>'+  
                              '<li id="city" style="width: 30%; padding-right: 10px">'+ 
                                '<div class="form-group">'+ 
                                  '<label for="city-customer'+jsonObj.customerAddress[i].deliveryAddressId+'">Cidade: *</label>'+ 
                                  '<input type="text" class="form-control" id="city-customer'+jsonObj.customerAddress[i].deliveryAddressId+'" placeholder="Ex.: São Paulo" name="city-customer" required/>'+  
                                '</div>'+ 
                              '</li>'+  
                              '<li id="cep" style="width: 30%; padding-right: 10px">'+ 
                                '<div class="form-group">'+ 
                                  '<label for="cep-customer'+jsonObj.customerAddress[i].deliveryAddressId+'">CEP: *</label>'+ 
                                  '<input type="text" class="form-control" id="cep-customer'+jsonObj.customerAddress[i].deliveryAddressId+'" placeholder="04308-020" name="cep" required/>'+ 
                                '</div>'+ 
                              '</li>'+  
                              '<li id="complement" style="width: 30%">'+  
                                '<div class="form-group">'+ 
                                  '<label for="complement-customer'+jsonObj.customerAddress[i].deliveryAddressId+'">Complemento :</label>'+ 
                                  '<input type="text" class="form-control" id="complement-customer'+jsonObj.customerAddress[i].deliveryAddressId+'" placeholder="Apto 12" name="complement">'+  
                                '</div>'+ 
                              '</li>'+  
                              '<a style="color:white; margin-top: 50px"class="btn btn-default color wrap floatRight" onclick="updateAddress('+jsonObj.customerAddress[i].deliveryAddressId+')">Salvar</a>'+  
                            '</ul>'+  
                          '</form>'+ 
                        '</div><hr>'; 
            }
            address+= '</ul>';
            document.getElementById("customer-address").innerHTML = address;
        }
        //Carrega cartões do comprador
        if(jsonObj.cardCustomer.length == 0){
          document.getElementById("customer-card").innerHTML = 
            '<fieldset>'+
              '<legend class="bold">Cartões:</legend>'+
              '<p><img src="images/caution.jpg" width="25" height="27"/> Nenhum  cartão cadastrado</p>'
            '</fieldset><br>';
        }else{
          var card = '<p class="bold">Cartões:</p><ul><hr>';
          for(var i=0; i<jsonObj.cardCustomer.length; i++){
            card+='<li><p><span style="font-weight: bold">Nome do titular: </span>'+jsonObj.cardCustomer[i].nameCardHolder+'</p></li><br/>'+
                  '<li><p><span style="font-weight: bold">Número do cartão: </span>'+jsonObj.cardCustomer[i].cardNumber+'</p></li><br/>'+
                  '<li><p><span style="font-weight: bold">Tipo do cartão: </span>'+jsonObj.cardCustomer[i].typeCard+'</p></li>'+
                  '<a class="floatRight" href="profile.html" style="color: black" onclick="deleteCard('+jsonObj.cardCustomer[i].cardId+')"><img src="images/delete.png"/></a><hr>';
          }
          card += '</ul>';
          document.getElementById("customer-card").innerHTML = card;
        }
     }  
  }
  http_request.open("GET", data_file, true);
  http_request.send();
}

//*********Perfil-fornecedor***********//
//Carrega informações do fornecedor
function loadInformationProvider() {
  idProvider = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/provider/"+idProvider;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

     if (http_request.readyState == 4 && http_request.status == 200) {
        var jsonObj = JSON.parse(http_request.responseText);

        document.getElementById("provider-trade-name").innerHTML = jsonObj.tradeName+"<br>";
        document.getElementById("provider-business-name").innerHTML = "<br><p class='bold'>Nome empresarial: </p> "+jsonObj.businessName+"<br>";
        document.getElementById("cnpj").innerHTML = "<p class='bold'>CNPJ:</p> "+jsonObj.cnpj+"<br>";
        document.getElementById("ie").innerHTML = "<p class='bold'>IE:</p> "+jsonObj.ie+"<br>";
        document.getElementById("contact-name").innerHTML = "<p class='bold'>Nome para contato:</p> "+jsonObj.contactName+"<br>";
        document.getElementById("tel-provider").innerHTML = "<p class='bold'>Telefone:</p> "+jsonObj.telProvider+"<br>";
        document.getElementById("e-mail").innerHTML = "<p class='bold'>E-mail:</p> "+jsonObj.email+"<br>";
        document.getElementById("address-provider").innerHTML = "<p class='bold'>Enderço:</p> "+jsonObj.providerAddress+" - "+jsonObj.providerCity+"/"+jsonObj.providerState+"<br>";
      }
    }
  http_request.open("GET", data_file, true);
  http_request.send(); 
}

//Mostrar os produtos que determinado fornecedor vende
function loadProductByProvider(){
  idProvider = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/product/provider/"+idProvider;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

     if (http_request.readyState == 4) {
      if(this.status ==204){
          document.getElementById("products").innerHTML += '<p class="bold">Produtos vendidos por você:</p><div><p><img src="images/caution.jpg" width="25" height="27"/> Você ainda não está vendendo nenhum produto.</p></div>';
      }else{
        var jsonObj = JSON.parse(http_request.responseText);
        var product = '<p class="bold">Produtos vendidos por você:</p><ul><hr>';
        for(var i = 0; i<jsonObj.length; i++){
          product += '<li>'+jsonObj[i].name+'</li> -  '+
                     '<li>'+jsonObj[i].brand+'</li> - '+
                     '<li>'+jsonObj[i].productType.productType+'</li>'+
                     '<a class="floatRight" href="profile_provider.html" style="color: black" onclick="deleteProduct('+jsonObj[i].productId+')"><img src="images/delete.png"/></a>'+
                     '<a class="floatRight" data-toggle="collapse" data-target="#address-update'+jsonObj[i].productId+'" style="padding-right: 20px"><img src="images/edit.png"/></a>'+
                     '<div id="address-update'+jsonObj[i].productId+'" class="collapse">'+
                        '<form action="#">'+
                        '<ul>'+
                          '<li style="width: 30%; padding-right: 10px">'+
                            '<div class="form-group">'+
                              '<label for="name-product'+jsonObj[i].productId+'">Nome: *</label>'+
                              '<input type="text" class="form-control" id="name-product'+jsonObj[i].productId+'" placeholder="Nome do produto"required/>'+
                            '</div>'+
                          '</li>'+
                          '<li style="width: 30%; padding-right: 10px">'+
                            '<div class="form-group">'+
                              '<label for="brand-product'+jsonObj[i].productId+'">Marca: *</label>'+
                              '<input type="text" class="form-control" id="brand-product'+jsonObj[i].productId+'" placeholder="Digite a marca do produto" required/>'+
                            '</div>'+
                          '</li>'+
                          '<li style="width: 20%; padding-right: 10px">'+
                            '<div class="form-group">'+
                              '<label for="price-product'+jsonObj[i].productId+'">Preço: *</label>'+
                              '<input type="text" class="form-control" id="price-product'+jsonObj[i].productId+'" placeholder="12.00" required/>'+
                            '</div>'+
                          '</li>'+
                          '<li style="width: 30%; padding-right: 10px">'+
                            '<div class="form-group">'+
                              '<label for="type-product'+jsonObj[i].productId+'t">Tipo do produto: *</label>'+
                                '<select class="form-control"  id="type-product'+jsonObj[i].productId+'" required/>'+
                                  '<option value=""> </option>'+
                                  '<option value=1>Medicamento</option>'+
                                  '<option value=2>Material Médico</option>'+
                                '</select>'+
                              '</div>'+
                            '</li>'+
                            '<li style="width: 30%; padding-right: 10px">'+
                              '<div class="form-group">'+
                                '<label for="description-product'+jsonObj[i].productId+'">Descrição: *</label>'+
                                '<input type="text" class="form-control" id="description-product'+jsonObj[i].productId+'" placeholder="Comente sobre o produto" required/>'+
                              '</div>'+
                            '</li>'+
                            '<a style="color:white; margin-top: 50px"class="btn btn-default color wrap floatRight" onclick="updateProduct('+jsonObj[i].productId+')">Salvar</a>'+
                          '</ul>'+
                        '</form>'+
                      '</div><hr/>';
        }
        product += '</ul>';
        document.getElementById("products").innerHTML += product;
      }
    }
  }
  http_request.open("GET", data_file, true);
  http_request.send(); 
}


//******Funções para deletar registros**********//
//Deleta um porduto
function deleteProduct(idProduct){
  var idProvider = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/product/"+idProduct;
  var http_request = new XMLHttpRequest();

  http_request.open("DELETE", data_file, true);
  http_request.send();

}

//Deleta um endereço do comprador
function deleteAddress(idAddress){
  idCustomer = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/address/"+idCustomer+"/"+idAddress;
  var http_request = new XMLHttpRequest();

  http_request.open("DELETE", data_file, true);
  http_request.send();

}


//Deleta um cartão do comprador
function deleteCard(idCard){
  idCustomer = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/card/"+idCustomer+"/"+idCard;
  var http_request = new XMLHttpRequest();

  http_request.open("DELETE", data_file, true);
  http_request.send();

}

//Deleta um comprador
function deleteCustomer(){
  idCustomer = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/customer/"+idCustomer;
  var http_request = new XMLHttpRequest();
  logout();

  http_request.open("DELETE", data_file, true);
  http_request.send();
}

//Deleta um fornecedor
function deleteProvider(){
  var idProvider = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/provider/"+idProvider;
  var http_request = new XMLHttpRequest();
  logout();

  http_request.open("DELETE", data_file, true);
  http_request.send();
}
