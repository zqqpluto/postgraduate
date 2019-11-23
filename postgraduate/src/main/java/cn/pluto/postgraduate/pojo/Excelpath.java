package cn.pluto.postgraduate.pojo;

public class Excelpath {
    private Integer id;

    private Integer userId;

    private String excelTime;

    private String excelPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExcelTime() {
        return excelTime;
    }

    public void setExcelTime(String excelTime) {
        this.excelTime = excelTime == null ? null : excelTime.trim();
    }

    public String getExcelPath() {
        return excelPath;
    }

    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath == null ? null : excelPath.trim();
    }
}