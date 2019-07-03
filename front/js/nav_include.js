function includeNavBar(){
  var nav = '';
  if(sessionStorage.getItem('userId') != 'logout' && sessionStorage.getItem('custProv') == 1){
    nav = '<a class="navbar-brand" href="index.html"><img src="images/bio.png"/></a>'+
      '<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">'+
        '<span class="navbar-toggler-icon"></span>'+
        '</button>'+
        '<div class="collapse navbar-collapse bionexo-color" id="collapsibleNavbar">'+
          '<ul class="navbar-nav">'+
            '<li class="nav-item">'+
              '<a class="nav-link" href="products.html">Produtos</a>'+
            '</li>'+
            '<li class="nav-item dropdown">'+
              '<a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">Minha conta</a>'+
              '<div class="dropdown-menu back-color-submenu">'+
                '<a class="dropdown-item mouse-hover" href="profile.html">Ver informações</a>'+
                '<a class="dropdown-item mouse-hover" href="cart.html">Carrinho</a>'+
                '<a class="dropdown-item mouse-hover" href="index.html" onclick="logout()">Sair</a>'+
              '</div>'+
              '</li>'+  
          '</ul>'+
        '</div>'
  }else if(sessionStorage.getItem('userId') != 'logout' && sessionStorage.getItem('custProv') == 2){
    nav = '<a class="navbar-brand" href="index.html"><img src="images/bio.png"/></a>'+
      '<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">'+
        '<span class="navbar-toggler-icon"></span>'+
        '</button>'+
        '<div class="collapse navbar-collapse bionexo-color" id="collapsibleNavbar">'+
          '<ul class="navbar-nav">'+
            '<li class="nav-item">'+
              '<a class="nav-link" href="products.html">Produtos</a>'+
            '</li>'+
            '<li class="nav-item">'+
              '<a class="nav-link" href="register_product.html">Cadastrar Produto</a>'+
            '</li>'+
            '<li class="nav-item dropdown">'+
              '<a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">Minha conta</a>'+
              '<div class="dropdown-menu back-color-submenu">'+
                '<a class="dropdown-item mouse-hover" href="profile_provider.html">Ver informações</a>'+
                '<a class="dropdown-item mouse-hover" href="index.html" onclick="logout()">Sair</a>'+
              '</div>'+
              '</li>'+  
          '</ul>'+
        '</div>'
  }else{
    nav = '<a class="navbar-brand" href="index.html"><img src="images/bio.png"/></a>'+
      '<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">'+
          '<span class="navbar-toggler-icon"></span>'+
          '</button>'+
          '<div class="collapse navbar-collapse bionexo-color" id="collapsibleNavbar">'+
            '<ul class="navbar-nav">'+
                '<li class="nav-item">'+
                  '<a class="nav-link" href="products.html">Produtos</a>'+
                '</li>'+
                '<li class="nav-item">'+
                  '<a class="nav-link" href="register.html">Cadastro</a>'+
                '</li>'+
                '<li class="nav-item dropdown">'+
                  '<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Login</a>'+
                  '<div class="dropdown-menu back-color-submenu">'+
                    '<a class="dropdown-item mouse-hover" href="login_customer.html">Comprador</a>'+
                    '<a class="dropdown-item mouse-hover" href="login_provider.html">Fornecedor</a>'+
                  '</div>'+
                '</li>'+   
              '</ul>'+
          '</div>'
  }
    document.getElementById("menu-bar").innerHTML = nav;    
}

//Login do cliente
function loginCustomer(){
  var email  = document.getElementById('email').value;
  var pass  = document.getElementById('pwd').value;

  var data_file = "http://localhost:8080/login/customer/"+email+"/"+pass;
  var http_request = new XMLHttpRequest();
  http_request.onreadystatechange = function() {

    if (http_request.readyState == 4 && http_request.status == 200){
      var jsonObj = JSON.parse(http_request.responseText);
      cart();
      var id = JSON.stringify(jsonObj.customerId);
      sessionStorage.setItem('userId', id);
      sessionStorage.setItem('custProv', 1); //Guarda na sessão se é um customer ou um provider - 1 = customer, 2 = provider.
      window.location.href = "profile.html";
    }else if (http_request.readyState == 4 && http_request.status == 401){
      alert("Senha incorreta");
    }else if (http_request.readyState == 4 && http_request.status == 500){
      alert("Usuário inexistente");
    }

  }
  http_request.open("GET", data_file);
  http_request.send();
}

//Login do fornecedor
function loginProvider(){
  var email  = document.getElementById('email').value;
  var pass  = document.getElementById('pwd').value;

  var data_file = "http://localhost:8080/login/provider/"+email+"/"+pass;
  var http_request = new XMLHttpRequest();
  http_request.onreadystatechange = function() {

    if (http_request.readyState == 4 && http_request.status == 200){
      var jsonObj = JSON.parse(http_request.responseText);
      var id = JSON.stringify(jsonObj.providerId);
      sessionStorage.setItem('userId', id);
      sessionStorage.setItem('custProv', 2); //Guarda na sessão se é um customer ou um provider - 1 = customer, 2 = provider.
      window.location.href = "profile_provider.html";
    }else if (http_request.readyState == 4 && http_request.status == 401){
      alert("Senha incorreta");
    }else if (http_request.readyState == 4 && http_request.status == 500){
      alert("Usuário inexistente");
    }

  }
  http_request.open("GET", data_file);
  http_request.send();
}

function logout(){
  sessionStorage.setItem('userId', 'logout');
  sessionStorage.setItem('custProv', 0);
  sessionStorage.setItem('cart', '');
}
