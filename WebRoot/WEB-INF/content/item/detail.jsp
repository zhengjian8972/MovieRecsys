<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<title>电影主页</title>
</head>
<jsp:include page="../commen/script.jsp"></jsp:include>
<body>
	<jsp:include page="../commen/header.jsp"></jsp:include>
	<!-- detail -->
	<s:iterator value="currentMovie">
		<div class='find_left'></div>
		<div class='find_main'>
			<h1 class='find_title'>
				<span class='find_movie_title'><s:property value="movieTitle" />
				</span>
			</h1>
			<div class='article'>
				<div class='poster'>
					<img class='movie_poster'
						src='images/movie_poster/<s:property value="movieId"/>.jpg' />
				</div>
				<div class='info'>
					<li class='find_movie_countries'>地区：<s:property
							value="countries" /></li>
					<li class='find_movie_genres'>标签：<s:property value="genres" />
					</li>
					<li class='find_movie_dir'>导演：<s:property value="directorName" />
					</li>
					<li class='find_movie_cast'>主演：<s:property value="castName" />
					</li>
				</div>
				<div class='find_rate'>
					<li class='find_avgrate'>评分：
						<div class="rateit"
							data-rateit-value="<s:property value="avgRate" />"
							data-rateit-ispreset="true" data-rateit-readonly="true"></div> <s:property
							value="avgRate" /></li> <span class='find_rate_cnt'>(<s:property
							value="rateCnt" />)人评价</span>
				</div>
			</div>

			<!-- 评分 -->
			<div id="interest_sect_level">
				<s:if test="#session.USER_NAME==null">
					<!-- 没有评分  点击登录-->
				</s:if>
				<s:else>
					<s:if test="userRating!=0">
				看过这部电影： 
				</s:if>
					<s:else>
				评价： 
				</s:else>
					<div class="rateit" data-rateit-step="1"
						data-productid="<s:property value="movieId"/>"
						data-rateit-value="<s:property value="userRating"/>"
						data-rateit-ispreset="true" data-rateit-readonly="false"></div>
				</s:else>
			</div>

			<div class='find_movie_summary'>
				<h2 class=''>剧情简介</h2>
				<span class='movie_summary'><s:property value="summary" /> </span>
			</div>

			<div class='find_movie_similar'>
				<h2 class=''>看过这部电影的人也喜欢......</h2>

				<s:iterator value="similarMovies">
					<ul class='movies_ul'>
						<li class='movie_li'>
							<ul class='movie_ul'>
								<li><div class='movie_poster'>
										<a class='movie_poster_a'
											href='detail?movieId=<s:property value="movieId"/>'> <img
											class='movie_poster_img'
											src='images/movie_poster/<s:property value="movieId"/>.jpg' />
										</a>
									</div></li>
								<li><a class='movie_title'
									href='item/detail/<s:property value="movieId"/>'><s:property
											value="movieTitle" /> </a></li>
							</ul>
						</li>
					</ul>
				</s:iterator>
			</div>

		</div>
	</s:iterator>

	<div id="subject-others-interests" class="aside">
		<h2>
			谁在看这部电影&nbsp; ·&nbsp;·&nbsp;·&nbsp; <span
				class="subject-others-interests-ft"> <s:property
					value="watchedUsers.size()" />人看过 </span>
		</h2>


		<ul>
			<s:subset source="watchedUsers" start="0" count="12">
				<s:iterator>
					<li><a href="profile?userId=<s:property value="userId"/>"
						class="others-interest-avatar"> <img
							src="images/user_normal.jpg" class="pil"
							alt="<s:property value="userName"/>"> </a>
						<div class="others-interest-info">
							<a href="profile?userId=<s:property value="userId"/>"><s:property
									value="userName" /> </a>
							<div>
								<s:property value="ratingDate" />
								看过
								<div>
									评分：
									<div class="rateit"
										data-rateit-value="<s:property value="rating" />"
										data-rateit-ispreset="true" data-rateit-readonly="true"></div>
									<s:property value="rating" />
								</div>
							</div>
						</div>
					</li>
				</s:iterator>
			</s:subset>
		</ul>
	</div>

	<div><jsp:include page="../commen/footer.jsp"></jsp:include></div>
</body>
</html>
