package baseknowledge.java.Polymorphic;

/**
 * @Author: shaoRongGang
 * @Description:
 * @Date:Created in 1:22 2020/3/19
 * @Modifid By:
 */
public class FlyStatus {
    private long height;
    private String flyTool;

    public FlyStatus() {
    }

    public FlyStatus(long height, String flyTool) {
        this.height = height;
        this.flyTool = flyTool;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getFlyTool() {
        return flyTool;
    }

    public void setFlyTool(String flyTool) {
        this.flyTool = flyTool;
    }
}
