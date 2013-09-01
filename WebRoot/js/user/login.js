function login_regis() {
	$('#register')
			.fancybox(
					
					{
						'scrolling' : false,
						'titleShow' : false,
						'afterShow' : function() {
							$('#register_submitbnt')
									.click(
											function(e) {
												e.preventDefault();
												$('#reg_errinfo').remove();
												if ($('input[name=pwd1]').val() != $(
														'input[name=pwd2]')
														.val()){
													var errinfo = "<span id='reg_errinfo' style='color:#fe2617; margin-left:20px'>密码不一致</span>";
													$('#register_submitbnt').parent().append(errinfo);
												}
												else {
													var userId = $('#register_user_id').val();
													var userName = $('#register_user_name').val();
													var pwd = $('#register_pwd').val();
													$
															.post(
																	'registerAjax/check',
																	{
																		userId : userId,
																		userName : userName,
																		pwd : pwd
																	},
																	function(
																			result) {
																		if (result == 'error') {
																			var errinfo = "<span id='reg_errinfo' style='color:#fe2617; margin-left:20px'>用户名已被占用</span>";
																			$('#register_submitbnt').parent().append(errinfo);
																		} else if (result == 'success')
																			window.location
																					.reload();

																	});
												}
											});
						},
						'onCancel' : function() {
						}
					});

	$('#login').fancybox({
		'scrolling' : false,
		'titleShow' : false,
		'afterShow' : function() {
			$('#login_submitbnt').click(function(e) {
				e.preventDefault();
				$('#login_errinfo').remove();
				var username = $('#login_user_id').val();
				var pwd = $('#login_pwd').val();
				$.post('loginAjax/check', {
					userId : username,
					password : pwd
				}, function callback (result) {
					if (result == 'success')
						window.location.reload();
					else if (result == 'none') {
						var errinfo = "<span id='login_errinfo' style='color:#fe2617; margin-left:20px'>用户名不存在</span>";
						$('#login_submitbnt').parent().append(errinfo);
					} else if (result == 'error') {
						alert("hes");
						var errinfo = "<span id='login_errinfo' style='color:#fe2617; margin-left:20px'>密码不正确</span>";
						$('#login_submitbnt').parent().append(errinfo);
					}
				},
				'json');
			});
		}
	});
}
