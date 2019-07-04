//Aqui estão as funções que estarão realizando os cadastros no site e também a atualização de dados.


//*****************Funções para cadastro********************//
//Função para cadastrar um cliente
function postCustomer(){
  var data_file = "http://localhost:8080/customer/post";
  var http_request = new XMLHttpRequest();

  var name = document.getElementById('name-customer').value;
  var cpf = document.getElementById('cpf-customer').value;
  var birth = document.getElementById('birth-customer').value;
  var tel = document.getElementById('tel-customer').value;
  var cel = document.getElementById('cel-customer').value;
  var email = document.getElementById('email-customer').value;
  var pass  = document.getElementById('pass-customer').value;

  if(name == "" || cpf == "" || email == "" || pass ==""){
    alert("Preencha todos os campos obrigatórios");
  }else{
    window.location.href = "login_customer.html";
    http_request.open("POST", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({
                        name: name,
                        cpfCustomer: cpf,
                        dateBirthCustomer: birth,
                        telCustomer: tel,
                        celCustomer: cel,
                        email: email,
                        password: pass,
                        bilingAddres: null,
                        cardCustomer: null,
                        customerAddress: null
                        }));
  }
}

//Função para cadastrar um fornecedor
function postProvider(){
  var data_file = "http://localhost:8080/provider/post";
  var http_request = new XMLHttpRequest();

  var bussiness_name = document.getElementById('bussiness-name-provider').value;
  var trade_name = document.getElementById('trade-name-provider').value;
  var cnpj = document.getElementById('cnpj-provider').value;
  var ie = document.getElementById('ie-provider').value;
  var state = document.getElementById('state-provider').value;
  var address= document.getElementById('address-provider').value;
  var city = document.getElementById('city-provider').value;
  var name_contact = document.getElementById('name-contact').value;
  var tel = document.getElementById('tel-provider').value;
  var email = document.getElementById('email-provider').value;
  var pass = document.getElementById('pass-provider').value;

  if(bussiness_name == "" || trade_name == "" || cnpj == "" || address =="" || state == "" || email == "" || pass == "" || tel == "" || name_contact == ""){
    alert("Preencha todos os campos obrigatórios");
  }else{
    window.location.href = "login_provider.html";
    http_request.open("POST", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({
                      businessName: bussiness_name,
                      tradeName: trade_name,
                      cnpj: cnpj,
                      ie: ie,
                      providerState: state,
                      providerAddress: address,
                      providerCity: city,
                      contactName: name_contact,
                      telProvider: tel,
                      email: email,
                      password: pass
                      }));
  }
}

//Função para cadastrar um endereço de entrega
function postDeliveryAddress(){
  var data_file = "http://localhost:8080/address";
  var http_request = new XMLHttpRequest();

  var idCustomer = sessionStorage.getItem('userId');
  var address = document.getElementById('address').value;
  var state = document.getElementById('state-customer').value;
  var city = document.getElementById('city-customer').value;
  var cep = document.getElementById('cep-customer').value;
  var complement = document.getElementById('complement-customer').value;

  if(address == "" || state == "" || city == "" || cep ==""){
    alert("Preencha todos os campos obrigatórios");
  }else{
    window.location.href = "profile.html#customer-address";
    http_request.open("POST", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({
                    customer: {customerId:  idCustomer},
                    customerAddress: address,
                    customerCity: city,
                    customerState: state,
                    cepCustomer: cep,
                    complementAddressCustomer: complement
                }));
  }
}

//Função para cadastrar cartão
function postCard(){
  var data_file = "http://localhost:8080/card/post";
  var http_request = new XMLHttpRequest();

  var idCustomer = sessionStorage.getItem('userId');
  var name_card = document.getElementById('name-card').value;
  var number = document.getElementById('card-number').value;
  var security_code = document.getElementById('security-code').value;
  var type = document.getElementById('type-card').value;
  var expiration_date = document.getElementById('expiration-date').value;

  if(name_card == "" || number == "" || security_code == "" || type =="" || expiration_date == ""){
    alert("Preencha todos os campos obrigatórios");
  }else{
    window.location.href = "profile.html#customer-card";
    http_request.open("POST", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({
                    customer: {customerId: idCustomer},
                    nameCardHolder: name_card,
                    cardNumber: number,
                    expirationDate: expiration_date,
                    typeCard: type,
                    cardSecurityCode: security_code
                }));
  }
}

//Função para cadastrar um novo produto
function postProduct(){
  var data_file = "http://localhost:8080/product";
  var http_request = new XMLHttpRequest();

  var idProvider = sessionStorage.getItem('userId');
  var name_product = document.getElementById('name-product').value;
  var brand = document.getElementById('brand-product').value;
  var price_product = document.getElementById('price-product').value;
  var type = document.getElementById('type-product').value;
  var description = document.getElementById('description-product').value;

  if(name_product == "" || brand == "" || price_product == "" || type =="" || description == ""){
    alert("Preencha todos os campos obrigatórios");
  }else{
    window.location.href = "profile_provider.html";
    http_request.open("POST", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({
                      productType: {productTypeId: type},
                      provider: {providerId: idProvider},
                      name: name_product,
                      brand: brand,
                      price: price_product,
                      description: description
                    }));
  }
}

//***************Funções para atualizar dados*******************//
//******Comprador*******//
//Atualiza as informações do comprador
function updateCustomer(){
  var idCustomer = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/customer/"+idCustomer;
  var http_request = new XMLHttpRequest();


  var name = document.getElementById('name-customer').value;
  var cpf = document.getElementById('cpf-customer').value;
  var birth = document.getElementById('birth-customer').value;
  var tel = document.getElementById('tel-customer').value;
  var cel = document.getElementById('cel-customer').value;
  var email = document.getElementById('email-customer').value;
  var pass  = document.getElementById('pass-customer').value;

  if(name == "" || cpf == "" || email == "" || pass ==""){
    alert("Preencha todos os campos obrigatórios");
  }else{
    window.location.href = "profile.html";
    http_request.open("PUT", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({
                        name: name,
                        cpfCustomer: cpf,
                        dateBirthCustomer: birth,
                        telCustomer: tel,
                        celCustomer: cel,
                        email: email,
                        password: pass,
                        }));
  }
}

//Carrega as informações nas caixas de texto da pagina de atualizaçao de informações (update_customer.html)
function informationToUpdateCustomer() {
  idCustomer = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/customer/"+idCustomer;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

     if (http_request.readyState == 4 && http_request.status == 200) {
      var jsonObj = JSON.parse(http_request.responseText);

      document.getElementById('name-customer').value = jsonObj.name;
      document.getElementById('cpf-customer').value = jsonObj.cpfCustomer;
      document.getElementById('birth-customer').value = jsonObj.dateBirthCustomer;
      document.getElementById('tel-customer').value = jsonObj.telCustomer;
      document.getElementById('cel-customer').value = jsonObj.celCustomer;
      document.getElementById('email-customer').value = jsonObj.email;
      document.getElementById('pass-customer').value = jsonObj.password;
    }

  }
  http_request.open("GET", data_file, true);
  http_request.send();
}

//Atualiza endereço do comprador
function updateAddress(id){
  var idCustomer = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/address/"+idCustomer+"/"+id;
  var http_request = new XMLHttpRequest();

  var address = document.getElementById('address'+id).value;
  var state = document.getElementById('state-customer'+id).value;
  var city = document.getElementById('city-customer'+id).value;
  var cep = document.getElementById('cep-customer'+id).value;
  var complement = document.getElementById('complement-customer'+id).value;

  if(address == "" || state == "" || city == "" || cep ==""){
    alert("Preencha todos os campos obrigatórios");
  }else{
    window.location.href = "profile.html#customer-address";
    http_request.open("PUT", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({
                    customerAddress: address,
                    customerCity: city,
                    customerState: state,
                    cepCustomer: cep,
                    complementAddressCustomer: complement
                }));
  }
}

//******Fornecedor*******//
//Carrega informações nas caixas de texto da página de atualização do fornecedor
function informationToUpdateProvider(){
  var idProvider = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/provider/"+idProvider;
  var http_request = new XMLHttpRequest();

    http_request.onreadystatechange = function() {

     if (http_request.readyState == 4 && http_request.status == 200) {
      var jsonObj = JSON.parse(http_request.responseText);

      document.getElementById('bussiness-name-provider').value = jsonObj.businessName;
      document.getElementById('trade-name-provider').value = jsonObj.tradeName;
      document.getElementById('cnpj-provider').value = jsonObj.cnpj;
      document.getElementById('ie-provider').value = jsonObj.ie;
      document.getElementById('state-provider').value = jsonObj.providerState;
      document.getElementById('address-provider').value = jsonObj.providerAddress;
      document.getElementById('city-provider').value = jsonObj.providerCity;
      document.getElementById('name-contact').value = jsonObj.contactName;
      document.getElementById('tel-provider').value = jsonObj.telProvider;
      document.getElementById('email-provider').value = jsonObj.email;
      document.getElementById('pass-provider').value = jsonObj.password;
    }

  }
  http_request.open("GET", data_file);
  http_request.send();
}


//Atualiza informações do fornecedor
function updateProvider(){
  var idProvider = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/provider/"+idProvider;
  var http_request = new XMLHttpRequest();

  var bussiness_name = document.getElementById('bussiness-name-provider').value;
  var trade_name = document.getElementById('trade-name-provider').value;
  var cnpj = document.getElementById('cnpj-provider').value;
  var ie = document.getElementById('ie-provider').value;
  var state = document.getElementById('state-provider').value;
  var address= document.getElementById('address-provider').value;
  var city = document.getElementById('city-provider').value;
  var name_contact = document.getElementById('name-contact').value;
  var tel = document.getElementById('tel-provider').value;
  var email = document.getElementById('email-provider').value;
  var pass = document.getElementById('pass-provider').value;

  if(bussiness_name == "" || trade_name == "" || cnpj == "" || address =="" || state == "" || email == "" || pass == "" || tel == "" || name_contact == ""){
    alert("Preencha todos os campos obrigatórios");
  }else{
    window.location.href = "profile_provider.html";
    http_request.open("PUT", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({
                      businessName: bussiness_name,
                      tradeName: trade_name,
                      cnpj: cnpj,
                      ie: ie,
                      providerState: state,
                      providerAddress: address,
                      providerCity: city,
                      contactName: name_contact,
                      telProvider: tel,
                      email: email,
                      password: pass
                      }));
  }
}

//Atualiza informações de um produto
function updateProduct(id){
  var data_file = "http://localhost:8080/product/"+id;
  var http_request = new XMLHttpRequest();

  var name = document.getElementById('name-product'+id).value;
  var brand = document.getElementById('brand-product'+id).value;
  var price = document.getElementById('price-product'+id).value;
  var type = document.getElementById('type-product'+id).value;
  var description = document.getElementById('description-product'+id).value;

  if(name == "" || brand == "" || price == "" || type =="" || description == ""){
    alert("Preencha todos os campos obrigatórios");
  }else{
    window.location.href = "profile_provider.html";
    http_request.open("POST", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({
                      productType: {productTypeId: type},
                      name: name,
                      brand: brand,
                      price: price,
                      description: description
                }));
  }
}