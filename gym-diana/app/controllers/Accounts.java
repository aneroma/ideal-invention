package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

public class Accounts extends Controller
{
    public static void index()
    {
        render("about.html");
    }

    public static void signup()
    {
        render("signup.html");
    }

    public static void login()
    {
        render("login.html");
    }

    public static void settings()
    {
        Member member = getLoggedInMember();
        render("dashboard.html", member);
    }

    public static void updateSettings(Member member)
    {
        Member loggedInMember = getLoggedInMember();

        loggedInMember.email = member.email;
        loggedInMember.name = member.name;
        loggedInMember.password = member.password;
        loggedInMember.address = member.address;
        loggedInMember.gender = member.gender;
        loggedInMember.height = member.height;
        loggedInMember.startingweight = member.startingweight;

        loggedInMember.save();
        redirect("/dashboard");
    }


    public static void logout()
    {
        session.clear();
        index();
    }

    public static Member getLoggedInMember()
    {
        Member member = null;
        if (session.contains("logged_in_Memberid")) {
            String memberId = session.get("logged_in_Memberid");
            member = Member.findById(Long.parseLong(memberId));
        } else {
            login();
        }
        return member;
    }

    public static void register(String email, String name, String password, String address, String gender, double height, double startingweight)
    {
        Logger.info(name + " " + email);
        Member member = new Member(email, name, password, address, gender, height, startingweight);
        member.save();
        index();
    }

    public static void authenticate(String email, String password)
    {
        Logger.info("Attempting to authenticate with " + email + ":" + password);

        Member member = Member.findByEmail(email);
        if ((member != null) && (member.checkPassword(password) == true)) {
            Logger.info("Authentication successful");
            session.put("logged_in_Memberid", member.id);
            Dashboard.index();
        } else {
            Logger.info("Authentication failed");
            login();
        }
    }
}