package utils;
import models.Member;

public class BMI{
    //method that calculates the BMI based on the last known weight and height
    public static double calculateBMI(Member member, double weight) {
        return Conversion.round(weight/(member.height * member.height),2);
    }
    //method that returns the BMI category
    public static String determineBMICategory(double bmiValue) {
        if (bmiValue < 16.0d ){
            return "SEVERELY UNDERWEIGHT";
        }else if (bmiValue >= 16.0d && bmiValue < 18.5d){
            return "UNDERWEIGHT";
        }else if (bmiValue >= 18.5d && bmiValue < 25.0d){
            return "NORMAL";
        }else if (bmiValue >= 25.0d && bmiValue < 30.0d){
            return "OVERWEIGHT";
        }else if (bmiValue >= 30.0d && bmiValue < 35.0d){
            return "MODERATELY OBESE";
        }else if (bmiValue >= 35.0d){
            return "SEVERELY OBESE";
        }
        //should never get here
        return "";
    }
    //method for establishing the ideal body weight based on the Devine formula
   /* public static boolean isIdealBodyWeight(Member member, Assessment assessment) {
        boolean ideal = false;
        float heightInInches = member.getHeight() * 39.3701f;
        float inchesOver;
        float idealWeight;

        switch ( member.getGender()){
            case "M":
                if (heightInInches > 60.0f) {
                    inchesOver = heightInInches - 60.0f;
                    idealWeight = 50.0f + 2.3f * inchesOver;
                }else {
                    idealWeight = 50.0f;
                }
                break;
            default:
                if (heightInInches > 60.0f) {
                    inchesOver = heightInInches - 60.0f;
                    idealWeight = 45.5f + 2.3f * inchesOver;
                }else {
                    idealWeight = 45.5f;
                }
                break;
        }
        //I am rounding to full kg's
        if(Math.round(idealWeight) == Math.round(assessment.getWeight())){
            ideal = true;
        }
        return ideal;
    }
*/
}