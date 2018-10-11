import spark.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.setPort;

public class HeroSquad {
public static void main(String[]args){

    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
        port = Integer.parseInt(process.environment().get("PORT"));
    } else {
        port = 4567;
    }

    setPort(port);

 String layout = "templates/layout.vtl";

   DataProperties dp = new DataProperties("arnold", 26, "god","cryptonite", "Captain America");

    get("/",(request,response)->{
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("template","templates/form.vtl");
        return new ModelAndView(model,layout);
    },new VelocityTemplateEngine());


    post("/hero",((request, response) -> {
        Map<String,Object> model = new HashMap<String,Object>();

        ArrayList<DataProperties> dataProperties = request.session().attribute("heroinfo");
        if (dataProperties == null){
        dataProperties = new ArrayList<>();
        request.session().attribute("heroinfo",dataProperties);
    }

        String name = request.queryParams("namehero");
        dp.setmName(name);

        int age = Integer.parseInt(request.queryParams("age")) ;
        dp.setmAge(age);

        String SpecialPower = request.queryParams("SpecialPower");
        dp.setmSpecialPowers(SpecialPower);

        String weakness = request.queryParams("weakness");
        dp.setmWeakness(weakness);

        request.session().attribute("namehero",dp);
        request.session().attribute("age",dp);
        request.session().attribute("SpecialPower",dp);
        request.session().attribute("weakness",dp);

        model.put("heroinfo",request.session().attribute("namehero"));
        model.put("heroinfo",request.session().attribute("age"));
        model.put("heroinfo",request.session().attribute("SpecialPower"));
        model.put("heroinfo",request.session().attribute("weakness"));
        model.put("template","templates/hero.vtl");
        return new ModelAndView(model,layout);
    }),new VelocityTemplateEngine());
}


}
