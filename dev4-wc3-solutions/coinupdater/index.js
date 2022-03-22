const mysql = require('mysql');
const fetch = require('node-fetch');

/*
This script fetches all coins listed on CoinLayer and their rates,
pushes these to a mysql database
*/

const API_KEY = '5aeefd828feed3bdd14307a0ef187833'
/*
const API_KEY = '9664a08186dee6d846b9c16f5fa78773'
*/
const con = mysql.createConnection({
  host: "mysql07.websrv.be",
  user: "u14405dev4be",
  password: "WH2t2L22cLs232Qr",
  database: '14405dev4be',
  port: 3306,
  connectTimeout: 100000,
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});

 const fetchApi = async () => {
    console.log("Fetching API... ")
    try {
        const response = await fetch(`http://api.coinlayer.com/api/live?access_key=${API_KEY}`);
        const body = await response.json();
        const rates = body.rates;
        console.log(rates);

        Object.keys(rates).forEach(key => {
            console.log(key, rates[key]);
            const sql = `UPDATE coins
            SET rate = ${rates[key]}
            WHERE name = "${key}" ;`
            con.query(sql, function (err, result) {
                if (err) throw err;
                //console.log("Result: " + result);
            });
            console.log("Updating SQL");
        });
        
        /*
        con.query(sql, function (err, result) {
            if (err) throw err;
            console.log("Result: " + result);
          });

          */

    } catch (e) {
        console.error("Probs the API key");
        console.error(e);
    }
    

}

setInterval(fetchApi, 9000);
