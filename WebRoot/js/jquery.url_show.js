function parseurl(url)
{
	if(url == null || url.indexOf("?") == -1)
		return null;
	var qs = url.split("?")[1];
	if(qs.indexOf("=") == -1)
		return null;

	var prop = qs.replace(/&/g, "',").replace(/=/g, ":'")+"'";
	var obj = null;
	var template = "obj = {p}";
	eval(template.replace(/p/g, prop));
	return obj;
}
function gettop(e)
{
	if(e.offsetParent != null)
		return e.offsetTop + gettop(e.offsetParent);
	else
		return e.offsetTop;
}
function getleft(e)
{
	if(e.offsetParent != null)
		return e.offsetLeft + getleft(e.offsetParent);
	else
		return e.offsetLeft;
}

function addrowbnt()
{
	var rowlen = $('tr:eq(0)').children().length;
	var idtd = $("td:nth-child("+rowlen+"n+1)");
	var tdnum = idtd.length;
	var th = $("<td></td>");
	th.append("<button id='addrowbnt' onclick='addrow()'>ROW</button>");
	th.append("<button id='modcolbnt' onclick='modcol()'>COL</button>");
	th.css('width','85px');
	$('th:eq(0)').before(th);
	for(var i = 0; i < tdnum; i++)
	{
		if(idtd[i].innerHTML != "&nbsp;")
		{
			var content = $("<td><button class='modbnt' onclick='modifyitem("+$(idtd[i]).text()+","+(i+1)+")'>MOD</button><button class='delbnt' onclick='deleteitem("+$(idtd[i]).text()+")'>DEL</button></td>");
			$(idtd[i]).before(content);
		}
		else
			$(idtd[i]).before("<td>&nbsp;</td>");
	}
	$("td:nth-child("+(rowlen+1)+"n+1)").css('background','lightgray');
}
function addcachedfunc()
{
	var rowlen = $('tr:eq(0)').children().length;
	var urltd = $("td:nth-child("+rowlen+"n+3)");
	var urlcnt = urltd.length;
	for(var i = 0; i < urlcnt; i++)
	{
		if(urltd[i].innerHTML != "&nbsp;")
		{
			var bnt = $('<button>=></button>');
	//		var top = gettop(urltd[i]) + $(urltd[i]).height();
	//		var left = getleft(urltd[i]);
			var pos = $(urltd[i]).offset();
			var top = 1+pos.top + $('tr:eq('+(i+1)+')').height();
			var left = pos.left;
			
			bnt.attr("onclick", "showcached("+top+","+left+",'"+urltd[i].textContent+"',"+i+")");
			$(urltd[i]).append(bnt);
		}
	}
}
function loadtbl(data,textstatus,xmlhttp)
{
	$('#url_tbl')[0].innerHTML = data;
	mainfunc();
}
function mainfunc()
{	
	//add modify and delete button for each row
	addrowbnt();
	//add cached button for each url
	addcachedfunc();
	//submit search form via ajax and reload table
	$('#searchform').submit(function(e)
	{
		e.preventDefault();
		$.post('/baidu/url_tools/url/reload', $('#searchform').serialize(), function(data,textstatus,xmlhttp)
		{
			loadtbl(data,textstatus,xmlhttp);
		})
	});
	//override click event to table navigation link, going to another page
	$('#tblnav a').click(function(e)
	{
		e.preventDefault();
		var data = parseurl($(this).attr('href'));
		var formdata = $('#searchform').serializeArray();
		for(key in formdata)
			data[formdata[key].name] = formdata[key].value;
		$.post('/baidu/url_tools/url/reload', data, function(data,textstatus,xmlhttp)
		{
			loadtbl(data,textstatus,xmlhttp);
		});
	});
	//override click event for table header link, sorting data
	$('th a').click(function(e)
	{
		e.preventDefault();
		var data = parseurl($(this).attr('href'));
		var formdata = $('#searchform').serializeArray();
		for(key in formdata)
			data[formdata[key].name] = formdata[key].value;
		$.post('/baidu/url_tools/url/reload', data, function(data,textstatus,xmlhttp)
		{
			loadtbl(data,textstatus,xmlhttp);
		});
	});
}
