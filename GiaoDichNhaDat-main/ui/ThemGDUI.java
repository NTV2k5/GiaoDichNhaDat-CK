package ui;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import control.ThemGDControl;

public class ThemGDUI {
    private PrintWriter screenOut = null;
    private Scanner keyBoardInput = null;
    private String maGDPrompt, ngayGDPrompt, donGiaPrompt, dienTichPrompt, loaiGDPrompt, loaiDatPrompt, loaiNhaPrompt, diaChiPrompt;
    private ThemGDControl themGDControl = null;

    public ThemGDUI() {

    }

    public ThemGDUI(PrintWriter screenOut, Scanner keyBoardInput, ThemGDControl themGDControl) {
        this(screenOut, keyBoardInput);
        this.themGDControl = themGDControl;
    }

    public ThemGDUI(PrintWriter screenOut, Scanner keyBoardInput) {
        this.screenOut = screenOut;
        this.keyBoardInput = keyBoardInput;
        maGDPrompt = "Nhap ma GD: ";
        ngayGDPrompt = "Nhap ngay GD: ";
        donGiaPrompt = "Nhap don gia: ";
        dienTichPrompt = "Nhap dien tich: ";
        loaiGDPrompt = "Nhap loai giao dich [\"Dat\" / \"Nha\"]: ";
        loaiDatPrompt = "Nhap loai dat [\"A\" / \"B\" / \"C\"]: ";
        loaiNhaPrompt = "Nhap loai nha [\"Cao cap\" / \"Thuong\"]: ";
        diaChiPrompt = "Nhap dia chi: ";
    }

    public void nhapThongTinGD() {
        screenOut.print(maGDPrompt);
        screenOut.flush();
        int maGD = keyBoardInput.nextInt();
        screenOut.print(ngayGDPrompt);
        screenOut.flush();
        String ngayGD = keyBoardInput.nextLine();
        Date ngayGDJava = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            ngayGDJava = simpleDateFormat.parse(ngayGD);
        } catch (ParseException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        screenOut.print(donGiaPrompt);
        screenOut.flush();
        double donGia = keyBoardInput.nextDouble();
        screenOut.print(dienTichPrompt);
        screenOut.flush();
        int dienTich = keyBoardInput.nextInt();
        screenOut.print(loaiGDPrompt);
        screenOut.flush();
        String loaiGD = keyBoardInput.nextLine();

        if("Dat".equalsIgnoreCase(loaiGD)) {
            screenOut.print(loaiDatPrompt);
            screenOut.flush();
            char loaiDat = keyBoardInput.next().charAt(0);
            themGDControl.taoGD(maGD, ngayGDJava, donGia, loaiDat, dienTich);
        }

        if("Nha".equalsIgnoreCase(loaiGD)) {
            screenOut.print(loaiNhaPrompt);
            screenOut.flush();
            String loaiNha = keyBoardInput.nextLine();
            screenOut.print(diaChiPrompt);
            screenOut.flush();
            String diaChi = keyBoardInput.nextLine();
            themGDControl.taoGD(maGD, ngayGDJava, donGia, loaiNha,diaChi, dienTich);
        }
        

    }
    
}
