

public class WebsiteView {
     public void show(WebsiteModel website) {
         System.out.println("Details:");
         System.out.println("Name:" +website.getName());
         System.out.println("url: " + website.getUrl());
         System.out.println("status " + website.getStatus());
     }
}
