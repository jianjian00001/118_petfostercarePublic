/**接口访问，带窗口刷新*/
function ajaxUnifiedCallUpdateAndAdd(url, json, success, error){
    $.ajax({
        type: 'post',
        async: false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: url,    //请求发送到Servlet
        contentType: 'application/json;charset=UTF-8',//指定消息请求类型
        data: JSON.stringify(json),
        timeout: 10000,    //超时10s
        success: function (res) {
            returnLogin(res);
            if(res.data > 0){
                alert(success)
                window.location.reload();
            }else {
                if(parseInt(res.code) === 500 ){
                    alert(res.data)
                } else {
                    alert(error)
                }
            }
        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert('数据请求失败!');
        }
    });
}

/**通过ID获取当前数据*/
function getDataIdData(OrderData,id){
    for (let i = 0; i < OrderData.length; i++) {
        if(OrderData[i].id === id){
            return OrderData[i];
        }
    }
}

/**接口访问，不带窗口刷新*/
function ajaxUnifiedCallUpdateAndAddFormData(url, json, success, error){
    $.ajax({
        type: 'post',
        async: false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: url,    //请求发送到Servlet
        contentType: false,//指定消息请求类型
        data: json,
        processData: false,
        cache: false,
        timeout: 100000,    //超时10s
        success: function (res) {
            returnLogin(res);
            if(res.data > 0){
                alert(success)
                window.location.reload();
            }else {
                if(parseInt(res.code) === 500 ){
                    alert(res.data)
                } else {
                    alert(error)
                }
            }
        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert('数据请求失败!');
        }
    });
}

/**接口访问，带窗口刷新*/
function ajaxUnifiedCallUpdateAndAddRemoveReload(url, json, success, error){
    $.ajax({
        type: 'post',
        async: false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: url,    //请求发送到Servlet
        contentType: 'application/json;charset=UTF-8',//指定消息请求类型
        data: JSON.stringify(json),
        timeout: 10000,    //超时10s
        success: function (res) {
            returnLogin(res);
            if(res.data > 0){
                alert(success)
            }else {
                if(parseInt(res.code) === 500 ){
                    alert(res.data)
                } else {
                    alert(error)
                }
            }
        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert('数据请求失败!');
        }
    });
}


// 验证手机号
function isPhoneNo(phone) {
    var pattern = /^1[34578]\d{9}$/;
    return pattern.test(phone);
}

/**验证是否登录*/
function returnLogin(res){
if(typeof res == "object"){
   return;
}
/**返回登录页面*/
if(res.indexOf("宠物寄养系统") > 0){
    alert('请登录！')
    parent.location.href = "/cwjy/login_user";
    window.location.href = "/cwjy/login_user";
    return;
}
}