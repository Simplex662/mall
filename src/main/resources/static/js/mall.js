//获取用户名信息
function getLoginUserName(){
    var loginUserId = window.localStorage.getItem("currentId");
    var loginUserName = window.localStorage.getItem("currentUserId");

    if (loginUserName != null && loginUserId != null){
        return { userId:loginUserName, id:loginUserId }
    } else {
        return { userId:'游客', id:0 };
    }

}

//获取网页id
function request(params) {
    var url = location.href;
    var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
    var paraObj = {};
    for (i = 0; j = paraString[i]; i++) {
        paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
    }
    var returnValue = paraObj[params.toLowerCase()];
    if (typeof (returnValue) == "undefined") {
        return "";
    } else {
        return decodeURI(returnValue);
    }
}

//退出登录，清理登录信息
window.onload = function (){
    var clear = document.getElementById("clear");
    clear.onclick = function (){
        window.localStorage.removeItem("currentId");
        window.localStorage.removeItem("currentUserId");
        alert("退出成功");
        getLoginUserName();
        window.location.reload();
    }
}
