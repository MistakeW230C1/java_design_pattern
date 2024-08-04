<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="studfunc.jsp"></script>
    <script type="text/javascript">

        function onload()
        {
            select(1);
            var obj = document.getElementById("student");
            addEvent(obj, "click", curobj.update);
        }
    </script>

</head>
<body>
<div><input type="button" id="studedit" value="完善个人信息"/></div>
<div id="content"></div>
</body>
</html>