function radioaction(obj){
	var temp = $("[type='radio']");
	var name = ['rand','stra','syst','clus'];
//	var flag = [0,0,0,0];
	for(var i = 0; i < temp.length; i++)
	{
		if($("input[type='radio'][value='"+i+"']").attr('checked') && $('#'+name[i]+'_para').css('display') == 'none')
		{
			$('#'+name[i]+'_para').slideToggle("slow");
			//$('#'+name[i]+'_para').css('display','block');
//			flag[i] = 1;
		}
		else if($('#'+name[i]+'_para').css('display') != 'none')
		{
			$('#'+name[i]+'_para').slideToggle("slow");
			//$('#'+name[i]+'_para').css('display','none');
//			flag[i] = 0;
		}
	}
}

/*if($(obj).attr('checked') && obj.display=="none")
	$(obj).slideToggle("slow");
else if(obj.display!="none")
	$(obj).slideToggle("slow");
}*/
