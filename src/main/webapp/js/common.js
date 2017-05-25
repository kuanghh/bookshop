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