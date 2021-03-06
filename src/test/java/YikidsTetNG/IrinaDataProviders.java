package YikidsTetNG;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class IrinaDataProviders {

    @DataProvider
    public static Iterator<Object[]> loadLogins() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/registeredLogins.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }


    @DataProvider
    public static Iterator<Object[]> loadInvalidLoginFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/IrinaNegativLogin.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> singUpNegativFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/IrinaNegativSingUp.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }


    @DataProvider
    public static Iterator<Object[]> SignUpAddress() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/webinar.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }


    @DataProvider
    public static Iterator<Object[]> loadGrafFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/graphs.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loadProfileDataFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/profile2.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loadTypesFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/progress.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loadMedicineTypesFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/medicine.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> optionsFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/options.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> usersSimple() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{"demo30", "1234"});
        data.add(new Object[]{"demo29", "1234"});
        return data.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> usersSimpleNeg() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{" ", " "});
        data.add(new Object[]{"admin", "admin"});
        return data.iterator();
    }

    //-------DataProvider for add employee-----//
    @DataProvider
    public static Iterator<Object[]> loadEmpDataFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/addEmp.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loadDataForProfile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/profiles.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loadNegativeDataForProfile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/profilesNegative.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loadDataForMDRating() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                IrinaDataProviders.class.getResourceAsStream("/mdrating.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }

  /*  @DataProvider
    public Object[][] getExcelData(String fileName, String sheetName) {
        String[][] arrayExcelData = null;
        try {
            FileInputStream fs = new FileInputStream(fileName);
            Workbook wb = Workbook.getWorkbook(fs);
            Sheet sh = wb.getSheet(sheetName);

            int totalNoOfCols = sh.getColumns();
            int totalNoOfRows = sh.getRows();

            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];

            for (int i= 1 ; i < totalNoOfRows; i++) {

                for (int j=0; j < totalNoOfCols; j++) {
                    arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return arrayExcelData;
    }
*/

    @DataProvider
    public Iterator<Object[]> users() {
        List<Object[]> data = new ArrayList<Object[]>();
        for (int i = 0; i < 5; i++) {
            data.add(new Object[]{
                    generateRandomName(), generateRandomPassword()
            });
        }
        return data.iterator();
    }

    private Object generateRandomPassword() {
        return "pass" + new Random().nextInt();
    }
    //---------------End--------------------//

    private Object generateRandomName() {
        return "demo" + new Random().nextInt();
    }
}