package telesens.academy.lesson10;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class DemoFile {
    public static void main(String[] args) {
        String baseUrl = null; // переменная для пути, где будет находится новый файл
        String manLastnameUrl = null;// переменная для пути, где находится файл с мужскими фамилиями
        String womanLastnameUrl = null;// переменная для пути, где находится файл с женскими фамилиями
        String manNameUrl = null;//переменная для пути, где находится файл с мужскими именами
        String womanNameUrl = null;// переменная для пути, где находится файл с женскими именами
        String basetxtUrl = null;
        int ageFrom = 0;// возраст, взятый из файла
        int ageTo = 0;// возраст, взятый из файла

        ArrayList<String> arrManlastname = new ArrayList<>();// список мужских фамилий
        ArrayList<String> arrWomanLastname = new ArrayList<>();// список женских фамилий
        ArrayList<String> arrManName = new ArrayList<>();// список мужских имен
        ArrayList<String> arrWomanName = new ArrayList<>();// список женских имен
        ArrayList<String> arrOperator = new ArrayList<>(Arrays.asList("Life", "Kievstar", "Vodafone"));// список операторов
        ArrayList<Long> arrOperatorLife = new ArrayList<>(Arrays.asList(380630000000L, 380930000000L, 380730000000L));
        ArrayList<Long> arrOperatorKiev = new ArrayList<>(Arrays.asList(380970000000L, 380670000000L, 380980000000L));
        ArrayList<Long> arrOperatorVodaf = new ArrayList<>(Arrays.asList(380500000000L, 380660000000L, 380950000000L));

        Properties prop = new Properties();
        File file = new File("D:\\Java\\telesens_home\\src\\main\\resources\\java-part.properties");
        try (FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);
            baseUrl = prop.getProperty("subscriber.exc");
            manLastnameUrl = prop.getProperty("male.lastnames");
            womanLastnameUrl = prop.getProperty("female.lastnames");
            manNameUrl = prop.getProperty("male.firstnames");
            womanNameUrl = prop.getProperty("female.firstnames");
            ageFrom = Integer.parseInt(prop.getProperty("age.from"));
            ageTo = Integer.parseInt(prop.getProperty("age.to"));
            basetxtUrl = prop.getProperty("subscriber.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //читаю из файла мужские и женские фамилии и записываю в список
        readData(manLastnameUrl, womanLastnameUrl, arrManlastname, arrWomanLastname);
        //читаю из файла мужские и женские имена и записываю в список
        readData(manNameUrl, womanNameUrl, arrManName, arrWomanName);

        arrManlastname.addAll(arrWomanLastname); // создаю один список с мужскими и женскими фамилиями
        arrManName.addAll(arrWomanName); // создаю один список с мужскими и женскими именами

        /*Random myRandomizer = new Random();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Demo");
        // устанавливаем стиль для чисел
        CellStyle style_for_numbers = workbook.createCellStyle();
        DataFormat dataFormat = workbook.createDataFormat();
        style_for_numbers.setDataFormat(dataFormat.getFormat("###0"));
        for (int r = 0; r < 2000; r++) {
            XSSFRow row = sheet.createRow(r);
            XSSFCell cellNumber = row.createCell(0);
            XSSFCell cellLastName = row.createCell(1);
            sheet.autoSizeColumn(1);
            XSSFCell cellName = row.createCell(2);
            sheet.autoSizeColumn(2);
            XSSFCell cellGender = row.createCell(3);
            XSSFCell cellAge = row.createCell(4);
            XSSFCell cellPhoneNumber = row.createCell(5);
            sheet.autoSizeColumn(5);
            XSSFCell cellOperator = row.createCell(6);


            //записывает порядковый номер
            cellNumber.setCellValue(r + 1);

            // записываем рандомную фамилию
            int random = myRandomizer.nextInt(arrManlastname.size()); // получаю рандомное число
            String randomLastname = getString(arrManlastname, cellLastName, random);

            // записываем рандомное имя
            String randomName = getString(arrManName, cellName, random);

            //устанавливаем пол в соответсвии с именем
            for (String s : arrManName) {
                if (randomName.equals(s)) {
                    cellGender.setCellValue("м");
                }
            }

            for (String s : arrWomanName) {
                if (randomName.equals(s)) {
                    cellGender.setCellValue("ж");
                }
            }

            //записываем случайный возраст
            cellAge.setCellValue((int) (ageFrom + Math.random() * (ageTo - ageFrom)));

            //записываем случайного оператора
            int randomOperator = myRandomizer.nextInt(arrOperator.size());
            String randomOperat = getString(arrOperator, cellOperator, randomOperator);

            //записываем номер телефона в соответсвии с оператором
            cellPhoneNumber.setCellStyle(style_for_numbers);
            switch (randomOperat) {
                case "Life":
                    long number = getNumber(arrOperatorLife, myRandomizer);
                    cellPhoneNumber.setCellValue(number);
                    break;
                case "Kievstar":
                    long number2 = getNumber(arrOperatorKiev, myRandomizer);
                    cellPhoneNumber.setCellValue(number2);
                    break;
                case "Vodafone":
                    long number3 = getNumber(arrOperatorVodaf, myRandomizer);
                    cellPhoneNumber.setCellValue(number3);
                    break;
            }

            try (FileOutputStream out = new FileOutputStream(new File(baseUrl))) {
                workbook.write(out);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }*/

        //Прочитать subscribers.xlsx в коллекцию Map<Long, Subscriber> и сохранить в текстовый файл: subscribers.txt
        Map<Long, Subscriber> map = new HashMap<>();
        try (XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(baseUrl))) {
            XSSFSheet sheet1 = workbook1.getSheet("Demo");
            for (int r = 0; r <= sheet1.getLastRowNum(); r++) {
                XSSFRow row = sheet1.getRow(r);
                Subscriber sub1 = new Subscriber();
                sub1.setId((long) row.getCell(0).getNumericCellValue());
                sub1.setLastName(row.getCell(1).getStringCellValue());
                sub1.setFirstName(row.getCell(2).getStringCellValue());
                String gender = row.getCell(3).getStringCellValue();
                if (gender.equals("ж")) {
                    sub1.setGender(Gender.FEMALE);
                } else {
                    sub1.setGender(Gender.MALE);
                }
                sub1.setAge((int) row.getCell(4).getNumericCellValue());
                sub1.setPhoneNumber(String.valueOf(row.getCell(5).getNumericCellValue()));
                sub1.setOperator(new Operator((long) (r + 1), row.getCell(6).getStringCellValue()));
                map.put((long) (r + 1), sub1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileWriter fstream = new FileWriter(basetxtUrl); BufferedWriter out = new BufferedWriter(fstream)) {
            Iterator<Map.Entry<Long, Subscriber>> it = map.entrySet().iterator();
            while (it.hasNext()) {

                Map.Entry<Long, Subscriber> pairs = it.next();
                out.write(pairs.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Прочитать subscribers.xlsx в коллекцию List<Subscriber> отсортировать сразу по 4 полям:
        //		- оператору
        //		- по возрасту
        //		- по фамилии
        //		- по имени


    }

    private static String getString(ArrayList<String> arrManName, XSSFCell cellName, int random) {
        String randomName = arrManName.get(random); // плучаю имя по рандомному номеру
        cellName.setCellValue(randomName);
        return randomName;
    }

    private static void readData(String manNameUrl, String womanNameUrl, ArrayList<String> arrManName, ArrayList<String> arrWomanName) {
        try (BufferedReader br2 = new BufferedReader(new FileReader(manNameUrl)); BufferedReader br3 = new BufferedReader(new FileReader(womanNameUrl))) {
            String content;
            while ((content = br2.readLine()) != null) {
                arrManName.add(content);
            }
            while ((content = br3.readLine()) != null) {
                arrWomanName.add(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getNumber(ArrayList<Long> arrOperatorLife, Random myRandomizer) {
        int randomCodLife = myRandomizer.nextInt(arrOperatorLife.size());
        long randomCodL = arrOperatorLife.get(randomCodLife);
        return (long) (randomCodL + (Math.random() * 9999999L));
    }
}
