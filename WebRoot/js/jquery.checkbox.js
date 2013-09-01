$(document).ready(function()
{
	function selectall()
	{
		$(':checkbox').attr('checked','true');
	}
	function inverse()
	{
		var checkboxtrue = $(":checkbox[checked='true']");
		var checkboxfalse = $(":checkbox[checked='false']");
		checkboxtrue.attr('checked', 'false');
		checkboxfalse.attr('checked', 'true');
	}


	var fields = $("th:gt(1)");
	var fieldcnt = fields.length;

	for(var i = 0; i < fieldcnt; i++)
	{
		$(fields[i].children).wrap("<nobr></nobr>");
		var tmp = $("<input type='checkbox' name='selectfield[]' value='"+$(fields[i].children).children().text()+"'/>");
		$(fields[i].children).append(tmp);
	}

	$('#main').wrap("<form action='/baidu/sfa_tools/tbl/sample"+location.search+"' method='post'></form>");
	var selectallbnt = $("<button id='selectallbnt' onclick='selectall()'>");
	var inversebnt = $("<button id='inversebnt' onclick='inverse()'>");
});
