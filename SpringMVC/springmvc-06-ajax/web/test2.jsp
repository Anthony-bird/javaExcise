<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.4.1/jquery.js"></script>

<script>
    $(function () {
        $("#btn").click(function () {
            $.post("${pageContext.request.contextPath}/a2", function (data) {
                //console.log(data);
                var html = "";

                for (var i = 0; i < data.length; i++) {
                    html += "<tr>" +
                        "<td>" + data[i].name + "<td>" +
                        "<td>" + data[i].age + "<td>" +
                        "<td>" + data[i].sex + "<td>" +
                        "<tr>"
                }
                $("#content").html(html);
            });
        })
    });
</script>
<body>
<input type="button" id="btn" value="加载数据"/>
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">
    </tbody>
</table>

</body>
</html>
