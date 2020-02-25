function getpage()
{
    var input = document.getElementById("currentpage");
    var value = input.value;
    if(value==""||value==null)
    {
        alert("请填入数值")
        return false;
    }

    if(!value.match("\\d+"))
    {
        alert("数字非法")
        return false;
    }

    window.location.href = "selectcategory?pagenum="+value;
}

function getpagebook()
{
    var input = document.getElementById("currentpage");
    var value = input.value;
    if(value==""||value==null)
    {
        alert("请填入数值")
        return false;
    }

    if(!value.match("\\d+"))
    {
        alert("数字非法")
        return false;
    }

    window.location.href = "selectbook?pagenum="+value;
}

function getpagebook2()
{
    var input = document.getElementById("currentpage");
    var value = input.value;
    if(value==""||value==null)
    {
        alert("请填入数值")
        return false;
    }

    if(!value.match("\\d+"))
    {
        alert("数字非法")
        return false;
    }

    window.location.href = "clientservlet?pagenum="+value;
}

function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if(username==""||username==null||password==""||password==null)
    {
        alert("请输入用户名和密码")
        return false;
    }
    window.location.href="/bookshop/userservlet?func=login&username="+username+"&password="+password;

}

function gomain() {
    window.location.reload();
}

function clearshoppingcart()
{
    window.location.href="/bookshop/shoppingcartservlet?func=clear";
}

function  commitorder() {
    window.location.href = "/bookshop/orderservlet?func=makeorder";
}






