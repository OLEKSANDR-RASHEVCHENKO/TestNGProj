package UsingTestNgXMLFile;

import org.testng.annotations.Test;

public class ClassC {
    @Test(priority = 1)
    public void methodCOne(){
        System.out.println("ClassC - methodCOne");
    }
    @Test(priority = 2)
    public void methodCTwo(){
        System.out.println("ClassC - methodCTwo");
    }
    @Test(priority = 3)
    public void methodCThree(){
        System.out.println("ClassC - methodCThree");
    }
}
