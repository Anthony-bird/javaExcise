<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.4.1/jquery.js"></script>
    <script>
        function a() {
            $.post({
                url: "${pageContext.request.contextPath}/a1",
                data: {"name": $("#username").val()},
                success: function (data, status) {
                    console.log("data=" + data);
                    console.log("status=" + status);
                }
            })
        }
    </script>
</head>
<body>

用户名：<input type="text" id="username" onblur="a()">
</body>
</html>
