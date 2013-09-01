<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<title><s:property value="userName" />
</title>
</head>
<jsp:include page="../commen/script.jsp"></jsp:include>
<body>
	<jsp:include page="../commen/header.jsp"></jsp:include>
	<!-- profile -->
	<div id='personal'>
		<span class="person_title"><s:property value="userName" />&nbsp;的电影主页
		</span>
		<div id="watched" class="person_movies">
			<h2>
				看过 &nbsp; ·&nbsp;·&nbsp;·&nbsp;(
				<s:property value="watchedNum" />
				)部
			</h2>
			<hr></hr>
			<div class='movies_div'>
				<s:subset source="watchedMovies" start="0" count="12">
					<s:iterator>
						<ul class='movies_ul'>
							<li class='movie_li2'>
								<ul class='movie_ul'>
									<li><div class='movie_poster'>
											<a class='movie_poster_a'
												href='detail?movieId=<s:property value="movieId"/>'> <img
												class='movie_poster_img'
												src='images/movie_poster/<s:property value="movieId"/>.jpg' />
											</a>
										</div></li>
									<li><a class='movie_title'
										href='detail?movieId=<s:property value="movieId"/>'><s:property
												value="movieTitle" /> </a></li>
									<li><span class='movie_avgrate'>评分：<s:property
												value="avgRate" /> </span></li>
								</ul>
							</li>
						</ul>
					</s:iterator>
				</s:subset>
			</div>
		</div>

		<div id="recommends" class="person_movies">
			<h2>推荐电影 &nbsp; ·&nbsp;·&nbsp;·&nbsp;</h2>
			<hr></hr>
			<div class='movies_div'>
				<s:subset source="recommendMovies" start="0" count="24">
					<s:iterator>
						<ul class='movies_ul'>
							<li class='movie_li2'>
								<ul class='movie_ul'>
									<li><div class='movie_poster'>
											<a class='movie_poster_a'
												href='detail?movieId=<s:property value="movieId"/>'> <img
												class='movie_poster_img'
												src='images/movie_poster/<s:property value="movieId"/>.jpg' />
											</a>
										</div></li>
									<li><a class='movie_title'
										href='detail?movieId=<s:property value="movieId"/>'><s:property
												value="movieTitle" /> </a></li>
								</ul>
							</li>
						</ul>
					</s:iterator>
				</s:subset>
			</div>
		</div>
	</div>

	<div id='personal_right'>
		<h2 id='top'>电影Top20</h2>

		<div id="billboard">
			<table>
				<s:iterator value="top20Movie" status="st">
					<tr>
						<td class="order"><s:property value="#st.count" />
						</td>
						<td class="title"><a
							href='detail?movieId=<s:property value="movieId"/>'><s:property
									value="movieTitle" /> </a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>

	</div>
	<div class='spacer'></div>
	<div><jsp:include page="../commen/footer.jsp"></jsp:include></div>
</body>
</html>
