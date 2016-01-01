package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "test_persons")
public class TestPersons extends Model {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(nullable = false, name = "user_name")
    public String userName;

    @Column(name = "biography")
    public String biography = "";

    @Column(name = "time_stamp")
    public Date timeStamp = new Date();

    public static Finder<Long, TestPersons> find = new Finder<>(TestPersons.class);

}
