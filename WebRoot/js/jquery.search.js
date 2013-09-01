function search()
{
/*	var item = {};
	item['textCol_select'] = $($('#textCol_select option')[$('#textCol_select')[0].selectedIndex]).attr('value');
	item['textCol_inputtext'] = $('#textCol_inputtext').attr('value').trim();

	var ths = $("tr:eq(0) td:gt(2)");
	var thcnt = ths.length;

	for(var i =0; i < thcnt; i++)
	{
		var field = $(ths[i]).text();
		if($("#select_"+field).length)
		{
			var select = $("#select_"+field);
			item[field+'_select'] = $(select.find('option')[select[0].selectedIndex]).attr('value');
		}
		else if($('#'+field+'_from_inputtext').length)
		{
			var from = $("#"+field+"_from_inputtext").attr('value');
			var to = $("#"+field+"_to_inputtext").attr('value');
			item[field+'_from_inputtext'] = from.trim();
			item[field+'_to_inputtext'] = to.trim();
		}
	}*/
	$.post('/baidu/url_tools/url/search', $('#searchform').serialize(), showtbl(result));

}
