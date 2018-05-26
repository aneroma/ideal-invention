package utils;

import models.Assessment;
import models.Member;

import java.util.List;

public class Results
{
    public static MemberResults generateMemberResults(Member member)
    {
        MemberResults results = new MemberResults();

        double weight = member.startingweight;
        List<Assessment> assessments = member.assessments;
        if (assessments.size() > 0) {
            Assessment assessment = assessments.get(assessments.size() - 1);
            weight = assessment.weight;
        }
        results.bmi = BMI.calculateBMI(member, weight);
        results.bmiCategory = BMI.determineBMICategory(results.bmi);
        return results;
    }
}
