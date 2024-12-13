package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entity.GiaoDich;

public class ThemGDDAOFile {

    private File fileData = null;

    public ThemGDDAOFile(String fileName) {
        fileData = new File(fileName);
    }

    /*
     public void addGiaoDich(GiaoDich GD) {

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileData);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // Ghi danh sách giao dịch vào file
            objectOutputStream.writeObject(GD);
            objectOutputStream.close();
            System.out.println("Ghi dữ liệu giao dịch thành công vào file: " + fileData.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */


    public void addGiaoDich(ArrayList<GiaoDich> dsGD) {

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileData);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // Ghi danh sách giao dịch vào file
            objectOutputStream.writeObject(dsGD);
            objectOutputStream.close();
            System.out.println("Ghi dữ liệu giao dịch thành công vào file: " + fileData.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Đọc danh sách giao dịch
    public ArrayList<GiaoDich> loadGiaoDich() {
        if (!fileData.exists()) {
            return new ArrayList<>(); // Trả về danh sách rỗng nếu file chưa tồn tại
        }
        try (FileInputStream fileInputStream = new FileInputStream(fileData);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ArrayList<GiaoDich>) objectInputStream.readObject(); // Đọc danh sách từ file
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
