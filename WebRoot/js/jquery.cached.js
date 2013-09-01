function showcached(top, left, url, i)
{
	if($('iframe').length)
	{
		if($('iframe[id='+i+']').length)
		{
			$('iframe').remove();
			return;
		}
		else
			$('iframe').remove();
	}

	var page = $("<iframe id= '"+i+"' target='"+i+"' width='1024px' height='768px' frameborder='1'></iframe>");
	page.attr('src', url);
	page.css({'background':'white','position':'absolute','z-index':'4'});
	page[0].style.top = top+"px";
	page[0].style.left = left+"px";
	$('#iframe').append(page);
}
