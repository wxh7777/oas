/* ===================================================
 * jquery.oas.validate.js 
 * 表单验证插件脚本
 * ===================================================
*/
/**
* 需要校验的地方
* 1 登陆窗口的用户名
* 2 资金资金日报的资金填充格
* 3 所有查询界面可以输入文字的地方
* 校验的时机：
* 用户结束录入的时候。
* 校验失败提示：
* 在录入格的旁边显示一个提示，录入错误的地方成为焦点，当用户进入编辑状态时消失，
* 校验规则：
*
*/
(function(window, $){
	var decimalRegex = /^\-?[0-9]*\.?[0-9]*$/,
		textRegex = /^[u4e00-u9fa50-9a-zA-Z]*$/;
	
	var ENTER_KEY = 13,
		ESCAPE_KEY = 27;
	
	var inValidText = $("<div>输入的内容格式错误</div>").css({"position":"absolute","color":"red"});
	
	var $body = $('body'),
		$inputText = $('.form-control.input-text') || $('.input-text');

	if(!$inputText) {
		return;
	}

	$body.on('keyup', '.input-text', editKeyup);

	function editKeyup(evt) {
		var key = evt.which;

		if (key === ESCAPE_KEY) {
			return;
		}

		var $input = $(evt.target),
			val = $input.val(),
			parent = $input.parent(),
			inputBorder = $input.css('border'),
			isValid;

		var inputClass = $input[0].className;
		if (inputClass === 'form-control input-text') {
			isValid = decimalRegex.test(val);
		} else if (inputClass === 'input-text focus') {
			isValid = textRegex.test(val);
		} else {
			return;
		}

		if (!isValid) {
			parent.append(inValidText);
			$input.focus();
			$input.css({"border":"1px solid red"});
		} else {
			inValidText.remove();
			$input.css({"border":"1px solid rgb(59, 180, 242)"});
		}

		if (key === ENTER_KEY) {
			evt.target.blur();
		}
	}

})(window, jQuery)