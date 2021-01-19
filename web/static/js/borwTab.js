var client;
var user;
var book;
$(document).ready(function () {
    var set =setHeight();
    $("#c_name").hide();
    $("#userId_link").hide();
    var u_data = {};
    user = postAjax("isLogin.action",u_data,);
    var is = isLogin(user);
    $("#btn_client_id").click(function () {
        var getB=getBorw();
    });
});
function update(opp) {
    var tr = $(opp).parent().parent();
    var borwId = tr.children("td:eq(1)").children().text();
    var borwCId = tr.children("td:eq(2)").children().text();
    var borwCName = tr.children("td:eq(3)").children().text();
    var borwBId = tr.children("td:eq(4)").children().text();
    var borwBName=tr.children("td:eq(5)").children().text();
    var borwUId=tr.children("td:eq(6)").children().text();
    var borwUName=tr.children("td:eq(7)").children().text();
    var borwATime=tr.children("td:eq(8)").children().text();

    var borw_data = {
        btnId:borwId,
        cId:borwCId,
        cName:borwCName,
        bId:borwBId,
        bName:borwBName,
        uId:borwUId,
        uName:borwUName,
        btnTime:borwATime
    }
    var is = postAjax("updateBorTab.action",borw_data,);
    if (is=="success"){
        alert("归还成功");
        var getB = getBorw();
    }else {
        alert("!!归还失败!!");
        var getB = getBorw();
    }
}
function getBorw() {
    var client_id = $("#sel_client_id").val();
    var c_data = {
        cId:client_id
    };
    client = postAjax("getClient.action",c_data,);
    if(null!=client){
        $("#c_name").text(client[0].name);
        $("#c_name").show();
        var tabBody;
        $("#table_body").html("");
        var borwTab =  postAjax("getBorwTab",c_data);
        $.each(borwTab,function (i,iteam) {
            if (iteam.borrow_aftertime==null){
                tabBody+="" +
                    "<tr>"+
                    "<td>"+
                    "</td>"+
                    "<td>"+
                    "<label class='tab_font'>"+iteam.id+"</label>"+
                    "</td>"+
                    "<td>"+
                    "<label class='tab_font'>"+iteam.client_id+"</label>"+
                    "</td>"+
                    "<td>"+
                    "<label class='tab_font'>"+iteam.client_name+"</label>"+
                    "</td>"+
                    "<td>"+
                    "<label class='tab_font'>"+iteam.book_id+"</label>"+
                    "</td>"+
                    "<td>"+
                    "<label class='tab_font'>"+iteam.book_name+"</label>"+
                    "</td>"+
                    "<td>"+
                    "<label class='tab_font'>"+iteam.user_id+"</label>"+
                    "</td>"+
                    "<td>"+
                    "<label class='tab_font'>"+iteam.user_name+"</label>"+
                    "</td>"+
                    "<td>"+
                    "<label class='tab_font'>"+changeTime(iteam.borrow_time)+"</label>"+
                    "</td>"+
                    "<td>"+
                    "<input onclick='update(this)' type='button' value='归还'>"+
                    "</td>"+
                    "</tr>" +
                    "";
            }
        });
        $("#table_body").append(tabBody);
    }else {
        alert("未找到客户")
    }
}
function addTabRow() {
    var addTable = "<tr><td></td>" +
        "<td></td>" +
            "<td>"+client[0].id+"</td>" +
            "<td>"+client[0].name+"</td>" +
            "<td><input id='add_bId' type='text'><input onclick='getBook()' id='btn_selBook' type='button' value='查询'></td>" +
            "<td><label id='re_bookName'></label></td>" +
            "<td>"+user[0].id+"</td>" +
            "<td>"+user[0].name+"</td>" +
            "<td></td>" +
            "<td><input onclick='addRow()' type='button' value='添加'></td>" +
            "</tr>";
    $("#table_body").append(addTable);
}
function getBook() {
    var book_id = $("#add_bId").val();
    var b_data = {
        bId:book_id
    };
    book = postAjax("getBooks" ,b_data);
    if (null!=book){
        $("#re_bookName").text(book[0].name);
    }else {
        $("#re_bookName").text("未查询到书籍");

    }
}
function addRow() {
    var bor_data = {
        cId:client[0].id,
        cName:client[0].name,
        bId:book[0].id,
        bName:book[0].name,
        uId:user[0].id,
        uName:user[0].name
    }
    var ret = postAjax("addBorTab.action",bor_data);
    if (ret=="success"){
        getBorw();
    }else {
        alert("添加失败")
    }
}

