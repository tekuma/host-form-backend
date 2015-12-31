package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.Person;
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
        Person person = Form.form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.Application.index());
    }

    @Transactional
    public Result getPersons() {
        List<Person> persons = Person.find.all();
        return ok(toJson(persons));
    }
}
