const fs = require('fs')

const halls = JSON.parse(fs.readFileSync("halls.json"))
const shows = JSON.parse(fs.readFileSync("shows.json"))

var newShows = JSON.stringify(shows.map(show => {show["cinemaId"] = halls[show.hallId-1].cinema.id; return show}))

console.log(newShows)
