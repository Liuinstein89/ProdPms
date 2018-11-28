
layui.use(['form', 'jquery', 'laydate', 'element'], function() {
	var form = layui.form;
	var	$ = layui.jquery;

	//获取cookies中的用户名 数据

    window.showName = function(id,name) {
        if(getCookie(name)!=null){
            $("#"+id).val(getCookie(name));
        }
    }

    // alert(getCookie("name"));
    window.getCookie = function(name) {
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)"); //正则匹配
        if(arr=document.cookie.match(reg)){
            return unescape(arr[2]);
        }
        else{
            return null;
        }
    }

    window.loadSelect = function(form,url,id,selval,selname,value){
        $.ajax({
            url : url,
            type : "GET",
            async : false,
            data:{page:1,limit:10000},
            dataType:"json",
            async: true,//异步执行
            success : function(res) {
                // layer.alert(JSON.stringify(res.data.list));
                $("#"+id).html("");
                $("#"+id).append('<option selected="" value="">请选择</option>');

                data1 = (res.data.list);

                // layer.alert(data1[0][selval]);

                // /*<![CDATA[*/
                // for(var i=0;i<res.data.total;i++){
                //     if(data1[i].id==value){
                //         $("#"+id).append('<option selected="" value='+data1[i].id+'>'+data1[i].funcName+'</option>');
                //     }else{
                //         $("#"+id).append('<option value='+data1[i].id+'>'+data1[i].funcName+'</option>');
                //     }
                // }
                // /*]]>*/

                /*<![CDATA[*/
                for(var i=0;i<res.data.total;i++){
                    if(data1[i][selval]==value){
                        $("#"+id).append('<option selected="" value='+data1[i][selval]+'>'+data1[i][selname]+'</option>');
                    }else{
                        $("#"+id).append('<option value='+data1[i][selval]+'>'+data1[i][selname]+'</option>');
                    }
                }
                /*]]>*/
                form.render();//重新渲染
            }
        });
    }


    //解析从url传过来的参数
    /*<![CDATA[*/
    window.getRequestParam = function(){
        var urlInfo = window.location.href;
        var argsIndex = urlInfo.indexOf("?");
        var args = urlInfo.substring((argsIndex + 1)).split("&");
        var argsInfo = "{";
        for ( var i = 0; i < args.length; i++) {
            var argResult = args[i].split("=");
            argsInfo = argsInfo + "'" + argResult[0] + "':'" + argResult[1] + "'";
            if (i != args.length - 1) {
                argsInfo += ',';
            }
        }
        argsInfo += "}";
        return eval('(' + argsInfo + ')');
    }
    /*]]>*/
});