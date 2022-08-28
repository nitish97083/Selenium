package TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.TestData;

public class DataProviders {


    @DataProvider(name ="meraNameTarjan" )
    public Object[][] getTestDat(){
    return TestData.readExcel();
    }


    @Test(dataProvider = "meraNameTarjan")
    public void dataProvider(String fName,String lName, String mNumber,String pass){

        System.out.println(fName+""+lName +" "+mNumber+ " "+pass);
    }
}
