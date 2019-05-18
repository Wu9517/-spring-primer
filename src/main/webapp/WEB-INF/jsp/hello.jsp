<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>websocket测试</title>
    <script type="text/javascript">


        //初始化一个webSocket对象
        var sock = new WebSocket('ws://' + window.location.host + '/myHandler');
        //建立web socket连接成功触发事件
        sock.onopen = function () {
            console.log("开启webSocket连接!");
        }
        //接受服务器端数据时触发事件
        sock.onmessage = function (e) {
            console.log('接受消息：' + e.data);
            setTimeout(function () {
                sayHello(), 2000
            })
        }
        //断开web socket连接是成功触发事件
        sock.onclose = function () {
            console.log("关闭WebSocket连接!");
        }
        //发送消息
        function sayHello() {
            //发送消息
            console.log("发送消息：hello world!");
            //使用send()方法发送数据
            sock.send('hello world!')
        }
    </script>
</head>
<body>

</body>
</html>
