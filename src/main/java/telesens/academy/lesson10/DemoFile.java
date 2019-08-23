package telesens.academy.lesson10;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DemoFile {
    private  static  final Logger LOG= LogManager.getLogger(DemoFile.class.getName());
    public static void main(String[] args) {
        String subscriberXlsxUrl = null; // переменная для пути, где будет находится новый файл
        String manLastnameUrl = null;// переменная для пути, где находится файл с мужскими фамилиями
        String womanLastnameUrl = null;// переменная для пути, где находится файл с женскими фамилиями
        String manNameUrl = null;//переменная для пути, где находится файл с мужскими именами
        String womanNameUrl = null;// переменная для пути, где находится файл с женскими именами
        String subscriberTxtUrl = null;
        String subscriberSortTxtUrl = null;
        String zipFileUrl = null;
        int ageFrom = 0;// возраст, взятый из файла
        int ageTo = 0;// возраст, взятый из файла

        ArrayList<String> arrManlastname = new ArrayList<>();// список мужских фамилий
        ArrayList<String> arrWomanLastname = new ArrayList<>(); // список женских фамилий
        ArrayList<String> arrAllLastname = new ArrayList<>();
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
            subscriberXlsxUrl = prop.getProperty("subscriber.exc");
            manLastnameUrl = prop.getProperty("male.lastnames");
            womanLastnameUrl = prop.getProperty("female.lastnames");
            manNameUrl = prop.getProperty("male.firstnames");
            womanNameUrl = prop.getProperty("female.firstnames");
            ageFrom = Integer.parseInt(prop.getProperty("age.from"));
            ageTo = Integer.parseInt(prop.getProperty("age.to"));
            subscriberTxtUrl = prop.getProperty("subscriber.txt");
            subscriberSortTxtUrl = prop.getProperty("subscriber.sort.txt");
            zipFileUrl = prop.getProperty("subscriber.arc");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //читаем из файла мужские и женские фамилии и записываум в список
        readData(manLastnameUrl, womanLastnameUrl, arrManlastname, arrWomanLastname);
        //читаем из файла мужские и женские имена и записываем в список
        readData(manNameUrl, womanNameUrl, arrManName, arrWomanName);

        //создаем список с женскими и мужскими фамилиями
        arrAllLastname.addAll(arrManlastname);
        arrAllLastname.addAll(arrWomanLastname);

        Random myRandomizer = new Random();

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
            String randomLastname = getValue(arrAllLastname, myRandomizer, cellLastName);

            // записываем рандомное имя
            int randomWoman = myRandomizer.nextInt(arrWomanName.size());
            int randomMan = myRandomizer.nextInt(arrManName.size());
            String randomName = null;
            for (String s : arrWomanLastname) {
                if (randomLastname.equals(s)) {
                    randomName = getValue2(arrWomanName, cellName, randomWoman);
                }
            }
            for (String s : arrManlastname) {
                if (randomLastname.equals(s)) {
                    randomName = getValue2(arrManName, cellName, randomMan);
                }
            }

            //устанавливаем пол в соответсвии с именем
            for (String s : arrManName) {
                assert randomName != null;
                if (randomName.equals(s)) {
                    cellGender.setCellValue("м");
                }
            }

            for (String s : arrWomanName) {
                assert randomName != null;
                if (randomName.equals(s)) {
                    cellGender.setCellValue("ж");
                }
            }

            //записываем случайный возраст
            cellAge.setCellValue((int) (ageFrom + Math.random() * (ageTo - ageFrom)));

            //записываем случайного оператора
            String randomOperat = getValue(arrOperator, myRandomizer, cellOperator);

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


            assert subscriberXlsxUrl != null;
            try (FileOutputStream out = new FileOutputStream(new File(subscriberXlsxUrl))) {
                workbook.write(out);
                LOG.info(workbook.getMapInfo());

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        //Прочитать subscribers.xlsx в коллекцию Map<Long, Subscriber> и сохранить в текстовый файл: subscribers.txt
        Map<Long, Subscriber> map = new HashMap<>();
        try (XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(subscriberXlsxUrl))) {
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

        try (FileWriter fstream = new FileWriter(subscriberTxtUrl); BufferedWriter out = new BufferedWriter(fstream)) {
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

        List<Subscriber> list = new ArrayList<>();
        try (XSSFWorkbook workbook2 = new XSSFWorkbook(new FileInputStream(subscriberXlsxUrl))) {
            XSSFSheet sheet2 = workbook2.getSheet("Demo");
            for (int r = 0; r <= sheet2.getLastRowNum(); r++) {
                XSSFRow row = sheet2.getRow(r);
                Subscriber sub2 = new Subscriber();
                sub2.setId((long) row.getCell(0).getNumericCellValue());
                sub2.setLastName(row.getCell(1).getStringCellValue());
                sub2.setFirstName(row.getCell(2).getStringCellValue());
                String gender = row.getCell(3).getStringCellValue();
                if (gender.equals("ж")) {
                    sub2.setGender(Gender.FEMALE);
                } else {
                    sub2.setGender(Gender.MALE);
                }
                sub2.setAge((int) row.getCell(4).getNumericCellValue());
                sub2.setPhoneNumber(String.valueOf(row.getCell(5).getNumericCellValue()));
                sub2.setOperator(new Operator((long) (r + 1), row.getCell(6).getStringCellValue()));
                list.add(r, sub2);

            }
            Collections.sort(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileWriter fstream = new FileWriter(subscriberSortTxtUrl); BufferedWriter out = new BufferedWriter(fstream)) {
            Iterator<Subscriber> it2 = list.iterator();
            while (it2.hasNext()) {
                out.write(it2.next() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Прочитать 1-ый десять строк файла sort-subscribers.txt и вывести на экран
        //(путь к файлу взять из 'java-part.properties')
        try (BufferedReader br = new BufferedReader(new FileReader(subscriberSortTxtUrl)))//dates from file
        {
            int countRow = 0;
            while (countRow < 11) {
                String abonent = br.readLine();
                System.out.println(abonent);
                countRow++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Упаковать файлы 'subscribers.txt' и 'java-part.properties' в zip архив 'subscriber.zip'
        //		(путь к исходным файлам и zip архиву брать из файла 'java-part.properties')

        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipFileUrl));
            FileInputStream fis= new FileInputStream(subscriberTxtUrl);FileInputStream fis2= new FileInputStream("D:\\Java\\telesens_home\\src\\main\\resources\\java-part.properties"))
        {
            ZipEntry entry1=new ZipEntry("subscriber.txt");
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            ZipEntry entry2=new ZipEntry("java-part.properties");
            zout.putNextEntry(entry2);
            // считываем содержимое файла в массив byte
            byte[] buffer2 = new byte[fis2.available()];
            fis2.read(buffer2);
            // добавляем содержимое к архиву
            zout.write(buffer2);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    private static String getValue2(ArrayList<String> arrayList, XSSFCell xssfCell, int random) {
        String randomName = arrayList.get(random);
        xssfCell.setCellValue(randomName);
        return randomName;
    }

    private static String getValue(ArrayList<String> arrayList, Random myRandomizer, XSSFCell xssfCell) {
        int random = myRandomizer.nextInt(arrayList.size());
        return getValue2(arrayList,xssfCell,random);
    }


    private static void readData(String firstUrl, String secondUrl, ArrayList<String> arrFirst, ArrayList<String> arrSecond) {
        try (BufferedReader br2 = new BufferedReader(new FileReader(firstUrl)); BufferedReader br3 = new BufferedReader(new FileReader(secondUrl))) {
            String content;
            while ((content = br2.readLine()) != null) {
                arrFirst.add(content);
            }
            while ((content = br3.readLine()) != null) {
                arrSecond.add(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getNumber(ArrayList<Long> arrOperator, Random myRandomizer) {
        int randomCodOfOperator = myRandomizer.nextInt(arrOperator.size());
        long randomCod = arrOperator.get(randomCodOfOperator);
        return (long) (randomCod + (Math.random() * 9999999L));
    }
}
