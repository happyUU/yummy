Calendar = (function(){
var datepicker=null,
_target=null,
rangeDate='';


function calendar(){
this.init.apply(this,arguments);
}
calendar.prototype={
		init : function() {
			var self = this;
			// 初始化全局属性
			self.tmo = null;
			self.month = new Date().getFullYear() * 12 + new Date().getMonth();
			self.day = 1;
			self.dateValue = null;
			self.datemap = {
				'before' : new Date().setDate(new Date().getDate() - 10000),
				'after' : new Date().setDate(new Date().getDate() + 10000),
				'yesterday' : new Date().setDate(new Date().getDate() - 1),
				'today' : new Date(),
				'tomorrow' : new Date().setDate(new Date().getDate() + 1)
			};

		},
		setOption : function(config) {
			// TODO 设置默认参数
			var self = this, config = config || {}, k, defaults = {
				panels : 1,
				width : 210,
				beginYear : 1960,
				endYear : 2020,
				tip : '', // 默认为空
				revise : [ 0, 0 ],
				startDay : 'today',
				endDay : 'after',
				selectedDay : 'today',
				selectedTip : '入住',
				nextInput : '',
				prevInput : '',
				callback : function() {
				}
			};
			self.options = {};
			self.festival = '0000-01-01:元旦,0000-05-01:劳动,0000-10-01:国庆,2015-02-19:春节,2015-04-05:清明,2015-06-20:端午,2015-09-27:中秋,2015-10-21:重阳,2016-02-07:除夕,2016-02-08:春节,2016-02-22:元宵,2016-03-04:清明,2016-05-09:端午,2016-09-15:中秋,2016-10-09:重阳,2017-01-27:除夕,2017-01-28:春节,2017-01-11:元宵,2017-04-04:清明,2017-05-30:端午,2017-10-04:中秋,2017-10-28:重阳';
			for (k in defaults) {
				// 检查自定义参数，若没有则使用默认参数
				self.options[k] = config[k] !== undefined ? config[k]
						: defaults[k];
			}
			return this;
		},
		// 绘制单个日历面板
		draw : function(n) {
			var self = this, tmpWeeks = '', tmpDays = '';
			for (var i = 0; i < 7; i++) {
				tmpWeeks += '<span>' + '日一二三四五六'.charAt(i) + '</span>';
			}
			for (var i = 0; i < 42; i++) {
				tmpDays += '<a class="disabled" href="javascript:;"></a>';
			}

			var currTime = self.month, currYear = parseInt(currTime / 12), currMon = currTime
					- currYear * 12 + 1, calendarTitle = '<div class="calendarTitle"><a href="javascript:;" class="monSelect"><em class="currYear">'
					+ currYear
					+ '年</em> <em class="currMon">'
					+ currMon
					+ '月</em></a><div class="monSelectBox" style="display: none"></div></div>', calendarWeek = '<p class="week">'
					+ tmpWeeks + '</p>', calendarDays = '<div class="days">'
					+ tmpDays + '</div>';
			var calendarCon = [
					'<form class="calendarForm" name="calendarForm">',
					calendarTitle, calendarWeek, calendarDays, '</form>' ]
					.join('');
			self.panel.append(calendarCon);
			var _form = self.panel.find('.calendarForm')[n];
			_form.style.width = self.options.width + 'px';
			_form = $(_form);
			self.bindData(currTime, _form);
			return this;
		},
		// 绑定数据
		bindData : function(currTime, form) {
			var self = this, today = new Date().toDateString(), This = self, tmpDate = '', currYear = parseInt(currTime / 12), currMon = currTime
					- currYear * 12 + 1, currday = currTime % 12, dateArray = self
					.getMonthViewDateArray(currYear, currMon - 1), daysCon = $(
					form).find('.days'), theDate = currYear + '-'
					+ self.formatDate(currMon) + '-'
					+ self.formatDate(self.day)
			tds = daysCon.find('a');

			if ('today,yesterday,tomorrow,after,before'
					.indexOf(self.options.selectedDay) > -1) {
				selectedDayTime = self.datemap[self.options.selectedDay]
						.toDateString();
			} else {
				selectedDayTime = self.format2Day(self.options.selectedDay)
						.toDateString();
			}

			var festival = self.festival.replace(/0000/g, currYear.toString())
					.split(',');
			daysCon.off('click');
			for (var i = 0; i < tds.length; i++) {
				if (tds[i].className.indexOf('current') > -1) {
					tds[i].className.replace('current', '');
				}
				if (i > dateArray.length - 1)
					continue;
				if (dateArray[i]) {
					var currDate = currYear + '-' + self.formatDate(currMon)
							+ '-' + self.formatDate(dateArray[i]), currDateTime = self
							.format2Day(currDate).toDateString();

					tds[i].setAttribute('data-value', currDate);
					tds[i].innerHTML = dateArray[i] || '';
					// 添加节日
					for (var k = festival.length - 1; k >= 0; k--) {
						tmpDate = festival[k].split(':');
						if (tmpDate[0].indexOf(currDate) > -1) {
							tds[i].innerHTML = tmpDate[1];
							$(tds[i]).addClass('festival');
						}
					}
					// 添加当前选择天

					if (currDate == theDate) {
						$(tds[i]).addClass('current');
						tds[i].innerHTML = dateArray[i] + '<br/>'
								+ self.options.selectedTip;
					}
					// 添加今天
					if (currDateTime == today) {
						$(tds[i]).addClass('today');
						tds[i].innerHTML = '今天'
					}
					self.setEnable(tds[i]);
				}
			}
			// 点击日历控件选取日期
			daysCon
					.on(
							'click',
							function(e) {
								e.stopPropagation();
								if (_target
										&& !e.target.className
												.indexOf('disabled') > -1) {
									self.dateValue = _target.value = e.target
											.getAttribute('data-value');
									This.hide(This);
									// 添加回调函数
									if (typeof This.options.callback === 'function') {
										This.options.callback.call(This,
												arguments);
									}
									var nextInput = document
											.getElementById(This.options.nextInput), nextDate = '', prevInput = document
											.getElementById(This.options.prevInput);
									if (nextInput
											&& nextInput.className
													.indexOf('widget_timer') > -1) {
										nextInput.rangeDate = _target.value;
										nextDate = new Date(This.format2Day(
												_target.value, 1));
										nextInput.value = nextDate
												.getFullYear()
												+ '-'
												+ This.formatDate(nextDate
														.getMonth() + 1)
												+ '-'
												+ This.formatDate(nextDate
														.getDate());
										$(nextInput).click();
									} else if (nextInput) {
										$(nextInput).click();
									} else if (prevInput
											&& !prevInput.className
													.indexOf('widget_timer') > -1) {
										prevInput.click();
									}

								}
							})
			// 选择年份和月份
			form.find('.monSelect').off('click');
			form
					.find('.monSelect')
					.on(
							'click',
							function(e) {
								e.stopPropagation();
								var box = $(this).next(), df = '';
								box
										.html('<div class="yearBox"></div><div class="monthBox"></div><div class="tc"><input type="button" value="确定"></div>');
								for (var i = self.options.beginYear; i <= self.options.endYear; i++) {
									df += '<span>' + i + '</span>';
								}
								box.find('.yearBox').html(df);
								box
										.find('.monthBox')
										.html(
												'<span>1月</span><span>2月</span><span>3月</span><span>4月</span><span>5月</span><span>6月</span><span>7月</span><span>8月</span><span>9月</span><span>10月</span><span>11月</span><span>12月</span>');
								self.setYearOrMonth(box);
								box.toggle();
							})

			return this;

		},
		// 设定日期范围
		setEnable : function(t) {
			var self = this, dateValue = t.getAttribute('data-value'), dayCount = self
					.format2Day(dateValue);
			t = $(t);

			// TODO 判断日期范围的各种情况，有待优化
			var start, end;
			// 结束日期是以今天为起点的数字
			if (typeof self.options.endDay == 'number') {
				if (typeof self.options.startDay == 'string'
						&& self.options.startDay.indexOf('-') == -1) {
					start = self.datemap[self.options.startDay];
					end = new Date().setDate(new Date().getDate()
							+ self.options.endDay);
				} else if (typeof self.options.startDay == 'string') {
					start = self.format2Day(self.options.startDay);
					end = new Date().setDate(new Date().getDate()
							+ self.options.endDay);
				}
			} else {
				// 两个都是yyyy-mm-dd格式的日期
				if (self.options.startDay.indexOf('-') > -1
						&& self.options.endDay.indexOf('-') > -1) {
					start = self.format2Day(self.options.startDay);
					end = self.format2Day(self.options.endDay);
				}
				// 开始日期是yyyy-mm-dd格式的日期
				else if (self.options.startDay.indexOf('-') > -1
						&& self.options.endDay.indexOf('-') == -1) {
					start = self.format2Day(self.options.startDay);
					end = self.datemap[self.options.endDay];
				}
				// 结束日期是yyyy-mm-dd格式的日期
				else if (self.options.startDay.indexOf('-') == -1
						&& self.options.endDay.indexOf('-') > -1) {
					start = self.datemap[self.options.startDay];
					end = self.format2Day(self.options.endDay);
				}
				// 两个都是预置的日期
				else {
					start = self.datemap[self.options.startDay];
					end = self.datemap[self.options.endDay];
				}
			}
			// 设置下一个日历控件的开始值是当前控件值的第二天
			if (_target && _target.rangeDate) {
				if (_target.rangeDate.indexOf('-') > -1) {
					start = self.format2Day(_target.rangeDate, 1);
				}
			}
			if (dayCount >= start && dayCount <= end) {
				t.removeClass('disabled');
			}

		},
		/**
		 * 创建日历容器
		 */
		createCalendarBox : function() {
			if ($('#calendarWarpper').length > 0) {
				$('#calendarWarpper').css(
						{
							width : (_target.options.width + 1)
									* _target.options.panels + 'px'
						});
				return;
			}
			var self = this, calendarWarpper = document.createElement('div'), calendarBox = document
					.createElement('div');

			calendarWarpper.id = 'calendarWarpper';
			$(calendarWarpper).css({
				width : (self.options.width + 1) * self.options.panels + 'px'
			});
			calendarBox.id = 'calendarPanel';
			calendarBox = $(calendarBox);
			calendarBox.css({
				width : '100%',
				zIndex : 2
			});

			if (!-[ 1, ] && /msie 6/.test(navigator.userAgent.toLowerCase())) {
				var calendarIframe = document.createElement('div');
				calendarIframe.id = 'calendarIframe';
				calendarIframe.innerHTML = '<iframe style="width:100%;height:100%;filter:alpha(opacity=0)"></iframe>';
				calendarWarpper.appendChild(calendarIframe);
			}
			calendarWarpper.appendChild(calendarBox[0]);
			self.panel = calendarBox;
			self.calendarWarpper = $(calendarWarpper);
			document.body.appendChild(calendarWarpper);
			return this;
		},
		// TODO 填充日历面板
		fillPanel : function() {
			var self = this;
			var tmpStr = '<a class="preYear">&lt;&lt;</a><a class="preMon">&lt;</a><a class="nextMon">&gt;</a><a class="nextYear">&gt;&gt;</a>';
			self.panel[0].innerHTML = tmpStr;
			self.bindEvent();
			for (var i = 0, len = self.options.panels; i < len; i++) {
				self.draw(i);
			}
			return this;
		},
		// TODO 绑定事件
		bindEvent : function() {
			var self = this;
			var preMon = self.panel.find('.preMon'), nextMon = self.panel
					.find('.nextMon'), preYear = self.panel.find('.preYear'), nextYear = self.panel
					.find('.nextYear');
			preMon.off('click');
			nextMon.off('click');
			preYear.off('click');
			nextYear.off('click');
			preMon.on('click', function(e) {
				e.stopPropagation();
				self.goPrevMonth();
			});
			nextMon.on('click', function(e) {
				e.stopPropagation();
				self.goNextMonth();
			});
			preYear.on('click', function(e) {
				e.stopPropagation();
				self.goPreYear();
			});
			nextYear.on('click', function(e) {
				e.stopPropagation();
				self.goNextYear();
			});

			return this;
		},
		// TODO 设置年份和月份
		setYearOrMonth : function(els) {
			var self = this, tempArr = [];
			els.off('click');
			els.on('click', function(e) {
				e.stopPropagation();
				if (e.target.tagName === 'SPAN') {
					if (e.target.innerHTML.length == 4) {
						tempArr[0] = e.target.innerHTML;
						els.find('.yearBox').find('span').removeClass(
								'selected');

					} else if (e.target.innerHTML.length < 4) {
						tempArr[1] = e.target.innerHTML;
						els.find('.monthBox').find('span').removeClass(
								'selected');
					}
					e.target.className = e.target.className + ' selected';
				} else if (e.target.tagName.toLowerCase() === "input") {
					if (tempArr[0] && tempArr[1]) {
						self.month = parseInt(tempArr[0]) * 12
								+ parseInt(tempArr[1]) - 1;
						self.fillPanel();
						els.hide();
					}
				}
			})

		},
		// TODO 显示前一月
		goPrevMonth : function() {
			var self = this;
			if (self.month <= self.options.beginYear * 12) {
				return;
			}
			self.month--;
			self.fillPanel();
			return this;
		},
		// TODO 显示后一月
		goNextMonth : function() {
			var self = this;
			if (self.month >= self.options.endYear * 12 + 11) {
				return;
			}
			self.month++;
			self.fillPanel();
			return this;
		},
		// TODO 显示前一年
		goPreYear : function() {
			var self = this;
			if (parseInt(self.month / 12) <= self.options.beginYear) {
				return;
			}
			self.month -= 12;
			self.fillPanel();
			return this;
		},
		// TODO 显示后一年
		goNextYear : function() {
			var self = this;
			if (parseInt(self.month / 12) >= self.options.endYear) {
				return;
			}
			self.month += 12;
			self.fillPanel();
			return this;
		},
		// 生成星期对应天数数组
		getMonthViewDateArray : function(y, m) {
			var dateArray = new Array(42);
			var dayOfFirstDate = new Date(y, m, 1).getDay();
			var dateCountOfMonth = new Date(y, m + 1, 0).getDate();
			for (var i = 0; i < dateCountOfMonth; i++) {
				dateArray[i + dayOfFirstDate] = i + 1;
			}
			return dateArray;
		},
		// 给某对象的某事件增加处理函数
		AddFunToObj : function() {
			var self = this;
			var This = self;
			$(document).off('click');
			$(document).on('click', function(e) {
				e.stopPropagation();
				This.onBlr();
			});
		},
		show : function(target) {
			var self = this;
			if (target.value != target.options.tip && target.value.length == 10) {
				var tmpYear = parseInt(target.value.substring(0, 4)), tmpDay = parseInt(target.value
						.substring(8, 10)), tmpMon = parseInt(target.value
						.substr(5, 2)) - 1;
				self.month = tmpYear * 12 + tmpMon;
				self.day = tmpDay;
			} else {
				target.value = '';
			}
			self.createCalendarBox();
			self.calendarWarpper.css({
				left : $(target).offset().left + target.options.revise[0]
						+ "px",
				top : $(target).offset().top + $(target).height()
						+ target.options.revise[1] + "px",
				display : 'block'
			});

			self.fillPanel();
			self.bindEvent();
			// 为document增加onclick处理函数的函数
			self.AddFunToObj();
			return this;
		},
		onBlr : function() {
			var self = this;
			var This = self;
			self.tmo = setTimeout(function() {
				This.hide(This);
			}, 150);
			return this;
		},
		hide : function(scope) {
			scope.calendarWarpper[0].style.display = "none";
			if (_target.value == '') {
				_target.value = _target.options.tip;
			}
		},
		// 格式化日期
		formatDate : function(n) {
			return n < 10 ? '0' + n : n;
		},
		// 把时间变成天数
		format2Day : function(date, n) {
			var tmpDate = date.split('-');
			if (typeof n === 'number') {
				var d = new Date(tmpDate[0], tmpDate[1] - 1, tmpDate[2], 23,
						59, 59);
				return new Date(d.getTime() + n * 86400000);
			} else {
				return new Date(tmpDate[0], tmpDate[1] - 1, tmpDate[2], 23, 59,
						59);
			}
		}
	}

	return {
		show : function(target) {
			var target = $(target)[0], options, config;
			_target = target;
			config = target.getAttribute('config');
			options = config == null ? arguments[1] == undefined ? {}
					: arguments[1] : eval("(" + config + ")");
			if (datepicker == null) {
				datepicker = new calendar();
			}
			datepicker.setOption(options);
			_target.options = datepicker.options;
			datepicker.show(target);
			$(target).on('blur', function() {
				if (target.value == '') {
					target.value = target.options.tip;
				}
			})
		}
	}

})()

window.onload = function() {
	var timeControl = $('.widget_timer');
	if (timeControl.length > 0) {
		timeControl.each(function() {
			if (this.value == 'today') {
				var date = new Date();
				this.value = date.getFullYear() + '-' + (date.getMonth() + 1)
						+ '-' + date.getDate();
			}
			$(this).on('click', function(e) {
				Calendar.show(this);
				e.stopPropagation();
			})
			$(this).next().on('click', function(e) {
				Calendar.show($(this).prev()[0]);
				e.stopPropagation();
			})
		})
	}
}
