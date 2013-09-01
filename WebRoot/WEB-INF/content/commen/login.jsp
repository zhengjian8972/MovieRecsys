<!DOCTYPE HTML>


<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>电影推荐系统</title>
<style type="text/css">
/* Reset */
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td { margin:0; padding:0; }
table { border-collapse:collapse; border-spacing:0; }
fieldset,img { border:0; }
address,caption,cite,code,dfn,em,strong,th,var { font-style:normal; font-weight:normal; }
ol,ul { list-style:none; }
caption,th { text-align:left; }
h1,h2,h3,h4,h5,h6 { font-size:100%; font-weight:normal; }
q:before,q:after { content:''; }
abbr,acronym { border:0; }

/* Font,  Link & Container */
body { font:12px/1.6 arial,helvetica,sans-serif; }
a:active { color:#fff;text-decoration:none;background:#f93; }
button { cursor:pointer;line-height:1.2; }
.mod { width:100%; }
.hd:after, .bd:after, .ft:after, .mod:after {content:'\0020';display:block;clear:both;height:0; }
.error-tip { margin-left:10px; }
.error-tip, .error { color:#fe2617; }

/* Layout */
.article { float:left;width:360px; }

h1 { color:#494949;display:block;font-size:25px;font-weight:bold;line-height:1.1;margin:0;padding:0 0 30px;word-wrap:break-word; }

/* form */
.item { clear:both;margin:15px 0;zoom:1; }
label { display: inline-block; float:left; margin-right: 15px; text-align: right; width: 60px; font-size: 14px; line-height: 30px; vertical-align: baseline }
.remember { cursor: pointer; font-size: 12px; display: inline; width: auto; text-align: left; float: none; margin: 0; color: #666 }
.item-captcha input,
.basic-input { width: 200px; padding: 5px; height: 18px; font-size: 14px;vertical-align:middle; -moz-border-radius: 3px; -webkit-border-radius: 3px; border-radius: 3px; border: 1px solid #c9c9c9 }
.item-captcha input:focus,
.basic-input:focus { border: 1px solid #a9a9a9 }
.item-captcha input { width:100px; }
.item-captcha .pl { color:#666; }
#login_submitbnt { cursor: pointer;color: #ffffff;background: #3fa156; border: 1px solid #528641; font-size: 14px; font-weight: bold; padding:6px 26px; border-radius: 3px; -moz-border-radius: 3px; -webkit-border-radius: 3px; *width: 100px;*height:30px; }
#login_submitbnt:hover { background-color:#4fca6c;border-color:#6aad54; }
#login_submitbnt:active { background-color:#3fa156;border-color:#528641; }
#item-error { padding-left:75px; }

body { -webkit-text-size-adjust: none;-webkit-touch-callout: none;-webkit-tap-highlight-color: transparent; }
</style>
</head>

<body >
  <div class="article">
    <div class="item">
        <label>帐号</label>
        <input id="login_user_id" name="username" type="text" class="basic-input" maxlength="60"  tabindex="1"/>
    </div>
    <div class="item">
        <label>密码</label>
        <input id="login_pwd" name="pwd" type="password" class="basic-input" maxlength="20" tabindex="2"/>
    </div>
    <div class="item">
        <label>&nbsp;</label>
        <p class="remember">
            <input type="checkbox" id="remember" name="remember" tabindex="3"/>
            <label for="remember" class="remember">下次自动登录</label>
        </p>
    </div>
    <div class="item">
        <label>&nbsp;</label>
        <input type="submit" value="登录" name="user_login" id="login_submitbnt" tabindex="4"/>
    </div>
</div>
</body>
</html>


