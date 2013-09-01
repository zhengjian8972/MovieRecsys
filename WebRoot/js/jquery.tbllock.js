(function($)
 {
 	$.extend($.fn,
		{
			tablelock:function(options)
			{
				var tl=$.extend(
				{
					table:'locktable',
					lockrow:1,
					lockcol:1,
					width:'100%',
					height:'100%',
					lockrowcss:'lockrowbg',
					lockcolcss:'lockcolbg'
				}, options);
				var tableid=tl.table;
				var table=$('#'+tableid);
				var rowspan=function(tr){}
				if(table)
				{
					var box=$("<div id='divboxing' class='divboxing'></div>").scroll(function()
						{
							$('.lockrow').css('top', $(this).scrollTop()+'px');
							$('.lockcol').css('left', $(this).scrollLeft()+'px');
						})
					box.css('width',tl.width).css('height', tl.height);
					table.wrap(box);
					table.addClass('tblock');
//					var crossnum=tl.lockrow*tl.lockcol;
					if(tl.lockrow > 0)
					{
						var tr;
						for(var r=0; r<tl.lockrow; ++r)
						{
							tr=table.find('tr:eq('+r+')');
							var colnum = tr.find('td, th').length;
							for(var c=0; c<colnum; c++)
							{
								tr.find('td:eq('+c+'), th:eq('+c+')').addClass('lockrow').addClass(tl.lockrowcss);
							}
						}
					}
					if(tl.lockcol > 0)
					{
						var rownum = $('#'+tableid+' tr').length;
						var tr;
						for(var r=0; r<rownum; r++)
						{
							tr = table.find('tr:eq('+r+')');
							for(var c=0; c<tl.lockcol; c++)
							{
								tr.find('td:eq('+c+'), th:eq('+c+')').addClass('lockcol').addClass(tl.lockcolcss);
							}
						}
					}
					if(tl.lockcol*tl.lockrow > 0)
					{
						for(var r=0; r < tl.lockrow; r++)
							for(var c=0; c < tl.lockcol; c++)
								table.find('tr:eq('+r+')').find('th:eq('+c+'), td:eq('+c+')').addClass('lockcross');
					}
				}
				else
					alert('no such table');
			}
		})
 }
)(jQuery)
