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

var cute;
fetch('/jerjack/rest/json/movie/get/all')
.then(checkStatus)
.then(parseJSON)
.then(function(data) {
	
	var movies = data

	var listElements = movies.map(function(movie) {
		return React.createElement('div', {key: movie.id, className: 'col-sm-6'},
					React.createElement('div', { className: 'card'}, 
						React.createElement('img', {className: 'img-fluid', src: movie.imagePath}, null),
						React.createElement('div', {className: 'card-block'}, 
								React.createElement('h4', {className: 'card-title'}, 'Tomato Meter'),
								React.createElement('ul', null, 
										React.createElement('li',null, 'Average Rating: ' + movie.tomatoMeter.averageRating ),
										React.createElement('li',null, 'Reviews Counted: ' + movie.tomatoMeter.reviewCounted),
										React.createElement('li',null, 'Fresh: ' + movie.tomatoMeter.fresh),
										React.createElement('li',null, 'Rotten: ' + movie.tomatoMeter.rotten)
								)
						),
						React.createElement('div', {className: 'card-block'}, 
								React.createElement('h4', {className: 'card-title'}, 'Audience Score'),
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






