package control;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import database.ThemGDDAOFile;
import entity.GiaoDich;
import entity.GiaoDichDat;
import entity.GiaoDichNha;
import ui.ThongBaoThemGDUI;


public class ThemGDControl {

    private ThemGDDAOFile themGDDAOFile = null;
    private ThongBaoThemGDUI thongBaoThemGDUI = null;

    public ThemGDControl() {

    }

    public ThemGDControl(ThemGDDAOFile themGDDAOFile) {
        this.themGDDAOFile = themGDDAOFile;
    }

    // Giao dich Dat
    public void taoGD(int maGD, Date ngayGD, double donGia, char loaiDat, int dienTich) {
        // TODO Auto-generated method stub
        GiaoDichDat gdDat = new GiaoDichDat(maGD, ngayGD, donGia, loaiDat, dienTich);
        themGD(gdDat);

    }

    // Giao dich Nha
    public void taoGD(int maGD, Date ngayGD, double donGia, String loaiNha, String diaChi, int dienTich) {
        // TODO Auto-generated method stub
        GiaoDichNha gdNha = new GiaoDichNha(maGD, ngayGD, donGia, loaiNha, diaChi, dienTich);
        themGD(gdNha);
        
    }

    public void setThongBaoThemGDUI(ThongBaoThemGDUI thongBaoThemGDUI) {
        this.thongBaoThemGDUI = thongBaoThemGDUI;
    }

    public void themGD(GiaoDich gd) {
        themGDDAOFile.addGiaoDich(gd);
        thongBaoThemGDUI.inThongBao("Them giao dich thanh cong!!!");
    }
}
