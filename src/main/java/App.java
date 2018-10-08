import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class App {
public static void main(String[]args){

 String layout = "templates/layout.vtl";

    get("/",(request,response)->{
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("template","templates/form.vtl");
        return new ModelAndView(model,layout);
    },new VelocityTemplateEngine());


}
}
