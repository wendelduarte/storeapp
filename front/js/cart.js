//***********Funções do carrinho e para finalizar pedido**************//

/*Cria um vertor vazio quando um comprador faz login e grava na sessão, esse vetor vai receber os id's dos 
produtos que serão adicionados no carrinho*/
function cart(){
  var products = [];
  sessionStorage.setItem('cart', JSON.stringify(products));
}

//Adiciona um produto ao carrinho (grava o id do produto no vetor que está salvo na sessão)
function addToCart(){
  if(sessionStorage.getItem('custProv') == 1){
    var urlId = location.search.substring(1);
    var idProduct = parseFloat(urlId.substring(3, urlId.length));
    var products = JSON.parse(sessionStorage.getItem('cart'));
    products.push(idProduct);
    sessionStorage.setItem('cart', JSON.stringify(products));
    alert('Produto adicionado ao carrinho');
  }else{
    alert("Faça login como comprador para adicionar ao carrinho");
  }

}

//Verifica se a sessão do carrinho está vazia, se não estiver, chama a função para carregar os produtos que estão no carrinho na tela.
function productInCart(){
  var products = JSON.parse(sessionStorage.getItem('cart'));
  var sizeCart = products.length;
  if(sizeCart == []){
    document.getElementById("products").innerHTML += 'Carrinho vazio, <a href="index.html" style="color: black">adicione<a> itens para continuar';
  }else{
    document.getElementById("products").innerHTML += '<hr><ul>';
    for(var i = 0; i<sizeCart; i++){//varifica a quantidade de produtos que tem no carrinho.
      loadProduct(products[i]); //essa função que carrega os produtos no carrinho.
    }
    document.getElementById("products").innerHTML += '<ul>';
  }
}

//Carrega as informações do produto no carrinho, é chamada pela função acima.
function loadProduct(idProduct){
  var data_file = "http://localhost:8080/product/"+idProduct;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

    if (http_request.readyState == 4 && http_request.status == 200) {
      var jsonObj = JSON.parse(http_request.responseText);
      document.getElementById("products").innerHTML += jsonObj.name+'</li> - '+
                              '<li>'+jsonObj.brand+'</li> - '+
                              '<li>'+jsonObj.productType.productType+'</li>'+
                              '<a class="floatRight" href="cart.html" style="margin-left: 20px" onclick="removeCart('+idProduct+')"><img src="images/delete.png"/></a>'+
                              '<input oninput="total()" class="floatRight" id="qtd'+idProduct+'" style="width: 8%; margin-left: 5px"" type="number"required/>'+
                              '<label class="floatRight" >Qtd: </label>'+
                              '<p>Valor unitário: <span id="price'+idProduct+'"">'+jsonObj.price+'</span></P>'+
                              '<hr>';      
    }
  }
  http_request.open("GET", data_file, true);
  http_request.send(); 
}

//Remove o produto do carrinho
function removeCart(idProduct){
  var products = JSON.parse(sessionStorage.getItem('cart'));
  var sizeCart = products.length;
  var i = 0;
  for(i; i<=sizeCart;i++){
    if(products[i] == idProduct){
      products.splice(i, 1);
      break;
    }
  }
  sessionStorage.setItem('cart', JSON.stringify(products));
}

//Calcula o total do pedido no carrinho, é chamada quando o usuário digitar uma quantidade em qualquer um dos produtos.
function total(){
  var total = 0;
  var products = JSON.parse(sessionStorage.getItem('cart'));
  console.log(products);
  for(var i =0; i<products.length; i++){
      console.log(products[i]);
      var qtd = document.getElementById('qtd'+products[i]).value;
      var price = JSON.parse(document.getElementById('price'+products[i]).innerHTML);
      total += qtd*price;
  }
  document.getElementById("total").innerHTML = '<span id="total-price">'+total+'</span>';
}

//No carrinho, quando o cliente clicar em finalizar o pedido, essa função vai gerar o pedido, mas ainda não está finalizado.
//Essa função gera o pedido, para confirmar ou cancelar tem a funções abaixo.
function finishOrder(){
  var products = JSON.parse(sessionStorage.getItem('cart'));
  if(products.length == 0){
    alert("Adicione produtos ao carrinho para finalizar seu pedido")
    window.location.href = "index.html";
  }else{
    var data_file = "http://localhost:8080/order";
    var http_request = new XMLHttpRequest();

    var idCustomer = sessionStorage.getItem('userId');
    var date = atualDate();
    var product = [];
    total = JSON.parse(document.getElementById("total-price").innerHTML);

    for(var i=0; i<products.length; i++){
      var qtd = document.getElementById('qtd'+products[i] ).value;
      var jsonProduct = {"productId": products[i], "quantityProduct": qtd};
      product.push(jsonProduct);
    }

    alert("Pedido finalizado");
    window.location.href = "purchases.html";
    cart();
    http_request.open("POST", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({ 
                        customerId: idCustomer,
                        statusOrderId: 1,
                        productOrder: product,
                        date: date,
                        total: total
                  }));
  }
}

//Pega a data atual para colocar no pedido, é chamada pela função de cima.
function atualDate(){
  var dNow = new Date();
  var localdate = dNow.getDate() + '/' + (dNow.getMonth()+1) + '/' + dNow.getFullYear();
  return localdate;
}

//Verifia se o cliente possui pelo menos um cartão para realizar a compra do produto,é chamada ao clicar no botão de pagar pedido nos detalhes do pedido.
function hasCard(purchaseOrderId){
  idCustomer = sessionStorage.getItem('userId');
  var data_file = "http://localhost:8080/customer/"+idCustomer;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {

    if (http_request.readyState === 4 && http_request.status == 200) {
      var jsonObj = JSON.parse(http_request.responseText);
      if(jsonObj.cardCustomer.length == 0){
        alert("Adicione um cartão para continuar.")
      }else{
        paymentOrder(purchaseOrderId);
      }
    }
  }
  http_request.open("GET", data_file, true);
  http_request.send();
}

//Atualiza o status do pedido como "Aprovado" quando o cliente clica em pagar e possui pelo menos um cartão.
function paymentOrder(purchaseOrderId){
    var data_file = "http://localhost:8080/order/"+purchaseOrderId;
    var http_request = new XMLHttpRequest();

    //window.location.href = "profile_provider.html";
    http_request.open("PUT", data_file);
    http_request.setRequestHeader("Content-Type", "application/json");
    http_request.send(JSON.stringify({
                      orderStatus: {statusId: 3}
                      }));
}

//Atualiza o status do pedido como cancelado quando o cliente clica em cancelar.
function cancelOrder(purchaseOrderId){
  var data_file = "http://localhost:8080/order/"+purchaseOrderId;
  var http_request = new XMLHttpRequest();

  //window.location.href = "profile_provider.html";
  http_request.open("PUT", data_file);
  http_request.setRequestHeader("Content-Type", "application/json");
  http_request.send(JSON.stringify({
                    orderStatus: {statusId: 2}
                    }));
}