package net.swmaestro.portal.user.vo;

/**
 * Created by junha on 2016. 11. 12..
 */
public class Group {
    private static final String GROUPCODE_MENTEE = "0";
    private static final String GROUPCODE_MENTO = "1";
    private static final String GROUPCODE_ADMIN = "2";

    private int groupId;

    private int userId;

    private int generationId;

    private String groupCode;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGenerationId() {
        return generationId;
    }

    public void setGenerationId(int generationId) {
        this.generationId = generationId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
