package NVHTN;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class Tools {

    private static final File rootPath = new File(Tools.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    public static final String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    public static final String phonePattern = "^(01\\d{9}|09\\d{8}|\\(0\\d{1,3}\\)\\d{7}|0\\d{1,3}[\\.\\-]\\d{7})$";
    public static final String CMNDPattern = "^\\d{9}$";
    public static SimpleDateFormat maLopFormatter = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat countTimeFormatter = new SimpleDateFormat("HH:mm:ss SSS");
    public static SimpleDateFormat runTimeFormatter = new SimpleDateFormat("mm:ss SSS");
    public static final int InvalidCompare = -1000;

    public static String getFileExtension(String filename) {
        return filename.substring(filename.indexOf('.') + 1);
    }

    public static String MD5(String content) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(content.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public static String uploadImage(String ImgPath, String imagePath, String newImageName) throws Exception {
        File source = new File(imagePath);
        if (source.exists() && !source.isDirectory()) {
            String newImagePath = ImgPath + newImageName + "." + Tools.getFileExtension(imagePath);
            File dest = new File(newImagePath);
            try {
                Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
                return newImagePath;
            } catch (IOException e) {
                throw e;
            }
        } else {
            throw new Exception("DB4O-uploadImage: the source image " + imagePath + " is not exist");
        }
    }

    public static boolean isValidEmailAddress(String email) {
        return isValid(email, emailPattern);
    }

    public static boolean isValidPhoneNumber(String phone) {
        return isValid(phone, phonePattern);
    }

    public static boolean isValidCMND(String CMND) {
        return isValid(CMND, CMNDPattern);
    }

    private static boolean isValid(String value, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(value);
        return m.matches();
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static float timeDifference(Date from, Date to) {
        long minutes = TimeUnit.MINUTES.toSeconds(to.getTime() - from.getTime());
        return (float) minutes / 60;
    }

    public static int dateDifference(Date from, Date to) {
        int count = 0;
        if (from.after(to)) {
            return -1;
        } else {
            while (from.before(to)) {
                from = Tools.addDays(from, count);
                count++;
            }
        }
        return count + 1;
    }

    public static int RandomNumber(int min, int max) throws Exception {
        if (max < min) {
            throw new Exception("Tools - RandomNumber: MIN must smaller than MAX");
        }
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static String FormatZero(long value, int space) {
        return String.format("%0" + space + "d", value);
    }

    public static String FormatMoney(long value) {
        DecimalFormat df = new DecimalFormat("###,###,###,###");
        return df.format(value);
    }

    public static String FormatTime(float value) {
        DecimalFormat df = new DecimalFormat("###,###.0");
        return df.format(value);
    }

    public static Point FormCenterScreen(JFrame fMain, JInternalFrame fChild) {
        //Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension fMainSize = fMain.getSize();
        Dimension fChildSize = fChild.getSize();
        int x = (fMainSize.width - fChildSize.width) / 2;
        int y = (fMainSize.height - fChildSize.height) / 2;
        return new Point(x, y);
    }

    public static void ClearTable(JTable tb) throws Exception {
        DefaultTableModel tbm = (DefaultTableModel) tb.getModel();
        tbm.setRowCount(0);
        tbm.fireTableDataChanged();
    }

    public static void LoadCSS(JEditorPane jep, String cssName) throws MalformedURLException {
        HTMLEditorKit kit = new HTMLEditorKit();
        URL url = new URL(rootPath.toURI() + "../../css/" + cssName);  //Windows
        //URL url = new URL(rootPath.toURI() + "../../css/" + cssName);
        //System.out.println("file:///" + rootPath.toURI() + "../../css/" + cssName);
        StyleSheet styleSheet = new StyleSheet();
        styleSheet.importStyleSheet(url);
        kit.setStyleSheet(styleSheet);
        jep.setEditorKit(kit);
    }

    public static String LayGioHoc(Date gioBatDau, boolean hienGio) throws ParseException {
        if (gioBatDau.equals(Tools.timeFormatter.parse("07:00"))) {
            return (hienGio ? "(7:00 - 9:00)" : "A----");
        } else if (gioBatDau.equals(Tools.timeFormatter.parse("09:00"))) {
            return (hienGio ? "(9:00 - 11:00)": "-B---");
        } else if (gioBatDau.equals(Tools.timeFormatter.parse("13:30"))) {
            return (hienGio ? "(13:30 - 15:30)":"--C--");
        } else if (gioBatDau.equals(Tools.timeFormatter.parse("15:30"))) {
            return (hienGio ? "(15:30 - 17:30)":"---D-");
        } else {
            return (hienGio ? "(18:30 - 20:30)":"----E");
        }
    }

    public static int LayTuanHoc(Date ngay1, Date ngay2) {
        Date ngay = ngay1;
        int soTuan = 0;
        while (ngay.compareTo(ngay2) < 0) {
            soTuan++;
            ngay = Tools.addDays(ngay, 7);
        }
        soTuan++;
        return soTuan;
    }

    public static String DinhDangTuan(String tuan, String mauSac) {
        String tuanHoc = "";
        boolean chuaDong = true;
        for (int i = 0; i < tuan.length(); i++) {
            tuanHoc += tuan.charAt(i);
            if (i % 20 == 0) {
                tuanHoc += "</b></span>";
                chuaDong = false;
            } else if (i % 10 == 0) {
                tuanHoc += "<span style='color:" + mauSac + ";'><b>";
                chuaDong = true;
            }
        }
        if (chuaDong) {
            tuanHoc += "</b></span>";
        }
        return tuanHoc;
    }
}