<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formcode</title>
</head>
<body>
<%
    //Take user email
    String username = request.getParameter("username");
    //Check if the user entered an email or left it empty
    if (username != null){
        try{
            // Instantiate an instance from the DBConnection class to use it inside this JSP page
            DBConnection DBConnection dbconn = new DBConnection();
            Statement st = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = null;

            conn = dbconn.setConnection();
          
            // Create a SQL statement that will retrieve the user email from the DB that matching user   email in the Form
            String strquery = "SELECT username FROM users WHERE username= ' "+username+" ' ; ";
          
            st = conn.createStatement();
            rs = st.executeQuery(strquery);         
            try{
                if (rs.next()){
                    /*Transport user to another page using one way from the following:
                      First, response.sendRedirect("yourpage.jsp");
                      Second, RequestDispatcher rd=request.getRequestDispatcher("yourpage.jsp");
                      rd.forward(request,response);*/
                  
                    RequestDispatcher rd=request.getRequestDispatcher("Hello.jsp");
                    rd.forward(request,response);
                }
                // Display a message if the DB is empty
                else{
                        if (! rs.next() ) {
                            System.out.println("This username is not stored in our DB");
                        }
               }
               //Close all connections                         
               dbconn.CloseConn(rs, st, ps, conn);
            }
            catch (Exception e) {
                out.println(e.toString() + "<br>");
            }
        }
        catch (Exception e) {
            out.println(e.toString() + "<br>");
        }              
    }
    else{
        out.println("Please Enter your Email");
    }
%>

</body>
</html>