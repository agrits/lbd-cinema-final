
list = []
for(hall = 1; hall <=50; hall++){
	for(row = 1; row <= 5; row++){
		for(column = 1; column <= 10; column++){
			list.push({
								"id": (hall-1)*50 + (row-1)*10 + column,
								"seatRow": row,
								"seatColumn": column,
								"hall": {"id": hall}
								})
		}
	}
}
console.log(JSON.stringify(list))
