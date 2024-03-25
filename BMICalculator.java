/*
1. Създайте клас BMICalculator.

2. Създайте и имплементирайте метод printIntroduction() – той ще се извиква всеки път при стартиране 
на програмата. Той ще трябва да информира потребителя какво прави програмата, която е пуснал.

3. Създайте метод getBMI(), който ще „поиска“ и ще „събере“ информация от потребителя за неговото тегло и 
височина. Нека да приема като аргумент Scanner, който чете от клавиатурата. В имплементацията на метода ще 
трябва да подканите потребителя да въведе височината си в инчове(За да си пресметнете височината използвайте, 
че 1см.= 0.3937 inch) и теглото си в паунди(използвайте формулата kg = lb / 2,2046). 
Нека за сега методът ви връща void.

4. Създайте метод bmiFor(), който по подадени тегло и височина, изчислява body mass index и го връща 
като резултат. Формулата за индекса е: weight*703/ (height*height).

5. Направете така, че методът getBMI() да връща като резултат, резултатът, който връща методът bmiFor().

6. Направете метод getStatus(). Той трябва да връща като резултат един от символните низове: 
underweight, normal, overweight, obese. По статистики на център за здраве, тези 4 характеристики се дават 
съответно ако: индексът е не повече от 18,5, ако индексът е не повече от 25, ако индексът е не повече от 30 
и ако е над 30.

7. Създайте метод ReportResults, който приема като параметри: пореден номер на резултата, BMI индекс, статус. 
Той трябва да изведе на конзолата подходящо съобщение, с което уведомява, че човекът с номер Х има BMI= х.х, 
закръглен до втория знак. За закръглянето изпозлвайте Math.round(BMI);

8. В main метод на програмата създайте Scanner, който чете от стандартен вход, подайте го към getBM(), 
после по върнатия от него резултат вземете статуса с метод getStatus() и извикайте метода reportResults(), 
за да изведете даннитe.
*/

import java.util.Scanner;

public class BMICalculator {
    public static void printIntroduction(){
        System.out.println("This is a body mass index calculator!");
    }
    public double getBMI(Scanner input){
        System.out.print("Enter your height in inches: ");
        double height = input.nextDouble();
        System.out.print("Enter your weight in pounds: ");
        double weight = input.nextDouble();
        return bmiFor(height, weight);
    }
    public double bmiFor(double height, double weight){
        return (double) Math.round((weight*703/(height*height))*100)/100;
        /*double bmiInd = weight*703/(height*height);
        String twoDigitsAfterTheDecimalPoint = String.format("%.2f", bmiInd);
        return Double.parseDouble(twoDigitsAfterTheDecimalPoint);*/
    }
    public String getStatus(double bmiIndex){
        if(bmiIndex <=18.5) return "Underweight!";
        else if(bmiIndex<=25) return "Normal!";
        else if(bmiIndex<=30) return "Overweight!";
        else return "Obese!";
    }
    public static void reportResults(int idNum, double bmiIndex, String status){
        System.out.println("ID Number " + idNum + " has a BMI index " + bmiIndex + " and their status is " + status);
    }

    public static void main(String[] args) {
        printIntroduction();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number of people to calculate their BMI: ");
        int numOfPeople = input.nextInt();
        for(int i = 0; i<numOfPeople; i++){
            BMICalculator p = new BMICalculator();
            double bmi = p.getBMI(input);
            String status = p.getStatus(bmi);
            reportResults(i+1, bmi, status);
        }
        /*BMICalculator p1 = new BMICalculator();
        double bmi = p1.getBMI(input);
        String status = p1.getStatus(bmi);
        reportResults(id, bmi, status);*/
    }
}
