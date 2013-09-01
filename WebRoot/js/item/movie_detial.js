function show_detials() {
	$("img.movie_poster_img")
			.mouseenter(
					function() {
						var movie_ul = $(this).parent().parent().parent()
								.parent().parent();
						var movie_title = decodeURIComponent(movie_ul
								.attr('m_movie_title'));
						// var yaer =
						// decodeURIComponent(movie_ul.attr('m_year'));
						var avg_rate = decodeURIComponent(movie_ul
								.attr('m_avg_rate'));
						var countries = decodeURIComponent(movie_ul
								.attr('m_countries'));
						var director_name = decodeURIComponent(movie_ul
								.attr('m_director_name'));
						var cast_name = decodeURIComponent(movie_ul
								.attr('m_cast_name'));
						var detials = "<div class='movie_detials'></div>";
						var title = "<li><span class='movie_det_title'>"
								+ movie_title + "</span></li>";
						var year = "<li><span class='movie_det_year'>" + year
								+ "</span></li>";
						var avg_rate = "<li><span class='movie_det_rate'>评分："
								+ avg_rate + "</span></li>";
						var countries = "<li><span class='movie_det_coun'>"
								+ countries + "</span></li>";
						var director = "<li><span class='movie_det_dir'>导演："
								+ director_name + "</span></li>";
						var cast = "<li><span class='movie_det_cast'>演员："
								+ cast_name + "</span</li>";
						$('#main').append(detials);
						$("div.movie_detials").append(title).append(avg_rate)
								.append(countries).append(director)
								.append(cast);
						var w = $(this).offset().left;
						var h = $(this).offset().top;
						$('div.movie_detials').css("position", "absolute");
						$('div.movie_detials').css("left",
								w + $(this).width() + 3);
						$('div.movie_detials').css("top", h);
					});
	$("img.movie_poster_img").mouseleave(function() {
		$("div.movie_detials").remove();
	})
}

function ratings() {

	$('.rateit').bind('rated reset', function(e) {
		var ri = $(this);
		var params = {
				userRating : ri.rateit('value'),
				movieId	:ri.data('productid')
		};
		$.post('itemAjax/rate', params, function callback(data) {
		}, 'json');
	});

}
