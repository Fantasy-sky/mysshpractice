$.fn.extend({
    serializeJson: function () {
        var json = {}; // 就是一个javascript的对象.
        // 1.通过jquery提供的serializeArray方法得到不符合要求的json串
        var msg = this.serializeArray();
        // console.info(msg);
        // [Object { name="username", value="tom"}, Object { name="password",
        // value="123"}, Object { name="hobby", value="eat"}, Object {
        // name="hobby", value="drink"}, Object { name="hobby", value="play"}]
        $(msg).each(function () {
            if (json[this.name]) { // 在json对象中没有this.name对应的值
                // 有,需要考虑一个名称对应多个值，而这些值应该放入到数组中
                if (!json[this.name].push) { // 如果为true,代表是数组,如果为false，代表不是数组
                    json[this.name] = [json[this.name]];
                }
                json[this.name].push(this.value || ''); // 装入到数组

            } else {
                // 没有
                json[this.name] = this.value || '';
            }
        });

        return json
    }
});

/*
    异步请求，在点击添加按钮之后，向后台发出请求，将表单数据转化成json格式数据，post方式请求。
    后台将发送回来的订单信息的list集合以json的格式发送回来。
    将数据进行解析，把这些插入到表格中，然后显示到页面上。
* */

function addorder() {
    var json = $("#formorder").serialize();

    // 表单添加一个隐藏域
    //json['publicationDate'] = "25";
    var url = "product_add";
    $.post(url, json, function (data) {
        var jdata = eval(data);
        html = "<table><th>订单号</th><th>地址</th><th>总金额</th>";
        for (var i = 0; i < jdata.length; i++) {
            html += "<th>" + jdata.id + "</th><th>" + jdata.address + "</th><th>" + jdata.totalprice + "</th>";
        }
        html += "</table>";
        $("#list").html(html);

    }, "json")


}
