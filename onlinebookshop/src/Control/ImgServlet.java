package Control;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ImgServlet",urlPatterns = "/imgservlet")
public class ImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage bufferedImage = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0,0,80,20);
        graphics2D.setFont(new Font(null,Font.BOLD,20));
        graphics2D.setColor(Color.BLUE);
        String randomstr = makenum();
        graphics2D.drawString(randomstr,0,20);
        request.getSession().setAttribute("randomstr",randomstr);
        response.setHeader("Content-type","image/jpeg");
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
    }

    private String makenum()
    {
        Random random = new Random();
        int num = random.nextInt(999999);
        String value = String.valueOf(num);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i <6 - value.length();i++)
        {
            builder.append(0);
        }
        builder.append(value);
        return  builder.toString();
    }
}
