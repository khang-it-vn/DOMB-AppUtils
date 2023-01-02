package app_utils.ktteam.src.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InformationUtil {
    public final static String FileHoTen = "HoTen.txt";
    public final static String FileSDT = "SoDienThoai.txt";
    public final static String FileDiaChi = "DiaChi.txt";
    public final static String FileEmail = "Email.txt";


    public static void writeToFile(String data,  FileOutputStream fos) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // write object to file
            oos.writeObject(data);

            // closing resources
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readToFile( FileInputStream fis)  {
        String data = "";
        try{

            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (String) ois.readObject();

            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }
}
