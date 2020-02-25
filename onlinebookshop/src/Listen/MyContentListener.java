package Listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

@WebListener()
public class MyContentListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
        private ArrayList<HttpSession> sessions = new ArrayList<HttpSession>(5);
    // Public constructor is required by servlet spec
    public MyContentListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
      Timer timer = new Timer();
      TimerTask timerTask = new TimerTask() {
          @Override
          public void run() {
              synchronized (sessions)
              {
                  Iterator<HttpSession> iter = sessions.iterator();
                  while(iter.hasNext())
                  {
                      HttpSession session = iter.next();
                      if(session.getLastAccessedTime()+5*60*1000<System.currentTimeMillis())
                      {
                          session.invalidate();
                          iter.remove();
                      }
                  }
              }
          }
      };
      timer.schedule(timerTask, 0L,150* 1000L);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        synchronized (sessions)
        {
            sessions.add(se.getSession());
        }
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
