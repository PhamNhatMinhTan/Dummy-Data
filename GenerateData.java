package NVHTN;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author vhkhanh
 */
public class GenerateData {

    public String path = "/home/ptkdiem/Documents/Studies/Master/HK1/docs/1_CSDLHDT/Project/NhanVien/GiaoVien/";
    private ArrayList<String> dsHinhGiaoVien;
    private final String[] dsEmail = {
        "gmail.com",
        "gmail.com.vn",
        "yahoo.com",
        "yahoo.com.vn",
        "ymail.com",
        "hotmail.com",
        "outlook.com"
    };
    private final String[] dsHo = {
        "Bành", "Bùi", "Cao", "Cù", "Đàm", "Đặng", "Đào", "Đinh", "Đỗ", "Đoàn", "Dương", "Đường", "Hà", "Hồ", "Hứa", "Huỳnh", "Khưu", "Lại", "Lâm", "Lê", "Lương", "Lý", "Mã", "Mạc", "Mai", "Ngô", "Nguyễn", "Ông", "Phạm", "Phan", "Phùng", "Quách", "Tạ", "Tăng", "Thạch", "Tô", "Trần", "Trang", "Triệu", "Trịnh", "Trương", "Võ", "Vũ", "Vương"
    };
    private final String[] dsTenNam1 = {
        "Bảo An", "Bình An", "Ðăng An", "Duy An", "Khánh An", "Nam An", "Phước An", "Thành An", "Thế An", "Thiên An", "Trường An", "Việt An", "Xuân An", "Công Ân", "Ðức Ân", "Gia Ân", "Hoàng Ân", "Minh Ân", "Phú Ân", "Thành Ân", "Thiên Ân", "Thiện Ân", "Vĩnh Ân", "Ngọc Ẩn", "Chí Anh", "Ðức Anh", "Dương Anh", "Gia Anh", "Hùng Anh", "Huy Anh", "Minh Anh", "Quang Anh", "Quốc Anh", "Thế Anh", "Thiếu Anh", "Thuận Anh", "Trung Anh", "Tuấn Anh", "Tùng Anh", "Tường Anh", "Việt Anh", "Vũ Anh", "Hồ Bắc", "Hoài Bắc", "Gia Bạch", "Công Bằng", "Ðức Bằng", "Hải Bằng", "Yên Bằng", "Chí Bảo", "Ðức Bảo", "Duy Bảo", "Gia Bảo", "Hữu Bảo", "Nguyên Bảo", "Quốc Bảo", "Thiệu Bảo", "Tiểu Bảo", "Ðức Bình", "Gia Bình", "Hải Bình", "Hòa Bình", "Hữu Bình", "Khánh Bình", "Kiên Bình", "Kiến Bình", "Phú Bình", "Quốc Bình", "Tân Bình", "Tất Bình", "Thái Bình", "Thế Bình", "Xuân Bình", "Yên Bình", "Quang Bửu", "Thiên Bửu", "Khải Ca", "Gia Cần", "Duy Cẩn", "Gia Cẩn", "Hữu Canh", "Gia Cảnh", "Hữu Cảnh", "Minh Cảnh", "Ngọc Cảnh", "Đức Cao", "Xuân Cao", "Bảo Chấn", "Bảo Châu", "Hữu Châu", "Phong Châu", "Thành Châu", "Tuấn Châu", "Tùng Châu", "Đình Chiến", "Mạnh Chiến", "Minh Chiến", "Hữu Chiến", "Huy Chiểu", "Trường Chinh", "Ðức Chính", "Trọng Chính", "Trung Chính", "Việt Chính", "Ðình Chương", "Tuấn Chương", "Minh Chuyên", "An Cơ", "Chí Công", "Thành Công", "Xuân Cung", "Hữu Cương", "Mạnh Cương", "Duy Cương", "Việt Cương", "Bá Cường", "Ðức Cường", "Ðình Cường", "Duy Cường", "Hùng Cường", "Hữu Cường", "Kiên Cường", "Mạnh Cường", "Ngọc Cường", "Phi Cường", "Phúc Cường", "Thịnh Cường", "Việt Cường", "Ngọc Đại", "Quốc Ðại", "Minh Dân", "Thế Dân", "Minh Ðan", "Nguyên Ðan", "Sỹ Ðan", "Hải Ðăng", "Hồng Ðăng", "Minh Danh", "Ngọc Danh", "Quang Danh", "Thành Danh", "Hưng Ðạo", "Thanh Ðạo", "Bình Ðạt", "Ðăng Ðạt", "Hữu Ðạt", "Minh Ðạt", "Quang Ðạt", "Quảng Ðạt", "Thành Ðạt", "Ðắc Di", "Phúc Ðiền", "Quốc Ðiền", "Phi Ðiệp", "Ðình Diệu", "Vinh Diệu", "Mạnh Ðình", "Bảo Ðịnh", "Hữu Ðịnh", "Ngọc Ðoàn", "Thanh Ðoàn", "Thành Doanh", "Thế Doanh", "Ðình Ðôn", "Quang Đông", "Từ Ðông", "Viễn Ðông", "Lâm Ðông", "Bách Du", "Thụy Du", "Hồng Đức", "Anh Ðức", "Gia Ðức", "Kiến Ðức", "Minh Ðức", "Quang Ðức", "Tài Ðức", "Thái Ðức", "Thiên Ðức", "Thiện Ðức", "Tiến Ðức", "Trung Ðức", "Tuấn Ðức", "Hoàng Duệ", "Anh Dũng", "Chí Dũng", "Hoàng Dũng", "Hùng Dũng", "Lâm Dũng", "Mạnh Dũng", "Minh Dũng", "Nghĩa Dũng", "Ngọc Dũng", "Nhật Dũng", "Quang Dũng", "Tấn Dũng", "Thế Dũng", "Thiện Dũng", "Tiến Dũng", "Trí Dũng"
    };
    private final String[] dsTenNam2 = {
        "Trọng Dũng", "Trung Dũng", "Tuấn Dũng", "Việt Dũng", "Hiếu Dụng", "Ðại Dương", "Ðình Dương", "Ðông Dương", "Hải Dương", "Nam Dương", "Quang Dương", "Thái Dương", "Việt Dương", "Anh Duy", "Bảo Duy", "Ðức Duy", "Khắc Duy", "Khánh Duy", "Nhật Duy", "Phúc Duy", "Thái Duy", "Trọng Duy", "Việt Duy", "Thế Duyệt", "Vương Gia", "Bảo Giang", "Chí Giang", "Công Giang", "Ðức Giang", "Hải Giang", "Hòa Giang", "Hoàng Giang", "Hồng Giang", "Khánh Giang", "Long Giang", "Minh Giang", "Thiện Giang", "Trường Giang", "Nguyên Giáp", "Huy Kha", "Anh Khải", "Ðức Khải", "Hoàng Khải", "Quang Khải", "Tuấn Khải", "Việt Khải", "An Khang", "Chí Khang", "Ðức Khang", "Duy Khang", "Hoàng Khang", "Hữu Khang", "Minh Khang", "Ngọc Khang", "Nguyên Khang", "Như Khang", "Phúc Khang", "Tấn Khang", "Việt Khang", "Hữu Khanh", "Tuấn Khanh", "Bảo Khánh", "Ðăng Khánh", "Duy Khánh", "Gia Khánh", "Huy Khánh", "Minh Khánh", "Quốc Khánh", "Trọng Khánh", "Chí Khiêm", "Ðức Khiêm", "Duy Khiêm", "Gia Khiêm", "Huy Khiêm", "Thành Khiêm", "Thiện Khiêm", "Anh Khoa", "Ðăng Khoa", "Việt Khoa", "Xuân Khoa", "Anh Khôi", "Hoàng Khôi", "Hữu Khôi", "Minh Khôi", "Ngọc Khôi", "Nguyên Khôi", "Việt Khôi", "Đăng Khương", "Ngọc Khương", "Nhật Khương", "Chí Kiên", "Ðức Kiên", "Gia Kiên", "Trọng Kiên", "Trung Kiên", "Xuân Kiên", "Gia Kiệt", "Liên Kiệt", "Minh Kiệt", "Thường Kiệt", "Tuấn Kiệt", "Trọng Kim", "Bá Kỳ", "Cao Kỳ", "Minh Kỳ", "Trường Kỳ", "Hiệp Hà", "Huy Hà", "Mạnh Hà", "Quang Hà", "Sơn Hà", "Trọng Hà", "Công Hải", "Ðông Hải", "Ðức Hải", "Duy Hải", "Hoàng Hải", "Khánh Hải", "Minh Hải", "Nam Hải", "Ngọc Hải", "Phi Hải", "Phú Hải", "Quang Hải", "Quốc Hải", "Sơn Hải", "Thanh Hải", "Trung Hải", "Tuấn Hải", "Việt Hải", "Vĩnh Hải", "Xuân Hãn", "Ðại Hành", "Hữu Hạnh", "Nguyên Hạnh", "Quốc Hạnh", "Công Hào", "Hiệp Hào", "Minh Hào", "Thanh Hào", "Trí Hào", "Ðình Hảo", "Công Hậu", "Thanh Hậu", "Duy Hiền", "Quốc Hiền", "Tạ Hiền", "Bảo Hiển", "Ngọc Hiển", "Quốc Hiển", "Gia Hiệp", "Hòa Hiệp", "Hoàng Hiệp", "Hữu Hiệp", "Phú Hiệp", "Tiến Hiệp", "Quốc Hiệp", "Chí Hiếu", "Công Hiếu", "Duy Hiếu", "Minh Hiếu", "Tất Hiếu", "Trọng Hiếu", "Trung Hiếu", "Xuân Hiếu", "Bảo Hòa", "Ðạt Hòa", "Ðức Hòa", "Gia Hòa", "Hiệp Hòa", "Khải Hòa", "Minh Hòa", "Nghĩa Hòa", "Nhật Hòa", "Phúc Hòa", "Quang Hòa", "Quốc Hòa", "Tất Hòa", "Thái Hòa", "Xuân Hòa", "Quốc Hoài", "Công Hoán", "Quốc Hoàn", "Khánh Hoàn", "Anh Hoàng", "Bảo Hoàng", "Duy Hoàng", "Gia Hoàng", "Hữu Hoàng", "Huy Hoàng", "Khánh Hoàng", "Minh Hoàng", "Phi Hoàng", "Quốc Hoàng", "Sỹ Hoàng", "Tuấn Hoàng", "Việt Hoàng", "Tiến Hoạt", "Khánh Hội", "Nhật Hồng"
    };
    private final String[] dsTenNam3 = {
        "Việt Hồng", "Ðình Hợp", "Hòa Hợp", "Gia Huấn", "Minh Huấn", "Chấn Hùng", "Duy Hùng", "Gia Hùng", "Hữu Hùng", "Mạnh Hùng", "Minh Hùng", "Nhật Hùng", "Phi Hùng", "Phú Hùng", "Quang Hùng", "Quốc Hùng", "Thế Hùng", "Trí Hùng", "Trọng Hùng", "Tuấn Hùng", "Việt Hùng", "Chấn Hưng", "Gia Hưng", "Minh Hưng", "Nam Hưng", "Phú Hưng", "Phúc Hưng", "Quang Hưng", "Quốc Hưng", "Thiên Hưng", "Vĩnh Hưng", "Chính Hữu", "Quang Hữu", "Trí Hữu", "Bảo Huy", "Ðức Huy", "Gia Huy", "Khánh Huy", "Minh Huy", "Ngọc Huy", "Nhật Huy", "Quang Huy", "Quốc Huy", "Thanh Huy", "Việt Huy", "Xuân Huy", "Bảo Huỳnh", "Ân Lai", "Bảo Lâm", "Huy Lâm", "Hoàng Lâm", "Phúc Lâm", "Quang Lâm", "Sơn Lâm", "Thế Lâm", "Tùng Lâm", "Tường Lâm", "Hoàng Lân", "Ngọc Lân", "Quang Lân", "Tường Lân", "Công Lập", "Gia Lập", "Hữu Lễ", "Tôn Lễ", "Hiếu Liêm", "Thanh Liêm", "Hoàng Linh", "Quang Linh", "Tuấn Linh", "Tùng Linh", "Hồng Lĩnh", "Huy Lĩnh", "Tường Lĩnh", "Bá Lộc", "Công Lộc", "Ðinh Lộc", "Ðình Lộc", "Nam Lộc", "Nguyên Lộc", "Phước Lộc", "Quang Lộc", "Xuân Lộc", "Tấn Lợi", "Thắng Lợi", "Thành Lợi", "Bá Long", "Bảo Long", "Ðức Long", "Hải Long", "Hoàng Long", "Hữu Long", "Kim Long", "Phi Long", "Tân Long", "Thăng Long", "Thanh Long", "Thành Long", "Thụy Long", "Trường Long", "Tuấn Long", "Việt Long", "Thiện Luân", "Vĩnh Luân", "Công Luận", "Ðình Luận", "Duy Luận", "Công Luật", "Hữu Lương", "Thiên Lương", "Công Lý", "Minh Lý", "Ðức Mạnh", "Duy Mạnh", "Quốc Mạnh", "Thiên Mạnh", "Thụy Miên", "Anh Minh", "Bình Minh", "Cao Minh", "Chiêu Minh", "Ðăng Minh", "Ðức Minh", "Duy Minh", "Gia Minh", "Hoàng Minh", "Hồng Minh", "Hiểu Minh", "Hữu Minh", "Khắc Minh", "Khánh Minh", "Ngọc Minh", "Nhật Minh", "Quang Minh", "Quốc Minh", "Thái Minh", "Thanh Minh", "Thế Minh", "Thiện Minh", "Trí Minh", "Tuấn Minh", "Tùng Minh", "Tường Minh", "Văn Minh", "Vũ Minh", "Xuân Minh", "Hoàng Mỹ", "Quốc Mỹ", "An Nam", "Chí Nam", "Ðình Nam", "Giang Nam", "Hải Nam", "Hồ Nam", "Hoài Nam", "Hoàng Nam", "Hữu Nam", "Khánh Nam", "Nhật Nam", "Phương Nam", "Tấn Nam", "Trường Nam", "Xuân Nam", "Ngọc Ngạn", "Gia Nghị", "Hiếu Nghĩa", "Hữu Nghĩa", "Minh Nghĩa", "Trọng Nghĩa", "Trung Nghĩa", "Mạnh Nghiêm", "Cao Nghiệp", "Hào Nghiệp", "Ðại Ngọc", "Hùng Ngọc", "Tuấn Ngọc", "Việt Ngọc", "Duy Ngôn", "Hoàng Ngôn", "Thiện Ngôn", "An Nguyên", "Bình Nguyên", "Ðình Nguyên", "Ðông Nguyên", "Hải Nguyên", "Khôi Nguyên", "Nhân Nguyên", "Phúc Nguyên", "Phước Nguyên", "Thành Nguyên", "Trung Nguyên", "Tường Nguyên", "Ðình Nhân", "Ðức Nhân", "Minh Nhân", "Thiện Nhân", "Phước Nhân", "Quang Nhân", "Thành Nhân", "Thụ Nhân"
    };
    private final String[] dsTenNam4 = {
        "Trọng Nhân", "Trung Nhân", "Trường Nhân", "Việt Nhân", "Thống Nhất", "Hồng Nhật", "Minh Nhật", "Nam Nhật", "Quang Nhật", "Hạo Nhiên", "An Ninh", "Khắc Ninh", "Quang Ninh", "Xuân Ninh", "Hoàng Phát", "Hồng Phát", "Tấn Phát", "Trường Phát", "Tường Phát", "Ðức Phi", "Khánh Phi", "Nam Phi", "Thanh Phi", "Cao Phong", "Chấn Phong", "Chiêu Phong", "Ðông Phong", "Ðức Phong", "Gia Phong", "Hải Phong", "Hiếu Phong", "Hoài Phong", "Hùng Phong", "Huy Phong", "Khởi Phong", "Nguyên Phong", "Quốc Phong", "Thanh Phong", "Thuận Phong", "Uy Phong", "Việt Phong", "Ðình Phú", "Ðức Phú", "Kim Phú", "Sỹ Phú", "Thiên Phú", "Ðình Phúc", "Gia Phúc", "Lạc Phúc", "Thế Phúc", "Trường Phúc", "Xuân Phúc", "Công Phụng", "Bá Phước", "Gia Phước", "Hữu Phước", "Tân Phước", "Thiện Phước", "Chế Phương", "Ðông Phương", "Lam Phương", "Nam Phương", "Quốc Phương", "Thành Phương", "Thế Phương", "Thuận Phương", "Viễn Phương", "Việt Phương", "Anh Quân", "Bình Quân", "Chiêu Quân", "Ðông Quân", "Hải Quân", "Hoàng Quân", "Long Quân", "Minh Quân", "Nhật Quân", "Quốc Quân", "Sơn Quân", "Đăng Quang", "Ðức Quang", "Duy Quang", "Hồng Quang", "Huy Quang", "Minh Quang", "Ngọc Quang", "Nhật Quang", "Thanh Quang", "Tùng Quang", "Ðình Quảng", "Ðức Quảng", "Anh Quốc", "Bảo Quốc", "Minh Quốc", "Nhật Quốc", "Việt Quốc", "Vinh Quốc", "Hồng Quý", "Minh Quý", "Xuân Quý", "Ðức Quyền", "Lương Quyền", "Sơn Quyền", "Thế Quyền", "Ngọc Quyết", "Việt Quyết", "Mạnh Quỳnh", "Thái San", "Ðình Sang", "Thái Sang", "Thành Sang", "Quang Sáng", "Ðức Siêu", "Công Sinh", "Ðức Sinh", "Phúc Sinh", "Tấn Sinh", "Thiện Sinh", "Anh Sơn", "Bảo Sơn", "Cao Sơn", "Chí Sơn", "Công Sơn", "Danh Sơn", "Ðông Sơn", "Giang Sơn", "Hải Sơn", "Hồng Sơn", "Hùng Sơn", "Kim Sơn", "Minh Sơn", "Nam Sơn", "Ngọc Sơn", "Phước Sơn", "Thái Sơn", "Thanh Sơn", "Thế Sơn", "Trường Sơn", "Vân Sơn", "Viết Sơn", "Việt Sơn", "Xuân Sơn", "Cao Sỹ", "Tuấn Sỹ", "Anh Tài", "Ðức Tài", "Hữu Tài", "Lương Tài", "Quang Tài", "Tấn Tài", "Tuấn Tài", "Ðức Tâm", "Duy Tâm", "Hữu Tâm", "Khải Tâm", "Phúc Tâm", "Thiện Tâm", "Duy Tân", "Hữu Tân", "Minh Tân", "Thái Tân", "Mạnh Tấn", "Nhật Tấn", "Trọng Tấn", "Cao Tiến", "Minh Tiến", "Nhật Tiến", "Nhất Tiến", "Quốc Tiến", "Việt Tiến", "Bảo Tín", "Hoài Tín", "Thành Tín", "Bảo Toàn", "Ðình Toàn", "Ðức Toàn", "Hữu Toàn", "Kim Toàn", "Minh Toàn", "Thanh Toàn", "Thuận Toàn", "Vĩnh Toàn", "Ðức Toản", "Quốc Toản", "Thanh Toản", "Hữu Trác", "Công Tráng", "Ðức Trí", "Dũng Trí", "Hữu Trí", "Minh Trí", "Thiên Trí", "Trọng Trí", "Minh Triết", "Phương Triều", "Quang Triều", "Vương Triều", "Khắc Triệu", "Minh Triệu", "Quang Triệu"
    };
    private final String[] dsTenNam5 = {
        "Vương Triệu", "Tấn Trình", "Ðắc Trọng", "Khắc Trọng", "Quang Trọng", "Ngọc Trụ", "Quốc Trụ", "Ðình Trung", "Ðức Trung", "Hoài Trung", "Hữu Trung", "Kiên Trung", "Minh Trung", "Quang Trung", "Quốc Trung", "Thành Trung", "Thanh Trung", "Thế Trung", "Tuấn Trung", "Xuân Trung", "Tấn Trương", "Lâm Trường", "Mạnh Trường", "Quang Trường", "Quốc Trường", "Xuân Trường", "Anh Tú", "Minh Tú", "Nam Tú", "Quang Tú", "Thanh Tú", "Tuấn Tú", "Hữu Từ", "Anh Tuấn", "Cảnh Tuấn", "Công Tuấn", "Ðình Tuấn", "Ðức Tuấn", "Huy Tuấn", "Khắc Tuấn", "Khải Tuấn", "Mạnh Tuấn", "Minh Tuấn", "Ngọc Tuấn", "Quang Tuấn", "Quốc Tuấn", "Thanh Tuấn", "Ðức Tuệ", "Anh Tùng", "Bá Tùng", "Sơn Tùng", "Thạch Tùng", "Thanh Tùng", "An Tường", "Ðức Tường", "Hữu Tường", "Huy Tường", "Mạnh Tường", "Thế Tường", "Minh Thạc", "Bảo Thạch", "Duy Thạch", "Ngọc Thạch", "Quang Thạch", "Anh Thái", "Bảo Thái", "Hòa Thái", "Hoàng Thái", "Minh Thái", "Quang Thái", "Triệu Thái", "Việt Thái", "Xuân Thái", "Chiến Thắng", "Ðình Thắng", "Ðức Thắng", "Duy Thắng", "Hữu Thắng", "Mạnh Thắng", "Minh Thắng", "Quang Thắng", "Quốc Thắng", "Quyết Thắng", "Toàn Thắng", "Trí Thắng", "Vạn Thắng", "Việt Thắng", "Chí Thanh", "Duy Thanh", "Hoài Thanh", "Nam Thanh", "Thiện Thanh", "Việt Thanh", "Bá Thành", "Chí Thành", "Công Thành", "Ðắc Thành", "Danh Thành", "Ðức Thành", "Duy Thành", "Huy Thành", "Khắc Thành", "Lập Thành", "Quốc Thành", "Tân Thành", "Tấn Thành", "Thuận Thành", "Triều Thành", "Trung Thành", "Trường Thành", "Tuấn Thành", "Thanh Thế", "Giang Thiên", "Quang Thiên", "Thanh Thiên", "Ân Thiện", "Bá Thiện", "Ðình Thiện", "Gia Thiện", "Hữu Thiện", "Mạnh Thiện", "Minh Thiện", "Ngọc Thiện", "Phước Thiện", "Quốc Thiện", "Tâm Thiện", "Thành Thiện", "Xuân Thiện", "Bá Thịnh", "Cường Thịnh", "Gia Thịnh", "Hồng Thịnh", "Hùng Thịnh", "Kim Thịnh", "Nhật Thịnh", "Phú Thịnh", "Phúc Thịnh", "Quang Thịnh", "Quốc Thịnh", "Cao Thọ", "Ðức Thọ", "Hữu Thọ", "Ngọc Thọ", "Vĩnh Thọ", "Duy Thông", "Hiếu Thông", "Huy Thông", "Kim Thông", "Minh Thông", "Nam Thông", "Quảng Thông", "Quốc Thông", "Vạn Thông", "Việt Thông", "Ðại Thống", "Hữu Thống", "Chính Thuận", "Minh Thuận", "Ngọc Thuận", "Quang Thuận", "Thanh Thuận", "Hải Thụy", "Hồng Thụy", "Vĩnh Thụy", "Xuân Thuyết", "Cát Uy", "Gia Uy", "Vũ Uy", "Danh Văn", "Khánh Văn", "Kiến Văn", "Quốc Văn", "Khôi Vĩ", "Triều Vĩ", "Lâm Viên", "Anh Việt", "Dũng Việt", "Hoài Việt", "Hoàng Việt", "Hồng Việt", "Huy Việt", "Khắc Việt", "Nam Việt", "Phụng Việt", "Quốc Việt", "Trọng Việt", "Trung Việt", "Tuấn Việt", "Vương Việt", "Công Vinh", "Gia Vinh", "Hồng Vinh", "Quang Vinh", "Quốc Vinh", "Thanh Vinh", "Thành Vinh", "Thế Vinh", "Trọng Vinh", "Trường Vinh", "Tường Vinh"
    };
    private final String[] dsTenNam6 = {
        "Hữu Vĩnh", "Quý Vĩnh", "Chí Vịnh", "Long Vịnh", "Tiến Võ", "Anh Vũ", "Hiệp Vũ", "Huy Vũ", "Khắc Vũ", "Lâm Vũ", "Minh Vũ", "Quang Vũ", "Quốc Vũ", "Thanh Vũ", "Trường Vũ", "Uy Vũ", "Xuân Vũ", "Hoàng Vương", "Minh Vương", "Hữu Vượng"
    };
    private final String[][] dsTenNam = {dsTenNam1, dsTenNam2, dsTenNam3, dsTenNam4, dsTenNam5, dsTenNam6};
    private final String[] dsTenNu1 = {
        "Diệu Ái", "Khả Ái", "Ngọc Ái", "Hoài An", "Huệ An", "Minh An", "Phương An", "Thanh An", "Hải Ân", "Huệ Ân", "Bảo Anh", "Diệp Anh", "Diệu Anh", "Hải Anh", "Hồng Anh", "Huyền Anh", "Kiều Anh", "Kim Anh", "Lan Anh", "Mai Anh", "Minh Anh", "Mỹ Anh", "Ngọc Anh", "Nguyệt Anh", "Như Anh", "Phương Anh", "Quế Anh", "Quỳnh Anh", "Thục Anh", "Thúy Anh", "Thùy Anh", "Trâm Anh", "Trang Anh", "Tú Anh", "Tuyết Anh", "Vân Anh", "Yến Anh", "Kim Ánh", "Ngọc Ánh", "Nguyệt Ánh", "Nhật Ánh", "Băng Băng", "Lệ Băng", "Tuyết Băng", "Như Bảo", "Gia Bảo", "Xuân Bảo", "Ngọc Bích", "An Bình", "Thái Bình", "Sơn Ca", "Ngọc Cầm", "Nguyệt Cầm", "Thi Cầm", "Bảo Châu", "Bích Châu", "Diễm Châu", "Hải Châu", "Hoàn Châu", "Hồng Châu", "Linh Châu", "Loan Châu", "Ly Châu", "Mai Châu", "Minh Châu", "Trân Châu", "Diệp Chi", "Diễm Chi", "Hạnh Chi", "Khánh Chi", "Kim Chi", "Lan Chi", "Lệ Chi", "Linh Chi", "Mai Chi", "Phương Chi", "Quế Chi", "Quỳnh Chi", "Bích Chiêu", "Hoàng Cúc", "Kim Cương", "Trang Ðài", "Tâm Đan", "Thanh Đan", "Linh Ðan", "Quỳnh Dao", "Anh Ðào", "Bích Ðào", "Hồng Ðào", "Ngọc Ðào", "Thục Ðào", "Trúc Ðào", "An Di", "Thiên Di", "Hồng Diễm", "Kiều Diễm", "Phương Diễm", "Thúy Diễm", "Bích Diệp", "Hồng Diệp", "Ngọc Diệp", "Bích Ðiệp", "Hồng Ðiệp", "Mộng Ðiệp", "Ngọc Ðiệp", "Huyền Diệu", "Tâm Ðoan", "Thục Ðoan", "Hạnh Dung", "Kiều Dung", "Kim Dung", "Mỹ Dung", "Nghi Dung", "Ngọc Dung", "Phương Dung", "Quỳnh Dung", "Thùy Dung", "Ánh Dương", "Chiêu Dương", "Thùy Dương", "Hải Ðường", "Bích Duyên", "Kỳ Duyên", "Linh Duyên", "Minh Duyên", "Mỹ Duyên", "Thu Duyên", "Hà Giang", "Hoài Giang", "Hương Giang", "Kiều Giang", "Linh Giang", "Phương Giang", "Quỳnh Giang", "Thanh Giang", "Thiên Giang", "Thu Giang", "Thùy Giang", "Hồng Giang", "Trà Giang", "Khánh Giao", "Quỳnh Giao", "Bảo Hà", "Bích Hà", "Hoàng Hà", "Hồng Hà", "Khánh Hà", "Lam Hà", "Linh Hà", "Mai Hà", "Minh Hà", "Ngân Hà", "Ngọc Hà", "Nguyệt Hà", "Nhật Hà", "Quỳnh Hà", "Thái Hà", "Thanh Hà", "Thu Hà", "Thúy Hà", "Vân Hà", "Việt Hà", "An Hạ", "Mai Hạ", "Ngọc Hạ", "Nhật Hạ", "Bích Hải", "Bảo Hân", "Gia Hân", "Ngọc Hân", "Tuyết Hân", "Bích Hằng", "Diễm Hằng", "Diệu Hằng", "Minh Hằng", "Thanh Hằng", "Thu Hằng", "Thúy Hằng", "Bích Hạnh", "Cẩm Hạnh", "Diễm Hạnh", "Hiếu Hạnh", "Hồng Hạnh", "Kiều Hạnh", "Minh Hạnh", "Mỹ Hạnh", "Phương Hạnh", "Thúy Hạnh", "Bích Hảo", "Thanh Hảo", "Bích Hậu", "Thu Hậu", "Bích Hiền", "Diệu Hiền", "Mai Hiền", "Minh Hiền", "Ngọc Hiền", "Phương Hiền", "Tâm Hiền", "Thanh Hiền"
    };
    private final String[] dsTenNu2 = {
        "Thu Hiền", "Thúy Hiền", "Xuân Hiền", "Ánh Hoa", "Bạch Hoa", "Diệu Hoa", "Hồng Hoa", "Kiều Hoa", "Kim Hoa", "Lệ Hoa", "Liên Hoa", "Mộng Hoa", "Ngọc Hoa", "Như Hoa", "Phương Hoa", "Quỳnh Hoa", "Thanh Hoa", "Tuyết Hoa", "Xuân Hoa", "Kim Hòa", "Thu Hoài", "Ngọc Hoan", "Mỹ Hoàn", "Ngọc Hoàn", "Ái Hồng", "Ánh Hồng", "Bích Hồng", "Diệu Hồng", "Minh Hồng", "Nguyên Hồng", "Nguyệt Hồng", "Nhã Hồng", "Như Hồng", "Thái Hồng", "Thanh Hồng", "Thảo Hồng", "Thu Hồng", "Tuyết Hồng", "Vũ Hồng", "Yến Hồng", "Bích Hợp", "Bảo Huệ", "Bích Huệ", "Minh Huệ", "Mỹ Huệ", "Ngọc Huệ", "Thu Huệ", "Anh Hương", "Dạ Hương", "Diễm Hương", "Diệu Hương", "Ðinh Hương", "Hoài Hương", "Huệ Hương", "Kim Hương", "Lan Hương", "Liên Hương", "Mai Hương", "Minh Hương", "Mộng Hương", "Nhã Hương", "Quỳnh Hương", "Thanh Hương", "Thảo Hương", "Thiên Hương", "Thúy Hương", "Thu Hương", "Tuyết Hương", "Vân Hương", "Việt Hương", "Xuân Hương", "Cẩm Hường", "Thu Hường", "Thanh Hường", "Thúy Hường", "Diệu Huyền", "Khánh Huyền", "Lệ Huyền", "Minh Huyền", "Mỹ Huyền", "Ngọc Huyền", "Thanh Huyền", "Thu Huyền", "Thúy Huyền", "Minh Khai", "Ái Khanh", "Ðan Khanh", "Gia Khanh", "Hiếu Khanh", "Hồng Khanh", "Kiều Khanh", "Lệ Khanh", "Mai Khanh", "Ngọc Khanh", "Nhã Khanh", "Phi Khanh", "Thụy Khanh", "Uyển Khanh", "Vân Khanh", "Kim Khánh", "Ngọc Khánh", "Thiên Khánh", "Vân Khánh", "Mai Khôi", "Diễm Khuê", "Hồng Khuê", "Lan Khuê", "Minh Khuê", "Ngọc Khuê", "Thục Khuê", "Việt Khuê", "Kim Khuyên", "Mỹ Khuyên", "Diễm Kiều", "Mỹ Kiều", "Thanh Kiều", "Thúy Kiều", "Thiên Kim", "Bích Lam", "Ngọc Lam", "Quỳnh Lam", "Thanh Lam", "Thiên Lam", "Trúc Lam", "Vy Lam", "Hồng Lâm", "Huệ Lâm", "Hương Lâm", "Ngọc Lâm", "Quế Lâm", "Quỳnh Lâm", "Thanh Lâm", "Thư Lâm", "Thụy Lâm", "Tịnh Lâm", "Trúc Lâm", "Tuệ Lâm", "Tuyết Lâm", "Xuân Lâm", "Bảo Lan", "Chi Lan", "Dạ Lan", "Diệu Lan", "Hoàng Lan", "Huệ Lan", "Hương Lan", "Khúc Lan", "Kim Lan", "Linh Lan", "Mai Lan", "Mộng Lan", "Mỹ Lan", "Ngọc Lan", "Nguyệt Lan", "Nhật Lan", "Phong Lan", "Phương Lan", "Thanh Lan", "Thiên Lan", "Trúc Lan", "Tuyết Lan", "Vy Lan", "Xuân Lan", "Ý Lan", "Ánh Lệ", "Mỹ Lệ", "Ngọc Lệ", "Diễm Lệ", "Bích Liên", "Cẩm Liên", "Diễm Liên", "Hà Liên", "Hoa Liên", "Hồng Liên", "Hương Liên", "Kim Liên", "Mai Liên", "Ngọc Liên", "Phương Liên", "Mộng Liễu", "Thúy Liễu", "Xuân Liễu", "Ái Linh", "Quỳnh Liên", "Thu Liên", "Thúy Liên", "Trúc Liên", "Ánh Linh", "Bội Linh", "Cẩm Linh", "Đan Linh", "Diệu Linh", "Gia Linh", "Hạnh Linh", "Hồng Linh", "Huệ Linh", "Huyền Linh", "Khánh Linh", "Mai Linh", "Ngọc Linh"
    };
    private final String[] dsTenNu3 = {
        "Phương Linh", "Quế Linh", "Thảo Linh", "Thu Linh", "Thùy Linh", "Trang Linh", "Trúc Linh", "Vân Linh", "Xuân Linh", "Bạch Loan", "Bích Loan", "Diệu Loan", "Kiều Loan", "Kim Loan", "Mai Loan", "Minh Loan", "Mỹ Loan", "Ngọc Loan", "Như Loan", "Phượng Loan", "Phương Loan", "Thanh Loan", "Thu Loan", "Thúy Loan", "Tố Loan", "Trúc Loan", "Tuyết Loan", "Xuân Loan", "Yến Loan", "Cẩm Ly", "Hương Ly", "Khánh Ly", "Kim Ly", "Lưu Ly", "Mai Ly", "Ngọc Ly", "Thảo Ly", "Trúc Ly", "Tú Ly", "Ngọc Lý", "Nhã Lý", "Ánh Mai", "Ban Mai", "Chi Mai", "Hiền Mai", "Hồng Mai", "Hương Mai", "Khánh Mai", "Kiều Mai", "Kim Mai", "Ngọc Mai", "Nhã Mai", "Như Mai", "Phương Mai", "Thanh Mai", "Thu Mai", "Thủy Mai", "Thúy Mai", "Trúc Mai", "Tuyết Mai", "Xuân Mai", "Yến Mai", "Tuệ Mẫn", "Hà Mi", "Thùy Mi", "Kiều Minh", "Nguyệt Minh", "Thu Minh", "Thủy Minh", "Thúy Minh", "Uyên Minh", "Diễm My", "Duyên My", "Hà My", "Hải My", "Hạnh My", "Huệ My", "Khánh My", "Thảo My", "Thúy My", "Thùy My", "Trà My", "Uyên My", "Uyển My", "Yến My", "Duyên Mỹ", "Kiều Mỹ", "Thiên Mỹ", "Bích Nga", "Diệu Nga", "Hạnh Nga", "Hồng Nga", "Kiều Nga", "Lệ Nga", "Mỹ Nga", "Nguyệt Nga", "Quỳnh Nga", "Thanh Nga", "Thiên Nga", "Thu Nga", "Thúy Nga", "Tố Nga", "Tuyết Nga", "Việt Nga", "Bích Ngà", "Thu Ngà", "Thúy Ngà", "Bích Ngân", "Hồng Ngân", "Khánh Ngân", "Kim Ngân", "Quỳnh Ngân", "Thanh Ngân", "Thu Ngân", "Thúy Ngân", "Ðông Nghi", "Phương Nghi", "Thảo Nghi", "Uyển Nghi", "Xuân Nghi", "Ánh Ngọc", "Bảo Ngọc", "Bích Ngọc", "Diệu Ngọc", "Giáng Ngọc", "Hồng Ngọc", "Huyền Ngọc", "Khánh Ngọc", "Kim Ngọc", "Lam Ngọc", "Lan Ngọc", "Minh Ngọc", "Mỹ Ngọc", "Như Ngọc", "Phương Ngọc", "Thanh Ngọc", "Thu Ngọc", "Thúy Ngọc", "Vân Ngọc", "Xuân Ngọc", "Tâm Nguyên", "Thanh Nguyên", "Thảo Nguyên", "Ánh Nguyệt", "Dạ Nguyệt", "Kiều Nguyệt", "Minh Nguyệt", "Mộng Nguyệt", "Tâm Nguyệt", "Thu Nguyệt", "Triều Nguyệt", "Tú Nguyệt", "Thanh Nhã", "Trang Nhã", "Uyển Nhã", "An Nhàn", "Thanh Nhàn", "Ái Nhi", "Cẩm Nhi", "Ðông Nhi", "Gia Nhi", "Hà Nhi", "Hải Nhi", "Hảo Nhi", "Hiền Nhi", "Hương Nhi", "Huyền Nhi", "Lâm Nhi", "Lan Nhi", "Lệ Nhi", "Linh Nhi", "Mai Nhi", "Minh Nhi", "Mộng Nhi", "Mỹ Nhi", "Ngọc Nhi", "Phương Nhi", "Quỳnh Nhi", "Tâm Nhi", "Thảo Nhi", "Thục Nhi", "Thùy Nhi", "Tịnh Nhi", "Tố Nhi", "Tuệ Nhi", "Tuyết Nhi", "Uyên Nhi", "Uyển Nhi", "Vân Nhi", "Xuân Nhi", "Ý Nhi", "Yên Nhi", "Yến Nhi", "An Nhiên", "Thu Nhiên", "Xuân Nhiên", "Bích Như", "Hồng Như", "Quỳnh Như", "Tâm Như"
    };
    private final String[] dsTenNu4 = {
        "Thùy Như", "Uyển Như", "Cẩm Nhung", "Hồng Nhung", "Phi Nhung", "Phương Nhung", "Quỳnh Nhung", "Thanh Nhung", "Tuyết Nhung", "Ngọc Nữ", "Diệu Nương", "Kiều Nương", "Mỹ Nương", "Thiên Nương", "Thụy Nương", "Xuân Nương", "Hoàng Oanh", "Hồng Oanh", "Kim Oanh", "Ngọc Oanh", "Thu Oanh", "Thục Oanh", "Thùy Oanh", "Trâm Oanh", "Tuyết Oanh", "Yến Oanh", "Thu Phong", "Diễm Phúc", "Hồng Phúc", "Mỹ Phụng", "Ngọc Phụng", "Diễm Phước", "Bảo Phương", "Diễm Phương", "Hà Phương", "Hạnh Phương", "Hoài Phương", "Hồng Phương", "Huệ Phương", "Lan Phương", "Liên Phương", "Linh Phương", "Mai Phương", "Minh Phương", "Mỹ Phương", "Như Phương", "Quế Phương", "Quỳnh Phương", "Thanh Phương", "Thiên Phương", "Thu Phương", "Trúc Phương", "Uyên Phương", "Vân Phương", "Xuân Phương", "Yến Phương", "Bích Phượng", "Diễm Phượng", "Hải Phượng", "Kim Phượng", "Linh Phượng", "Minh Phượng", "Mỹ Phượng", "Thu Phượng", "Thúy Phượng", "Xuân Phượng", "Yến Phượng", "Bích Quân", "Lệ Quân", "Như Quân", "Phương Quân", "Trúc Quân", "Tùng Quân", "Hồng Quế", "Ngọc Quế", "Nguyệt Quế", "Phương Quế", "Bảo Quyên", "Bích Quyên", "Diễm Quyên", "Khánh Quyên", "Lệ Quyên", "Mai Quyên", "Ngọc Quyên", "Phương Quyên", "Thảo Quyên", "Thục Quyên", "Tố Quyên", "Tú Quyên", "Vân Quyên", "Vi Quyên", "Bảo Quỳnh", "Diễm Quỳnh", "Gia Quỳnh", "Khánh Quỳnh", "Lê Quỳnh", "Mộng Quỳnh", "Ngọc Quỳnh", "Như Quỳnh", "Phương Quỳnh", "Thúy Quỳnh", "Trúc Quỳnh", "Tú Quỳnh", "Kim Sa", "Quỳnh Sa", "Bích San", "Linh San", "Ngọc San", "San San", "Ngọc Sương", "Nhã Sương", "Sương Sương", "Thu Sương", "Tú Sương", "Bảo Uyên", "Diễm Uyên", "Duy Uyên", "Giáng Uyên", "Hạ Uyên", "Hải Uyên", "Lâm Uyên", "Minh Uyên", "Mỹ Uyên", "Ngọc Uyên", "Nhã Uyên", "Phương Uyên", "Phượng Uyên", "Thanh Uyên", "Thảo Uyên", "Thục Uyên", "Thùy Uyên", "Thụy Uyên", "Tố Uyên", "Tú Uyên", "Xuân Uyên", "Ngọc Uyển", "Nguyệt Uyển", "Băng Tâm", "Minh Tâm", "Mỹ Tâm", "Ngọc Tâm", "Như Tâm", "Phương Tâm", "Thanh Tâm", "Thục Tâm", "Bảo Tiên", "Cát Tiên", "Giáng Tiên", "Hà Tiên", "Hạ Tiên", "Hoa Tiên", "Hương Tiên", "Phượng Tiên", "Quỳnh Tiên", "Thiện Tiên", "Thủy Tiên", "Vân Tiên", "Bạch Trà", "Hương Trà", "Phương Trà", "Bảo Trâm", "Bích Trâm", "Huyền Trâm", "Mỹ Trâm", "Ngọc Trâm", "Phương Trâm", "Quỳnh Trâm", "Thụy Trâm", "Uyên Trâm", "Yến Trâm", "Hương Trầm", "Bảo Trân", "Huyền Trân", "Ánh Trang", "Bích Trang", "Ðài Trang", "Diễm Trang", "Ðoan Trang", "Hạnh Trang", "Hoài Trang", "Hương Trang", "Huyền Trang", "Khánh Trang", "Kiều Trang", "Kim Trang", "Linh Trang", "Minh Trang", "Mỹ Trang", "Nhã Trang", "Phương Trang", "Quỳnh Trang", "Tâm Trang", "Thanh Trang", "Thảo Trang", "Thiên Trang", "Thu Trang", "Thục Trang", "Thủy Trang", "Vân Trang", "Xuân Trang"
    };
    private final String[] dsTenNu5 = {
        "Yến Trang", "Diễm Trinh", "Kiết Trinh", "Kiều Trinh", "Mai Trinh", "Ngọc Trinh", "Phương Trinh", "Thục Trinh", "Thụy Trinh", "Tú Trinh", "Tuyết Trinh", "Vân Trinh", "Việt Trinh", "Yến Trinh", "Bảo Trúc", "Hồng Trúc", "Lan Trúc", "Ngân Trúc", "Nhã Trúc", "Thanh Trúc", "Khuê Trúc", "Cẩm Tú", "Khả Tú", "Minh Tú", "Ngọc Tú", "Minh Tuệ", "Kim Tuyến", "Ðông Tuyền", "Kim Tuyền", "Lam Tuyền", "Lâm Tuyền", "Mộng Tuyền", "Sơn Tuyền", "Thanh Tuyền", "Thiên Tuyền", "Ánh Tuyết", "Bạch Tuyết", "Kim Tuyết", "Minh Tuyết", "Ngọc Tuyết", "Thanh Tuyết", "Cát Tường", "Hồng Thắm", "Ðoan Thanh", "Giang Thanh", "Hà Thanh", "Kim Thanh", "Lệ Thanh", "Mai Thanh", "Ngân Thanh", "Nhã Thanh", "Phương Thanh", "Quỳnh Thanh", "Thanh Thanh", "Thiên Thanh", "Vân Thanh", "Xuân Thanh", "Yến Thanh", "Anh Thảo", "Bích Thảo", "Diễm Thảo", "Hương Thảo", "Kim Thảo", "Mai Thảo", "Minh Thảo", "Nguyên Thảo", "Như Thảo", "Phương Thảo", "Thạch Thảo", "Thanh Thảo", "Thiên Thảo", "Thu Thảo", "Xuân Thảo", "Ái Thi", "Dạ Thi", "Mộng Thi", "Ngọc Thi", "Phương Thi", "Khánh Thi", "Uyên Thi", "Tuệ Thi", "Hoa Thiên", "Anh Thơ", "Ánh Thơ", "Ngọc Thơ", "Quỳnh Thơ", "Uyên Thơ", "Bảo Thoa", "Bích Thoa", "Kim Thoa", "Bích Thu", "Hồng Thu", "Hương Thu", "Kiều Thu", "Kim Thu", "Lệ Thu", "Mai Thu", "Minh Thu", "Mộng Thu", "Quế Thu", "Thanh Thu", "Xuân Thu", "Anh Thư", "Diễm Thư", "Hồng Thư", "Huyền Thư", "Kim Thư", "Minh Thư", "Thanh Thư", "Thiên Thư", "Hiền Thục", "Hoài Thương", "Huệ Thương", "Lan Thương", "Minh Thương", "Thương Thương", "Bảo Thúy", "Cẩm Thúy", "Diễm Thúy", "Diệu Thúy", "Hồng Thúy", "Minh Thúy", "Thanh Thúy", "Vân Thúy", "Phương Thùy", "Bích Thủy", "Hồng Thủy", "Hương Thủy", "Khánh Thủy", "Kim Thủy", "Lệ Thủy", "Minh Thủy", "Phương Thủy", "Thanh Thủy", "Thu Thủy", "Xuân Thủy", "Ái Vân", "Bạch Vân", "Bảo Vân", "Bích Vân", "Cẩm Vân", "Diệu Vân", "Hải Vân", "Hồng Vân", "Khánh Vân", "Mộng Vân", "Mỹ Vân", "Ngọc Vân", "Quỳnh Vân", "Thái Vân", "Thanh Vân", "Thảo Vân", "Thu Vân", "Thục Vân", "Thụy Vân", "Thúy Vân", "Thùy Vân", "Thy Vân", "Trúc Vân", "Tường Vân", "Tuyết Vân", "Xuân Vân", "Hạnh Vi", "Hoàn Vi", "Khánh Vi", "Mộng Vi", "Thúy Vi", "Tường Vi", "Uyên Vi", "Bảo Vy", "Diệp Vy", "Ðông Vy", "Hạ Vy", "Hải Vy", "Khánh Vy", "Lan Vy", "Mai Vy", "Minh Vy", "Mộng Vy", "Ngọc Vy", "Phượng Vy", "Thanh Vy", "Thảo Vy", "Thúy Vy", "Trúc Vy", "Tường Vy", "Tuyết Vy", "Ánh Xuân", "Hồng Xuân", "Hương Xuân", "Kim Xuân", "Minh Xuân", "Mỹ Xuân", "Nghi Xuân", "Thanh Xuân", "Thi Xuân", "Tuyết Xuân", "Kim Xuyến", "Nhã Ý", "Như Ý"
    };
    private final String[] dsTenNu6 = {
        "Thái Yên", "Bạch Yến", "Cẩm Yến", "Dạ Yến", "Hải Yến", "Hoàng Yến", "Kim Yến", "Minh Yến", "Mỹ Yến", "Ngọc Yến", "Nhã Yến", "Phụng Yến", "Phương Yến", "Thanh Yến", "Thi Yến", "Thu Yến", "Xuân Yến"
    };
    private final String[] dsDiaChiCanTho = {
        "3/2, P. Hưng Lợi, Q. Ninh Kiều", "30/4, P. An Phú, Q. Ninh Kiều", "Châu Văn Liêm, P. An Lạc, Q. Ninh Kiều", "CMT8, P. Cái Khế, Q. Ninh Kiều", "Điện Biên Phủ, P. Tân An, Q. Ninh Kiều", "Đinh Công Tráng, P. Xuân Khánh, Q. Ninh Kiều", "Đường Trục Chính, Q. Bình Thủy", "Hai Bà Trưng, P. Tân An, Q. Ninh Kiều", "Hoà Bình, P.Tân An, Q.Ninh Kiều", "Hùng Vương, P. Thới Bình, Q. Ninh Kiều", "Lê Hồng Phong, P. Trà An, Q. Bình Thủy", "Lê Hồng Phong, P. Trà Nóc, Q. Bình Thủy", "Lê Lợi, P. Cái Khế, Q. Ninh Kiều", "Lý Thường Kiệt, P. Tân An, Q. Ninh Kiều", "Lý Tự Trọng, P. An Cư, Q. Ninh Kiều", "Mậu Thân, P. An Hòa, Q. Ninh Kiều", "Mậu Thân, P. Xuân Khánh, Q. Ninh Kiều", "Nam Kỳ Khởi Nghĩa, P. Tân An, Q. Ninh Kiều", "Ngô Gia Tự, P. An Hội, Q. Ninh Kiều", "Ngô Hữu Hạnh, P. An Hội, Q. Ninh Kiều", "Ngô Quyền, P. An Cư, Q. Ninh Kiều", "Nguyễn An Ninh, P. Tân An, Q. Ninh Kiều", "Nguyễn Đình Chiểu, P. An Hội, Q. Ninh Kiều", "Nguyễn Thái Học, P. Tân An, Q. Ninh Kiều", "Nguyễn Thị Minh Khai, P. An Lạc, Q. Ninh Kiều", "Nguyễn Trãi, P. An Hội, Q. Ninh Kiều", "Nguyễn Văn Cừ Nối Dài, P. An Khánh, Q. Ninh Kiều", "Nguyễn Văn Cừ, P. An Hòa, Q. Ninh Kiều", "Phạm Ngũ Lão, P. Thới Bình, Q. Ninh Kiều", "Phan Đăng Lưu, P. Thới Bình, Q. Ninh Kiều", "Phan Đình Phùng, P. Tân An, Q. Ninh Kiều", "Phan Văn Trị, P. An Phú, Q. Ninh Kiều", "Phan Văn Trị, P. An Phú, Q. Ninh Kiều", "QL1A, Q. Cái Răng", "QL91, Q. Ô Môn", "QL91B, P. Hưng Lợi, Q. Ninh Kiều", "QL91B, P. Long Hòa, Q. Bình Thủy", "Quang Trung, P. Hưng Phú,  Q. Cái Răng", "Quang Trung, P. Phú Thứ, Q. Cái Răng", "Sông Hậu, P. Cái Khế, Q. Ninh Kiều", "Tân Trào, P. Tân An, Q. Ninh Kiều", "Trần Hoàng Na, P. Hưng Lợi, Q. Ninh Kiều", "Trần Hưng Đạo, P. An Nghiệp, Q. Ninh Kiều", "Trần Khánh Dư, P. Xuân Khánh, Q. Ninh Kiều", "Trần Ngọc Quế, P. Xuân Khánh, Q. Ninh Kiều", "Trần Phú, P. Cái Khế, Q. Ninh Kiều", "Trần Quang Diệu, P. An Thới, Q. Bình Thủy", "Trần văn hoài, P. Xuân Khánh, Q. Ninh Kiều", "Trần Văn Khéo, P. Cái Khế, Q. Ninh Kiều", "Trần Việt Châu, P. An Hòa, Q. Ninh Kiều", "Ung Văn Khiêm, P. Cái Khế, Q. Ninh Kiều", "Võ Thị Sáu, P. An Hội, Q. Ninh Kiều", "Võ Văn Kiệt, P. An Thới, Q. Bình Thủy", "Xô Viết Nghệ Tĩnh, P. An Hội, Q. Ninh Kiều"
    };
    private final String[][] dsTenNu = {dsTenNu1, dsTenNu2, dsTenNu3, dsTenNu4, dsTenNu5, dsTenNu6};

    public GenerateData() {
        dsHinhGiaoVien = new ArrayList<String>();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                dsHinhGiaoVien.add(listOfFiles[i].getName());
                //System.out.println(listOfFiles[i].getName());
            }
        }
    }

    public String TenNam() throws Exception {
        return TenNam("");
    }

    public String TenNam(String ho) throws Exception {
        if (ho.equals("")) {
            ho = dsHo[Tools.RandomNumber(0, dsHo.length - 1)];
        }
        String hoLot = "";
        int coHoLot = Tools.RandomNumber(0, 100);
        if (coHoLot > 65) {
            do {
                hoLot = dsHo[Tools.RandomNumber(0, dsHo.length - 1)];
            } while (hoLot.equals(ho));
            hoLot = " " + hoLot;
        }
        int tenIndex = Tools.RandomNumber(0, dsTenNam.length - 1);
        return ho + hoLot + " " + dsTenNam[tenIndex][Tools.RandomNumber(0, dsTenNam[tenIndex].length - 1)];
    }

    public String TenNu() throws Exception {
        return TenNu("");
    }

    public String TenNu(String ho) throws Exception {
        int tenIndex = Tools.RandomNumber(0, dsTenNu.length - 1);
        int coThi = Tools.RandomNumber(0, 1);
        String thi = "";
        String hoLot = "";
        if (ho.equals("")) {
            ho = dsHo[Tools.RandomNumber(0, dsHo.length - 1)];
        }
        if (coThi == 1) {
            thi = " Thị";
        } else {
            int coHoLot = Tools.RandomNumber(0, 100);
            if (coHoLot > 65) {
                do {
                    hoLot = dsHo[Tools.RandomNumber(0, dsHo.length - 1)];
                } while (hoLot.equals(ho));
                hoLot = " " + hoLot;
            }
        }
        return ho + hoLot + thi + " " + dsTenNu[tenIndex][Tools.RandomNumber(0, dsTenNu[tenIndex].length - 1)];
    }

    public String TenMe(String tenCon) throws Exception {
        String ho = tenCon.split(" ")[1];
        String hoMe = "";
        for (String h : dsHo) {
            if (ho.equals(h)) {
                hoMe = ho;
                break;
            }
        }
        return TenNu(hoMe);
    }

    public String TenCha(String tenCon) throws Exception {
        String ho = tenCon.split(" ")[0];
        return TenNam(ho);
    }

    public String TenPhuHuynh(String tenCon) throws Exception {
        int tenCha = Tools.RandomNumber(0, 1);
        if (tenCha == 1) {
            return TenCha(tenCon);
        } else {
            return TenMe(tenCon);
        }
    }

    public String HoTenRutGon(String hoTen) {
        hoTen = stripAccents(hoTen);
        String result = "";
        String[] a = hoTen.split(" ");
        for (int i=0; i<a.length-1; i++) {
            result += a[i].charAt(0);
        }
        result += a[a.length-1];
        return result.toLowerCase();
    }

    public static String stripAccents(String str) {
        str = str.toLowerCase();
        str = str.replaceAll("à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ", "a");
        str = str.replaceAll("è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ", "e");
        str = str.replaceAll("ì|í|ị|ỉ|ĩ", "i");
        str = str.replaceAll("ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ", "o");
        str = str.replaceAll("ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ", "u");
        str = str.replaceAll("ỳ|ý|ỵ|ỷ|ỹ", "y");
        str = str.replaceAll("đ|ð", "d");

        return str;
    }

    public String Email(String hoTen, boolean coNamSinh, String dichVuMail) throws Exception {
        String email = HoTenRutGon(hoTen);
        if (coNamSinh) {
            email += Tools.RandomNumber(1960, 1986);
        }
        email += "@";
        if (dichVuMail.equals("")) {
            email += dsEmail[Tools.RandomNumber(0, dsEmail.length - 1)];
        } else {
            email += dichVuMail;
        }
        return email;
    }

    public String HoTen() throws Exception {
        int tenNam = Tools.RandomNumber(0, 1);
        if (tenNam == 1) {
            return TenNam();
        } else {
            return TenNu();
        }
    }

    public String DiaChi() throws Exception {
        String diaChi = "" + Tools.RandomNumber(1, 400);
        int coChu = Tools.RandomNumber(0, 100);
        int coHem = Tools.RandomNumber(1, 70);
        if (coHem > 50) {
            coHem -= 50;
            coHem = (int) Math.ceil((double) coHem / 10);
            diaChi += "/" + Tools.RandomNumber(2, 100);
            if (coHem == 2) {
                diaChi += "/" + Tools.RandomNumber(2, 50);
            }
        } else {
            coHem = 0;
        }
        if ((coHem > 0 && coChu > 30) || (coHem == 0 && coChu > 60)) {
            diaChi += (char) ('A' + Tools.RandomNumber(0, 4));
        }
        diaChi += " " + dsDiaChiCanTho[Tools.RandomNumber(0, dsDiaChiCanTho.length - 1)];
        diaChi += ", Tp. Cần Thơ";
        return diaChi;
    }

    public String CMND() throws Exception {
        return Tools.RandomNumber(100000000, 400000000) + "";
    }

    public String SoDienThoai() throws Exception {
        String soDienThoai = "09";
        int soDau = Tools.RandomNumber(0, 100);
        if (soDau > 60) {
            soDienThoai = "012";
        }
        soDienThoai += Tools.FormatZero(Tools.RandomNumber(0, 99999999), 8);
        return soDienThoai;
    }

    public Date GioBatDau() throws Exception {
        int rand = Tools.RandomNumber(1, 5);
        Date gio = null;
        switch (rand) {
            case 1:
                gio = Tools.timeFormatter.parse("07:00");
                break;
            case 2:
                gio = Tools.timeFormatter.parse("09:00");
                break;
            case 3:
                gio = Tools.timeFormatter.parse("13:30");
                break;
            case 4:
                gio = Tools.timeFormatter.parse("15:30");
                break;
            case 5:
                gio = Tools.timeFormatter.parse("18:30");
                break;
        }
        return gio;
    }

    public Date GioKetThuc(Date gioBatDau) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(gioBatDau);
        cal.add(Calendar.HOUR_OF_DAY, 2); //minus number would decrement the hours
        return cal.getTime();
    }

    public LoaiBangCap BangCapGiaoVien() throws Exception {
        int rand = Tools.RandomNumber(1, 6);
        LoaiBangCap bc = LoaiBangCap.CD;
        switch (rand) {
            case 1:
                bc = LoaiBangCap.CD;
                break;
            case 2:
                bc = LoaiBangCap.DH;
                break;
            case 3:
                bc = LoaiBangCap.TC;
                break;
        }
        return bc;
    }

    public String HinhGiaoVien(boolean gioiTinh, int slGVNam, int slGVNu) throws Exception {
        String fileName = "a" + Tools.FormatZero(slGVNam, 2);
        if (gioiTinh == false) {
            fileName = "b" + Tools.FormatZero(slGVNu, 2);
        }
        for (String img : dsHinhGiaoVien) {
            if (img.startsWith(fileName)) {
                return img;
            }
        }
        return "uGV_80.png";
        //throw new Exception("HinhGiaoVien: " + fileName);
    }

    public String NamSinhGiaoVien(String img) throws Exception {
        return img.substring(4, 6);
    }

    public boolean CanThemGiaoVienMoi(int slGVRanh, int slGV) throws Exception {
        if (slGVRanh == 0) {
            return true;
        } else if (slGVRanh > 2) {
            return false;
        } else if (slGV > 9) {
            return Tools.RandomNumber(1, 100) > 95;
        } else {
            return true;
        }
    }
    public void XoaHetHinhNhanVien() {
        File folder = new File("hinhAnh/NhanVien/");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (!listOfFiles[i].isDirectory()) {
                listOfFiles[i].delete();
                //dsHinhGiaoVien.add(listOfFiles[i].getName());
                //System.out.println(listOfFiles[i].getName());
            }
        }
    }   
    public static <T extends SaveAble> void SaveAll(DB4OMS db, Class<T> loai) throws Exception {
        List<T> ds = db.theDB.queryByExample(loai);
        for (T obj : ds) {
            obj.LuuVaoCSDL();
            //System.out.println("Lop " + obj.toString());
        }
    }
}
