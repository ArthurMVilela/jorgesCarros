var express = require("express"); 
var path = require('path');
var fetch = require('node-fetch');
var bodyParser = require('body-parser');

var porta = 3000;
var urlAPI = "http://localhost:4000";

var app = express();

// Setup view engine
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.use(bodyParser.urlencoded({ extended: true }));

app.get("/", function(req,res,next) {
	res.render("index", {});
});
app.get("/cadastrar-carro", function(req,res,next) {
	var carros;

	fetch(urlAPI + "/carros")
		.then(response => response.json())
		.then(data => {
			carros = data;
			res.render("./carros/cadastrar-carro", {
				listaCarros: carros,
				mensagem: null
			});
		})
		.catch(err => {
			console.log(err)
		});	
});

app.post("/cadastrar-carro", function(req,res,next) {
	var corpo = req.body;
	var carro = {
		codigo: parseInt(corpo.codigo),
        placa: corpo.placa,
        renavam: corpo.renavam,
        status: parseInt(corpo.status),
        categoria: parseInt(corpo.categoria),
        tipoMotor: parseInt(corpo.motor),
        cor: parseInt(corpo.cor),
        modelo: corpo.modelo,
        ano: parseInt(corpo.ano),
        marca: corpo.marca,
        kmLitro: parseFloat(corpo.km_litro),
        volumeTanque: parseInt(corpo.tanque),
        arCondicionado: corpo.ar_condicionado == "1",
        gps: corpo.gps == "1",
        direcaoAutomatica: corpo.direcao_automatica == "1",
        radioBluetooth: corpo.radio_bluetooth == "1"
	};

	fetch(urlAPI + "/carros", { method: 'POST',
               mode: 'cors',
               cache: 'default', 
               body: JSON.stringify(carro)})
		.then(response => response.json())
		.then(data => {
			console.log(data)
			//printar a tela com o carro cadastrado
			fetch(urlAPI + "/carros")
				.then(response => response.json())
				.then(data => {
					carros = data;
					res.render("./carros/cadastrar-carro", {
						listaCarros: carros,
						mensagem: {
							tipo: "sucesso",
							texto: "Sucesso ao cadastrar carro."
						}
					});
				})
				.catch(err => {
					console.log(err)
				});	
		})
		.catch(err => {
			console.log(err)
		});	
});

app.post("/excluir-carro/:id", function(req,res,next) {
	var id = req.params.id;
	var status;

	fetch(urlAPI + "/carros/" + id, { method: 'DELETE',
            mode: 'cors',
        	cache: 'default',
      	}).then(response => {
      		status = response.status;
      		response.json()
      	})
		.then(data => {
			if (status == 204) {
				fetch(urlAPI + "/carros")
					.then(response => response.json())
					.then(data => {
						carros = data;
						res.render("./carros/cadastrar-carro", {
							listaCarros: carros,
							mensagem: {
								tipo: "sucesso",
								texto: "Sucesso ao excluir carro."
							}
						});
					})
					.catch(err => {
						console.log(err)
					});
			}
		})
		.catch(err => {})

	console.log(id);

})

app.post("/atualizar-carro/:id", function(req,res,next) {
	var id = req.params.id;
	var status;

	var corpo = req.body;
	var carro = {
		codigo: parseInt(corpo.codigo),
        placa: corpo.placa,
        renavam: corpo.renavam,
        status: parseInt(corpo.status),
        categoria: parseInt(corpo.categoria),
        tipoMotor: parseInt(corpo.motor),
        cor: parseInt(corpo.cor),
        modelo: corpo.modelo,
        ano: parseInt(corpo.ano),
        marca: corpo.marca,
        kmLitro: parseFloat(corpo.km_litro),
        volumeTanque: parseInt(corpo.tanque),
        arCondicionado: corpo.ar_condicionado == "1",
        gps: corpo.gps == "1",
        direcaoAutomatica: corpo.direcao_automatica == "1",
        radioBluetooth: corpo.radio_bluetooth == "1"
	};

	fetch(urlAPI + "/carros/" + carro.codigo, { method: 'PATCH',
		mode: 'cors',
		cache: 'default', 
		body: JSON.stringify(carro)})
		.then(response => {
			console.log(response)
      		status = response.status;

      		response.json()
      	}).then(data => {
			
			fetch(urlAPI + "/carros")
				.then(response => response.json())
				.then(data => {
					carros = data;
					if (status == 201) {
						res.render("./carros/cadastrar-carro", {
							listaCarros: carros,
							mensagem: {
								tipo: "sucesso",
								texto: "Sucesso ao alterar carro."
							}
						});
					} else {
						res.render("./carros/cadastrar-carro", {
							listaCarros: carros,
							mensagem: {
								tipo: "erro",
								texto: "Erro ao tentar alterar carro."
							}
						});
					}
				})
				.catch(err => {
					console.log(err)
				});
			
		})
})

app.get("/cadastro-cliente", function(req,res,next) {
	res.render("./cliente/cadastro-cliente");
})

app.post("/cadastrar-cliente", function(req,res,next) {
	var corpo = req.body;

	var cliente = {
		cpf: corpo.cpf,
		nome: corpo.nome,
		rg: corpo.rg,
		cnh: corpo.cnh,
		dataNascimento: Date.parse(corpo.dataNascimento),
		endereco: {
			cep: corpo.cep,
			cidade: corpo.cidade,
			estado: corpo.estado,
			bairro: corpo.bairro,
			numero: parseInt(corpo.numero),
			complemento: corpo.complemento,
			logradouro: corpo.logradouro
		}
	}; //criar objeto com dados do cliente pegando do formulario (corpo) semelhante ao cadastrar carro. - FEITO (MARINA -08/07)

	//fazer o request para cadastrar
	fetch(urlAPI + "/cliente", { method: 'POST',
           mode: 'cors',
           cache: 'default', 
           body: JSON.stringify(cliente)})
		.then((response) => {
			status = response.status
			//return response.json();
			if (status == 201) {
				res.render("./cliente/cadastro-sucesso");
			}
		})
		//.then((cliente) => {})
		.catch((err) => {
			console.log(err);
		})
})

app.post("/excluir-cliente/:id", function(req,res,next) {
	var id = req.params.id;

	fetch(urlAPI + "/cliente/" + id, { method: 'DELETE',
           mode: 'cors',
           cache: 'default'}) 
           //body: JSON.stringify(cliente)})
		.then((response) => {
			status = response.status
			//return response.json();
			if (status == 200) {
				res.render("./cliente/exclusao-sucesso");
			}
		})
		//.then((cliente) => {})
		.catch((err) => {
			console.log(err);
		})
})
app.post("/alterar-cliente/:id", function(req,res,next) {
	var id = req.params.id;

	var corpo = req.body;

	var cliente = {
		cpf: corpo.cpf,
		nome: corpo.nome,
		rg: corpo.rg,
		cnh: corpo.cnh,
		dataNascimento: Date.parse(corpo.dataNascimento),
		endereco: {
			codEndereco: corpo.codEndereco,
			cep: corpo.cep,
			cidade: corpo.cidade,
			estado: corpo.estado,
			bairro: corpo.bairro,
			numero: parseInt(corpo.numero),
			complemento: corpo.complemento,
			logradouro: corpo.logradouro
		}
	};

	fetch(urlAPI + "/cliente", { method: 'UPDATE',
           mode: 'cors',
           cache: 'default', 
           body: JSON.stringify(cliente)})
		.then((response) => {
			status = response.status
			//return response.json();
			if (status == 201) {
				res.render("./cliente/alteracao-sucesso");
			}
		})
		//.then((cliente) => {})
		.catch((err) => {
			console.log(err);
		})
})

app.get("/locar-carro", function(req,res,next) {
	res.render("./locacao/locar-carro.ejs");
})


var server = app.listen(porta, function(){});