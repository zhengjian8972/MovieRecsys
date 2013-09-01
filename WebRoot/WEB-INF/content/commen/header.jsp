<%@taglib prefix="s" uri="/struts-tags"%>
<div id='header_nav'>
	<a id='return_home' class='navcell' href='home'>首页</a>
	<div id='login_info'>
		<s:if test="#session.USER_NAME==null">
			<a id='login' class='navcell fancybox.ajax' href='login'>登录</a>
			<a id='register' class='navcell fancybox.ajax' href='register'>注册</a>
		</s:if>
		<s:else>
			<a id='profile' class='navcell'
				href='profile?userId=<s:property value="#session.USER_ID"/>'><s:property
					value="#session.USER_NAME" /> </a>
			<a id='logout' class='navcell' href='logout'>退出</a>
		</s:else>
	</div>
</div>

<div id="nav-wrap">
	<div id="nav-primary">
		<div id="nav-search">
			<form action="search" method="get">
				<fieldset>
					<legend>搜索：</legend>
					<label id="inp-query" style="display: block;">电影、电视剧</label>
					<div class="inp">
						<input id="inp-query" name="searchText" size="22" maxlength="60"
							value="" autocomplete="off">
					</div>
					<div class="inp-btn">
						<input type="submit" value="搜索">
					</div>
				</fieldset>
			</form>
		</div> 
	</div>
</div>

<script>
$(".inp").click(function(e) {
if($("#inp-query").val()=="") $("#inp-query").hide();
});
$(".inp").focusout(function(e) {
if($("#inp-query").val()=="") $("#inp-query").show();
});

 </script>
