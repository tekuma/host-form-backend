package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import controllers.actions.CORSAction;
import models.TestPersons;
import play.data.Form;
import play.db.ebean.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.index;

@With(CORSAction.class)
public class Application extends Controller {

    public Result options(String path) {
        return ok();
    }

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    @Transactional
    public Result addPerson() {
        TestPersons testPersons = Form.form(TestPersons.class).bindFromRequest().get();
        testPersons.save();
        return ok(toJson(testPersons));
    }

    @Transactional
    public Result getPersons() {
        List<TestPersons> testPersons = TestPersons.find.all();
        return ok(toJson(testPersons));
    }

    public Result getTestData() {
        return ok("Test data from be-Tekuma-host-form");
    }
}
