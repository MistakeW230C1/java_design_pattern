<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="studfunc.jsp"></script>
    <script type="text/javascript">

        var curobj = null;
var xmlHtpRq = new ActiveXObject("Microsoft.XMLHTTP"); // 建立Ajax异步通讯对象
// 为obj组件注册type(如click) 消息.响应函数是fn
function select(
    type
) {
    switch (type) {
        case 1:
            curObj = new StudObj();
            break
        case 2:
            curObj = new TeacherObj();
            break
    }
}

function StudObj() {
}

StudObj.prototyp.update = function (e) {
    url = "updateservlet?mytype=1";
    xmlHtpRq.open("post", url, true);
    xmlHtpRq.onreadystatechange = curobj.update_state;
    xmlHtpRq.send(null);
};

// ajax 响应学生信息显示页面
StudObj.prototype.update_state = function () {
    if (xmlHtpRq.readyState == 4) {
        if (xmlHtpRq.status == 200) {
            var obj = document.getElementById("content");
            obj.innerHTML = xmlHtpRq.responseText;
            obj = document.getElementById("myupdate");
            addEvent(obj, "click", curobj.updateProc);
        }
    }
}

StudObj.prototype.updateProc = function (e){
    var account = doucument.getElementById("account").value();
    var name = doucument.getElementById("name").value();
    var age = doucument.getElementById("age").value();
    var major = doucument.getElementById("major").value();
    var depart = doucument.getElementById("depart").value();
    var strsql = "update student set name = '" + name + "',age='" + age +"',major ='" + major +"',depart ='" + depart+"' where user ='"+ user+"'";
    url = "dbservlet";
    xmlHtpRq.open("post",url,true);
    xmlHtpRq.onreadystatechange = studObj.update_state();
    xmlHtpRq.send(null);
}
StudObj.prototype.update_state = function (){

}

    </script>

</head>
<body>
<div><input type="button" id="studedit" value="完善个人信息"/></div>
<div id="content"></div>
</body>
</html>