package PACKAGES;

/**
 *
 * @@Hoàng Ngọc Long 
 */
public class PacketChupAnh extends PacketTin {
    public static final String ID = "chupanh";
    public static final String CMD_CHAPNHAN = "chapnhan";
    public static final String CMD_KHOIDONG = "khoidong";
    public static final String CMD_HOANTAT = "hoantat";
    public PacketChupAnh() {
        setId(ID);
    }
}
