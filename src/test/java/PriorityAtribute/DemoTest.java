package PriorityAtribute;

import org.testng.annotations.Test;

public class DemoTest {
    @Test(priority = 1)
    public void sampleOne(){
        System.out.println("sample one");
    }
    @Test(priority = 1)
    public void sampleTwo(){
        System.out.println("sample two");
    }
    @Test(priority = 1)
    public void sampleThree(){
        System.out.println("sample Three");
    }
    @Test(priority = 4)
    public void sampleFour(){
        System.out.println("sample Four");
    }
    @Test(priority = 5)
    public void sampleFive(){
        System.out.println("sample Five");
    }
}
