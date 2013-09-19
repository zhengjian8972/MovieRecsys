<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
		<title>搜索电影：<s:property value="searchText" /></title>
	</head>
	<jsp:include page="../commen/script.jsp"></jsp:include>
	<body>
		<jsp:include page="../commen/header.jsp"></jsp:include>
		<!-- detail -->
		<div id="wrapper">
			<div id="content">
				<div class="grid-16-8 clearfix">
				<s:iterator value="searchMovie">
					<div class="article">
						<p class="ul"></p>
						<table width="940" height="137">
							<tbody>
								<tr class="item">
									<td width="100" valign="top">

										<a class="nbg" href='detail?movieId=<s:property value="movieId"/>'
											title='<s:property value="movieTitle"/>'> <img
												src='images/movie_poster/<s:property value="movieId"/>.jpg' alt='<s:property value="movieTitle"/>'>
										</a>
									</td>
									<td valign="top">
										<div class="pl2">
											<a class="nounderline" href='detail?movieId=<s:property value="movieId"/>'
												onclick="moreurl(this,{i:'1'})"><span class="nounderline"><s:property value="movieTitle"/> </span>
											</a>
											<p class="pl">
												<div class='info'>
													<li class='find_movie_countries'>地区：<s:property value="countries"/></li>
													<li class='find_movie_genres'>标签：<s:property value="genres"/></li>
													<li class='find_movie_dir'>导演：<s:property value="directorName"/></li>
													<li class='find_movie_cast'>主演：<s:property value="castName"/></li>
												</div>
											</p>
											<div class='find_rate'>
												<li class='find_avgrate'>评分：<s:property value="avgRate"/></li> <span
													class='find_rate_cnt'>(<s:property value="rateCnt"/>)人评价</span>
											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</s:iterator>
				<s:if test="searchMovie != null && searchMovie.size() == 0" >
					<div class="nonemovie" style="font-size: 12px;">
						没有找到与"<s:property value="searchText"/>"相关的内容，可以换个关键词试试。 <a href="home">返回主页</a>
					</div>
				</s:if>
				</div>
			</div>
		</div>
		<div><jsp:include page="../commen/footer.jsp"></jsp:include></div>
	</body>
</html>
