package controllers;
import play.db.jpa.*;
import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class About extends Controller
{
    public static void index() {
        Logger.info("Rendering about");
        render ("about.html");
    }
}
