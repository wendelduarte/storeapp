//Funções para trabalhar com os filtros, na busca de produtos.

//Função que realiza a busca de produtos conforme usuário digitar (no Index)
function searchProducts(){
  var find = document.getElementById('search').value
  var data_file = "http://localhost:8080/product/search/"+find;
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {
    if (http_request.readyState == 4) {
      if(this.status ==200){
        var jsonObj = JSON.parse(http_request.responseText);
        var tam = jsonObj.length;
        var i
        var card = '';
        for(i = 0; i<tam; i++){
          card += '<li>'+ 
                    '<div class="card" style="width:200px">'+
                      '<img class="card-img-top" src="images/bio.png" alt="Card image" style="width:100%">'+
                      '<div class="card-body"> <h4 class="card-title">' + jsonObj[i].name + '</h4>'+
                      '<p class="card-text">R$ '+jsonObj[i].price+'</p>'+
                      '<a href="product_information.html?id='+jsonObj[i].productId+'" class="btn btn-default color">Ver mais</a>'+
                      '</div>'+
                    '</div>'+
                  '</li>';
        }
        document.getElementById("cards").innerHTML = card;
        document.getElementById("section-content").innerHTML = '<h4 style="color: #808080"> Resultados da sua pesquisa para "'+find+'":</h4><br>';
      }else{
        document.getElementById("section-content").innerHTML = '<h4 style="color: #808080"> Sua pesquisa para "'+find+'" não encontrou resultados</h4><br/>';
        document.getElementById("cards").innerHTML = '<br/><img src="images/not-found.png"/>';
      }
    }  
  }
  http_request.open("GET", data_file, true);
  http_request.send();
}

//Função para filtros dos radios buttons (no Index)
function filter(filter){

  if(filter == 3){
    var data_file = "http://localhost:8080/product/filter/desc";
  }else if(filter == 4){
    var data_file = "http://localhost:8080/product/filter/asc";
  }else{
    var data_file = "http://localhost:8080/product/filter/"+filter;
  }
  var http_request = new XMLHttpRequest();

  http_request.onreadystatechange = function() {
    if (http_request.readyState == 4 && http_request.status == 200) {
      var jsonObj = JSON.parse(http_request.responseText);
      var tam = jsonObj.length;
      var i
      var card = '';
      for(i = 0; i<tam; i++){
        card += '<li>'+
                  '<div class="card" style="width:200px"> '+
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
      if(filter == 4){
        document.getElementById("section-content").innerHTML = 
          '<h4 style="color: #808080"> Filtro para menor preço primeiro:</h4>'+
          '<button id="remove" class="btn btn-default color" onclick="loadAllProducts(1), showFilters()">Remover filtro</button>'+
          '<br>';
        document.getElementById("type-product-filter").innerHTML = ' ';
        document.getElementById("text-box-for-search").innerHTML = ' ';
      }else if (filter == 3){
        document.getElementById("section-content").innerHTML = 
          '<h4 style="color: #808080"> Filtro para maior preço primeiro:</h4>'+
          '<button id="remove" class="btn btn-default color" onclick="loadAllProducts(1), showFilters()">Remover filtro</button>'+
          '<br>';
        document.getElementById("type-product-filter").innerHTML = ' ';
        document.getElementById("text-box-for-search").innerHTML = ' ';
      }else if (filter == 1) {
        document.getElementById("section-content").innerHTML = 
          '<h4 style="color: #808080"> Filtro para medicamentos:</h4>'+
          '<button id="remove" class="btn btn-default color" onclick="loadAllProducts(1), showFilters()">Remover filtro</button>'+
          '<br>';
        document.getElementById("price-product-filter").innerHTML = ' ';
        document.getElementById("text-box-for-search").innerHTML = ' ';
      }else{
        document.getElementById("section-content").innerHTML = 
          '<h4 style="color: #808080"> Filtro para material médico:</h4>'+
          '<button id="remove" class="btn btn-default color" onclick="loadAllProducts(1), showFilters()">Remover filtro</button>'+
          '<br>';
        document.getElementById("price-product-filter").innerHTML = ' ';
        document.getElementById("text-box-for-search").innerHTML = ' ';   
      }
    }
  }
  http_request.open("GET", data_file, true);
  http_request.send();
}

//Chamada quando clica no botão remover filtros, faz os filtros voltarem (no Index)
function showFilters(){
  document.getElementById("text-box-for-search").innerHTML = '<li>'+
      '<input id ="search" type="search" class="form-control form-control-lg" placeholder="Digite o nome do produto" name="search">'+
    '</li>'+
    '<li>'+
      '<a id="searchButton" class="btn btn-default color" onclick="searchProducts()"><img src="images/lupa.png"></a>'+
    '</li>';
  document.getElementById("type-product-filter").innerHTML = '<legend>Tipo do Produto</legend>'+
    '<input type="radio" id="medicamento" name="type-prooduct" onchange="filter(1)"/>'+
    '<label for="medicamento">Medica<wbr>mentos</label><br>'+
    '<input type="radio" id="material-medico" name="type-prooduct" onchange="filter(2)"/>'+
    '<label for="material-medico">Material Medico</label>';
  document.getElementById("price-product-filter").innerHTML = '<legend>Preço</legend>'+
    '<input type="radio" id="maior" name="price-prooduct" value="desc" onchange="filter(3)"/>'+
    '<label for="maior">Maior Preço</label><br>'+
    '<input type="radio" id="menor" name="price-prooduct" value="asc" onchange="filter(4)"/>'+
    '<label for="menor">Menor preço</label>';
}

//Função que busca pelo nome do produto de um determinado tipo
function findType(type){
  var find = document.getElementById('search').value
  var data_file = "http://localhost:8080/product/filter/"+type+"/"+find;
  var http_request = new XMLHttpRequest();
  http_request.onreadystatechange = function() {
    if (http_request.readyState == 4) {
      if(this.status ==200){
        var jsonObj = JSON.parse(http_request.responseText);
        var tam = jsonObj.length;
        var i
        var card = '';
        for(i = 0; i<tam; i++){
          card += '<li>'+
                    '<div class="card" style="width:200px">'+
                      '<img class="card-img-top" src="images/bio.png" alt="Card image" style="width:100%">'+
                      '<div class="card-body"> <h4 class="card-title">' + jsonObj[i].name + '</h4>'+
                      '<p class="card-text">R$ '+jsonObj[i].price+'</p>'+
                      '<a href="product_information.html?id='+jsonObj[i].productId+'" class="btn btn-default color">Ver mais</a>'+
                      '</div>'+
                    '</div>'+
                  '</li>';
        }
        document.getElementById("cards").innerHTML = card;
        document.getElementById("section-content").innerHTML = '<h4 style="color: #808080"> Resultados da sua pesquisa para "'+find+'":</h4><br>';
      }else{
        document.getElementById("section-content").innerHTML = '<h4 style="color: #808080"> Sua pesquisa para "'+find+'" não encontrou resultados</h4><br/>';
        document.getElementById("cards").innerHTML = '<br/><img src="images/not-found.png"/>';
      }
    }  
  }
  http_request.open("GET", data_file, true);
  http_request.send();
}