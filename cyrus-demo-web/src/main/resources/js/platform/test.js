$(document).ready(
		function() {
			$("#submit").click(
					function() { // “登录”按钮单击事件
						alert("click!");

						var username = $("#username").val(); // 获取用户名称

						var password = $("#password").val(); // 获取输入密码

						var data = {
							'username' : username,
							'password' : password
						},

						// 开始发送数据
						alert
						("data = " + JSON.stringify(data) + " ,URL = " + JSON
								.stringify(__user_ctx + "/get-user"));
						$.ajax({ // 请求登录处理页
							type : 'POST',
							contentType : 'application/json;charset=utf-8',
							url : __user_ctx + "/get-user", // 登录处理页
							dataType : "json",
							// 传送请求数据
							data : JSON.stringify(data),
							success : function(username) { // 登录成功后返回的数据
								alert("success!");
							},
							error : function(url) { // 登录成功后返回的数据
								alert("error = " + JSON.stringify(url));
							}
						})
					})
		})