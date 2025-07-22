import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FreeMarkerTest {

     @Test
    public void testGenerate() throws Exception {
         Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);

         configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
         configuration.setDefaultEncoding("UTF-8");

         Template template = configuration.getTemplate("myweb.html.ftl");

         Map<String,Object> dataModel = new HashMap<>();
         dataModel.put("currentYear",2025);
         List<Map<String,Object>> menuItems = new ArrayList<>();
         Map<String,Object> menuItem1 = new HashMap<>();
         menuItem1.put("url","http://codefather.cn");
         menuItem1.put("label","编程导航");
         menuItems.add(menuItem1);

         Map<String,Object> menuItem2 = new HashMap<>();
         menuItem2.put("url","http://laoy7ujianli.com");
         menuItem2.put("label","老鱼简历");
         menuItems.add(menuItem2);
         dataModel.put("menuItems",menuItems);


         Writer out = new FileWriter("myweb.html");
         template.process(dataModel, out);
     }
}
