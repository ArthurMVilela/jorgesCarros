var express = require("express"); 
var path = require('path');
var fetch = require('node-fetch');

var porta = 3000;
var urlAPI = "http://localhost:4000";

var app = express();

// Setup view engine
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

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
				listaCarros: carros
			});
		})
		.catch(err => {
			console.log(err)
		});

	
})


var server = app.listen(porta, function(){});