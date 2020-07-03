var express = require("express"); 
const path = require('path');

var app = express();

// Setup view engine
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.get("/", function(req,res,next) {
	res.render("index", {});
});

app.get("/cadastrar-carro", function(req,res,next) {
	res.render("carros/cadastrar-carros", {})
})


var server = app.listen(3000, function(){});