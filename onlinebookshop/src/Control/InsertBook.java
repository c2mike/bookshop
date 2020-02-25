package Control;

import Service.BookService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "InsertBook",urlPatterns = "/insertbook")
public class InsertBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        Map<String,String> param = new HashMap<String,String>();
        System.out.println(request.getCharacterEncoding());
        try {
            List<FileItem > list = servletFileUpload.parseRequest(request);
            for(FileItem item:list)
            {
                if(item.isFormField())
                {
                    String name = item.getFieldName();
                    String value = item.getString();
                    value = new String(value.getBytes("iso-8859-1"),"utf-8");
                    param.put(name,value);
                }
                else
                {
                    String filename = item.getName();
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    InputStream in = item.getInputStream();
                    int len = 0;
                    byte[] buffer = new byte[1024];
                    int hashcode = filename.hashCode();
                    int low4bit = hashcode&0x0000000f;
                    int high4bit =hashcode&0x000000f0;
                    String basedir = request.getServletContext().getRealPath("/testVirtualPath");
                    String t = "/"+high4bit+"/"+low4bit+"/"+ UUID.randomUUID()+"_"+filename;
                    String path = basedir+t;
                    File file  = new File(path);
                    if(!file.exists())
                    {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    while((len = in.read(buffer,0,1024))>0)
                    {
                        fileOutputStream.write(buffer,0,len);
                    }
                    fileOutputStream.close();
                    in.close();
                    param.put("pic",t);
                }
            }
            BookService bookService = new BookService();
            bookService.insertone(param.get("name"),
                                   param.get("description"),
                                    param.get("author"),
                                        param.get("pic"),
                                            param.get("categoryname"),
                                                Float.parseFloat(param.get("price")));
            request.setAttribute("message","插入成功");
        } catch (FileUploadException e) {
            e.printStackTrace();
            request.setAttribute("message","插入失败");
        }
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("manager/insertbook.jsp").forward(request,response);
    }
}
