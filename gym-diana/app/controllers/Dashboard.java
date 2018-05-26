package controllers;

import models.Assessment;
import models.Member;
import play.Logger;
import play.mvc.Controller;
import utils.Results;
import utils.MemberResults;


import java.util.List;

public class Dashboard extends Controller
{
    public static void index()
    {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        List<Assessment> assessments = member.assessments;
        MemberResults memberResults = Results.generateMemberResults(member);
        render("dashboard.html", member, assessments, memberResults);
    }

    public static void addAssessment(double weight, double chest, double thigh, double upperarm, double waist, double hips)
    {
        Logger.info("Creating Assessment");
        Member member = Accounts.getLoggedInMember();
        Assessment assessment = new Assessment(weight, chest, thigh, upperarm, waist, hips);
        member.assessments.add(assessment);
        member.save();
        redirect("/dashboard");
    }
    public static void deleteAssessment(Long memberid, Long assessmentid)
    {
        Member member = Member.findById(memberid);
        Assessment assesment = Assessment.findById(assessmentid);
        member.assessments.remove(assesment);
        member.save();
        assesment.delete();
        redirect("/dashboard");
    }
}
