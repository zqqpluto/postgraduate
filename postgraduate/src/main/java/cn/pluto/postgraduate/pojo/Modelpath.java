package cn.pluto.postgraduate.pojo;

public class Modelpath {
    private Integer id;

    private Integer excelId;

    private Integer userId;

    private String modelPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExcelId() {
        return excelId;
    }

    public void setExcelId(Integer excelId) {
        this.excelId = excelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath == null ? null : modelPath.trim();
    }
}