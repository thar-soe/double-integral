//Programmer: Thar Soe
//04.08.2018	
public class doubleIntegral
{
    final static double stepSize=0.001;
    

    public static double doubleIntegral(String upper1, String lower1, String upper2, String lower2, String obj) 
    {
        double sum = 0;
        MathEval math=new MathEval();

        for(double currVal1 =math.evaluate(upper1); currVal1<=math.evaluate(lower1); currVal1+=stepSize)
        {
            math.setVariable("x",currVal1);
            
            for(double currVal2 =math.evaluate(upper2); currVal2<=math.evaluate(lower2); currVal2+=stepSize)
            {
                math.setVariable("y",currVal2);
                sum += math.evaluate(obj);
            }
        }
        double integral = (stepSize * stepSize * sum);
        return integral;
    }
}
