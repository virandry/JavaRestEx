function checkStatus(response) {
	if (response.status >= 200 && response.status < 300) {
		return response
	} else {
		var error = new Error(response.statusText)
		error.response = response
		throw error
	}
}

function parseJSON(response) {
	return response.json()
}

function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}


var cute;
fetch('/jerjack/rest/json/movie/get/all')
.then(checkStatus)
.then(parseJSON)
.then(function(data) {
	
	var movies = data

	var listElements = movies.map(function(movie) {
		return React.createElement('div', {key: movie.id, className: 'w3-third w3-container w3-margin-bottom'},
					React.createElement('div', { className: ''}, 
						React.createElement('img', {className: 'w3-hover-opacity', src: movie.imagePath}, null),
						React.createElement('div', {className: 'w3-container w3-white'}, 
								React.createElement('h4', {className: ''}, 'Tomato Meter'),
								React.createElement('ul', null, 
										React.createElement('li',null, 'Average Rating: ' + movie.tomatoMeter.averageRating ),
										React.createElement('li',null, 'Reviews Counted: ' + movie.tomatoMeter.reviewCounted),
										React.createElement('li',null, 'Fresh: ' + movie.tomatoMeter.fresh),
										React.createElement('li',null, 'Rotten: ' + movie.tomatoMeter.rotten)
								)
						),
						React.createElement('div', {className: 'w3-container w3-white'}, 
								React.createElement('h4', {className: ''}, 'Audience Score'),
								React.createElement('ul', null, 
										React.createElement('li',null, 'Average Rating: ' + movie.audienceScore.averageRating),
										React.createElement('li',null, 'User Ratings: ' + movie.audienceScore.userRating)
								)
						)
					)
				)
	})
	  
	var rootElement = React.createElement('div', null, listElements)

	ReactDOM.render(rootElement, document.getElementById('app'))

}).catch(function(error) {
	console.log('request failed', error)
})






