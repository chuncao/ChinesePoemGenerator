<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
        <script type="text/javascript">
        var isChange = false;

        function change() {
            $("#textWords").val("");
            isChange = true;
        }

        function make() {
            var selectedWords = $("#selectedWords").find("option:selected").text();
            var textWords = $("#textWords").val();
            var words;
            if (textWords.length == 0) {
                if (isChange) {
                    words = selectedWords;
                } else {
                    alert("请选择一项或手动输入");

                    return;
                }
            } else {
                $('#selectedWords')[0].selectedIndex = 0;
                words = textWords;
            }
            var type = $("input[name='type']:checked").val();
            var order = $("input[name='order']:checked").val();

            var data = '{\"words\":\"' + words + '\",\"type\":\"' + type + '\",\"order\":\"' + order + '\"}';

            $.ajax({
                type: "POST", //请求方式  
                url: "index", //请求路径：命名空间是在配置文件中定义。  
                cache: false,
                data: {
                    data: data
                }, //传参  
                dataType: 'json', //返回值类型  
                success: function(json) {
                    $('pre').text(json.poem);
                }
            });
        }
        </script>
    </head>

    <body>
        <form>
            选择：
            <select id="selectedWords" onchange="change()">
                <option disabled selected value>-- 请选择 --</option>
                <option>凯凯王现在有点紧张</option>
                <option>吴同学是要读博的</option>
                <option>交际草今晚翘课了</option>
                <option>赵七天是寝霸</option>
                <option>春哥说大家是小朋友</option>
            </select>
            <br> 输入：
            <input type="text" id="textWords">
            <input type="button" value="作诗" onclick="make()" />
            <br> 字数：
            <input name="type" type="radio" value="5" checked="checked" />五言
            <input name="type" type="radio" value="7" />七言
            <br> 藏的位置：
            <input name="order" type="radio" value="0" checked="checked" />藏头
            <input name="order" type="radio" value="1" />藏尾
            <input name="order" type="radio" value="2" />藏中
            <input name="order" type="radio" value="3" />递增
            <input name="order" type="radio" value="4" />递减
            <br>
            <pre></pre>
        </form>
    </body>

    </html>