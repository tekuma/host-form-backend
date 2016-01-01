package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.TestPersons;
import play.data.Form;
import play.db.ebean.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    @Transactional
    public Result addPerson() {
        TestPersons testPersons = Form.form(TestPersons.class).bindFromRequest().get();
        testPersons.save();
        return redirect(routes.Application.getPersons());
    }

    @Transactional
    public Result getPersons() {
        List<TestPersons> testPersonses = TestPersons.find.all();
        return ok(toJson(testPersonses));
    }
}
