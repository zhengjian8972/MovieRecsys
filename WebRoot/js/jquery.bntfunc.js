function deleteitem(id)
{
	$.post("/baidu/url_tools/url/deleteitem", {id:id}, function(result){
		alert(result);
		window.location.href="/baidu/url_tools/index.php";
	});
}
function saveitem(id, rowid)
{
	var savebnt = $("tr:eq("+rowid+") td:eq(0) button:eq(0)");
	var tds = $("tr:eq("+rowid+") td:gt(2)");
	var ths = $("tr:eq(0) th:gt(1)");
	var thcnt = ths.length;
	var data = {id:id};
	for(var i = 0; i < thcnt; i++)
	{
		var field = $(ths[i]).text();
		if($(tds[i]).find('select').length)
		{
			var select = $(tds[i]).find('select');
			var selectedid = select[0].selectedIndex;
			var tmp = $(select.find("option")[selectedid]).attr('value');
			tds[i].textContent = tmp;
			select.remove();
			data[field] = tmp.trim();
		}
		else
		{
			var input = $(tds[i]).find('input');
			var tmp = input.attr('value');
			tds[i].textContent = tmp;
			input.remove();
			data[field] = tmp.trim();
		}
	}
	$.post("/baidu/url_tools/url/modifyitem", data, function(result){
		if(result == '0')
		{
			alert('Modify Error!');
			window.location.href="/baidu/url_tools/index.php";
		}
		else
		{
			var modbnt = $("<button class='modbnt' onclick='modifyitem("+id+","+rowid+")'>MOD</button>");
			savebnt.before(modbnt);
			savebnt.remove();
		}
		alert(result);
	})
	
}
function modifyitem(id, rowid)
{
	var modbnt = $("tr:eq("+rowid+") td:eq(0) button:eq(0)");
	var tds = $("tr:eq("+rowid+") td:gt(2)");
	var ths = $("tr:eq(0) th:gt(1)");
	var thcnt = ths.length;
	
	for(var i = 0; i < thcnt; i++)
	{
		var field = $(ths[i]).text();
		if($("#select_"+field).length)
		{
			var tmp = tds[i].textContent;
			tds[i].textContent="";
			var select = $("#select_"+field).find('select').clone();
			select[0].remove(0)
			select.attr('name', 'mod_select_'+field);
			select.find("option[value='"+tmp+"']").attr('selected','selected');
			$(tds[i]).append(select);
		}
		else
		{
			var tmp = tds[i].textContent;
			tds[i].textContent="";
			var input= $("<input type=text value='"+tmp+"' name='mod_input"+field+"'/>");
			$(tds[i]).append(input);
		}
	}
	var savebnt = $("<button class='savebnt' onclick='saveitem("+id+","+rowid+")'>SAV</button>");
	modbnt.before(savebnt);
	modbnt.remove();
}
function addrow()
{
	$.blockUI({
		message: $('#addrow_layer'),
		css:{width:'600px'}
	})
	$("#addrow_closebnt").click($.unblockUI);
}
$(function()
{
	$('#addrow_submitbnt').click(function(){
		var trs = $('#addrowtbl tr');
		var trcnt = trs.length;
		var data = {};
		for(var i = 0; i < trcnt; i++)
		{
			if($(trs[i]).find('td input').length)
				data[$(trs[i]).find('th').text()] = $(trs[i]).find('td input').attr('value').trim();
			else
			{
				var select = $(trs[i]).find('td select');
				data[$(trs[i]).find('th').text()] = $(select.find('option')[select[0].selectedIndex]).attr('value').trim();
			}
		}
		$.post('/baidu/url_tools/url/addrow', data, function(result){
			alert(result);
			window.location.href='/baidu/url_tools/index.php';
		})
	})
})
function modcol()
{
	var left = document.body.offsetWidth/2-325
	left = (100*left/document.body.offsetWidth)+"%";
	$.blockUI({
		message: $('#modcol_layer'),
		css:{
			width:'650px',
			top:'10%',
			left:left
			}
	})
	$("#modcol_closebnt").click($.unblockUI);
}
function addoption(bnt)
{
	if(bnt.parent().find('.option_input').attr('value').trim() != '')
	{
		var field = $(bnt.parent().find('input')[0]).attr('name');
		var optionname = bnt.parent().find('.option_input').attr('value');
		var div = $("<div class='newoption'></div>");
		div.append("<input type='checkbox' value='"+optionname+"'/><label class='addoptionname'>"+optionname+"</label>");
//		$('#'+field+'_addoptions').append(div[0]);
		bnt.parent().find('.newoptions').append(div[0]);
	}
}
$(function()
{
	$('.addoptionbnt').click(function(e){
			e.preventDefault();
			addoption($(this));
	});
})
$(function()
{
	$('#modcol_addbnt').click(function(){
		var div = $("<div class='addcol'></div>");
		div.append("<label class='colname'>name : </label>");
		var colname = $("<input type='text' class='colname_input'/>");
//		colname.change(function(){
//			$(this).attr('name',$(this).attr('value'));	
//		})
		div.append(colname[0]);
		div.append("<label class='newcoltype'>type :</label>");
		var select = $("<select class='newcoltype_select'>"+
					 "<option value='text'>text</option>"+
					 "<option value='num'>number</option>"+
					 "<option value='select'>select</option>"+
					 "</select>");
		div.append(select[0]);
		select.change(function(){
			if($(this).find('option')[$(this)[0].selectedIndex].value == 'select')
			{	
				var bnt = $("<button class='addoptionbnt'>add option</button>");
				bnt.click(function(e){e.preventDefault();addoption($(this));});
				var text = $("<input type='text' class='option_input'/>");
				var tdiv = "<div class='newoptions'></div>";
				$(this).parent().append(bnt[0]).append(text[0]).append(tdiv);
			}
		})
		$('#modcolform .modcol').last().after(div[0]);
	})
})
function modcol_check(form)
{
	var addcol = form.find('.addcol');
	var cnt = addcol.length;
	for(var i = 0; i < cnt; i++)
	{
		var div = $(addcol[i]);
		var name = div.find('.colname_input').attr('value');
		div.find('.colname_input').attr('name', 'newcolname[]');
		var type = div.find('.newcoltype_select');
		type.attr('name', name+'_type');
		var idx = type[0].selectedIndex;
		if(type.find('option')[idx].value == 'select' )
			if(div.find('.newoptions input[type=checkbox]').length)
				div.find('.newoptions input[type=checkbox]').attr('name',name+'_option[]');
	}
	var modcol = form.find('.modcol');
	cnt = modcol.length;
	for(var i = 0; i < cnt; i++)
	{
		var div = $(modcol[i]);
		var name = div.find('.colname_input').attr('name');
		if($("select[name='"+name+"_select']").length)
			if(div.find('.newoptions input[type=checkbox]').length)
				div.find('.newoptions input[type=checkbox]').attr('name',name+'_option[]');
	}
}
$(function()
{
	$('#modcol_submitbnt').click(function(){
		modcol_check($('#modcolform'));
		
		alert($('#modcolform').serialize().replace(/&/g, '\n'));
		$.post('/baidu/url_tools/url/modcol', $('#modcolform').serialize(), function(data,textstatus,xmlhttp){
			alert(data);
			window.location.href = '/baidu/url_tools/index.php';
		})
	})
})
