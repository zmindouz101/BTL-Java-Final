
/*
 * @author Hoàng Ngọc Long - 64121
 */
package zSERVER.REMOTE;

/**
 * Được sử dụng để biểu thị các lệnh có thể được gửi bởi máy chủ
 */
public enum EnumCommands {
    PRESS_MOUSE(-1),
    RELEASE_MOUSE(-2),
    PRESS_KEY(-3),
    RELEASE_KEY(-4),
    MOVE_MOUSE(-5);
    private int abbrev;

    EnumCommands(int abbrev){
        this.abbrev = abbrev;
    }

    public int getAbbrev(){
        return abbrev;
    }
}
