const fs = require('fs');

let rawdata = fs.readFileSync('db.json');
let db = JSON.parse(rawdata);

var tableNames = {
  "shows": "show",
  "categories": "category",
  "movies": "movie",
  "users": "cinemauser",
  "discounts": "discount",
  "reservations": "reservation",
  "tickets": "ticket",
  "locations": "location",
  "cinemas": "cinema",
  "halls": "hall",
  "seats": "seat"
}
function formatRow(row){
  processedRow = {}
  Object.keys(row).forEach(key => {
    if(row[key].hasOwnProperty("id")){
      processedRow[key+"_id"] = row[key]["id"]
    }
    else{
      processedRow[key] = row[key]
    }
  })
  return processedRow;
}
var formatQuery = function(query){
  return query.replace("Id", "_id").toLowerCase().replace("admin", "ADMIN").replace(",\"user\")", ",\"USER\")")
}
var queries = []
Object.keys(tableNames).forEach(table => {
  db[table].forEach(row => {
    delete row["id"]
    row = formatRow(row)
    let keys = Object.keys(row).join(",")
    let values = Object.values(row).map(val => {
      if(typeof(val) === 'number' && val < 99999999){
        return val
      }
      else return `"${val}"`
    }).join(",")
    let query = `INSERT INTO ${tableNames[table]} (${keys}) values (${values})`
    queries.push(formatQuery(query))
  })
})
queries.forEach(query => console.log(query))
