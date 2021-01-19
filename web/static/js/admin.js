var client;
var user;
var book;
$(function () {
    $("#c_name").hide();
    $("#userId_link").hide();
    var u_data = {};
    user = postAjax("isLogin.action",u_data);
    var isl = isLogin(user);
    if(isl){
        $("#lab_user_id").text(user[0].id);
        $("#lab_user_name").text(user[0].name);
        $("#user_id").text(user[0].id);
        $("#user_name").val(user[0].name);
        $("#user_phone").val(user[0].phone);
        $("#user_address").val(user[0].address);
    }
    $("#tab_book").on("click","span",function () {
        var i = $(this).parent().index();
        if (i<=4&&i!=1){
            var val=$(this).text();
            $(this).parent().parent("tr").children("td:eq(0)").html("<input onclick='updateBooks(this)' type='button' value='修改'>");
            $(this).parent().html("<input type='text' value='"+val+"'>");
        }
    });
    $(".client_tbody").on("click","span",function () {
        var i = $(this).parent().index();
        if (i!=1){
            var val=$(this).text();
            $(this).parent().parent("tr").children("td:eq(0)").html("<input onclick='updateClient(this)' type='button' value='修改'>");
            $(this).parent().html("<input type='text' value='"+val+"'>");
        }
    });
    $("#flip").on("click","a",function () {
        var t = $(this);
        var f= pagBook(t.text(),book);
        var pagf = $("#flip");
        pagSet(f,pagf,t.text())
    });
    $("#cli_f").on("click","a",function () {
        var t = $(this);
        var f= pagBook(t.text(),client);
        var pagf = $("#cli_f");
        pagSet(f,pagf,t.text())
    });

})
function getBooks() {
    var b_data = {bId:""};
    book = postAjax("getBooks.action",b_data);
    var ye= pagBook(1,book);
    var pagf = $("#flip");
    pagSet(ye,pagf,1);
}
function getClients() {
    var c_data = {cId:""}
    client = postAjax("getClient.action",c_data);
    var f = pagClient(1,client);
    pagSet(f,$("#cli_f"),1);
}
function addBooks() {
    var b_addData={
        bName:$("#txt_book_name").val(),
        bWriter:$("#txt_book_writer").val(),
        bNum:$("#txt_book_num").val(),
        uId:$("#lab_user_id").text(),
        uName:$("#lab_user_name").text()
    }
    var ret = postAjax("addBooks.action",b_addData);
    if (ret=="success"){
        getBooks();
    }else{
        alert("添加失败")
    }
}
function updateBooks(opp) {
    var btn = $(opp).parent().parent();
    var id = btn.children("td:eq(1)").children().text();
    var name = btn.children("td:eq(2)").children().text();
    var writer = btn.children("td:eq(3)").children().text();
    var num = btn.children("td:eq(4)").children().text();
    var user_id = btn.children("td:eq(5)").children().text();
    var user_name = btn.children("td:eq(6)").children().text();
    var addTime = btn.children("td:eq(7)").children().text();
    if (""==name){
        name = btn.children("td:eq(2)").children().val();
    }
    if (""==writer){
        writer = btn.children("td:eq(3)").children().val();
    }
    if(""==num){
        num = btn.children("td:eq(4)").children().val();
    }
    var book_data = {
        bId:id,
        bName:name,
        bWriter:writer,
        bNum:num,
        uId:user_id,
        uName:user_name,
        addTime:addTime
    }
    var ret = postAjax("updateBooks.action",book_data);
    alert(ret)
    if (ret=="success"){
        getBooks();
    }
}
function deleteBooks(opp) {
    var btn = $(opp).parent().parent();
    var id = btn.children("td:eq(1)").children().text();
    var name = btn.children("td:eq(2)").children().text();
    var writer = btn.children("td:eq(3)").children().text();
    var num = btn.children("td:eq(4)").children().text();
    var user_id = btn.children("td:eq(5)").children().text();
    var user_name = btn.children("td:eq(6)").children().text();
    var addTime = btn.children("td:eq(7)").children().text();

    var book_data = {
        bId:id,
        bName:name,
        bWriter:writer,
        bNum:num,
        uId:user_id,
        uName:user_name,
        addTime:addTime
    }
    var ret = postAjax("deleteBooks.action",book_data);
    alert(ret)
    if (ret=="error"){
        getBooks();
    }
}
function addClient() {
    var cName = $("#txt_addclient_name").val();
    var cPhone = $("#txt_addclient_phone").val();
    var cAddress = $("#txt_addclient_address").val();
    var c_data = {
        cName:cName,
        cPhone:cPhone,
        cAddress:cAddress
    }
    var ret = postAjax("addClients.action",c_data);
    if(ret=="success"){
        getClients();
    }else {
        alert("添加失败");
    }
}
function updateClient(opp) {
    var th = $(opp).parent().parent();
    var cId = th.children("td:eq(1)").children().text();
    var cName = th.children("td:eq(2)").children().text();
    var cPhone = th.children("td:eq(3)").children().text();
    var cAddress = th.children("td:eq(4)").children().text();

    if (cName==""){
        cName = th.children("td:eq(2)").children().val();
    }
    if (cPhone==""){
        th.children("td:eq(3)").children().val();
    }
    if (cAddress==""){
        th.children("td:eq(4)").children().val();
    }
    var client_data = {
        cId:cId,
        cName:cName,
        cPhone:cPhone,
        cAddress:cAddress
    }
    var ret = postAjax("updateClients.action",client_data);
    if (ret=="success"){
        getClients()
    }
}
function deleteClient(opp) {
    var th = $(opp).parent().parent();
    var cId = th.children("td:eq(1)").children().text();
    var cName = th.children("td:eq(2)").children().text();
    var cPhone = th.children("td:eq(3)").children().text();
    var cAddress = th.children("td:eq(4)").children().text();

    if (cName==""){
        cName = th.children("td:eq(2)").children().val();
    }
    if (cPhone==""){
        th.children("td:eq(3)").children().val();
    }
    if (cAddress==""){
        th.children("td:eq(4)").children().val();
    }

    var client_data = {
        cId:cId,
        cName:cName,
        cPhone:cPhone,
        cAddress:cAddress
    }
    var ret = postAjax("deleteClients.action",client_data);
    if (ret=="success"){
        getClients()
    }
}
function updateUser() {
    var uId = $("#user_id").text();
    var uName = $("#user_name").val();
    var uPhone = $("#user_phone").val();
    var uAddress = $("#user_address").val();
    var udata = {
        uId:uId,
        uPassword:user[0].password,
        uName:uName,
        uPhone:uPhone,
        uAddress:uAddress
    }
    var ret = postAjax("updateUser",udata)
    if (ret=="success"){
        user = postAjax("isLogin.action",{});
        $("#user_id").text(user[0].id);
        $("#user_name").val(user[0].name);
        $("#user_phone").val(user[0].phone);
        $("#user_address").val(user[0].address);
        alert("信息修改完成")
    }else {
        alert("修改失败");
    }

}
function updatePaw() {
    var jPasw = $("#txt_password_fir").val();
    var pasw0 = $("#txt_password_new0").val();
    var pasw1 = $("#txt_password_new1").val();

    var isUser = postAjax("isLogin.action",{uId:user[0].id,uPassword:jPasw});
    if (jPasw==isUser[0].password){
        if (pasw0==pasw1){
            var d = {
                uId:user[0].id,
                uPassword:pasw0,
                uName:user[0].name,
                uPhone:user[0].phone,
                uAddress:user[0].address
            }
            var is = postAjax("updateUser.action",d);
            if (is=="success"){
                user = postAjax("isLogin.action",{});
                $("#user_id").text(user[0].id);
                $("#user_name").val(user[0].name);
                $("#user_phone").val(user[0].phone);
                $("#user_address").val(user[0].address);
                alert("密码修改完成");
            }else {
                alert("密码修改失败");
            }
        }
    }else {
        $("#error_paswd").text("密码错误");
    }
}
function pagBook(ye,data) {
    var tBook = $("#tab_book");
    var y = 0;
    tBook.html("");
    var tab="",q=[(ye-1)*10,ye*10-1];
    $.each(data,function (i,item) {
        if (i<=q[1]&&i>=q[0]){
            tab+="<tr>" +
                "<td></td>"+
                "<td><span>"+item.id+"</span></td>" +
                "<td><span>"+item.name+"</span></td>" +
                "<td><span>"+item.writer+"</span></td>" +
                "<td><span>"+item.num+"</span></td>" +
                "<td><span>"+item.user_id+"</span></td>" +
                "<td><span>"+item.user_name+"</span></td>" +
                "<td><span>"+changeTime(item.addtime)+"</span></td>" +
                "<td><input onclick='deleteBooks(this)' type='button' value='删除'></td>" +
                "</tr>";

        }
        y=i;
    });
    tBook.append(tab);
    return y;
}
function pagClient(ye,data) {
    var cClient = $(".client_tbody");
    var y=0;
    var cTab,q=[(ye-1)*10,ye*10-1];
    $.each(client,function (i,item) {
        if (i<=q[1]&&i>=q[0]) {
            cTab += "<tr>" +
                "<td></td>" +
                "<td><span>" + item.id + "</span></td>" +
                "<td><span>" + item.name + "</span></td>" +
                "<td><span>" + item.phone + "</span></td>" +
                "<td><span>" + item.address + "</span></td>" +
                "<td><input onclick='deleteClient(this)' type='button' value='删除'></td>" +
                "</tr>";
        }
        y=i;
    });
    cClient.html("");
    cClient.append(cTab);
    return y;
}
