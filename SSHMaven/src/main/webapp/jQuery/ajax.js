$(document).ready(function (){
  
 var tds = $("td");
 tds.click(tdclick);

});
 
function tdclick(){
 
 //保留td元素的节点，以后会用到
 var tdthis = $(this);
 //取得td元素里面的文本内容，保留后用
 var tdvalue = tdthis.text();
 //建立input标签，默认是文本类型
 var input = $("<input>");
 //在input标签上面追加属性。
 input.attr("value",tdvalue);
 input.attr("name","zjc");
 input.attr("id","zz");
 //失去焦点后，触发事件。跟onclick事件一样。
 input.blur(function (){
  var inputnode = $(this);
   //取得文本框里的值
   var inputext  = inputnode.val();
   //清除td对象
   var tdparent = inputnode.parent();
   //把文本框里面的值保存到td节点里面
   
   if(inputext.length = 0 || inputext == ""){
    
    alert("不能为空");
    
    tdparent.html(tdvalue);
    
    return false;
   }
   tdparent.html(inputext);
  
   tdparent.click(tdclick);
 });
 
 
 //input的onclick事件
 input.keyup(function (event){
  
  var myevent = event || window.event;
  
  var kcode = myevent.keyCode;
  
  if(kcode==13){
   
   var inputnode = $(this);
   //取得文本框里的值
   var inputext  = inputnode.val();
   //清除td对象
   var tdparent = inputnode.parent();
   //把文本框里面的值保存到td节点里面
   
   if(isNaN(inputext)){
    alert("不是数字");
    tdparent.html(tdvalue);
    return false;
   }
     if(inputext.length = 0 || inputext==""){
       alert("不能为空");
    tdparent.html(tdvalue);
    return false;
   }   
   tdparent.html(inputext);
   //得到你所点击的行的 id。
   var id= tdparent.parents("tr").children("td").eq(0).text();

  //第一次想到，一个笨方法取id。  利用了一个title标签。呵呵！笨！ 
   // var cc = tdthis.attr("title");
   $.post("update.action?user.password="+inputext+"&user.username="+id,function(data){
    alert(data);
   }); 
   if(kcode==27){
    input.val(tdvalue);
   }
   tdparent.click(tdclick);
  }
 });
 
 //清空td元素中的文本内容。
 tdthis.empty();
 //把input加入到td元素标签中。
 tdthis.append(input);
 //取得第一个input对象
// var inputdom = input.get(0);
// //对input对象文本内容全选
// inputdom.select();
    input.trigger("focus").trigger("select");   
 //input.trigger("focus");

 tdthis.unblid("click");
}