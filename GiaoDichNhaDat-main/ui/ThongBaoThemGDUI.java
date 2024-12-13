package ui;

import java.io.PrintWriter;

public class ThongBaoThemGDUI {

    private PrintWriter screenOut = null;

    public ThongBaoThemGDUI() {

    }

    public ThongBaoThemGDUI(PrintWriter screenOut) {
        this.screenOut = screenOut;
    }

    public void inThongBao(String thongBao) {
        screenOut.println(thongBao);
    }

}
