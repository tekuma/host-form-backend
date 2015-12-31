package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.format.Formats;
import play.db.ebean.Model;

@Entity
public class Person extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;

    public String name;

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dueDate = new Date();

    public static Finder<Long, Person> find = new Finder<>(Person.class);

}
