/**
 * Created by Administrator on 2017/5/17.
 */

var projectUrl = "http://localhost:8080/bookshop";

function js2Json(data){
    return eval("(" + data + ")");
}

function strToDate(str){
    return new Date(parseInt(str) ).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
}
/**
 * 刷新当前页面
 */
function pageflush(){
   return history.go(0);
}

function jsonArr2JsArr (jsonArr) {
    var  jsonStr= jsonArr.substring(1,jsonArr.length-1);
    var jsonArr= jsonStr.split(",");
    return jsonArr;
}

function exit(){
    var url = projectUrl + "/index/exit.action";
    $.get(url,{},function(databack){
        var code = databack.code;
        if(code == 5000){
            alert(databack.message);
        }else{
            alert(databack.message);
            window.location.href = "index.html";
        }
    });
}