import spark.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

   DataProperties dp = new DataProperties();

    List<Object> allheroes = new ArrayList<Object>();
    List<Object> allsquad = new ArrayList<Object>();

    get("/",(request,response)->{
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("template","templates/form.vtl");
        return new ModelAndView(model,layout);
    },new VelocityTemplateEngine());


    post("/heros",((request, response) -> {
        Map<String,Object> model = new HashMap<String,Object>();
         try{
             String name = request.queryParams("namehero");
             dp.setmName(name);
             int age = Integer.parseInt(request.queryParams("age")) ;
             dp.setmAge(age);
             String SpecialPower = request.queryParams("SpecialPower");
             dp.setmSpecialPowers(SpecialPower);
             String weakness = request.queryParams("weakness");
             dp.setmWeakness(weakness);
             model.put("template","templates/success.vtl");
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
        return new ModelAndView(model,layout);
    }),new VelocityTemplateEngine());

    get("/hero", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        allheroes.add(dp.getmName());
        allheroes.add(dp.getmAge());
        allheroes.add(dp.getmSpecialPowers());
        allheroes.add(dp.getmWeakness());
        model.put("heroinfo", allheroes);
        model.put("template", "templates/hero.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/squadform",(request, response) ->{
        Map<String, Object> model = new HashMap<String, Object>();
        try{
        String namesquad = request.queryParams("namesquad");
        dp.setmSquadname(namesquad);
        String squadcause = request.queryParams("cause");
        dp.setmSquadCause(squadcause);
        String squadsize = request.queryParams("size");
        dp.setmSquadSize(squadsize);
            model.put("template", "templates/squadsuccess.vtl");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squadform", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        allsquad.add(dp.getmSquadname());
        allsquad.add(dp.getmSquadCause());
        allsquad.add(dp.getmSquadSize());
        model.put("squadinfo", allsquad);
        model.put("template", "templates/squadform.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

}

}
