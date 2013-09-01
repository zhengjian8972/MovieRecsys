<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<title>电影推荐系统</title>
</head>
<jsp:include page="commen/script.jsp"></jsp:include>
	<body>
		<jsp:include page="commen/header.jsp"></jsp:include>
		
	<div id = "main">
	<div id = "popular" class = "show_movies">
		<h2>最近热门</h2>
		<hr></hr>
		<div id='popular_movies' class='movies_div'>
		 <s:iterator value="popularMovies">
<ul class='movies_ul'>
	<li class='movie_li'
		m_movie_id='<s:property value="movieId"/>'
		m_movie_title='<s:property value="movieTitle"/>'
		m_avg_rate='<s:property value="avgRate"/>'
		m_year='<s:property value="year"/>'
		m_countries='<s:property value="countries"/>'
		m_director_name='<s:property value="directorName"/>'
		m_cast_name='<s:property value="castName"/>'
		m_rate_cnt='<s:property value="rateCnt"/>'
	>
	<ul class='movie_ul'>
	<li><div class='movie_poster'>
	<a class = 'movie_poster_a'  href='detail?movieId=<s:property value="movieId"/>'>
	<img class = 'movie_poster_img' src='images/movie_poster/<s:property value="movieId"/>.jpg'/>
	</a>
	</div></li>
	<li><a class='movie_title' href='detail?movieId=<s:property value="movieId"/>'><s:property value="movieTitle"/></a></li>
	<li><span class='movie_avgrate'>评分：<s:property value="avgRate"/></span></li>
	</ul>
	</li>
	</ul>
 	</s:iterator>
		</div>
	</div>
	<div id = "highrate" class = "show_movies">
		<h2>评分最高</h2>
		<hr></hr>
	<s:iterator value="topMovies">
	<ul class='movies_ul'>
		<li class='movie_li'
			m_movie_id='<s:property value="movieId"/>'
			m_movie_title='<s:property value="movieTitle"/>'
			m_avg_rate='<s:property value="avgRate"/>'
			m_year='<s:property value="year"/>'
			m_countries='<s:property value="countries"/>'
			m_director_name='<s:property value="directorName"/>'
			m_cast_name='<s:property value="castName"/>'
			m_rate_cnt='<s:property value="rateCnt"/>'
		>
		<ul class='movie_ul'>
		<li><div class='movie_poster'>
		<a class = 'movie_poster_a'  href='detail?movieId=<s:property value="movieId"/>'>
		<img class = 'movie_poster_img' src='images/movie_poster/<s:property value="movieId"/>.jpg'/>
		</a>
		</div></li>
		<li><a class='movie_title' href='detail?movieId=<s:property value="movieId"/>'><s:property value="movieTitle"/></a></li>
		<li><span class='movie_avgrate'>评分：<s:property value="avgRate"/></span></li>
		</ul>
		</li>
	</ul>
	</s:iterator>
	</div>
	</div>
		<div><jsp:include page="commen/footer.jsp"></jsp:include></div>
	</body>
</html>
