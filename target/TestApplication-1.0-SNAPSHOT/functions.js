/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

buildTable();


function buildTable() {
    $.ajax({
        url:"AdminServlet",
        type:"GET",
        
        success:function(data){
            var table = document.getElementById('myTable');
            var s = JSON.parse(data);
		for (var i = 0; i < s.length; i++){
			
                    var td_id = document.createElement("td");
                    td_id.innerHTML = s[i].id;

                     var td_username = document.createElement("td");
                     td_username.innerHTML = s[i].username;

                     var td_password = document.createElement("td");
                     td_password.innerHTML = s[i].password;

                     var td_firstName = document.createElement("td");
                     td_firstName.innerHTML = s[i].firstName;

                     var td_lastName = document.createElement("td");
                     td_lastName.innerHTML = s[i].lastName;

                     var tri = document.createElement("tr");

                     tri.append(td_id);
                     tri.append(td_username);
                     tri.append(td_password);
                     tri.append(td_firstName);
                     tri.append(td_lastName);

                     table.append(tri);
		}
        }
    });
}
