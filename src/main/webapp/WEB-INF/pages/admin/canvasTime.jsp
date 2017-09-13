<%--
  Created by IntelliJ IDEA.
  User: afb
  Date: 2017/9/2
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>粒子时钟</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

<canvas id="canvas" style="width: 500px" class="bg-info">当前浏览器不支持canvas，请更换浏览器后再试</canvas>

<script type="text/javascript">
    <!--定义时钟每位可能出现的数字0~9-->
    var digit =
        [
            [
                [0, 0, 1, 1, 1, 0, 0],
                [0, 1, 1, 0, 1, 1, 0],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [0, 1, 1, 0, 1, 1, 0],
                [0, 0, 1, 1, 1, 0, 0]
            ],//0
            [
                [0, 0, 0, 1, 1, 0, 0],
                [0, 1, 1, 1, 1, 0, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [1, 1, 1, 1, 1, 1, 1]
            ],//1
            [
                [0, 1, 1, 1, 1, 1, 0],
                [1, 1, 0, 0, 0, 1, 1],
                [0, 0, 0, 0, 0, 1, 1],
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 0, 1, 1, 0, 0, 0],
                [0, 1, 1, 0, 0, 0, 0],
                [1, 1, 0, 0, 0, 0, 0],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 1, 1, 1, 1, 1]
            ],//2
            [
                [1, 1, 1, 1, 1, 1, 1],
                [0, 0, 0, 0, 0, 1, 1],
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 0, 1, 1, 1, 0, 0],
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 0, 0, 0, 1, 1],
                [0, 0, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [0, 1, 1, 1, 1, 1, 0]
            ],//3
            [
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 0, 1, 1, 1, 0],
                [0, 0, 1, 1, 1, 1, 0],
                [0, 1, 1, 0, 1, 1, 0],
                [1, 1, 0, 0, 1, 1, 0],
                [1, 1, 1, 1, 1, 1, 1],
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 0, 1, 1, 1, 1]
            ],//4
            [
                [1, 1, 1, 1, 1, 1, 1],
                [1, 1, 0, 0, 0, 0, 0],
                [1, 1, 0, 0, 0, 0, 0],
                [1, 1, 1, 1, 1, 1, 0],
                [0, 0, 0, 0, 0, 1, 1],
                [0, 0, 0, 0, 0, 1, 1],
                [0, 0, 0, 0, 0, 1, 1],
                [0, 0, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [0, 1, 1, 1, 1, 1, 0]
            ],//5
            [
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 1, 1, 0, 0, 0],
                [0, 1, 1, 0, 0, 0, 0],
                [1, 1, 0, 0, 0, 0, 0],
                [1, 1, 0, 1, 1, 1, 0],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [0, 1, 1, 1, 1, 1, 0]
            ],//6
            [
                [1, 1, 1, 1, 1, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 0, 1, 1, 0, 0, 0],
                [0, 0, 1, 1, 0, 0, 0],
                [0, 0, 1, 1, 0, 0, 0],
                [0, 0, 1, 1, 0, 0, 0]
            ],//7
            [
                [0, 1, 1, 1, 1, 1, 0],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [0, 1, 1, 1, 1, 1, 0],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [0, 1, 1, 1, 1, 1, 0]
            ],//8
            [
                [0, 1, 1, 1, 1, 1, 0],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [1, 1, 0, 0, 0, 1, 1],
                [0, 1, 1, 1, 0, 1, 1],
                [0, 0, 0, 0, 0, 1, 1],
                [0, 0, 0, 0, 0, 1, 1],
                [0, 0, 0, 0, 1, 1, 0],
                [0, 0, 0, 1, 1, 0, 0],
                [0, 1, 1, 0, 0, 0, 0]
            ],//9
            [
                [0, 0, 0, 0, 0, 0, 0],
                [0, 0, 1, 1, 1, 0, 0],
                [0, 0, 1, 1, 1, 0, 0],
                [0, 0, 1, 1, 1, 0, 0],
                [0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0],
                [0, 0, 1, 1, 1, 0, 0],
                [0, 0, 1, 1, 1, 0, 0],
                [0, 0, 1, 1, 1, 0, 0],
                [0, 0, 0, 0, 0, 0, 0]
            ]//:
        ];
    var canvas = document.getElementById("canvas");
    if (canvas.getContext) {
        var cxt = canvas.getContext('2d');//二维空间
    }
    //声明cavas的高度和宽度
    var H = 100, W = 700;
    canvas.height = H;
    canvas.width = W;
    //存储时间数据
    var data = [];
    //存储运动的小球
    var balls = [];
    //设置粒子半径
    var R = canvas.height / 20 - 1;
    //匿名的函数
    (function () {
        //正则表达式的exec()
        var temp = /(\d)(\d):(\d)(\d):(\d)(\d)/.exec(new Date());
        //存储时间数字，由十位小时、个位小时、冒号、十位分钟、个位分钟、冒号、十位秒钟、个位秒钟这7个数字组成
        data.push(temp[1], temp[2], 10, temp[3], temp[4], 10, temp[5], temp[6]);
    })();

    /**生成点阵数字**/
    function renderDigit(index, num) {
        for (var i = 0; i < digit[num].length; i++) {
            for (var j = 0; j < digit[num][i].length; j++) {
                if (digit[num][i][j] == 1) {
                    //画表盘
                    cxt.beginPath();
                    //cxt.arc(100,100,30,0,Math.PI*2,true); 括号内第一个和第二个参数，代表圆心坐标。第三个参数是圆的半径。第四个参数代表圆周起始位置。0 PI就是起始位置。沿顺时针路线，分别是0.5 PI（正下方），1 PI和1.5 PI（正上方），为画饼图提供了扇形范围的依据。 第五个参数是弧长Math.PI*2就是整个圆，Math.PI是半圆。第六个参数是一个布尔值，true是顺时针false是顺时针。
                    cxt.arc(14 * (R + 2) * index + j * 2 * (R + 1), i * 2 * (R + 1) + R + 1, R, 0, 2 * Math.PI);
                    cxt.closePath();
                    cxt.fill();
                }
            }

        }
    }

    /**更新时钟**/
    function updateDigitTime() {
        var changeNumArray = [];
        var temp = /(\d)(\d):(\d)(\d):(\d)(\d)/.exec(new Date());
        var NewData = [];
        NewData.push(temp[1], temp[2], 10, temp[3], temp[4], 10, temp[5], temp[6]);
        for (var i = data.length - 1; i >= 0; i--) {
            //时间发生变化
            if (NewData[i] !== data[i]) {
                //将变化的数字值和在data数组中的索引存储在changeNumArray数组中
                changeNumArray.push(i + '_' + (Number(data[i] + 1) % 10))
            }
        }
        //增加小球
        for (var i = 0; i < changeNumArray.length; i++) {
            addBalls.apply(this, changeNumArray[i].split('_'));

        }
        //concat()方法用于连接两个或多个数组。该方法不会改变现有的数组，而仅仅会返回被连接数组的一个副本。
        data = NewData.concat();
    }

    /**更新小球的状态**/
    function updateBalls() {
        for (var i = 0; i < balls.length; i++) {
            balls[i].stepY += balls[i].disY;
            balls[i].x += balls[i].stepX;
            balls[i].y += balls[i].stepY;
            if (balls[i].x > W + R || balls[i].y > H + R) {
                //arrayObject.splice(index,howmany,item1,.....,itemX)
                //index:必需。整数，规定添加/删除项目的位置，使用负数可从数组结尾处规定位置。
                //howmany:必需。要删除的位置在index之后的多少个项目。如果设置为 0，则不会删除项目。
                //(item1, ..., itemX):可选。向数组index位置添加的新项目。
                balls.splice(i, 1);
                i--;
            }
        }
    }

    /**添加要运行小球**/
    function addBalls(index, num) {
        var numArray = [1, 2, 3];
        var colorArray = ["#3BE", "#09C", "#A6C", "#93C", "#9C0", "#690", "#FB3", "#F80", "#F44", "#C00"];
        for (var i = 0; i < digit[num].length; i++) {
            for (var j = 0; j < digit[num][i].length; j++) {
                if (digit[num][i][j] == 1) {
                    var ball = {
                        x: 14 * (R + 2) * index + j * 2 * (R + 1) + (R + 1),
                        y: i * 2 * (R + 1) + (R + 1),
                        stepX: Math.floor(Math.random() * 4 - 2),
                        stepY: -2 * numArray[Math.floor(Math.random() * numArray.length)],
                        color: colorArray[Math.floor(Math.random() * colorArray.length)],
                        disY: 1
                    };
                    balls.push(ball);
                }
            }
        }
    }

    /**渲染**/
    function render() {
        //重置画布宽度，达到清空画布的效果
        canvas.height = 100;
        //渲染时钟
        for (var i = 0; i < data.length; i++) {
            renderDigit(i, data[i]);
        }
        //渲染小球
        for (var i = 0; i < balls.length; i++) {
            cxt.beginPath();
            cxt.arc(balls[i].x, balls[i].y, R, 0, 2 * Math.PI);
            cxt.fillStyle = balls[i].color;
            cxt.closePath();
            cxt.fill();
        }
    }

    clearInterval(oTimer);
    var oTimer = setInterval(function () {
        //更新时钟
        updateDigitTime();
        //更新小球状态
        updateBalls();
        //渲染
        render();
    }, 50);
</script>

</body>
</html>